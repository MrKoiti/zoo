package com.example.zoo.repos;

import com.example.zoo.models.animal_menu;
import com.example.zoo.models.animal_type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface animal_menuRep extends CrudRepository<animal_menu, UUID>{
    animal_menu save(animal_menu animal_menu);
    void delete(animal_menu animal_menu);
    void deleteById(UUID id);
    Optional<animal_menu> findById(UUID id);
}