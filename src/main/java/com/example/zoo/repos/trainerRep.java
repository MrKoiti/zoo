package com.example.zoo.repos;

import com.example.zoo.models.trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface trainerRep extends CrudRepository<trainer, Integer>{
}