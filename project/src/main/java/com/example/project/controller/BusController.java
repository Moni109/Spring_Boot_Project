package com.example.project.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/details/{id}")
    public ResponseEntity<BusDetails> getListofbuses1(@PathVariable int id){
        BusDetails buses=busService.getByBusId(id);
        if(buses==null){
            return new ResponseEntity<>(buses,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(buses,HttpStatus.CREATED);
    }

    
    @PutMapping("/updatedetails/{id}")
    public ResponseEntity<BusDetails> putBusDetails(@PathVariable int id,@RequestBody BusDetails busDetails){
        BusDetails buses=busService.updateBusDetails(id,busDetails);
        if(buses==null){
            return new ResponseEntity<>(buses,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(buses,HttpStatus.OK);
    }
    
    @DeleteMapping("/deletedetails/{id}")
    public ResponseEntity<Void> deleteBusDetails(@PathVariable int id){
        busService.deleteBusDetails(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
        
    @GetMapping("/sortBy/{field}")
    public List<BusDetails> sortByDetails(@PathVariable String field){
        return busService.sortTheDetails(field);
    }

    @GetMapping("/pages/{offset}/{pageSize}")
    public Page<BusDetails> getByPages(@PathVariable int offset, @PathVariable int pageSize){
        return busService.sortPages(offset,pageSize);
    }
    @GetMapping("/pages/{offset}/{pageSize}/{field}")
    public List<BusDetails> getByPages(@PathVariable int offset, @PathVariable int pageSize, @PathVariable String field){
        return busService.sortByBoth(offset,pageSize,field);
    }

    @GetMapping("/search")
    public ResponseEntity<List<BusDetails>> findBusesBySourceAndDestination(@RequestParam String source, @RequestParam String destination) {
        List<BusDetails> buses = busService.findBusesBySourceAndDestination(source, destination);
        return new ResponseEntity<>(buses, HttpStatus.OK);
    }
}
