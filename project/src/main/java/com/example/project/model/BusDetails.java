package com.example.project.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BusDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Bus_id ;
    private String Bus_Name;
    private LocalDateTime Departure_time;
    private LocalDateTime Arrival_time;
    private String Bus_type;
    private int seats_available;
    private int price;
    private String status;
    private String source;
    private String destination;
    
    public int getBus_id() {
        return Bus_id;
    }
    public void setBus_id(int bus_id) {
        Bus_id = bus_id;
    }
    public String getBus_Name() {
        return Bus_Name;
    }
    public void setBus_Name(String bus_Name) {
        Bus_Name = bus_Name;
    }
    public LocalDateTime getDeparture_time() {
        return Departure_time;
    }
    public void setDeparture_time(LocalDateTime departure_time) {
        Departure_time = departure_time;
    }
    public LocalDateTime getArrival_time() {
        return Arrival_time;
    }
    public void setArrival_time(LocalDateTime arrival_time) {
        Arrival_time = arrival_time;
    }
    public String getBus_type() {
        return Bus_type;
    }
    public void setBus_type(String bus_type) {
        Bus_type = bus_type;
    }
    public int getSeats_available() {
        return seats_available;
    }
    public void setSeats_available(int seats_available) {
        this.seats_available = seats_available;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public void setStatus(String status) {
        this.status=status;
    }
    public String getStatus() {
        return status;
    }
    public void setActive(String status) {
        this.status = status;
    }
    public String getSource() {
        return source;
    }
    public void setSource(String source) {
        this.source = source;
    }
    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    
}
