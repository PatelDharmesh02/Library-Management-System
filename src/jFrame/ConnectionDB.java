/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jFrame;
import java.sql.*;

/**
 *
 * @author patel
 */
public class ConnectionDB {
    static Connection con = null;
    
    public static Connection getConnect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms","root","P@telcric8");
            
        } catch (Exception e) {
             e.printStackTrace();
        }
        return con;
    }
}
