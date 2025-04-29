package com.edtech.course.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;



import com.fasterxml.jackson.annotation.JsonProperty;

    public class CourseDTO {

        private UUID courseId;
        private String title;
        private String description;

        @JsonProperty("course_Banner")
        private String courseBanner;

        private String language;

        private List<String> tags;
        private String duration;

        @JsonProperty("difficulty_level")
        private String difficultyLevel;

        private Double price;
        private String currency;

        @JsonProperty("teacher_id")
        private UUID teacherId;

        private List<String> prerequisites;

        @JsonProperty("enrollment_status")
        private String enrollmentStatus;

        @JsonProperty("categoryId")
        private UUID categoryId;

        // Getters and setters
        public UUID getCourseId() {
            return courseId;
        }

        public void setCourseId(UUID courseId) {
            this.courseId = courseId;
        }

        public String getTitle() {
            return title;
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

        public String getCourseBanner() {
            return courseBanner;
        }

        public void setCourseBanner(String courseBanner) {
            this.courseBanner = courseBanner;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public List<String> getTags() {
            return tags;
        }

        public void setTags(List<String> tags) {
            this.tags = tags;
        }

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

        public List<String> getPrerequisites() {
            return prerequisites;
        }

        public void setPrerequisites(List<String> prerequisites) {
            this.prerequisites = prerequisites;
        }

        public String getEnrollmentStatus() {
            return enrollmentStatus;
        }

        public void setEnrollmentStatus(String enrollmentStatus) {
            this.enrollmentStatus = enrollmentStatus;
        }

        public UUID getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(UUID categoryId) {
            this.categoryId = categoryId;
        }
    }


