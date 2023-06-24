package com.example.zoo.mvc;


import com.example.zoo.repos.animal_typeRep;
import com.example.zoo.service.animal_typeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.zoo.models.animal_type;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@RestController
public class animal_typeController {
    private final animal_typeService animal_typeService;

    public animal_typeController(animal_typeService animal_typeService) {
        this.animal_typeService = animal_typeService;
    }
    @GetMapping("/animal_type")
    public ModelAndView getAllAnimalTypes() {
        return new ModelAndView("animal_type").addObject("animal_types", animal_typeService.getAllAnimalType());}
}

