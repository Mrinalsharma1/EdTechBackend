package com.edtech.course.controller;

import com.edtech.course.dto.LessonDTO;
import com.edtech.course.service.LessonService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/lessons")
public class LessonController {
    private final LessonService lessonService;

    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @PostMapping("/addLesson/{chapterId}")
    public ResponseEntity<LessonDTO> addTopic(@Valid @PathVariable UUID chapterId, @RequestBody LessonDTO lessonDTO) {
        LessonDTO savedLesson = lessonService.addLesson(chapterId,lessonDTO);
        return ResponseEntity.ok(savedLesson);
    }

    @GetMapping("/getLessonById/{id}")
    public ResponseEntity<LessonDTO> getLessonById(@PathVariable UUID id) {
        LessonDTO lesson = lessonService.getLesson(id);
        return ResponseEntity.ok(lesson);
    }

    @PutMapping("/updateLesson/{id}")
    public ResponseEntity<LessonDTO> updateTopic(@PathVariable UUID id, @RequestBody LessonDTO lessonDTO) {
        LessonDTO updatedTopic = lessonService.updateLesson(id, lessonDTO);
        return ResponseEntity.ok(updatedTopic);
    }

    @DeleteMapping("/deleteLesson/{id}")
    public ResponseEntity<String> deleteTopic(@PathVariable UUID id) {
        lessonService.deleteLesson(id);
        return ResponseEntity.ok("Topic with ID " + id + " deleted successfully.");
    }


}
