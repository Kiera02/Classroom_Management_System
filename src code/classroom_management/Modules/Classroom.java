/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classroom_management.Modules;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author minhh
 */
public class Classroom implements Serializable {
    private String classroomID;
    private ArrayList<Student> studentsList;
    private String classCode;
    private int capacity;
    private String projector;
    private String clean;
    
    public Classroom() {}

    public Classroom(String classroomID, String classCode, int capacity, String projector, String clean) {
        this.classroomID = classroomID;
        this.capacity = capacity;
        this.classCode = classCode;
        this.projector = projector;
        this.clean = clean;
    }

    public String getClassroomID() {
        return classroomID;
    }

    public void setClassroomID(String classroomID) {
        this.classroomID = classroomID;
    }
    
    public List<Student> getStudents() {
        return this.studentsList;
    }
    
    public void addStudents(Student student) {
        studentsList.add(student);
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String isProjector() {
        return projector;
    }

    public void setProjector(String projector) {
        this.projector = projector;
    }
    
    public String isClean() {
        return clean;
    }
    
    public void setClean(String clean) {
        this.clean = clean;
    }
}
