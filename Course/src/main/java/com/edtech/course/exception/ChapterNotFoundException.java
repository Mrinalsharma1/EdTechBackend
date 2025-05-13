package com.edtech.course.exception;

import com.edtech.course.constants.PredefinedConstants;
import com.edtech.course.utility.RBundle;

public class ChapterNotFoundException extends RuntimeException{
    public ChapterNotFoundException() {
        super(RBundle.getKey(PredefinedConstants.TOPIC_NOT_FOUND));
    }
        public ChapterNotFoundException(String message) {
        super(message);
    }
}
