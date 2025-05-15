package com.edtech.course.mapper;

import com.edtech.course.model.Course;
import com.edtech.course.dto.CourseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", uses = ChapterMapper.class, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CourseMapper {

    @Mapping(source = "courseId", target = "courseId")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "categoryId", target = "categoryId")
    @Mapping(source = "language", target = "language")
    @Mapping(source = "courseBanner", target = "courseBanner")
    @Mapping(source = "tags", target = "tags")
    @Mapping(source = "duration", target = "duration")
    @Mapping(source = "difficultyLevel", target = "difficultyLevel")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "currency", target = "currency")
    @Mapping(source = "teacherId", target = "teacherId")
    @Mapping(source = "prerequisites", target = "prerequisites")
    @Mapping(source = "chapters", target = "chapters")
    @Mapping(source = "enrollmentStatus", target = "enrollmentStatus")
    Course toEntity(CourseDTO courseDto);

    @Mapping(source = "courseId", target = "courseId")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "categoryId", target = "categoryId")
    @Mapping(source = "language", target = "language")
    @Mapping(source = "courseBanner", target = "courseBanner")
    @Mapping(source = "tags", target = "tags")
    @Mapping(source = "duration", target = "duration")
    @Mapping(source = "difficultyLevel", target = "difficultyLevel")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "currency", target = "currency")
    @Mapping(source = "teacherId", target = "teacherId")
    @Mapping(source = "prerequisites", target = "prerequisites")
    @Mapping(source = "chapters", target = "chapters")
    @Mapping(source = "enrollmentStatus", target = "enrollmentStatus")
    CourseDTO toDto(Course course);
}
