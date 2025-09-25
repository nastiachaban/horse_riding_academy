package com.example.school.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
public class Course {
    @Id
    @GeneratedValue
    private Long id;
    private String type; //idk
    private String name;
    private String description;
    private List<Student> students;
    private List<Lesson> lessons;
    private int capacity;
    private Date start;
    private Date end;

}
