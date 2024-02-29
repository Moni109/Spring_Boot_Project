package com.example.project.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.project.model.Ticket;
import com.example.project.repository.TicketRepository;

@Service
public class TicketService {
    private TicketRepository ticketRepo;
    public TicketService(TicketRepository ticketRepo){
        this.ticketRepo=ticketRepo;
    }
    
    public Ticket saveTicketDetails(Ticket ticket){
        if (ticket != null) {
            return ticketRepo.save(ticket);
        } 
        else {
            throw new IllegalArgumentException("TicketDetails cannot be null");
        }
    }

    public List<Ticket> getTicketDetails(){
        return ticketRepo.findAll();
    }
    

    public List<Ticket> getTicketPrice(int price){
        return ticketRepo.findByPrice(price);
    }

    public boolean deleteTicket(int id){
        if (ticketRepo.existsById(id)) {
            ticketRepo.deleteById(id);
            return true;
        } 
        else {
            return false;
        }
    }

}
