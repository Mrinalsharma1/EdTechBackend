package com.edtech.teacher.exception;


import com.edtech.teacher.constants.PredefinedConstants;
import com.edtech.teacher.utility.RBundle;

public class TeacherNotFoundException extends RuntimeException{
    public TeacherNotFoundException() {
        super(RBundle.getKey(PredefinedConstants.TEACHER_NOT_FOUND));
    }
    public TeacherNotFoundException(String message) {
        super(message);
    }
}
