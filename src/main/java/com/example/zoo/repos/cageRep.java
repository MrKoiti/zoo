package com.example.zoo.repos;

import com.example.zoo.models.cage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface cageRep extends CrudRepository<cage, Integer>{
}