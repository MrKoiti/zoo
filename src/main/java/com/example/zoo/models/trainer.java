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
@Table(name = "trainer")
public class trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_trainer")
    private UUID id_trainer;
    @Column(name = "id_man", columnDefinition = "UUID")
    private UUID id_man;

    @Column(name = "animal_type", columnDefinition = "text")
    private String animal_type;
}