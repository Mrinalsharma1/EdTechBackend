package com.edtech.teacher.utility;

import java.util.ResourceBundle;

public class RBundle {
    public static String getKey(String name){
        ResourceBundle rs=ResourceBundle.getBundle("constant");
        return rs.getString(name);
    }
}


