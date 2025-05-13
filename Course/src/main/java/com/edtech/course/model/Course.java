package com.edtech.course.model;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;
import java.util.UUID;


@Entity
@Data
@Table(name= "courses")
public class Course {

    @Id
    @Column(name="course_id")
    @GeneratedValue
    private UUID courseId;

    @Column
    private String title;
    @Column
    private String description;
    @Column
    private UUID categoryId;
    @Column
    private String language;
    @Column
    private String courseBanner;

//    @Column
//    @ElementCollection
//    private List<String> tags;

    @Column
    private String duration;
    @Column
    private String difficultyLevel;
    @Column
    private Double price;
    @Column
    private String currency;
    @Column
    private UUID teacherId;

//    @Column
//    @ElementCollection
//    private List<String> prerequisites;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Chapter> chapters;

    private String enrollmentStatus;


    public List<Chapter> getChapters() {
        return chapters;
    }

    public UUID getCourseId() {
        return courseId;
    }

    public String getTitle() {
        return title;
    }

    public void setCourseId(UUID courseId) {
        this.courseId = courseId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UUID getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(UUID categoryId) {
        this.categoryId = categoryId;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCourseBanner() {
        return courseBanner;
    }

    public void setCourseBanner(String courseBanner) {
        this.courseBanner = courseBanner;
    }

//    public List<String> getTags() {
//        return tags;
//    }
//
//    public void setTags(List<String> tags) {
//        this.tags = tags;
//    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public UUID getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(UUID teacherId) {
        this.teacherId = teacherId;
    }
//
//    public List<String> getPrerequisites() {
//        return prerequisites;
//    }
//
//    public void setPrerequisites(List<String> prerequisites) {
//        this.prerequisites = prerequisites;
//    }

    public String getEnrollmentStatus() {
        return enrollmentStatus;
    }

    public void setEnrollmentStatus(String enrollmentStatus) {
        this.enrollmentStatus = enrollmentStatus;
    }


}

