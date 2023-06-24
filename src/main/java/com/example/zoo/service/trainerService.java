package com.example.zoo.service;

import com.example.zoo.repos.trainerRep;
import com.example.zoo.models.trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class trainerService {
    private final trainerRep trainerRep;

    @Autowired
    public trainerService(trainerRep trainerRep) {
        this.trainerRep = trainerRep;
    }

    public List<trainer> getAllTrainer() {
        List<trainer> trainer = new ArrayList<>();
        trainerRep.findAll().forEach(trainer::add);
        return trainer;
    }

    public trainer getTrainer(Integer id) {
        return trainerRep.findById(id).orElse(null);
    }

    public void addTrainer(trainer trainer) {
        trainerRep.save(trainer);
    }

    public void updateTrainer(trainer trainer) {
        trainerRep.save(trainer);
    }

    public void deleteTrainer(Integer id) {
        trainerRep.deleteById(id);
    }
}