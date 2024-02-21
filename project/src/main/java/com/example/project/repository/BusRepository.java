package com.example.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.project.model.BusDetails;

@Repository
public interface BusRepository extends JpaRepository <BusDetails,Integer> {
    List<BusDetails> findBusesBySourceAndDestination(@Param("source") String source, @Param("destination") String destination);

}
