package com.example.zoo.repos;

import com.example.zoo.models.feed_norm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface feed_normRep extends CrudRepository<feed_norm, Integer>{
}