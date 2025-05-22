/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author user
 */
public class Nxenes extends Perdorues {
    private int klasa;
    private int viti;
    
    public Nxenes() {
        super();
    }
    
    public Nxenes(String id, String emer, String mbiemer, String email, int klasa, int viti) {
        super(id, emer, mbiemer, email);
        this.klasa = klasa;
        this.viti = viti;
    }
    
    public int getKlasa() {
        return klasa;
    }
    
    public void setKlasa(int klasa) {
        this.klasa = klasa;
    }
    
    public int getViti() {
        return viti;
    }
    
    public void setViti(int viti) {
        this.viti = viti;
    }
    
    @Override
    public String toString() {
        return "Nxenes [" + super.toString() + ", klasa=" + klasa + ", viti=" + viti + "]";
    }
    
}
