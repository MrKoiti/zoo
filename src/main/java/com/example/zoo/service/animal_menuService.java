package com.example.zoo.service;

import com.example.zoo.repos.animal_menuRep;
import com.example.zoo.models.animal_menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class animal_menuService {
    private final animal_menuRep animal_menuRep;

    @Autowired
    public animal_menuService(animal_menuRep animal_menuRep) {
        this.animal_menuRep = animal_menuRep;
    }

    public List<animal_menu> getAllAnimalMenu() {
        List<animal_menu> animal_menu = new ArrayList<>();
        animal_menuRep.findAll().forEach(animal_menu::add);
        return animal_menu;
    }

    public animal_menu getAnimalMenu(UUID id) {
        return animal_menuRep.findById(id).orElse(null);
    }

    public void addAnimalMenu(animal_menu animal_menu) {
        animal_menuRep.save(animal_menu);
    }

    public void updateAnimalMenu(animal_menu animal_menu) {
        animal_menuRep.save(animal_menu);
    }

    public void deleteAnimalMenu(UUID id) {
        animal_menuRep.deleteById(id);
    }
}
