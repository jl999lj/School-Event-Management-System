/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalTime;

/**
 *
 * @author user
 */
public class PlanifikimEventi {
     private String id;
    private Event event;
    private LocalTime oraFillimi;
    private LocalTime oraMbarimit;
    
    public PlanifikimEventi() {}
    
    public PlanifikimEventi(String id, Event event, LocalTime oraFillimi, LocalTime oraMbarimit) {
        this.id = id;
        this.event = event;
        this.oraFillimi = oraFillimi;
        this.oraMbarimit = oraMbarimit;
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public Event getEvent() {
        return event;
    }
    
    public void setEvent(Event event) {
        this.event = event;
    }
    
    public LocalTime getOraFillimi() {
        return oraFillimi;
    }
    
    public void setOraFillimi(LocalTime oraFillimi) {
        this.oraFillimi = oraFillimi;
    }
    
    public LocalTime getOraMbarimit() {
        return oraMbarimit;
    }
    
    public void setOraMbarimit(LocalTime oraMbarimit) {
        this.oraMbarimit = oraMbarimit;
    }
    
   
    
    @Override
    public String toString() {
        return "PlanifikimEventi [id=" + id + ", event=" + event.getId() + 
               ", oraFillimi=" + oraFillimi + ", oraMbarimit=" + oraMbarimit + "]";
    }
}

