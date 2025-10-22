package com.example.school.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@DiscriminatorValue("worker")
public class Worker extends Account {

//    @Id
//    @GeneratedValue
//    private Long id;
    private String firstname;
    private String lastname;
    private int age;

}
