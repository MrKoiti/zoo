package com.example.zoo.mvc;


import com.example.zoo.repos.cage_animalRep;
import com.example.zoo.service.cage_animalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.zoo.models.cage_animal;

import java.util.List;
@RestController
@RequestMapping("/cage_animal")
public class cage_animalController {
    private final cage_animalRep cage_animalRep;
    private final cage_animalService cage_animalService;

    @Autowired
    public cage_animalController(cage_animalService cage_animalService, cage_animalRep cage_animalRep) {
        this.cage_animalService = cage_animalService;
        this.cage_animalRep = cage_animalRep;
    }

    @GetMapping("/getall")
    public List<cage_animal> getAllCageAnimal() {
        return cage_animalService.getAllCageAnimal();
    }

    @GetMapping("/{id}")
    public cage_animal getCageAnimal(@PathVariable Integer id) {
        return cage_animalService.getCageAnimal(id);
    }

    @PostMapping("")
    public void createCageAnimal(@RequestBody cage_animal cage_animal) {
        cage_animalService.updateCageAnimal(cage_animal);
    }

    @PutMapping("")
    public void updateCageAnimal(@RequestBody cage_animal cage_animal) {
        cage_animalService.updateCageAnimal(cage_animal);
    }

    @DeleteMapping("/{id}")
    public void deleteCageAnimal(@PathVariable Integer id) {
        cage_animalService.deleteCageAnimal(id);
    }
}

