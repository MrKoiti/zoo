package com.example.zoo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "vaccination")
public class vaccination {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_vaccination")
    private UUID id_vaccination;
    @Column(name = "id_vet", columnDefinition = "UUID")
    private UUID id_vet;

    @Column(name = "id_animal", columnDefinition = "UUID")
    private UUID id_animal;

    @Column(name = "vaccination_date")
    @Temporal(TemporalType.DATE)
    private Date vaccination_date;

    @Column(name = "vaccination_name", columnDefinition = "text")
    private Date vaccination_name;
}

