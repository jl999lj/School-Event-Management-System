/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author user
 */
public class Mesuesi extends Perdorues {
    private String lenda;
    
    public Mesuesi() {
        super();
    }
    
    public Mesuesi(String id, String emer, String mbiemer, String email, String lenda) {
        super(id, emer, mbiemer, email);
        this.lenda = lenda;
    }
    
    public String getLenda() {
        return lenda;
    }
    
    public void setLenda(String lenda) {
        this.lenda = lenda;
    }
    
    @Override
    public String toString() {
        return "Mesuesi [" + super.toString() + ", lenda=" + lenda + "]";
    }
    
}
