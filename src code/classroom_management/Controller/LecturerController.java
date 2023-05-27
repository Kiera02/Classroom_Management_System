/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classroom_management.Controller;

import classroom_management.Modules.Lecturer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author minhh
 */
public class LecturerController implements Controller<Lecturer>{
        
    @Override
    public void add(Lecturer lecturer) {
        Connection conn = null;
        PreparedStatement pst = null;
                    
        try {
            conn = Controller.getConnection();
            pst = conn.prepareStatement("INSERT INTO lecturer(ID,Name,Email,Major) VALUES(?,?,?,?)");
            
            pst.setInt(1, lecturer.getID());
            pst.setString(2, lecturer.getName());
            pst.setString(3, lecturer.getEmail());
            pst.setString(4, lecturer.getLecturerMajor());
            pst.executeUpdate();
            
            System.out.println("Added Successfully");
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(LecturerController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } finally {
            try {
                conn.close();
            } catch(SQLException ex) {
                java.util.logging.Logger.getLogger(LecturerController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            try {
                pst.close();
            } catch(SQLException ex) {
                java.util.logging.Logger.getLogger(LecturerController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
    }
    
    @Override
    public void update(Lecturer lecturer) {
        Connection conn = null;
        PreparedStatement pst = null;
                    
        try {
            conn = Controller.getConnection();
            pst = conn.prepareStatement("UPDATE lecturer SET name = ?, email = ?, major = ? where id = ?");
            
            pst.setString(1, lecturer.getName());
            pst.setString(2, lecturer.getEmail());
            pst.setString(3, lecturer.getLecturerMajor());
            pst.setInt(4, lecturer.getID());
            pst.executeUpdate();
            
            System.out.println("Updated Successfully");
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(LecturerController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } finally {
            try {
                conn.close();
            } catch(SQLException ex) {
                java.util.logging.Logger.getLogger(LecturerController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            try {
                pst.close();
            } catch(SQLException ex) {
                java.util.logging.Logger.getLogger(LecturerController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
    }
    
    @Override
    public void delete(Lecturer lecturer) {
        Connection conn = null;
        PreparedStatement pst = null;
                    
        try {
            conn = Controller.getConnection();
            pst = conn.prepareStatement("DELETE FROM lecturer WHERE id = ?");
            
            pst.setInt(1, lecturer.getID());
            pst.executeUpdate();
            
            System.out.println("Deleted Successfully");
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(LecturerController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } finally {
            try {
                conn.close();
            } catch(SQLException ex) {
                java.util.logging.Logger.getLogger(LecturerController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            try {
                pst.close();
            } catch(SQLException ex) {
                java.util.logging.Logger.getLogger(LecturerController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public List<Lecturer> findByID(String ID) {
        List<Lecturer> lecturers  = new ArrayList<>();
        
        Connection conn = null;
        PreparedStatement pst = null;
        
        try {
            conn = Controller.getConnection();
            // query
            String sql = "select * from lecturer where id = ?";
            pst = conn.prepareStatement(sql);
            pst.setString(1,ID);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){ 
                Lecturer lecturer;
                lecturer = new Lecturer(rs.getInt("id"), rs.getString("Name"), rs.getString("Email"), rs.getString("Major"));
                
                lecturers.add(lecturer);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TimetableController.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            if (pst != null){
                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Lecturer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Lecturer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //end connection
        return lecturers;    
    }
}
