/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classroom_management.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author minhh
 */
public interface Controller<T> {
    static final String sqlconn = "jdbc:mysql://localhost:3306/mysql";
    static final String usrname = "root";
    static final String pass = "admin";
    static Connection getConnection() {
        Connection conn = null;

        try {            
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(sqlconn, usrname, pass);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(LecturerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
    
    public void add(T object);
    
    public void update(T object);
    
    public void delete(T object);
    
    public List<T> findByID(String ID);
}
