package com.example.school.entities;

import com.example.school.entities.enums.TeacherType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Teacher extends Account{

//    @Id
//    @GeneratedValue
//    private Long id;
    private String firstname;
    private String lastname;

    @OneToMany
    private List<Review> reviews;

    private Date birthDate;

    private int age;

    @Enumerated(EnumType.STRING)
    private TeacherType teacherType;

}
