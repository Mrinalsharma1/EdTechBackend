package com.edtech.course.exception;

import com.edtech.course.constants.PredefinedConstants;
import com.edtech.course.utility.RBundle;

public class CourseNotFoundException extends RuntimeException{

        public CourseNotFoundException() {
            super(RBundle.getKey(PredefinedConstants.CNA));
        }
        public CourseNotFoundException(String message) {
            super(message);
        }


}
