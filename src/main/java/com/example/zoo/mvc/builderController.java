package com.example.zoo.mvc;


import com.example.zoo.repos.builderRep;
import com.example.zoo.service.builderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.zoo.models.builder;

import java.util.List;
@RestController
@RequestMapping("/builder")
public class builderController {
    private final builderRep builderRep;
    private final builderService builderService;

    @Autowired
    public builderController(builderService builderService, builderRep builderRep) {
        this.builderService = builderService;
        this.builderRep = builderRep;
    }

    @GetMapping("/getall")
    public List<builder> getAllBuilder() {
        return builderService.getAllBuilder();
    }

    @GetMapping("/{id}")
    public builder getBuilder(@PathVariable Integer id) {
        return builderService.getBuilder(id);
    }

    @PostMapping("")
    public void createBuilder(@RequestBody builder builder) {
        builderService.updateBuilder(builder);
    }

    @PutMapping("")
    public void updateBuilder(@RequestBody builder builder) {
        builderService.updateBuilder(builder);
    }

    @DeleteMapping("/{id}")
    public void deleteBuilder(@PathVariable Integer id) {
        builderService.deleteBuilder(id);
    }
}

