/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classroom_management.Modules;

/**
 *
 * @author minhh
 */
public class Lecturer extends User {
    private String lecturerMajor;

    public Lecturer() {}
    
    public Lecturer(int ID, String Name, String Email, String major) {
        super(ID, Name, Email);
        this.lecturerMajor = major;
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
    public void setName(String newName) {
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
    
    public String getLecturerMajor() {
        return this.lecturerMajor;
    }
    
    public void setLecturerMajor(String newMajor) {
        this.lecturerMajor = newMajor;
    }
}
