package com.edtech.course.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "chapters")
@AllArgsConstructor
@NoArgsConstructor

public class Chapter {

    @Id
    @Column(name="chapter_id")
    @GeneratedValue
    private UUID chapterId;

    @Column
    private String chapterTitle;

    @Column
    private String chapterDescription;

    @OneToMany(mappedBy = "chapter", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Lesson> lessons;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id", referencedColumnName = "course_id")
    private Course course;

    public void setCourse(Course course) {
        this.course = course;
    }
    public void setChapterId(UUID chapterId) {
        this.chapterId = chapterId;
    }
    public void setChapterTitle(String chapterTitle) {
        this.chapterTitle = chapterTitle;
    }
    public void setChapterDescription(String chapterDescription) {
        this.chapterDescription = chapterDescription;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public UUID getChapterId() {
        return chapterId;
    }

    public String getChapterTitle() {
        return chapterTitle;
    }

    public Course getCourse() {
        return course;
    }

    public String getChapterDescription() {
        return chapterDescription;
    }
}
