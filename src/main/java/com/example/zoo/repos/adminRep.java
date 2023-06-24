package com.example.zoo.repos;

import com.example.zoo.models.admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface adminRep extends CrudRepository<admin, Integer>{
}
