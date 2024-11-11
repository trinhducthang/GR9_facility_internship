package com.soa.manageLaptop.controller;

import com.soa.manageLaptop.dto.response.request.CategoryRequest;
import com.soa.manageLaptop.model.Category;
import com.soa.manageLaptop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody CategoryRequest categoryRequest) {
        return new ResponseEntity<>(categoryService.saveCategory(categoryRequest.getName(), categoryRequest.getIds()), HttpStatus.CREATED);
    }

}
