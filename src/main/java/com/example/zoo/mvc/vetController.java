package com.example.zoo.mvc;


import com.example.zoo.repos.vetRep;
import com.example.zoo.service.vetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.zoo.models.vet;

import java.util.List;
@RestController
@RequestMapping("/vet")
public class vetController {
    private final vetRep vetRep;
    private final vetService vetService;

    @Autowired
    public vetController(vetService vetService, vetRep vetRep) {
        this.vetService = vetService;
        this.vetRep = vetRep;
    }

    @GetMapping("/getall")
    public List<vet> getAllVet() {
        return vetService.getAllVet();
    }

    @GetMapping("/{id}")
    public vet getVet(@PathVariable Integer id) {
        return vetService.getVet(id);
    }

    @PostMapping("")
    public void createVet(@RequestBody vet vet) {
        vetService.updateVet(vet);
    }

    @PutMapping("")
    public void updateVet(@RequestBody vet vet) {
        vetService.updateVet(vet);
    }

    @DeleteMapping("/{id}")
    public void deleteVet(@PathVariable Integer id) {
        vetService.deleteVet(id);
    }
}

