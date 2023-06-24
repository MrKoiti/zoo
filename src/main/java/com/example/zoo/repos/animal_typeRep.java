package com.example.zoo.repos;

import com.example.zoo.models.animal_type;
import com.example.zoo.models.man;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface animal_typeRep extends CrudRepository<animal_type, UUID>{
    animal_type save(animal_type animal_type);
    void delete(animal_type animal_type);
    void deleteById(UUID id);
    Optional<animal_type> findById(UUID id);
}