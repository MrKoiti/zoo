package com.example.zoo.mvc;


import com.example.zoo.repos.vaccinationRep;
import com.example.zoo.service.vaccinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.zoo.models.vaccination;

import java.util.List;
@RestController
@RequestMapping("/vaccination")
public class vaccinationController {
    private final vaccinationRep vaccinationRep;
    private final vaccinationService vaccinationService;

    @Autowired
    public vaccinationController(vaccinationService vaccinationService, vaccinationRep vaccinationRep) {
        this.vaccinationService = vaccinationService;
        this.vaccinationRep = vaccinationRep;
    }

    @GetMapping("/getall")
    public List<vaccination> getAllVaccination() {
        return vaccinationService.getAllVaccination();
    }

    @GetMapping("/{id}")
    public vaccination getVaccination(@PathVariable Integer id) {
        return vaccinationService.getVaccination(id);
    }

    @PostMapping("")
    public void createVaccination(@RequestBody vaccination vaccination) {
        vaccinationService.updateVaccination(vaccination);
    }

    @PutMapping("")
    public void updateVaccination(@RequestBody vaccination vaccination) {
        vaccinationService.updateVaccination(vaccination);
    }

    @DeleteMapping("/{id}")
    public void deleteVaccination(@PathVariable Integer id) {
        vaccinationService.deleteVaccination(id);
    }
}

