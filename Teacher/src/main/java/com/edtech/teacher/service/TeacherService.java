package com.edtech.teacher.service;

import com.edtech.teacher.dto.TeacherDTO;
import com.edtech.teacher.exception.TeacherNotFoundException;
import com.edtech.teacher.mapper.TeacherMapper;
import com.edtech.teacher.model.Teacher;
import com.edtech.teacher.model.Users;
import com.edtech.teacher.repository.TeacherRepository;
import com.edtech.teacher.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private UserRepository userRepository;

    public TeacherDTO addTeacher(@Valid TeacherDTO teacherDTO) {
        Users user = userRepository.findById(teacherDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + teacherDTO.getUserId()));

        if (!user.getEmail().equalsIgnoreCase(teacherDTO.getEmail())) {
            throw new RuntimeException("Email does not match the user with ID: " + teacherDTO.getUserId());
        }
        Teacher teacher = teacherMapper.toEntity(teacherDTO);
        teacher.setUser(user);
        Teacher savedTeacher = teacherRepository.save(teacher);
        return teacherMapper.toDto(savedTeacher);
    }

    public TeacherDTO getTeacher(@Valid UUID teacherId) {
        Teacher existingTeacher = teacherRepository.findById(teacherId).orElseThrow(() -> new TeacherNotFoundException("Teacher not found with this id" + teacherId));
        return teacherMapper.toDto(existingTeacher);
    }

    public TeacherDTO updateTeacher(UUID id, TeacherDTO teacherDTO) {
        return teacherRepository.findById(id)
                .map(existingTeacher -> {
                    if (teacherDTO.getFullName() != null && !teacherDTO.getFullName().isBlank()) {
                        existingTeacher.setFullName(teacherDTO.getFullName());
                    }
                    if (teacherDTO.getEmail() != null && !teacherDTO.getEmail().isBlank()) {
                        existingTeacher.setEmail(teacherDTO.getEmail());
                    }
                    if (teacherDTO.getProfilePicture() != null) {
                        existingTeacher.setProfilePicture(teacherDTO.getProfilePicture());
                    }
                    if (teacherDTO.getBio() != null) {
                        existingTeacher.setBio(teacherDTO.getBio());
                    }
                    if (teacherDTO.getExperienceYears() > 0) {
                        existingTeacher.setExperienceYears(teacherDTO.getExperienceYears());
                    }
                    if (teacherDTO.getExpertise() != null && !teacherDTO.getExpertise().isEmpty()) {
                        existingTeacher.setExpertise(teacherDTO.getExpertise());
                    }
                    if (teacherDTO.getLanguages() != null && !teacherDTO.getLanguages().isEmpty()) {
                        existingTeacher.setLanguages(teacherDTO.getLanguages());
                    }
                    if (teacherDTO.getCertifications() != null && !teacherDTO.getCertifications().isEmpty()) {
                        existingTeacher.setCertifications(teacherDTO.getCertifications());
                    }
                    if (teacherDTO.getLinkedinUrl() != null) {
                        existingTeacher.setLinkedinUrl(teacherDTO.getLinkedinUrl());
                    }
                    if (teacherDTO.getTwitterUrl() != null) {
                        existingTeacher.setTwitterUrl(teacherDTO.getTwitterUrl());
                    }
                    if (teacherDTO.getPersonalWebsite() != null) {
                        existingTeacher.setPersonalWebsite(teacherDTO.getPersonalWebsite());
                    }

                    return teacherRepository.save(existingTeacher);
                })
                .map(teacherMapper::toDto)
                .orElseThrow(() -> new TeacherNotFoundException("Teacher not found with ID: " + id));
    }


    public void deleteTeacher(@Valid UUID teacherId) {
        teacherRepository.findById(teacherId)
                .ifPresentOrElse(
                        teacherRepository::delete,
                        () -> {
                            throw new TeacherNotFoundException("Teacher not found with ID: " + teacherId);
                        }
                );
    }

}
