package com.example.zoo.service;

import com.example.zoo.repos.cageRep;
import com.example.zoo.models.cage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class cageService {
    private final cageRep cageRep;

    @Autowired
    public cageService(cageRep cageRep) {
        this.cageRep = cageRep;
    }

    public List<cage> getAllCage() {
        List<cage> cage = new ArrayList<>();
        cageRep.findAll().forEach(cage::add);
        return cage;
    }

    public cage getCage(Integer id) {
        return cageRep.findById(id).orElse(null);
    }

    public void addCage(cage cage) {
        cageRep.save(cage);
    }

    public void updateCage(cage cage) {
        cageRep.save(cage);
    }

    public void deleteCage(Integer id) {
        cageRep.deleteById(id);
    }
}
