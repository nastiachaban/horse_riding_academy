package com.example.school.entities;

import com.example.school.entities.enums.Breed;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Horse {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Breed breed;
    private int age;
    private String description;
    private Picture picture;
    @OneToOne
    private Stable stable;


}
