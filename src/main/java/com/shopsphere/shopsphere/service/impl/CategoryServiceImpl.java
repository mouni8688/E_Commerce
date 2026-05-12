package com.shopsphere.shopsphere.service.impl;

import com.shopsphere.shopsphere.service.CategoryService;
import com.shopsphere.shopsphere.entity.Category;
import com.shopsphere.shopsphere.repository.CategoryRepository;
import com.shopsphere.shopsphere.exception.*;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.*;
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
    public Page<Category> getAllCategories(

            int page,
            int size,
            String sortBy

    ) {

        Pageable pageable = PageRequest.of(
                page,
                size,
                Sort.by(sortBy));

        return categoryRepository.findAll(pageable);

    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category Not found"));
    }

    @Override
    public Category updateCategory(Long id, Category category) {
        Category existingCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category Not found"));

        existingCategory.setName(category.getName());
        return categoryRepository.save(existingCategory);
    }

    @Override
    public void deleteCategory(Long id){
        Category existingCategory=categoryRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Category Not Found"));
                
                categoryRepository.delete(existingCategory);
    }

}
