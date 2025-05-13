package com.edtech.course.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class LessonDTO {
    @JsonProperty("lesson_id")
    private String lessonId;

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

    public String getLessonTitle() {
        return lessonTitle;
    }

    public String getLessonDescription() {
        return lessonDescription;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public String getDuration() {
        return duration;
    }
}

