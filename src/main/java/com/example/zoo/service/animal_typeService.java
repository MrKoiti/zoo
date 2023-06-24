package com.example.zoo.service;

import com.example.zoo.repos.animal_typeRep;
import com.example.zoo.models.animal_type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class animal_typeService {
    private final animal_typeRep animal_typeRep;

    @Autowired
    public animal_typeService(animal_typeRep animal_typeRep) {
        this.animal_typeRep = animal_typeRep;
    }

    public List<animal_type> getAllAnimalType() {
        List<animal_type> animal_type = new ArrayList<>();
        animal_typeRep.findAll().forEach(animal_type::add);
        return animal_type;
    }

    public animal_type getAnimalType(UUID id) {
        return animal_typeRep.findById(id).orElse(null);
    }

    public void addAnimalType(animal_type animal_type) {
        animal_typeRep.save(animal_type);
    }

    public void updateAnimalType(animal_type animal_type) {
        animal_typeRep.save(animal_type);
    }

    public void deleteAnimalType(UUID id) {
        animal_typeRep.deleteById(id);
    }
}