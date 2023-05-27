/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classroom_management.Modules;

/**
 *
 * @author minhh
 */
public abstract class User {
    protected String name;
    protected int ID;
    protected String email;
    
    public User() {}
    
    public User(int ID, String Name, String Email) {
        this.ID = ID;
        this.name = Name;
        this.email = Email;
    }
    
    abstract int getID();
    abstract void setID(int newID);
    abstract String getName();
    abstract void setName(String newName);
    abstract String getEmail();
    abstract void setEmail(String newEmail);
}
