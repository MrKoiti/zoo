package com.example.zoo.mvc;


import com.example.zoo.repos.cageRep;
import com.example.zoo.service.cageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.zoo.models.cage;

import java.util.List;
@RestController
@RequestMapping("/cage")
public class cageController {
    private final cageRep cageRep;
    private final cageService cageService;

    @Autowired
    public cageController(cageService cageService, cageRep cageRep) {
        this.cageService = cageService;
        this.cageRep = cageRep;
    }

    @GetMapping("/getall")
    public List<cage> getAllCage() {
        return cageService.getAllCage();
    }

    @GetMapping("/{id}")
    public cage getCage(@PathVariable Integer id) {
        return cageService.getCage(id);
    }

    @PostMapping("")
    public void createCage(@RequestBody cage cage) {
        cageService.updateCage(cage);
    }

    @PutMapping("")
    public void updateCage(@RequestBody cage cage) {
        cageService.updateCage(cage);
    }

    @DeleteMapping("/{id}")
    public void deleteCage(@PathVariable Integer id) {
        cageService.deleteCage(id);
    }
}

