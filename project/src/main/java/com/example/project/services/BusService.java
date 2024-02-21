package com.example.project.services;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.project.model.BusDetails;
import com.example.project.repository.BusRepository;

@Service
public class BusService {
    private BusRepository busRepository;
    public BusService(BusRepository busRepository){
        this.busRepository=busRepository;
    }

    public List<BusDetails> getListofbuses(){
        return busRepository.findAll();
    }


    public BusDetails saveBusDetails(BusDetails busDetails){
        if (busDetails != null) {
            return busRepository.save(busDetails);
        } 
        else {
            throw new IllegalArgumentException("busDetails cannot be null");
        }
    }

    public BusDetails updateBusDetails(BusDetails updatedBusDetails){
        int id = updatedBusDetails.getBus_id();
        BusDetails existingBusDetails = busRepository.findById(id).orElse(null);
        
        if(existingBusDetails != null){
            existingBusDetails.setBus_Name(updatedBusDetails.getBus_Name());
            existingBusDetails.setDeparture_time(updatedBusDetails.getDeparture_time());
            existingBusDetails.setArrival_time(updatedBusDetails.getArrival_time());
            existingBusDetails.setBus_type(updatedBusDetails.getBus_type());
            existingBusDetails.setSeats_available(updatedBusDetails.getSeats_available());
            existingBusDetails.setPrice(updatedBusDetails.getPrice());
            existingBusDetails.setStatus(updatedBusDetails.getStatus());
            existingBusDetails.setSource(updatedBusDetails.getSource());
            existingBusDetails.setDestination(updatedBusDetails.getDestination());

            return busRepository.save(existingBusDetails);
        } 
        else {
            throw new IllegalArgumentException("Bus with id " + id + " not found");
        }
    }
    
    public void deleteBusDetails(BusDetails deletedBusDetails){
        int id = deletedBusDetails.getBus_id();
        if(busRepository.existsById(id)){
            busRepository.deleteById(id);
        } 
        else {
            throw new IllegalArgumentException("Bus with id"+ id + "not found");
        }
    }

    public List<BusDetails> findBusesBySourceAndDestination(String source, String destination) {
        return busRepository.findBusesBySourceAndDestination(source, destination);
    }
}
