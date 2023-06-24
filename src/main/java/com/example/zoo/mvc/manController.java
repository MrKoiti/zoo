package com.example.zoo.mvc;


import com.example.zoo.repos.manRep;
import com.example.zoo.service.animalService;
import com.example.zoo.service.manService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.zoo.models.man;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@RestController
public class manController {
    private final manService manService;

    public manController(manService manService) {
        this.manService = manService;
    }
    @GetMapping("/man")
    public ModelAndView getAllMan() {
        return new ModelAndView("man").addObject("mans", manService.getAllMan());
    }
}

