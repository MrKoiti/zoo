package com.example.zoo.service;

import com.example.zoo.repos.builderRep;
import com.example.zoo.models.builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class builderService {
    private final builderRep builderRep;

    @Autowired
    public builderService(builderRep builderRep) {
        this.builderRep = builderRep;
    }

    public List<builder> getAllBuilder() {
        List<builder> builder = new ArrayList<>();
        builderRep.findAll().forEach(builder::add);
        return builder;
    }

    public builder getBuilder(Integer id) {
        return builderRep.findById(id).orElse(null);
    }

    public void addBuilder(builder builder) {
        builderRep.save(builder);
    }

    public void updateBuilder(builder builder) {
        builderRep.save(builder);
    }

    public void deleteBuilder(Integer id) {
        builderRep.deleteById(id);
    }
}