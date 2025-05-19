package com.edtech.teacher.dto;

import com.edtech.teacher.model.Course;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.*;
import java.util.List;
import java.util.UUID;


@NoArgsConstructor
@AllArgsConstructor
public class TeacherDTO {

    private UUID teacherId;

    @NotBlank(message = "Full name is required")
    @Size(min = 3, max = 100)
    @JsonProperty("full_name")
    private String fullName;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    @JsonProperty("profile_picture")
    private String profilePicture;

    private String bio;

    @Min(value = 0, message = "Experience must be a positive number")
    @JsonProperty("experience_years")
    private int experienceYears;

    @Size(max = 5, message = "Maximum 5 areas of expertise allowed")
    private List<String> expertise;

    private List<String> languages;

    private List<String> certifications;

    @JsonProperty("linkedin_url")
    private String linkedinUrl;

    @JsonProperty("twitter_url")
    private String twitterUrl;

    @JsonProperty("personal_website")
    private String personalWebsite;

    // Reference to Course IDs instead of actual Course objects
//    @JsonProperty("courses")
//    private List<Course> courses;

    // Reference to User ID (from API Gateway service or auth service)
    @NotNull(message = "User ID is required")
    @JsonProperty("user_id")
    private UUID userId;

    public UUID getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(UUID teacherId) {
        this.teacherId = teacherId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    public List<String> getExpertise() {
        return expertise;
    }

    public void setExpertise(List<String> expertise) {
        this.expertise = expertise;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public List<String> getCertifications() {
        return certifications;
    }

    public void setCertifications(List<String> certifications) {
        this.certifications = certifications;
    }

    public String getLinkedinUrl() {
        return linkedinUrl;
    }

    public void setLinkedinUrl(String linkedinUrl) {
        this.linkedinUrl = linkedinUrl;
    }

    public String getTwitterUrl() {
        return twitterUrl;
    }

    public void setTwitterUrl(String twitterUrl) {
        this.twitterUrl = twitterUrl;
    }

    public String getPersonalWebsite() {
        return personalWebsite;
    }

    public void setPersonalWebsite(String personalWebsite) {
        this.personalWebsite = personalWebsite;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }
}
