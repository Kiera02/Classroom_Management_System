/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classroom_management.Controller;

import classroom_management.Modules.Classroom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author minhh
 */
public class ClassroomController implements Controller<Classroom>{

    @Override
    public void add(Classroom classroom) {
        Connection conn = null;
        PreparedStatement pst = null;
                    
        try {
            conn = Controller.getConnection();
            pst = conn.prepareStatement("INSERT INTO classroom(Classroom_ID,Class_Code,Capacity,Need_Projector,Require_Clean) VALUES(?,?,?,?,?)");
            
            pst.setString(1, classroom.getClassroomID());
            pst.setString(2, classroom.getClassCode());
            pst.setInt(3, classroom.getCapacity());
            pst.setString(4, classroom.isProjector());
            pst.setString(5, classroom.isClean());
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
    public void update(Classroom classroom) {
        Connection conn = null;
        PreparedStatement pst = null;
                    
        try {
            conn = Controller.getConnection();
            pst = conn.prepareStatement("UPDATE classroom SET class_code = ?, capacity = ?, need_projector = ?, require_clean = ? where classroom_id = ?");
            
            pst.setString(1, classroom.getClassCode());
            pst.setInt(2, classroom.getCapacity());
            pst.setString(3, classroom.isProjector());
            pst.setString(4, classroom.isClean());
            pst.setString(5, classroom.getClassroomID());
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
    public void delete(Classroom classroom) {
Connection conn = null;
        PreparedStatement pst = null;
                    
        try {
            conn = Controller.getConnection();
            pst = conn.prepareStatement("DELETE FROM classroom WHERE classroom_id = ?");
            
            pst.setString(1, classroom.getClassroomID());
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
    public List<Classroom> findByID(String ID) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
