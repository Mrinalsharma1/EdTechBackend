package com.edtech.course.dto;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseDTO {
    private Map<String, Object> extendedMap = new HashMap<>();

    public Map<String, Object> getExtendedMap() {
        return extendedMap;
    }

    public void setExtendedMap(Map<String, Object> extendedMap) {
        this.extendedMap = extendedMap;
    }
    public void addExtendedProperty(String key, Object value) {
        this.extendedMap.put(key, value);
    }

}
