/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author user
 */
public class Njoftime {
     private String permbajta;
    private String id;
    private Perdorues marres;
    private LocalDate dataDergimit;
    
    public Njoftime() {}
    
    public Njoftime(String id, String permbajta, Perdorues marres, LocalDate dataDergimit) {
        this.id = id;
        this.permbajta = permbajta;
        this.marres = marres;
        this.dataDergimit = dataDergimit;
    }
    
    public String getPermbajta() {
        return permbajta;
    }
    
    public void setPermbajta(String permbajta) {
        this.permbajta = permbajta;
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public Perdorues getMarres() {
        return marres;
    }
    
    public void setMarres(Perdorues marres) {
        this.marres = marres;
    }
    
    public LocalDate getDataDergimit() {
        return dataDergimit;
    }
    
    public void setDataDergimit(LocalDate dataDergimit) {
        this.dataDergimit = dataDergimit;
    }
    
 
    @Override
    public String toString() {
        return "Njoftime [id=" + id + ", permbajta=" + permbajta + ", marres=" + marres.getId() + 
               ", dataDergimit=" + dataDergimit + "]";
    }
}

