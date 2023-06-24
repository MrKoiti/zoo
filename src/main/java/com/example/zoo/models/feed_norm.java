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
@Table(name = "feed_norm")
public class feed_norm {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_feed_norm")
    private UUID id_feed_norm;

    @Column(name = "age", columnDefinition = "integer")
    private int age;

    @Column(name = "size", columnDefinition = "integer")
    private int size;

    @Column(name = "season", columnDefinition = "character varying")
    private String season;

    @Column(name = "name", columnDefinition = "text")
    private String name;
}
