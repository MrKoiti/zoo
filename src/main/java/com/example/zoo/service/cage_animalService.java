package com.example.zoo.service;

import com.example.zoo.repos.cage_animalRep;
import com.example.zoo.models.cage_animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class cage_animalService {
    private final cage_animalRep cage_animalRep;

    @Autowired
    public cage_animalService(cage_animalRep cage_animalRep) {
        this.cage_animalRep = cage_animalRep;
    }

    public List<cage_animal> getAllCageAnimal() {
        List<cage_animal> cage_animal = new ArrayList<>();
        cage_animalRep.findAll().forEach(cage_animal::add);
        return cage_animal;
    }

    public cage_animal getCageAnimal(Integer id) {
        return cage_animalRep.findById(id).orElse(null);
    }

    public void addCageAnimal(cage_animal cage_animal) {
        cage_animalRep.save(cage_animal);
    }

    public void updateCageAnimal(cage_animal cage_animal) {
        cage_animalRep.save(cage_animal);
    }

    public void deleteCageAnimal(Integer id) {
        cage_animalRep.deleteById(id);
    }
}