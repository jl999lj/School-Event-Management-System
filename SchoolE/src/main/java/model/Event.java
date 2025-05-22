/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class Event {
     private String id;
    private String titull;
    private String pershkrimi;
    private String tipi;
    private LocalDate data;
    private LocalTime ora;
    private String venddodhja;
    private Perdorues organizatori;
    private List<Perdorues> pjesmarres;
    
    public Event() {
        this.pjesmarres = new ArrayList<>();
    }
    
    public Event(String id, String titull, String pershkrimi, String tipi, LocalDate data, 
                 LocalTime ora, String venddodhja, Perdorues organizatori) {
        this.id = id;
        this.titull = titull;
        this.pershkrimi = pershkrimi;
        this.tipi = tipi;
        this.data = data;
        this.ora = ora;
        this.venddodhja = venddodhja;
        this.organizatori = organizatori;
        this.pjesmarres = new ArrayList<>();
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getTitull() {
        return titull;
    }
    
    public void setTitull(String titull) {
        this.titull = titull;
    }
    
    public String getPershkrimi() {
        return pershkrimi;
    }
    
    public void setPershkrimi(String pershkrimi) {
        this.pershkrimi = pershkrimi;
    }
    
    public String getTipi() {
        return tipi;
    }
    
    public void setTipi(String tipi) {
        this.tipi = tipi;
    }
    
    public LocalDate getData() {
        return data;
    }
    
    public void setData(LocalDate data) {
        this.data = data;
    }
    
    public LocalTime getOra() {
        return ora;
    }
    
    public void setOra(LocalTime ora) {
        this.ora = ora;
    }
    
    public String getVenddodhja() {
        return venddodhja;
    }
    
    public void setVenddodhja(String venddodhja) {
        this.venddodhja = venddodhja;
    }
    
    public Perdorues getOrganizatori() {
        return organizatori;
    }
    
    public void setOrganizatori(Perdorues organizatori) {
        this.organizatori = organizatori;
    }
    
    public List<Perdorues> getPjesmarres() {
        return pjesmarres;
    }
    
    public void setPjesmarres(List<Perdorues> pjesmarres) {
        this.pjesmarres = pjesmarres;
    }
    
   
    @Override
    public String toString() {
        return "Event [id=" + id + ", titull=" + titull + ", pershkrimi=" + pershkrimi + 
               ", tipi=" + tipi + ", data=" + data + ", ora=" + ora + 
               ", venddodhja=" + venddodhja + ", organizatori=" + organizatori.getId() + "]";
    }
}
