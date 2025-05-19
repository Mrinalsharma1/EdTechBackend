package com.edtech.teacher.mapper;

import com.edtech.teacher.model.Teacher;
import com.edtech.teacher.dto.TeacherDTO;

import com.edtech.teacher.model.Users;
import org.mapstruct.*;

import java.util.UUID;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TeacherMapper {

    @Mapping(source = "teacherId", target = "teacherId")
    @Mapping(source = "fullName", target = "fullName")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "profilePicture", target = "profilePicture")
    @Mapping(source = "bio", target = "bio")
    @Mapping(source = "experienceYears", target = "experienceYears")
    @Mapping(source = "expertise", target = "expertise")
    @Mapping(source = "languages", target = "languages")
    @Mapping(source = "certifications", target = "certifications")
    @Mapping(source = "linkedinUrl", target = "linkedinUrl")
    @Mapping(source = "twitterUrl", target = "twitterUrl")
    @Mapping(source = "personalWebsite", target = "personalWebsite")
    // Map user entity's id to userId in DTO
    @Mapping(source = "user.id", target = "userId")
    TeacherDTO toDto(Teacher teacher);

    @Mapping(source = "teacherId", target = "teacherId")
    @Mapping(source = "fullName", target = "fullName")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "profilePicture", target = "profilePicture")
    @Mapping(source = "bio", target = "bio")
    @Mapping(source = "experienceYears", target = "experienceYears")
    @Mapping(source = "expertise", target = "expertise")
    @Mapping(source = "languages", target = "languages")
    @Mapping(source = "certifications", target = "certifications")
    @Mapping(source = "linkedinUrl", target = "linkedinUrl")
    @Mapping(source = "twitterUrl", target = "twitterUrl")
    @Mapping(source = "personalWebsite", target = "personalWebsite")
//    @Mapping(target = "course", ignore = true)
    Teacher toEntity(TeacherDTO teacherDTO);

//    // Helper method to convert userId to Users entity (for toEntity mapping)
//    default Users mapUserIdToUser(UUID userId) {
//        if (userId == null) {
//            return null;
//        }
//        Users user = new Users();
//        user.setId(userId);
//        return user;
//    }
}
