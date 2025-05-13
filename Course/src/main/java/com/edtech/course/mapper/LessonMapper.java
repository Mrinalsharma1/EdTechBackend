package com.edtech.course.mapper;

import com.edtech.course.dto.LessonDTO;
import com.edtech.course.model.Lesson;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface LessonMapper {
    LessonDTO toDto(Lesson lesson);
    Lesson toEntity(LessonDTO lessonDto);


    @Named("uuidToString")
    static UUID uuidFromString(String id) {
        return id != null ? UUID.fromString(id) : null;
    }

    @Named("stringToUuid")
    static String stringFromUuid(UUID id) {
        return id != null ? id.toString() : null;
    }
}
