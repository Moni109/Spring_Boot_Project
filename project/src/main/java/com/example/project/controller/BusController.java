package com.example.project.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.model.BusDetails;
import com.example.project.services.BusService;

@RestController
public class BusController {
    private BusService busService;
    public BusController(BusService busService){
        this.busService=busService;
    }
    @PostMapping("/bus")
    public ResponseEntity<BusDetails> busController(@RequestBody BusDetails busDetails){
        BusDetails bus=busService.saveBusDetails(busDetails);
        if(bus==null){
            return new ResponseEntity<>(bus,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(bus,HttpStatus.CREATED);
    }

    @GetMapping("/details")
    public ResponseEntity<List<BusDetails>> getListofbuses1(){
        List<BusDetails> buses=busService.getListofbuses();
        if(buses==null){
            return new ResponseEntity<>(buses,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(buses,HttpStatus.CREATED);
    }
    
    @PutMapping("/updatedetails")
    public ResponseEntity<BusDetails> putBusDetails(@RequestBody BusDetails busDetails){
        BusDetails buses=busService.updateBusDetails(busDetails);
        if(buses==null){
            return new ResponseEntity<>(buses,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(buses,HttpStatus.OK);
    }
    
    @DeleteMapping("/deletedetails")
    public ResponseEntity<Void> deleteBusDetails(@RequestBody BusDetails busDetails){
        busService.deleteBusDetails(busDetails);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
     @GetMapping("/search")
    public ResponseEntity<List<BusDetails>> findBusesBySourceAndDestination(@RequestParam String source, @RequestParam String destination) {
        List<BusDetails> buses = busService.findBusesBySourceAndDestination(source, destination);
        return new ResponseEntity<>(buses, HttpStatus.OK);
    }
}
