package com.edtech.course.controller;

import com.edtech.course.dto.LessonDTO;
import com.edtech.course.dto.ChapterDTO;
import com.edtech.course.service.ChapterService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/chapters")
public class ChapterController {
    private final ChapterService chapterservice;


    public ChapterController(ChapterService chapterservice) {
        this.chapterservice = chapterservice;
    }

    @PostMapping("/addChapter/{courseId}")
    public ResponseEntity<ChapterDTO> addChapter(@Valid @PathVariable UUID courseId, @RequestBody ChapterDTO chapterDTO) {
        ChapterDTO savedChapter = chapterservice.addChapter(courseId, chapterDTO);
        return ResponseEntity.ok(savedChapter);
    }

    @GetMapping("/getChapterById/{id}")
    public ResponseEntity<ChapterDTO> getChapterById(@PathVariable UUID id) {
        ChapterDTO chapter = chapterservice.getChapter(id);
        return ResponseEntity.ok(chapter);
    }

    @PutMapping("/updateChapter/{id}")
    public ResponseEntity<ChapterDTO> updateTopic(@PathVariable UUID id, @RequestBody ChapterDTO chapterDTO) {
        ChapterDTO updatedChapter = chapterservice.updateTopic(id, chapterDTO);
        return ResponseEntity.ok(updatedChapter);
    }

    @DeleteMapping("/deleteChapter/{id}")
    public ResponseEntity<String> deleteChapter(@PathVariable UUID id) {
        chapterservice.deleteChapter(id);
        return ResponseEntity.ok(" Chapter with ID " + id + " deleted successfully.");
    }

    @GetMapping("/allLessons/{chapterId}")
    public ResponseEntity<List<LessonDTO>> getAllLessons(@PathVariable UUID chapterId) {
        return ResponseEntity.ok(chapterservice.getAllLessons(chapterId));
    }
}