package com.edtech.course.service;

import com.edtech.course.dto.LessonDTO;
import com.edtech.course.exception.LessonNotFoundException;
import com.edtech.course.exception.ChapterNotFoundException;
import com.edtech.course.mapper.LessonMapper;
import com.edtech.course.model.Lesson;
import com.edtech.course.model.Chapter;
import com.edtech.course.repository.LessonRepository;
import com.edtech.course.repository.ChapterRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LessonService {
    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private ChapterRepository chapterRepository;

    @Autowired
    private LessonMapper lessonMapper;

    @Transactional
    public LessonDTO addLesson(UUID chapterId, LessonDTO lessonDTO) {
        Chapter chapter = chapterRepository.findById(chapterId)
                .orElseThrow(() -> new ChapterNotFoundException("Chapter not found with ID: " + chapterId));
        System.out.println(chapter.getChapterTitle());
        System.out.println(lessonDTO.getLessonDescription());
        Lesson lesson = lessonMapper.toEntity(lessonDTO);
        System.out.println(lesson.getLessonTitle());
        lesson.setChapter(chapter);
        System.out.println(lesson.getChapter());

        Lesson savedLesson = lessonRepository.save(lesson);
        System.out.println(savedLesson.getLessonTitle());
        LessonDTO result=lessonMapper.toDto(savedLesson);//not working
        System.out.println(result.getLessonTitle());
        return result;


    }

    public LessonDTO getLesson(UUID lessonId) {
        Lesson lesson = lessonRepository.findById(lessonId)
                .orElseThrow(() -> new LessonNotFoundException("Lesson not found with ID: " + lessonId));
        return lessonMapper.toDto(lesson);
    }

    public LessonDTO updateLesson(UUID lessonId, LessonDTO lessonDTO) {
        return lessonRepository.findById(lessonId)
                .map(existingLesson -> {
                    if (lessonDTO.getLessonTitle() != null)
                        existingLesson.setLessonTitle(lessonDTO.getLessonTitle());

                    if (lessonDTO.getLessonDescription() != null)
                        existingLesson.setLessonDescription(lessonDTO.getLessonDescription());

                    if (lessonDTO.getVideoUrl() != null)
                        existingLesson.setVideoUrl(lessonDTO.getVideoUrl());

                    if (lessonDTO.getDuration() != null)
                        existingLesson.setDuration(lessonDTO.getDuration());

                    return lessonRepository.save(existingLesson);
                })
                .map(lessonMapper::toDto)
                .orElseThrow(() -> new LessonNotFoundException("Lesson not found with ID: " + lessonId));
    }

    public void deleteLesson(UUID lessonId) {
        lessonRepository.findById(lessonId)
                .ifPresentOrElse(
                        lessonRepository::delete,
                        () -> { throw new LessonNotFoundException("Lesson not found with ID: " + lessonId); }
                );
    }
}
