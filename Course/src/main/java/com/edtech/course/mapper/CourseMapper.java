package com.edtech.course.mapper;

import com.edtech.course.model.Course;
import com.edtech.course.model.CourseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface CourseMapper {



//    @Mapping(source = "categoryId", target = "category_Id", qualifiedByName = "uuidToString")
//    @Mapping(source = "courseBanner", target = "course_Banner")
//    @Mapping(source = "difficultyLevel", target = "difficulty_level")
//    @Mapping(source = "teacherId", target = "teacher_id", qualifiedByName = "uuidToString")
//    @Mapping(source = "enrollmentStatus", target = "enrollment_status")
    CourseDTO toDto(Course course);

//    @Mapping(source = "categoryId", target = "categoryId")
//    @Mapping(source = "courseBanner", target = "courseBanner")
    @Mapping(source = "difficultyLevel", target = "difficultyLevel")
//    @Mapping(source = "teacherId", target = "teacherId")
//    @Mapping(source = "enrollmentStatus", target = "enrollmentStatus")
    Course toEntity(CourseDTO courseDTO);


    @Named("uuidToString")
    static UUID uuidFromString(String id) {
        return id != null ? UUID.fromString(id) : null;
    }

    @Named("stringToUuid")
    static String stringFromUuid(UUID id) {
        return id != null ? id.toString() : null;
    }
}

