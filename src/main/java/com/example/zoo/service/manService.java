package com.example.zoo.service;

import com.example.zoo.repos.manRep;
import com.example.zoo.models.man;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class manService {
    private final manRep manRep;

    @Autowired
    public manService(manRep manRep) {
        this.manRep = manRep;
    }

    public List<man> getAllMan() {
        List<man> man = new ArrayList<>();
        manRep.findAll().forEach(man::add);
        return man;
    }

    public man getMan(UUID id) {
        return manRep.findById(id).orElse(null);
    }

    public void addMan(man man) {
        manRep.save(man);
    }

    public void updateMan(man man) {
        manRep.save(man);
    }

    public void deleteMan(UUID id) {
        manRep.deleteById(id);
    }
}