package com.example.school.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToOne;

import java.io.Serializable;
import java.util.Date;

@Embeddable
public class LessonId implements Serializable {

    @OneToOne
    public Teacher teacher;
    public Date date;

}
