/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classroom_management.Controller;
import classroom_management.Modules.Timetable;
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
public class TimetableController implements Controller<Timetable>{
    @Override
    public void add(Timetable timetable) {
        Connection conn = null;
        PreparedStatement pst = null;
                    
        try {
            conn = Controller.getConnection();
            pst = conn.prepareStatement("INSERT INTO timetable(request_id,lecturer,purpose,subject,classRequestDate,startTime,endTime,classroom_id) VALUES(?,?,?,?,?,?,?,?)");
            
            pst.setInt(1, timetable.getRequestId());
            pst.setString(2, timetable.getLecturer());
            pst.setString(3, timetable.getPurpose());
            pst.setString(4, timetable.getSubject());
            pst.setString(5, timetable.getClassRequestDate());
            pst.setString(6, timetable.getStartTime());
            pst.setString(7, timetable.getEndTime());
            pst.setString(8, timetable.getClassroom_ID());

            pst.executeUpdate();
            
            System.out.println("Added Successfully");
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(TimetableController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } finally {
            try {
                conn.close();
            } catch(SQLException ex) {
                java.util.logging.Logger.getLogger(TimetableController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            try {
                pst.close();
            } catch(SQLException ex) {
                java.util.logging.Logger.getLogger(TimetableController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
    }
    
    @Override
    public void update(Timetable timetable) {
Connection conn = null;
        PreparedStatement pst = null;
                    
        try {
            conn = Controller.getConnection();
            pst = conn.prepareStatement("UPDATE timetable SET lecturer = ?, purpose = ?, subject = ?, classRequestDate = ?, startTime = ?, endTime = ?, classroom_id = ? where request_id = ?");
            
            pst.setString(1, timetable.getLecturer());
            pst.setString(2, timetable.getPurpose());
            pst.setString(3, timetable.getSubject());
            pst.setString(4, timetable.getClassRequestDate());
            pst.setString(5, timetable.getStartTime());
            pst.setString(6, timetable.getEndTime());
            pst.setString(7, timetable.getClassroom_ID());
            pst.setInt(8, timetable.getRequestId());

            pst.executeUpdate();
            
            System.out.println("Updated Successfully");
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(TimetableController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } finally {
            try {
                conn.close();
            } catch(SQLException ex) {
                java.util.logging.Logger.getLogger(TimetableController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            try {
                pst.close();
            } catch(SQLException ex) {
                java.util.logging.Logger.getLogger(TimetableController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
    }
    
    @Override
    public void delete(Timetable timetable) {
        Connection conn = null;
        PreparedStatement pst = null;
                    
        try {
            conn = Controller.getConnection();
            pst = conn.prepareStatement("DELETE FROM timetable WHERE request_id = ?");
            
            pst.setInt(1, timetable.getRequestId());
            pst.executeUpdate();
            
            System.out.println("Deleted Successfully");
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(TimetableController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } finally {
            try {
                conn.close();
            } catch(SQLException ex) {
                java.util.logging.Logger.getLogger(TimetableController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            try {
                pst.close();
            } catch(SQLException ex) {
                java.util.logging.Logger.getLogger(TimetableController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public List<Timetable> findByID(String ID) {
        List<Timetable> timetables = new ArrayList<>();
        
        Connection conn = null;
        PreparedStatement pst = null;
        
        try {
            conn = Controller.getConnection();
            // query
            String sql = "select * from timetable where classroom_id = ?";
            pst = conn.prepareStatement(sql);
            pst.setString(1,ID);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){ 
                Timetable ttb;
                ttb = new Timetable(rs.getInt("request_id"),rs.getString("lecturer"), 
                        rs.getString("classroom_id"), 
                        rs.getString("subject"), rs.getString("purpose"), 
                        rs.getString("classRequestDate"), rs.getString("startTime"), 
                        rs.getString("endTime"));
                timetables.add(ttb);
                
                System.out.println("classroom_management.Controller.TimetableController.findByID()");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TimetableController.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            if (pst != null){
                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Timetable.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Timetable.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //end connection
        return timetables;
    }    
}
