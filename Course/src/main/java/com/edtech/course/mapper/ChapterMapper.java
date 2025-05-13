package com.edtech.course.mapper;

import com.edtech.course.dto.ChapterDTO;
import com.edtech.course.model.Chapter;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", uses = LessonMapper.class, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ChapterMapper {
    ChapterDTO toDto(Chapter chapter);
    Chapter toEntity(ChapterDTO chapterDto);

    @Named("uuidToString")
    static java.util.UUID uuidFromString(String id) {
        return id != null ? java.util.UUID.fromString(id) : null;
    }

    @Named("stringToUuid")
    static String stringFromUuid(java.util.UUID id) {
        return id != null ? id.toString() : null;
    }
}
