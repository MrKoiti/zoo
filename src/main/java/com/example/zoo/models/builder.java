package com.example.zoo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "builder")
public class builder {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_builder")
    private UUID id_builder;
    @Column(name = "id_man", columnDefinition = "UUID")
    private UUID id_man;
}

