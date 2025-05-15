package com.edtech.course.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.UUID;

public class LessonDTO {

    @JsonProperty("lesson_id")
    private UUID lessonId;

    @NotBlank(message = "Lesson title is required")
    @JsonProperty("lesson_title")
    private String lessonTitle;

    @NotBlank(message = "Lesson description is required")
    @JsonProperty("lesson_description")
    private String lessonDescription;

    @NotBlank(message = "Video URL is required")
    @Pattern(
            regexp = "^(http|https)://.*$",
            message = "Video URL must be a valid URL"
    )
    @JsonProperty("video_url")
    private String videoUrl;

    @NotBlank(message = "Duration is required")
    private String duration;

    // ✅ Add these missing getters/setters
    public UUID getLessonId() {
        return lessonId;
    }

    public void setLessonId(UUID lessonId) {
        this.lessonId = lessonId;
    }

    public String getLessonTitle() {
        return lessonTitle;
    }

    public void setLessonTitle(String lessonTitle) {
        this.lessonTitle = lessonTitle;
    }

    public String getLessonDescription() {
        return lessonDescription;
    }

    public void setLessonDescription(String lessonDescription) {
        this.lessonDescription = lessonDescription;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
