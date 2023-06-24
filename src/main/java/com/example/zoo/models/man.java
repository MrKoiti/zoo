package com.example.zoo.models;

import jakarta.persistence.criteria.CriteriaBuilder;
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
@Table(name = "man")
public class man {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_man")
    UUID id_man;
    @Column(name = "man_name", columnDefinition = "text")
    String man_name;
    @Column(name = "man_age", columnDefinition = "integer")
    int man_age;
    @Column(name = "man_profession", columnDefinition = "text")
    String man_profession;
    @Column(name = "salary", columnDefinition = "integer")
    int salary;
}



