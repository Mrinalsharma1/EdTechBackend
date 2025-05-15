package com.edtech.course.mapper;

import com.edtech.course.dto.ChapterDTO;
import com.edtech.course.model.Chapter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", uses = LessonMapper.class, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ChapterMapper {

    @Mapping(source = "chapterId", target = "chapterId")
    @Mapping(source = "chapterTitle", target = "chapterTitle")
    @Mapping(source = "chapterDescription", target = "chapterDescription")
    @Mapping(target = "course", ignore = true)
    @Mapping(source = "lessons", target = "lessons")
    Chapter toEntity(ChapterDTO chapterDto);

    @Mapping(source = "chapterId", target = "chapterId")
    @Mapping(source = "chapterTitle", target = "chapterTitle")
    @Mapping(source = "chapterDescription", target = "chapterDescription")
    @Mapping(source = "course.courseId", target = "courseId")
    @Mapping(source = "lessons", target = "lessons")
    ChapterDTO toDto(Chapter chapter);
}

