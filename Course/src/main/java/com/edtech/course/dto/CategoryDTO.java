package com.edtech.course.dto;

import java.util.*;

public class CategoryDTO extends BaseDTO {
    private Long id;
    private String name;
    private List<SubCategoryDTO> subcategories;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<SubCategoryDTO> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<SubCategoryDTO> subcategories) {
        this.subcategories = subcategories;
    }

}
