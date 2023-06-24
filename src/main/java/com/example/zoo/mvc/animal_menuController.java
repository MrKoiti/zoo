package com.example.zoo.mvc;


import com.example.zoo.models.animal;
import com.example.zoo.repos.animal_menuRep;
import com.example.zoo.service.animal_menuService;
import com.example.zoo.service.manService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.web.bind.annotation.*;
import com.example.zoo.models.animal_menu;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
public class animal_menuController {


    private final animal_menuService animal_menuService;

    public animal_menuController(animal_menuService animal_menuService) {
        this.animal_menuService = animal_menuService;
    }
    @GetMapping("/animal_menu")
    public ModelAndView getAllAnimalMenus() {
        return new ModelAndView("animal_menu").addObject("animal_menus", animal_menuService.getAllAnimalMenu());}






    @GetMapping("/add_animal_menu")
    public ModelAndView setAll(@PathParam(value="id_feed_norm") String id_feed_norm, @PathParam (value="provider") String provider, @PathParam (value="since") Date since, @PathParam (value="amount_tpy") Integer amount_tpy) {
        if (provider != null){
            animal_menu animal_menu = new animal_menu();
            animal_menu.setId_feed_norm(UUID.fromString(id_feed_norm));
            animal_menu.setProvider(provider);
            animal_menu.setSince(since);
            animal_menu.setAmount_tpy(amount_tpy);;
            animal_menu.setId_animal_menu(UUID.randomUUID());
            animal_menuService.addAnimalMenu(animal_menu);
            return new ModelAndView("animal_menu").addObject("animal_menus", animal_menuService.getAllAnimalMenu());
        }
        return new ModelAndView("add_animal_menu");
    }



    @GetMapping("/delete_animal_menu")
    public ModelAndView delette(@PathParam (value="id_animal_menu") String id_animal_menu) {
        if (id_animal_menu != null){
            animal_menuService.deleteAnimalMenu(UUID.fromString(id_animal_menu));
            return new ModelAndView("animals").addObject("animal_menus", animal_menuService.getAllAnimalMenu());
        }
        return new ModelAndView("delete_animal_menu");
    }



}

