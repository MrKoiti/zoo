package com.example.zoo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "animal_type")
public class animal_type {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_animal_type")
    private UUID id_animal_type;
    @Column(name = "id_cage", columnDefinition = "UUID")
    private UUID id_cage;
    @Column(name = "id_animal_menu", columnDefinition = "UUID")
    private UUID id_animal_menu;

    @Column(name = "warm_place", columnDefinition = "text")
    private boolean warm_place;
    @Column(name = "animal_type_name", columnDefinition = "character varying")
    private String animal_type_name;
    @Column(name = "compatibility", columnDefinition = "character varying[]")
    private List<String> compatibility;
}