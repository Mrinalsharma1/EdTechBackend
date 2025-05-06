package com.happiest.apigateway.courseservice;

import com.happiest.apigateway.courseservice.model.CourseDTO;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@FeignClient(name="http://Course/v1/course")
public interface CourseRepository {
    @PostMapping("/addCourse")
    public ResponseEntity<CourseDTO> addCourse(
            @Valid @RequestBody CourseDTO courseDTO);

    @GetMapping("/getCourseById/{id}")
    public ResponseEntity<CourseDTO> getCourse(@Valid @PathVariable UUID id);

    @PutMapping("/updateCourse/{id}")
    public ResponseEntity<CourseDTO> updateCourse(@PathVariable UUID id, @RequestBody CourseDTO courseDTO);

    @DeleteMapping("/deleteCourse/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable UUID id);

}
