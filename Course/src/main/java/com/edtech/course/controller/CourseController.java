package com.edtech.course.controller;

import com.edtech.course.model.Course;
import com.edtech.course.model.CourseDTO;
import com.edtech.course.service.CourseService;
import jakarta.validation.Valid;
import jakarta.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/addCourse")
    public ResponseEntity<CourseDTO> addCourse(
            @Valid @RequestBody CourseDTO courseDTO) {
        CourseDTO savedCourse = courseService.addCourse(courseDTO);
        return ResponseEntity.ok(savedCourse);
    }

    @GetMapping("/getCourseById/{id}")
    public ResponseEntity<CourseDTO> getCourse(@Valid @PathVariable UUID id){
        CourseDTO course= courseService.getCourse(id);
        return ResponseEntity.ok(course);
    }

    @PutMapping("/updateCourse/{id}")
    public ResponseEntity<CourseDTO> updateCourse(@PathVariable UUID id, @RequestBody CourseDTO courseDTO) {
        CourseDTO updatedCourse = courseService.updateCourse(id, courseDTO);
        return ResponseEntity.ok(updatedCourse);
    }

    @DeleteMapping("/deleteCourse/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable UUID id) {
        courseService.deleteCourse(id);
        return ResponseEntity.ok("Course with ID " + id + " deleted successfully.");
    }
}
