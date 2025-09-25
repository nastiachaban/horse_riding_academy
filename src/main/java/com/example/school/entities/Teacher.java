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
public class Teacher {

    @Id
    @GeneratedValue
    private Long id;
    private String firstname;
    private String lastname;

    @ManyToOne
    private List<Review> reviews;

    @OneToOne
    private Account account;

    private Date birthDate;

    private int age;

    @Enumerated(EnumType.STRING)
    private TeacherType teacherType;

}
