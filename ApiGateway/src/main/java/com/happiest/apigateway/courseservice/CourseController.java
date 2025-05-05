package com.happiest.apigateway.courseservice;

import com.happiest.apigateway.courseservice.model.CourseDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public class CourseController {

    @Autowired
    private CourseRepository courseRepository;


    @PostMapping("/addCourse")
    public ResponseEntity<CourseDTO> addCourse(
            @Valid @RequestBody CourseDTO courseDTO) {
        CourseDTO savedCourse = courseRepository.addCourse(courseDTO).getBody();
        return ResponseEntity.ok(savedCourse);
    }

    @GetMapping("/getCourseById/{id}")
    public ResponseEntity<CourseDTO> getCourse(@Valid @PathVariable UUID id){
        CourseDTO course= courseRepository.getCourse(id).getBody();
        return ResponseEntity.ok(course);
    }

    @PutMapping("/updateCourse/{id}")
    public ResponseEntity<CourseDTO> updateCourse(@PathVariable UUID id, @RequestBody CourseDTO courseDTO) {
        CourseDTO updatedCourse = courseRepository.updateCourse(id, courseDTO).getBody();
        return ResponseEntity.ok(updatedCourse);
    }

    @DeleteMapping("/deleteCourse/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable UUID id) {
        courseRepository.deleteCourse(id);
        return ResponseEntity.ok("Course with ID " + id + " deleted successfully.");
    }

}
