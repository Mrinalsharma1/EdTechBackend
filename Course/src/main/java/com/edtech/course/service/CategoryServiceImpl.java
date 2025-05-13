package com.edtech.course.service;

import com.edtech.course.dto.CategoryDTO;
import com.edtech.course.dto.SubCategoryDTO;

import com.edtech.course.dto.TopicDTO;
import com.edtech.course.model.Category;
import com.edtech.course.model.SubCategory;

import com.edtech.course.model.Topic;
import com.edtech.course.repository.CategoryRepository;
import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryDTO> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        if (categories.isEmpty()) throw new ResourceNotFoundException("No categories found.");

        return categories.stream().map(this::mapToCategoryDTO).collect(Collectors.toList());
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO dto) {
        Category category = new Category();
        category.setId(dto.getId());
        category.setName(dto.getName());

        List<SubCategory> subList = new ArrayList<>();
        for (SubCategoryDTO scDto : dto.getSubcategories()) {
            SubCategory sc = new SubCategory();
            sc.setId(scDto.getId());
            sc.setName(scDto.getName());
            sc.setCategory(category);

            List<Topic> topics = new ArrayList<>();
            for (TopicDTO tDto : scDto.getTopics()) {
                Topic t = new Topic();
                t.setId(tDto.getId());
                t.setName(tDto.getName());
                t.setSubCategory(sc);
                topics.add(t);
            }
            sc.setTopics(topics);
            subList.add(sc);
        }

        category.setSubcategories(subList);
        categoryRepository.save(category);
        return mapToCategoryDTO(category);
    }

    private CategoryDTO mapToCategoryDTO(Category category) {
        CategoryDTO dto = new CategoryDTO();
        dto.setId(category.getId());
        dto.setName(category.getName());
        dto.setSubcategories(category.getSubcategories().stream().map(this::mapToSubCategoryDTO).collect(Collectors.toList()));
        return dto;
    }

    private SubCategoryDTO mapToSubCategoryDTO(SubCategory sub) {
        SubCategoryDTO dto = new SubCategoryDTO();
        dto.setId(sub.getId());
        dto.setName(sub.getName());
        dto.setTopics(sub.getTopics().stream().map(t -> {
            TopicDTO tdto= new TopicDTO();
//            tdto.setId(t.getId());
//            tdto.setName(t.getName());
            return tdto;
        }).collect(Collectors.toList()));
        return dto;
    }
}