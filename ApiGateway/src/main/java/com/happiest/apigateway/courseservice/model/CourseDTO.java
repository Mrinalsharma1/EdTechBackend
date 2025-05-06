package com.happiest.apigateway.courseservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;

import java.util.List;
import java.util.UUID;

public class CourseDTO {

    private UUID courseId;

    @NotBlank(message = "Title is required")
    @Size(min = 3, max = 100)
    private String title;

    @NotBlank(message = "Description is required")
    private String description;

    @NotBlank(message = "Language is required")
    private String language;

    @NotEmpty(message = "Tags cannot be empty")
    @Size(min = 1, max = 5, message = "You can have up to 5 tags")
    private List<String> tags;

    @NotBlank(message = "Duration is required")
    private String duration;

    @NotBlank(message = "Difficulty level is required")
    @JsonProperty("difficulty_level")
    private String difficultyLevel;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be positive")
    private Double price;

    @NotBlank(message = "Currency is required")
    @Pattern(regexp = "^[A-Z]{3}$", message = "Currency must be a valid 3-letter currency code")
    private String currency;

    @NotBlank(message = "Enrollment status is required")
    @Pattern(regexp = "^(open|closed)$", message = "Enrollment status must be 'open' or 'closed'")
    @JsonProperty("enrollment_status")
    private String enrollmentStatus;

    @NotNull(message = "Category ID is required")
    @JsonProperty("category_id")
    private UUID categoryId;

    @NotNull(message = "Teacher ID is required")
    @JsonProperty("teacher_id")
    private UUID teacherId;

    private List<String> prerequisites;

    @JsonProperty("course_banner")
    private String courseBanner;

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


