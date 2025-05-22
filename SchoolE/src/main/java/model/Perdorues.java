/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author user
 */
public class Perdorues {
    private String id;
    private String emer;
    private String mbiemer;
    private String email;
    
    public Perdorues() {}
    
    public Perdorues(String id, String emer, String mbiemer, String email) {
        this.id = id;
        this.emer = emer;
        this.mbiemer = mbiemer;
        this.email = email;
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getEmer() {
        return emer;
    }
    
    public void setEmer(String emer) {
        this.emer = emer;
    }
    
    public String getMbiemer() {
        return mbiemer;
    }
    
    public void setMbiemer(String mbiemer) {
        this.mbiemer = mbiemer;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    

    @Override
    public String toString() {
        return "Perdorues [id=" + id + ", emer=" + emer + ", mbiemer=" + mbiemer + ", email=" + email + "]";
    }
    
}
