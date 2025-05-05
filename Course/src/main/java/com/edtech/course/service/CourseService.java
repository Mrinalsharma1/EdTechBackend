package com.edtech.course.service;

import com.edtech.course.exception.CourseNotFoundException;
import com.edtech.course.mapper.CourseMapper;
import com.edtech.course.model.Course;
import com.edtech.course.model.CourseDTO;
import com.edtech.course.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseMapper courseMapper;

    public CourseDTO addCourse(CourseDTO courseDTO) {

        Course course = courseMapper.toEntity(courseDTO);
        Course addedCourse = courseRepository.save(course);


        return courseMapper.toDto(addedCourse);
    }

    public CourseDTO getCourse(UUID id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException("Course not found with ID: " + id));

        return courseMapper.toDto(course);
    }

    public CourseDTO updateCourse(UUID id, CourseDTO courseDTO) {
        return courseRepository.findById(id)
                .map(existingCourse -> {

                    if (courseDTO.getTitle() != null) existingCourse.setTitle(courseDTO.getTitle());
                    if (courseDTO.getDescription() != null) existingCourse.setDescription(courseDTO.getDescription());
                    if (courseDTO.getCategoryId() != null) existingCourse.setCategoryId(courseDTO.getCategoryId());
                    if (courseDTO.getLanguage() != null) existingCourse.setLanguage(courseDTO.getLanguage());
                    if (courseDTO.getCourseBanner() != null) existingCourse.setCourseBanner(courseDTO.getCourseBanner());
                    if (courseDTO.getTags() != null) existingCourse.setTags(courseDTO.getTags());
                    if (courseDTO.getDuration() != null) existingCourse.setDuration(courseDTO.getDuration());
                    if (courseDTO.getDifficultyLevel() != null) existingCourse.setDifficultyLevel(courseDTO.getDifficultyLevel());
                    if (courseDTO.getPrice() != null) existingCourse.setPrice(courseDTO.getPrice());
                    if (courseDTO.getCurrency() != null) existingCourse.setCurrency(courseDTO.getCurrency());
                    if (courseDTO.getTeacherId() != null) existingCourse.setTeacherId(courseDTO.getTeacherId());
                    if (courseDTO.getPrerequisites() != null) existingCourse.setPrerequisites(courseDTO.getPrerequisites());
                    if (courseDTO.getEnrollmentStatus() != null) existingCourse.setEnrollmentStatus(courseDTO.getEnrollmentStatus());

                    return courseRepository.save(existingCourse);
                })
                .map(courseMapper::toDto)
                .orElseThrow(() -> new CourseNotFoundException("Course not found with ID: " + id));
    }





    public void deleteCourse(UUID id) {
        courseRepository.findById(id)
                .ifPresentOrElse(
                        courseRepository::delete,
                        () -> { throw new CourseNotFoundException("Course not found with ID: " + id); }
                );
    }

}

