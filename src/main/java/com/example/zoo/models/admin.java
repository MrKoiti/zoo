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
@Table(name = "admin")
public class admin {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_admin")
    private UUID id_admin;
    @Column(name = "id_man", columnDefinition = "UUID")
    private UUID id_man;
}

