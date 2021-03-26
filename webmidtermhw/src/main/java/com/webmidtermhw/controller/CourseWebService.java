package com.webmidtermhw.controller;

import com.webmidtermhw.dataAccessObjects.RepositoryForCourse;
import com.webmidtermhw.model.Entities.Course;
import com.webmidtermhw.model.dataTransferObjects.CourseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
public class CourseWebService {
    @Autowired
    RepositoryForCourse repositoryForCourse;

    //list all courses
    @GetMapping
    public ResponseEntity<?> listCourses(){
        return ResponseEntity.ok(repositoryForCourse.findAll());
    }

    //add course
    @PostMapping
    public ResponseEntity<?> createCourse(@RequestBody CourseModel courseModel){
        Course course = new Course(courseModel);
        return ResponseEntity.ok(repositoryForCourse.save(course));
    }
}
