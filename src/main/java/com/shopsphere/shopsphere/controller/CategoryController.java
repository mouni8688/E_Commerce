package com.shopsphere.shopsphere.controller;

import com.shopsphere.shopsphere.entity.Category;
import com.shopsphere.shopsphere.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor

public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    public Category saveCategory(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }
}
