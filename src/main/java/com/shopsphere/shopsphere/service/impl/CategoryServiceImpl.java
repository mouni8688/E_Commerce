package com.shopsphere.shopsphere.service.impl;

import com.shopsphere.shopsphere.service.CategoryService;
import com.shopsphere.shopsphere.entity.Category;
import com.shopsphere.shopsphere.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

}
