/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classroom_management.Modules;

import java.io.Serializable;

/**
 *
 * @author minhh
 */
public class Timetable implements Serializable{
    private int requestID;
    private String lecturer;
    private String purpose;
    private String subject;
    private String classRequestDate;
    private String startTime;
    private String endTime;
    private String classroom_ID;
    
    public Timetable() {}
    
    public Timetable(int requestID, String lecturer, String classroom_ID, 
                   String subject, String purpose, String classRequestDate,
                   String startTime, String endTime) {
        this.requestID = requestID;
        this.lecturer = lecturer;
        this.classroom_ID = classroom_ID;
        this.purpose = purpose;
        this.subject = subject;
        this.classRequestDate = classRequestDate;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    
    public int getRequestId() {
        return requestID;
    }

    public void setRequestId(int newrequestID) {
        this.requestID = newrequestID;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getClassRequestDate() {
        return classRequestDate;
    }

    public void setClassRequestDate(String classRequestDate) {
        this.classRequestDate = classRequestDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getClassroom_ID() {
        return classroom_ID;
    }

    public void setClassroom_ID(String classroom_ID) {
        this.classroom_ID = classroom_ID;
    }
}
