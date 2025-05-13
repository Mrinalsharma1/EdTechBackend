package com.edtech.course.exception;

import com.edtech.course.constants.PredefinedConstants;
import com.edtech.course.utility.RBundle;

public class LessonNotFoundException extends RuntimeException{
    public LessonNotFoundException() {
        super(RBundle.getKey(PredefinedConstants.LESSON_NOT_FOUND));
    }
    public LessonNotFoundException(String message) {
        super(message);
    }
}

