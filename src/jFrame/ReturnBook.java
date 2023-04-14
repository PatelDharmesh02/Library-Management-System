/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jFrame;
//import java.util.Date;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author patel
 */
public class ReturnBook extends javax.swing.JFrame {
    
    /**
     * Creates new form IssueBook
     */
    public ReturnBook() {
        initComponents();
    }
    
    
    public void getIssueBookDetails() {
        
        int bookId = Integer.parseInt(txt_bookId.getText());
        int studentId = Integer.parseInt(txt_studentId.getText());
        
        try {
            Connection con = ConnectionDB.getConnect();
            String query = "select * from issue_book_details where book_id = ? and student_id = ? and status = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, bookId);
            pst.setInt(2, studentId);
            pst.setString(3, "pending");
            
            ResultSet rs = pst.executeQuery();
            if(rs.next()) {
            
                txt_issueId.setText(rs.getString("id"));
                txt_bookName.setText(rs.getString("book_name"));
                txt_studentName.setText(rs.getString("student_name"));
                txt_issueDate.setText(rs.getString("issue_date"));
                txt_dueDate.setText(rs.getString("due_date"));
                txt_bookError.setText("");
                
            } else {
                txt_bookError.setText("No record found");
                txt_issueId.setText("");
                txt_bookName.setText("");
                txt_studentName.setText("");
                txt_issueDate.setText("");
                txt_dueDate.setText("");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public boolean isReturned() {
        boolean isReturn = false;
        int bookId = Integer.parseInt(txt_bookId.getText());
        int studentId = Integer.parseInt(txt_studentId.getText());
        
        try {
            Connection con = ConnectionDB.getConnect();
            String query = "update issue_book_details set status = ? where book_id = ? and student_id = ? and status = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1,"returned");
            pst.setInt(2, bookId);
            pst.setInt(3, studentId);
            pst.setString(4,"pending");
            
            int rowCount = pst.executeUpdate();
            if(rowCount > 0) {
                isReturn = true;
            }else {
                isReturn = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isReturn;
    }
    
    
    public void updateBookCount() {
        int bookId = Integer.parseInt(txt_bookId.getText());
        
        try {
            
            Connection con = ConnectionDB.getConnect();
            String query = "update book_details set quantity = quantity + 1 where book_id = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, bookId);
            int rowCount = pst.executeUpdate();
            
            if(rowCount > 0) {
                JOptionPane.showMessageDialog(this, "Book count updated successfully");
                
            }else {
                JOptionPane.showMessageDialog(this, "Book count updation failed !!");
            }
            
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMain = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txt_bookError = new javax.swing.JLabel();
        txt_dueDate = new javax.swing.JLabel();
        txt_issueId = new javax.swing.JLabel();
        txt_bookName = new javax.swing.JLabel();
        txt_studentName = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txt_issueDate = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txt_bookId = new app.bolivia.swing.JCTextField();
        txt_studentId = new app.bolivia.swing.JCTextField();
        jLabel19 = new javax.swing.JLabel();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        jPanel8 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelMain.setBackground(new java.awt.Color(255, 255, 255));
        panelMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(204, 102, 0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Lucida Sans", 1, 30)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel8.setText("Book Details");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 360, 110));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 410, 5));

        jLabel13.setFont(new java.awt.Font("Lucida Sans Typewriter", 3, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Issue ID :");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 110, -1));

        jLabel14.setFont(new java.awt.Font("Lucida Sans Typewriter", 3, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Book Name :");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 130, -1));

        jLabel15.setFont(new java.awt.Font("Lucida Sans Typewriter", 3, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Student Name :");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 130, -1));

        txt_bookError.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 18)); // NOI18N
        txt_bookError.setForeground(new java.awt.Color(255, 255, 0));
        jPanel3.add(txt_bookError, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 750, 350, 50));

        txt_dueDate.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        txt_dueDate.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(txt_dueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 630, 270, 40));

        txt_issueId.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        txt_issueId.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(txt_issueId, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 270, 40));

        txt_bookName.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        txt_bookName.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(txt_bookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, 270, 40));

        txt_studentName.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        txt_studentName.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(txt_studentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 450, 270, 40));

        jLabel21.setFont(new java.awt.Font("Lucida Sans Typewriter", 3, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Return Date :");
        jPanel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 650, 120, -1));

        jLabel22.setFont(new java.awt.Font("Lucida Sans Typewriter", 3, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Issue Date :");
        jPanel3.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 560, 120, -1));

        txt_issueDate.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        txt_issueDate.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(txt_issueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 550, 270, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/library-2.png"))); // NOI18N
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-590, 60, 570, 470));

        panelMain.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 0, 430, 850));

        jPanel7.setBackground(new java.awt.Color(204, 0, 0));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panelMain.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 180, 350, 5));

        jLabel4.setFont(new java.awt.Font("Lucida Sans", 1, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 51, 0));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel4.setText("Issue Book");
        panelMain.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 110, 320, 60));

        jLabel17.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(204, 51, 0));
        jLabel17.setText("Book ID :");
        panelMain.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 270, 130, 30));

        txt_bookId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 51, 0)));
        txt_bookId.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        txt_bookId.setPhColor(new java.awt.Color(102, 102, 255));
        txt_bookId.setPlaceholder("Enter Book ID");
        txt_bookId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_bookIdFocusLost(evt);
            }
        });
        txt_bookId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bookIdActionPerformed(evt);
            }
        });
        panelMain.add(txt_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 270, 320, 30));

        txt_studentId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 51, 0)));
        txt_studentId.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        txt_studentId.setPhColor(new java.awt.Color(102, 102, 255));
        txt_studentId.setPlaceholder("Enter Student ID");
        txt_studentId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentIdFocusLost(evt);
            }
        });
        txt_studentId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentIdActionPerformed(evt);
            }
        });
        panelMain.add(txt_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 400, 320, 30));

        jLabel19.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(204, 51, 0));
        jLabel19.setText("Student ID :");
        panelMain.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 400, 140, 30));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(204, 0, 51));
        rSMaterialButtonCircle1.setText("Return Book");
        rSMaterialButtonCircle1.setFont(new java.awt.Font("Lucida Sans", 1, 18)); // NOI18N
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        panelMain.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 700, 250, 80));

        jPanel8.setBackground(new java.awt.Color(204, 51, 0));

        jLabel2.setFont(new java.awt.Font("Lucida Sans", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("X");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 14, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        panelMain.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1490, 0, 40, 40));

        jPanel4.setBackground(new java.awt.Color(102, 51, 255));

        jLabel7.setFont(new java.awt.Font("Lucida Sans", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel7.setText("Back");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelMain.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(102, 51, 255));
        rSMaterialButtonCircle2.setText("Find");
        rSMaterialButtonCircle2.setFont(new java.awt.Font("Lucida Sans", 1, 18)); // NOI18N
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        panelMain.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 580, 250, 80));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/library-2.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        panelMain.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 580, 570));

        getContentPane().add(panelMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1530, 850));

        setSize(new java.awt.Dimension(1530, 850));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        HomePage home = new HomePage();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void txt_bookIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bookIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookIdActionPerformed

    private void txt_studentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentIdActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void txt_bookIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookIdFocusLost
        
    }//GEN-LAST:event_txt_bookIdFocusLost

    private void txt_studentIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentIdFocusLost
        
    }//GEN-LAST:event_txt_studentIdFocusLost

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
        if(isReturned() == true) {
            JOptionPane.showMessageDialog(this,"Book returned Successfully");
            updateBookCount();
        }else {
            JOptionPane.showMessageDialog(this,"Book returning failed !!");
        }
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
        getIssueBookDetails();
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

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
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReturnBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel panelMain;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private javax.swing.JLabel txt_bookError;
    private app.bolivia.swing.JCTextField txt_bookId;
    private javax.swing.JLabel txt_bookName;
    private javax.swing.JLabel txt_dueDate;
    private javax.swing.JLabel txt_issueDate;
    private javax.swing.JLabel txt_issueId;
    private app.bolivia.swing.JCTextField txt_studentId;
    private javax.swing.JLabel txt_studentName;
    // End of variables declaration//GEN-END:variables
}