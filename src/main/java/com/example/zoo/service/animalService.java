package com.example.zoo.service;

import com.example.zoo.models.animal;
import com.example.zoo.repos.animalRep;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class animalService {
    private final animalRep animalRep;

    @Autowired
    public animalService(animalRep animalRep) {
        this.animalRep = animalRep;
    }

    public List<animal> getAllAnimal() {
        List<animal> animal = new ArrayList<>();
        animalRep.findAll().forEach(animal::add);
        return animal;
    }

    public animal getAnimal(UUID id) {
        return animalRep.findById(id).orElse(null);
    }

    public void addAnimal(animal animal) {
        animalRep.save(animal);
    }

    public void updateAnimal(animal animal) {
        animalRep.save(animal);
    }

    public void deleteAnimal(UUID id) {
        animalRep.deleteById(id);
    }


    public List<animal> getAnimalWeight(int weight) {
        List<animal> animal = new ArrayList<>();
        animalRep.findAll().forEach(animal::add);
        List<animal> animalweight = new ArrayList<>();
        for (int i = 0; i < animal.toArray().length; i++) {
            if (animal.get(i).getWeight() >= weight) {
                animalweight.add(animal.get(i));
            }
        }
        return animalweight;
    }
}
