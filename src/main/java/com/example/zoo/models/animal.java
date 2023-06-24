package com.example.zoo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import lombok.Setter;
import org.w3c.dom.Text;
import java.util.UUID;

@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "animal")
public class animal {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_animal")
    private UUID id_animal;

    @Column(name = "id_animal_type", columnDefinition = "UUID")
    private UUID id_animal_type;

    @Column(name = "health_state", columnDefinition = "text")
    private String health_state;
    @Column(name = "weight", columnDefinition = "integer")
    private int weight;
    @Column(name = "height", columnDefinition = "integer")
    private int height;
    @Column(name = "animal_name", columnDefinition = "text")
    private String animal_name;
}
