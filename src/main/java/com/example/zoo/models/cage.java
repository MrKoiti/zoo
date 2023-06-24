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
@Table(name = "cage")
public class cage {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_cage")
    private UUID id_cage;
    @Column(name = "cage_type", columnDefinition = "text")
    private String cage_type;
}
