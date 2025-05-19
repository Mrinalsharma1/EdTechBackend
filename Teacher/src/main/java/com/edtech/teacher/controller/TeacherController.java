package com.edtech.teacher.controller;

import com.edtech.teacher.dto.TeacherDTO;
import com.edtech.teacher.service.TeacherService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1/api/teachers")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @PostMapping("/addTeacher")
    public ResponseEntity<TeacherDTO> addTeacher(@Valid  @RequestBody TeacherDTO teacherDTO){
        TeacherDTO savedTeacher=teacherService.addTeacher(teacherDTO);
        return ResponseEntity.ok(savedTeacher);

    }

    @GetMapping("/getTeacher/{teacherId}")
    public ResponseEntity<TeacherDTO> getTeacher(@Valid @PathVariable UUID teacherId){
        TeacherDTO savedTeacher=teacherService.getTeacher(teacherId);
        return ResponseEntity.ok(savedTeacher);

    }

    @PutMapping("/updateTeacher/{teacherId}")
    public ResponseEntity<TeacherDTO> addTeacher(@Valid  @PathVariable UUID teacherId, @RequestBody TeacherDTO teacherDTO){
        TeacherDTO savedTeacher=teacherService.updateTeacher(teacherId,teacherDTO);
        return ResponseEntity.ok(savedTeacher);

    }

    @DeleteMapping("/deleteTeacher/{teacherId}")
    public ResponseEntity<String> addTeacher(@Valid  @PathVariable UUID teacherId){
        teacherService.deleteTeacher(teacherId);
         return ResponseEntity.ok("Course with ID " + teacherId + " deleted successfully.");

    }




}
