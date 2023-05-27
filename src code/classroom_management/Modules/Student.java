/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classroom_management.Modules;

/**
 *
 * @author minhh
 */
public class Student extends User {
    private String studentMajor;
    private String classroomID;
    private String classCode;
    
    public Student() {}
    
    public Student(int ID, String Name, String Email, String major, String classroomID, String classCode) {
        super(ID, Name, Email);
        this.studentMajor = major;
        this.classroomID = classroomID;
        this.classCode = classCode;
    }

    @Override
    public int getID() {
        return this.ID;
    }

    @Override
    public void setID(int newID) {
        this.ID = newID;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    void setName(String newName) {
        this.name = newName;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public void setEmail(String newEmail) {
        this.email = newEmail;
    }
    
    public String getStudentMajor() {
        return this.studentMajor;
    }
    
    public void setStudentMajor(String newMajor) {
        this.studentMajor = newMajor;
    }
    
    public String getClassroomID() {
        return this.classroomID;
    }
    
    public void setClassroomID(String newClassroomID) {
        this.classroomID = newClassroomID;
    } 
    
    public String getClassCode() {
        return this.classCode;
    }
    
    public void setClassCode(String newClassCode) {
        this.classCode = newClassCode;
    }
} 
