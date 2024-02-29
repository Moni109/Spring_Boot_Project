package com.example.project.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.model.Ticket;
import com.example.project.services.TicketService;

@RestController
@RequestMapping("/ticket")

public class TicketController {
    private TicketService ticketService;
    public TicketController(TicketService ticketService){
        this.ticketService=ticketService;
    }

    @PostMapping
    public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket){
        Ticket tic=ticketService.saveTicketDetails(ticket);
        if(tic==null){
            return new ResponseEntity<>(tic,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(tic,HttpStatus.CREATED);
    }

    @GetMapping("/tickets")
    public List<Ticket> getTickets(){
        return ticketService.getTicketDetails();
    }

    @GetMapping("/sortPrice/{price}")
    public List<Ticket> getByPrice(@PathVariable int price){
        return ticketService.getTicketPrice(price);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBusDetails(@PathVariable int id){
        ticketService.deleteTicket(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
