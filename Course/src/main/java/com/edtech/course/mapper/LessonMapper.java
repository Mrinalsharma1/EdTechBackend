package com.edtech.course.mapper;

import com.edtech.course.dto.LessonDTO;
import com.edtech.course.model.Lesson;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LessonMapper {

    @Mapping(source = "lessonId", target = "lessonId")
    @Mapping(source = "lessonTitle", target = "lessonTitle")
    @Mapping(source = "lessonDescription", target = "lessonDescription")
    @Mapping(source = "videoUrl", target = "videoUrl")
    @Mapping(source = "duration", target = "duration")
    LessonDTO toDto(Lesson lesson);

    @Mapping(source = "lessonId", target = "lessonId")
    @Mapping(source = "lessonTitle", target = "lessonTitle")
    @Mapping(source = "lessonDescription", target = "lessonDescription")
    @Mapping(source = "videoUrl", target = "videoUrl")
    @Mapping(source = "duration", target = "duration")
    @Mapping(target = "chapter", ignore = true)
    Lesson toEntity(LessonDTO lessonDto);


}
