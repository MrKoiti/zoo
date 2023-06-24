package com.example.zoo.service;

import com.example.zoo.repos.vaccinationRep;
import com.example.zoo.models.vaccination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class vaccinationService {
    private final vaccinationRep vaccinationRep;

    @Autowired
    public vaccinationService(vaccinationRep vaccinationRep) {
        this.vaccinationRep = vaccinationRep;
    }

    public List<vaccination> getAllVaccination() {
        List<vaccination> vaccination = new ArrayList<>();
        vaccinationRep.findAll().forEach(vaccination::add);
        return vaccination;
    }

    public vaccination getVaccination(Integer id) {
        return vaccinationRep.findById(id).orElse(null);
    }

    public void addVaccination(vaccination vaccination) {
        vaccinationRep.save(vaccination);
    }

    public void updateVaccination(vaccination vaccination) {
        vaccinationRep.save(vaccination);
    }

    public void deleteVaccination(Integer id) {
        vaccinationRep.deleteById(id);
    }
}