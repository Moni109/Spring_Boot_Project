package com.example.project.model;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class BusDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int busid ;
    private String busName;
    private LocalDateTime departure_time;
    private LocalDateTime arrival_time;
    private String bustype;
    private int seats_available;
    private int price;
    private String status;
    private String source;
    private String destination;

    @JsonManagedReference
    @OneToMany(mappedBy = "busDetails",cascade = CascadeType.ALL)
    private List<Ticket> tickets;
    
    
    
}
