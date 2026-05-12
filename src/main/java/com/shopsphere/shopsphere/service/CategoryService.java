package com.shopsphere.shopsphere.service;
import com.shopsphere.shopsphere.entity.Category;
import org.springframework.data.domain.Page;

import java.util.List;
public interface CategoryService {
    Category saveCategory(Category category);
    Page<Category>getAllCategories(
        int page,
        int size,
        String sortBy
    );

    Category getCategoryById(Long id);

    Category updateCategory(Long id,Category category);

    void deleteCategory(Long id);
}
