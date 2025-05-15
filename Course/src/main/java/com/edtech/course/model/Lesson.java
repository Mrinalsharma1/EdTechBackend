package com.edtech.course.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "lessons")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lesson {
    @Id
    @Column(name="lesson_id")
    @GeneratedValue
    private UUID lessonId;

    @Column
    private String lessonTitle;

    @Column
    private String lessonDescription;

    @Column
    private String videoUrl;

    @Column
    private String duration;

    @ManyToOne
    @JoinColumn(name = "chapterId")
    private Chapter chapter;

    public UUID getLessonId() {
        return lessonId;
    }

    public void setLessonId(String lessonId) {
        this.lessonId = UUID.fromString(lessonId);
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

    public Chapter getChapter() {
        return chapter;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }
}

