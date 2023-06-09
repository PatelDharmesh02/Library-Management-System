/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jFrame;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author patel
 */
public class ManageStudents extends javax.swing.JFrame {
    /**
     * Creates new form ManageBooks
     */
    
    
    DefaultTableModel model;
    
    public ManageStudents() {
        initComponents();
        setStudentDetailsToTable();
    }
    
    // Method to add books into table from database
    public void setStudentDetailsToTable() {
        try {
            Connection con = ConnectionDB.getConnect();
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from student_details");
            
            while(rs.next()) {
                int studentId = rs.getInt("student_id");
                String studentName = rs.getString("student_name");
                String course = rs.getString("course");
                String  branch = rs.getString("branch");
                
                Object[] obj = {studentId,studentName, course, branch};
                
                model = (DefaultTableModel)tbl_studentDetails.getModel();
                
                model.addRow(obj);
                
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    //Method to clear the table
    public void clearTable() {
        DefaultTableModel model = (DefaultTableModel)tbl_studentDetails.getModel();
        model.setRowCount(0);
    }
    
    //Method to add books in the table
    public boolean addStudent() {
        boolean isAdded = false;
        int studentId = Integer.parseInt(txt_studentId.getText());
        String studentName = txt_studentName.getText();
        String course = combo_course.getSelectedItem().toString();
        String  branch = combo_branch.getSelectedItem().toString();
        
        try {
            
            Connection con = ConnectionDB.getConnect();
            String query = "insert into student_details values(?,?,?,?)";
            
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, studentId);
            pst.setString(2, studentName);
            pst.setString(3, course);
            pst.setString(4,branch);
            
            int rowCount = pst.executeUpdate();
            
            if(rowCount > 0)isAdded = true;
            else isAdded = false;
            
            return isAdded;

        } catch(Exception e) {
            e.printStackTrace();
        }
        return isAdded;
    }
    
    
    //Method to update the books from table
    public boolean updateStudent() {
        boolean isUpdate = false;
        
        int studentId = Integer.parseInt(txt_studentId.getText());
        String studentName = txt_studentName.getText();
        String course = combo_course.getSelectedItem().toString();
        String  branch = combo_branch.getSelectedItem().toString();
        
        try {
            Connection con = ConnectionDB.getConnect();
            
            String query = "update student_details set student_name = ?, course = ?, branch = ? where student_id = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1,studentName);
            pst.setString(2, course);
            pst.setString(3, branch);
            pst.setInt(4, studentId);
            
            int rowCount = pst.executeUpdate();
            
            if(rowCount > 0)isUpdate = true;
            else isUpdate = false;
            
        } catch(Exception e) {
            e.printStackTrace();
        }
        return isUpdate;
    }
    
    
    //Method to delete the books from table
    public boolean deleteStudent() {
        boolean isDeleted = false;
        int studentId = Integer.parseInt(txt_studentId.getText());
        try {
            Connection con = ConnectionDB.getConnect();
            
            String query = "delete from student_details where student_id = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1,studentId);
            
            int rowCount = pst.executeUpdate();
            if(rowCount > 0)isDeleted = true;
            else isDeleted = false;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isDeleted;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txt_studentId = new app.bolivia.swing.JCTextField();
        txt_studentName = new app.bolivia.swing.JCTextField();
        rSMaterialButtonCircle1 = new necesario.RSMaterialButtonCircle();
        rSMaterialButtonCircle2 = new necesario.RSMaterialButtonCircle();
        rSMaterialButtonCircle3 = new necesario.RSMaterialButtonCircle();
        combo_branch = new javax.swing.JComboBox<>();
        combo_course = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_studentDetails = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 51, 51));

        jLabel1.setFont(new java.awt.Font("Lucida Sans", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel1.setText("Back");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 50));

        jLabel9.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Student ID");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 130, -1));

        jLabel17.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 18)); // NOI18N
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Contact_26px.png"))); // NOI18N
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 60, 60));

        jLabel10.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Name");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, 150, -1));

        jLabel18.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 18)); // NOI18N
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Moleskine_26px.png"))); // NOI18N
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 60, 60));

        jLabel11.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Course ");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 350, 140, -1));

        jLabel19.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 18)); // NOI18N
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/course.png"))); // NOI18N
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 60, 60));

        jLabel12.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Branch");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 460, 100, -1));

        jLabel20.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 18)); // NOI18N
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Unit_26px.png"))); // NOI18N
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 450, 60, 60));

        txt_studentId.setBackground(new java.awt.Color(51, 102, 255));
        txt_studentId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        txt_studentId.setForeground(new java.awt.Color(255, 255, 255));
        txt_studentId.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        txt_studentId.setPhColor(new java.awt.Color(255, 255, 0));
        txt_studentId.setPlaceholder("Enter Student ID");
        txt_studentId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentIdActionPerformed(evt);
            }
        });
        jPanel1.add(txt_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 320, 30));

        txt_studentName.setBackground(new java.awt.Color(51, 102, 255));
        txt_studentName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        txt_studentName.setForeground(new java.awt.Color(255, 255, 255));
        txt_studentName.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        txt_studentName.setPhColor(new java.awt.Color(255, 255, 0));
        txt_studentName.setPlaceholder("Enter Student Name");
        txt_studentName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentNameActionPerformed(evt);
            }
        });
        jPanel1.add(txt_studentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, 320, 30));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(255, 51, 0));
        rSMaterialButtonCircle1.setText("delete");
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 600, 130, 60));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(255, 51, 0));
        rSMaterialButtonCircle2.setText("Add");
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 600, 130, 60));

        rSMaterialButtonCircle3.setBackground(new java.awt.Color(255, 51, 0));
        rSMaterialButtonCircle3.setText("Update");
        rSMaterialButtonCircle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle3ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 600, 130, 60));

        combo_branch.setBackground(new java.awt.Color(51, 102, 255));
        combo_branch.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        combo_branch.setForeground(new java.awt.Color(255, 255, 255));
        combo_branch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "CSE", "ECE", "DSAI", "Mechanical", "Electrical", "Civil", "Chemical", " " }));
        combo_branch.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(255, 255, 255)));
        jPanel1.add(combo_branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 490, 320, 30));

        combo_course.setBackground(new java.awt.Color(51, 102, 255));
        combo_course.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        combo_course.setForeground(new java.awt.Color(255, 255, 255));
        combo_course.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Btech", "Mtech", "Phd", "Bsc", "Msc", " " }));
        combo_course.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(255, 255, 255)));
        jPanel1.add(combo_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 380, 320, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 850));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 51, 51));

        jLabel2.setFont(new java.awt.Font("Lucida Sans", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("X");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 14, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, 40, 40));

        tbl_studentDetails.setBackground(new java.awt.Color(0, 255, 255));
        tbl_studentDetails.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tbl_studentDetails.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        tbl_studentDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Name", "Course", "Branch"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_studentDetails.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tbl_studentDetails.setGridColor(new java.awt.Color(0, 0, 0));
        tbl_studentDetails.setRowHeight(40);
        tbl_studentDetails.setSelectionBackground(new java.awt.Color(255, 255, 204));
        tbl_studentDetails.setSelectionForeground(new java.awt.Color(51, 51, 51));
        tbl_studentDetails.setShowGrid(true);
        tbl_studentDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_studentDetailsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_studentDetails);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 660, 380));

        jLabel3.setFont(new java.awt.Font("Lucida Sans", 1, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 51, 0));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Student_Male_100px.png"))); // NOI18N
        jLabel3.setText("Manage Students");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 410, 100));

        jPanel5.setBackground(new java.awt.Color(204, 0, 0));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 155, 450, 5));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 950, 850));

        setSize(new java.awt.Dimension(1530, 850));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        HomePage home = new HomePage();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void txt_studentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentIdActionPerformed

    private void txt_studentNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentNameActionPerformed

    private void rSMaterialButtonCircle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3ActionPerformed
        if(updateStudent() == true) {
            JOptionPane.showMessageDialog(this, "Student updated successfully");
            clearTable();
            setStudentDetailsToTable();
        }else {
            JOptionPane.showMessageDialog(this, "Student updation failed !!");
        }
    }//GEN-LAST:event_rSMaterialButtonCircle3ActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void tbl_studentDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_studentDetailsMouseClicked
        int rowNo = tbl_studentDetails.getSelectedRow();
        TableModel model = tbl_studentDetails.getModel();
        
        txt_studentId.setText(model.getValueAt(rowNo, 0).toString()); 
        txt_studentName.setText(model.getValueAt(rowNo, 1).toString());
        combo_course.setSelectedItem(model.getValueAt(rowNo, 2).toString());
        combo_branch.setSelectedItem(model.getValueAt(rowNo,3).toString());
        
    }//GEN-LAST:event_tbl_studentDetailsMouseClicked

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
        if(addStudent() == true) {
            JOptionPane.showMessageDialog(this, "Student added successfully");
            clearTable();
            setStudentDetailsToTable();
        }else {
            JOptionPane.showMessageDialog(this, "Student addition failed !!");
        }
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
        if(deleteStudent() == true) {
            JOptionPane.showMessageDialog(this, "Student deleted successfully");
            clearTable();
            setStudentDetailsToTable();
        }else {
            JOptionPane.showMessageDialog(this, "Student deletion failed !!");
        }
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageStudents().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo_branch;
    private javax.swing.JComboBox<String> combo_course;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle3;
    private javax.swing.JTable tbl_studentDetails;
    private app.bolivia.swing.JCTextField txt_studentId;
    private app.bolivia.swing.JCTextField txt_studentName;
    // End of variables declaration//GEN-END:variables
}
