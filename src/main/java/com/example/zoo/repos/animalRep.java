package com.example.zoo.repos;

import com.example.zoo.models.animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface animalRep extends CrudRepository<animal, UUID>{
    animal save(animal animal);
    void delete(animal animal);
    void deleteById(UUID id);
    Optional<animal> findByWeight(Integer weight);
}