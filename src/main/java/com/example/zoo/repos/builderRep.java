package com.example.zoo.repos;

import com.example.zoo.models.builder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface builderRep extends CrudRepository<builder, Integer>{
}