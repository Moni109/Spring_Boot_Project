package com.example.project.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

     public BusDetails getByBusId(int id){
        return busRepository.findById(id).orElse(null);
    }
    
    public BusDetails updateBusDetails(int id,BusDetails updatedBusDetails){
        
        boolean ID = busRepository.existsById(id);
        if(ID){
            updatedBusDetails.setBusid(id);
            return busRepository.save(updatedBusDetails);
        }
        else{
            throw new IllegalArgumentException("busDetails cannot be null");
        } 
    }
    
    public boolean deleteBusDetails(int id) {
        if (busRepository.existsById(id)) {
            busRepository.deleteById(id);
            return true;
        } 
        else {
            return false;
        }
    }
    

    public List<BusDetails> sortTheDetails(String field){
        return busRepository.findAll(Sort.by(field));
    }

    public Page<BusDetails> sortPages(int offset,int pageSize){
        Pageable pageable = PageRequest.of(offset, pageSize);
        return busRepository.findAll(pageable);
    }

    public List<BusDetails> sortByBoth(int offset, int pageSize, String field){
        Pageable pageable= PageRequest.of(offset, pageSize, Sort.by(field));
        return busRepository.findAll(pageable).getContent();
    }

    public List<BusDetails> findBusesBySourceAndDestination(String source, String destination) {
        return busRepository.findBusesBySourceAndDestination(source, destination);
    }

}
