package com.example.zoo.service;

import com.example.zoo.repos.vetRep;
import com.example.zoo.models.vet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class vetService {
    private final vetRep vetRep;

    @Autowired
    public vetService(vetRep vetRep) {
        this.vetRep = vetRep;
    }

    public List<vet> getAllVet() {
        List<vet> vet = new ArrayList<>();
        vetRep.findAll().forEach(vet::add);
        return vet;
    }

    public vet getVet(Integer id) {
        return vetRep.findById(id).orElse(null);
    }

    public void addVet(vet vet) {
        vetRep.save(vet);
    }

    public void updateVet(vet vet) {
        vetRep.save(vet);
    }

    public void deleteVet(Integer id) {
        vetRep.deleteById(id);
    }
}