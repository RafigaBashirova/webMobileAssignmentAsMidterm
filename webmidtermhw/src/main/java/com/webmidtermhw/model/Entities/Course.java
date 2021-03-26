package com.webmidtermhw.model.Entities;

import com.webmidtermhw.model.dataTransferObjects.CourseModel;

import javax.persistence.*;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String instructor;

    public Course() {
    }

    public Course(CourseModel courseModel) {
        this.name = courseModel.getName();
        this.instructor = courseModel.getInstructor();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
