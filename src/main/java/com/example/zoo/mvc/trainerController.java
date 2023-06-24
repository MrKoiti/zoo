package com.example.zoo.mvc;


import com.example.zoo.repos.trainerRep;
import com.example.zoo.service.trainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.zoo.models.trainer;

import java.util.List;
@RestController
@RequestMapping("/trainer")
public class trainerController {
    private final trainerRep trainerRep;
    private final trainerService trainerService;

    @Autowired
    public trainerController(trainerService trainerService, trainerRep trainerRep) {
        this.trainerService = trainerService;
        this.trainerRep = trainerRep;
    }

    @GetMapping("/getall")
    public List<trainer> getAllTrainer() {
        return trainerService.getAllTrainer();
    }

    @GetMapping("/{id}")
    public trainer getTrainer(@PathVariable Integer id) {
        return trainerService.getTrainer(id);
    }

    @PostMapping("")
    public void createTrainer(@RequestBody trainer trainer) {
        trainerService.updateTrainer(trainer);
    }

    @PutMapping("")
    public void updateTrainer(@RequestBody trainer trainer) {
        trainerService.updateTrainer(trainer);
    }

    @DeleteMapping("/{id}")
    public void deleteTrainer(@PathVariable Integer id) {
        trainerService.deleteTrainer(id);
    }
}

