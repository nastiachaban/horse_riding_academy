package com.example.school.entities;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DiscriminatorValue("student")
public class Student extends Account{
//    @Id
//    @GeneratedValue
//    private Long id;
    private String firstname;
    private String lastname;
    private int age;

    @OneToOne
    private Horse horse;
    private boolean under_18;



}
