package com.edtech.course.service;

import com.edtech.course.dto.LessonDTO;
import com.edtech.course.dto.ChapterDTO;
import com.edtech.course.exception.CourseNotFoundException;
import com.edtech.course.exception.ChapterNotFoundException;
import com.edtech.course.mapper.ChapterMapper;
import com.edtech.course.mapper.LessonMapper;

import com.edtech.course.model.Course;
import com.edtech.course.model.Chapter;
import com.edtech.course.repository.CourseRepository;
import com.edtech.course.repository.ChapterRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ChapterService {
    @Autowired
    private ChapterRepository chapterRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ChapterMapper chapterMapper;

    @Autowired
    private LessonMapper lessonMapper;


    @Transactional
    public ChapterDTO addChapter(UUID courseId, ChapterDTO chapterDTO) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new CourseNotFoundException("Course not found with ID: " + courseId));

        System.out.println("Found course: " + course.getCourseId());
        System.out.println("Found course: " + course.getTitle());

        Chapter chapter = chapterMapper.toEntity(chapterDTO);

        chapter.setCourse(course);


        Chapter savedTopic = chapterRepository.save(chapter);
        return chapterMapper.toDto(savedTopic);
    }

    public ChapterDTO getChapter(UUID chapterId){
        Chapter chapter= chapterRepository.findById(chapterId).orElseThrow(()-> new ChapterNotFoundException("Chapter not found with ID: " + chapterId));
        return chapterMapper.toDto(chapter);
    }

    public ChapterDTO updateTopic(UUID chapterId, ChapterDTO chapterDTO){
        return chapterRepository.findById(chapterId).
                map(existingTopic->{
                    if(chapterDTO.getChapterTitle()!=null)
                        existingTopic.setChapterTitle(chapterDTO.getChapterTitle());
                    if (chapterDTO.getChapterDescription() != null)
                        existingTopic.setChapterDescription(chapterDTO.getChapterDescription());

                    return chapterRepository.save(existingTopic);

                })
                .map(chapterMapper::toDto)
                .orElseThrow(()-> new ChapterNotFoundException("Topic not found with this id " + chapterId));

    }
    public void deleteChapter(UUID chapterId) {
        chapterRepository.findById(chapterId)
                .ifPresentOrElse(
                        chapterRepository::delete,
                        () -> { throw new ChapterNotFoundException("Chapter not found with ID: " + chapterId); }
                );
    }


    public List<LessonDTO> getAllLessons(UUID chapterId) {
        Chapter chapter = chapterRepository.findById(chapterId)
                .orElseThrow(() -> new ChapterNotFoundException("Chapter not found with ID: " + chapterId));


        return chapter.getLessons()
                .stream()
                .map(lessonMapper::toDto)
                .collect(Collectors.toList());
    }

    }

