/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classroom_management.Controller;

import classroom_management.Modules.Lecturer;
import classroom_management.Modules.Student;
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
public class StudentController implements Controller<Student>{

    @Override
    public void add(Student student) {
        Connection conn = null;
        PreparedStatement pst = null;
                    
        try {
            conn = Controller.getConnection();
            pst = conn.prepareStatement("INSERT INTO student(ID,FullName,Email,Major,Classroom_ID,Class_Code) VALUES(?,?,?,?,?,?)");
            
            pst.setInt(1, student.getID());
            pst.setString(2, student.getName());
            pst.setString(3, student.getEmail());
            pst.setString(4, student.getStudentMajor());
            pst.setString(5, student.getClassroomID());
            pst.setString(6, student.getClassCode());
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
    public void update(Student student) {
        Connection conn = null;
        PreparedStatement pst = null;
                    
        try {
            conn = Controller.getConnection();
            pst = conn.prepareStatement("UPDATE student SET fullname = ?, email = ?, major = ?, classroom_id = ?, class_code = ? where id = ?");
            
            pst.setString(1, student.getName());
            pst.setString(2, student.getEmail());
            pst.setString(3, student.getStudentMajor());
            pst.setString(4, student.getClassroomID());
            pst.setString(5, student.getClassCode());
            pst.setInt(6, student.getID());
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
    public void delete(Student student) {
Connection conn = null;
        PreparedStatement pst = null;
                    
        try {
            conn = Controller.getConnection();
            pst = conn.prepareStatement("DELETE FROM student WHERE id = ?");
            
            pst.setInt(1, student.getID());
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
    public List<Student> findByID(String ID) {
        List<Student> students  = new ArrayList<>();
        
        Connection conn = null;
        PreparedStatement pst = null;
        
        try {
            conn = Controller.getConnection();
            // query
            String sql = "select * from student where id = ?";
            pst = conn.prepareStatement(sql);
            pst.setString(1,ID);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){ 
                Student student;
                student = new Student(rs.getInt("id"), rs.getString("FullName"), rs.getString("Email"), 
                        rs.getString("Major"), rs.getString("Classroom_ID"), 
                        rs.getString("Class_Code"));
                
                students.add(student);
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
        return students;
    }
}

