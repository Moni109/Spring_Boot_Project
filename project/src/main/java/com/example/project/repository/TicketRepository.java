package com.example.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.model.Ticket;
@Repository
public interface TicketRepository extends JpaRepository<Ticket,Integer>{
   List<Ticket> findByPrice(int price);
}


