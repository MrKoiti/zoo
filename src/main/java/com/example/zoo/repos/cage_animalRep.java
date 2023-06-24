package com.example.zoo.repos;

import com.example.zoo.models.cage_animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface cage_animalRep extends CrudRepository<cage_animal, Integer>{
}