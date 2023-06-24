package com.example.zoo.mvc;


import com.example.zoo.repos.animalRep;
import com.example.zoo.service.animalService;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.zoo.models.animal;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;
import java.util.UUID;

@RestController
public class animalController {
    private final animalService animalService;


    public animalController(animalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping("/animals")
    public ModelAndView getAllAnimal() {
        return new ModelAndView("animals").addObject("animals", animalService.getAllAnimal());
    }


    @GetMapping("/add_animal")
    public ModelAndView setAll(@PathParam (value="animal_name") String animal_name, @PathParam (value="height") Integer height, @PathParam (value="weight") Integer weight, @PathParam (value="health_state") String health_state, @PathParam (value="id_animal_type") String id_animal_type) {
        if (animal_name != null){
            animal animal = new animal();
            animal.setAnimal_name(animal_name);
            animal.setId_animal_type(UUID.fromString(id_animal_type));
            animal.setWeight(weight);
            animal.setHeight(height);
            animal.setHealth_state(health_state);
            animal.setId_animal(UUID.randomUUID());
            animalService.addAnimal(animal);
            return new ModelAndView("animals").addObject("add_animal", animalService.getAllAnimal());
        }
        return new ModelAndView("add_animal");
    }



    @GetMapping("/delete_animal")
    public ModelAndView delete(@PathParam (value="id_animal") String id_animal) {
        if (id_animal != null){
            animalService.deleteAnimal(UUID.fromString(id_animal));
            return new ModelAndView("animals").addObject("delete_animal", animalService.getAllAnimal());
        }
        return new ModelAndView("delete_animal");
    }


    @GetMapping("/byWeight_param")
    public ModelAndView delete(@PathParam (value="weight") Integer weight) {
        if (weight != null){
            var aw = animalService.getAnimalWeight(weight);
            return new ModelAndView("byWeight_search").addObject("weight_animal", aw);
        }
        return new ModelAndView("byWeight_param");
    }



}

