package com.example.zoo.models;



import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import lombok.Setter;
import org.w3c.dom.Text;
import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "cage_animal")
public class cage_animal {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_cage_animal")
    private UUID id_cage_animal;

    @Column(name = "id_cage", columnDefinition = "UUID")
    private UUID id_cage;

    @Column(name = "id_animal", columnDefinition = "UUID")
    private UUID id_animal;

    @Column(name = "receipt_date")
    @Temporal(TemporalType.DATE)
    private Date receipt_date;


    @Column(name = "departure_date")
    @Temporal(TemporalType.DATE)
    private Date departure_date;
}
