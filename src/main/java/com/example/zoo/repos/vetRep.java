package com.example.zoo.repos;

import com.example.zoo.models.vet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface vetRep extends CrudRepository<vet, Integer>{
}