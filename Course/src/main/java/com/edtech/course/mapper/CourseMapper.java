package com.edtech.course.mapper;

import com.edtech.course.model.Course;
import com.edtech.course.dto.CourseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.UUID;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CourseMapper {

//    @Mapping(target = "prerequisites", ignore = true)
    Course toEntity(CourseDTO dto);

//    @Mapping(target = "prerequisites", ignore = true)
    CourseDTO toDto(Course entity);
}
