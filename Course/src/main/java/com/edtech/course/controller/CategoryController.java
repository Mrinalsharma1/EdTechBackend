package com.edtech.course.controller;

import com.edtech.course.dto.ApiResponse;
import com.edtech.course.dto.CategoryDTO;
import com.edtech.course.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * Endpoint to fetch all categories.
     *
     * @return ResponseEntity containing an ApiResponse with a list of CategoryDTO objects
     *         and a success message.
     */

    @GetMapping("/getAllCategories")
    public ResponseEntity<ApiResponse<List<CategoryDTO>>> getAllCategories() {
        List<CategoryDTO> data = categoryService.getAllCategories();
        return ResponseEntity.ok(new ApiResponse<>("Categories fetched successfully", 200, data));
    }

    @PostMapping("/addCategory")
    public ResponseEntity<ApiResponse<CategoryDTO>> createCategory(@RequestBody CategoryDTO dto) {
        CategoryDTO created = categoryService.createCategory(dto);
        return ResponseEntity.status(201).body(new ApiResponse<>("Category created successfully", 201, created));
    }
}
