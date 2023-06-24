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
@Table(name = "animal_menu")
public class animal_menu {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_animal_menu")
    private UUID id_animal_menu;
    @Column(name = "id_feed_norm", columnDefinition = "UUID")
    private UUID id_feed_norm;

    @Column(name = "provider", columnDefinition = "character varying")
    private String provider;
    @Column(name = "since")
    @Temporal(TemporalType.DATE)
    private Date since;
    @Column(name = "amount_tpy", columnDefinition = "integer")
    private int amount_tpy;
}