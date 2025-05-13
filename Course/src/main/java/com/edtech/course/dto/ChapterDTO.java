package com.edtech.course.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;
import java.util.UUID;


@Data
public class ChapterDTO {

    @JsonProperty("chapter_id")
    private UUID chapterId;

    @NotBlank(message = "Topic title is required")
    @JsonProperty("chapter_title")
    private String chapterTitle;

    @NotBlank(message = "Topic description is required")
    @JsonProperty("chapter_description")
    private String chapterDescription;

    @JsonProperty("course_id")
    private UUID courseId;

    @JsonProperty("lessons")
    private List<LessonDTO> lessons;

    public UUID getChapterId() {
        return chapterId;
    }

    public void setChapterId(UUID chapterId) {
        this.chapterId = chapterId;
    }

    public String getChapterTitle() {
        return chapterTitle;
    }

    public void setChapterTitle(String chapterTitle) {
        this.chapterTitle = chapterTitle;
    }

    public String getChapterDescription() {
        return chapterDescription;
    }

    public void setChapterDescription(String chapterDescription) {
        this.chapterDescription = chapterDescription;
    }

    public UUID getCourseId() {
        return courseId;
    }

    public void setCourseId(UUID courseId) {
        this.courseId = courseId;
    }

    public List<LessonDTO> getLessons() {
        return lessons;
    }

    public void setLessons(List<LessonDTO> lessons) {
        this.lessons = lessons;
    }
}