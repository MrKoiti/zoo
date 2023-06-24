package com.example.zoo.repos;

import com.example.zoo.models.animal;
import com.example.zoo.models.man;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface manRep extends CrudRepository<man, UUID>{
    man save(man man);
    void delete(man man);
    void deleteById(UUID id);
    Optional<man> findById(UUID id);
}