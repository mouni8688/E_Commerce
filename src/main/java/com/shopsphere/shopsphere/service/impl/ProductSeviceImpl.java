package com.shopsphere.shopsphere.service.impl;

import com.shopsphere.shopsphere.entity.Product;
import com.shopsphere.shopsphere.entity.Category;
import com.shopsphere.shopsphere.repository.CategoryRepository;
import com.shopsphere.shopsphere.dto.ProductRequestDto;
import com.shopsphere.shopsphere.repository.ProductRepository;
import com.shopsphere.shopsphere.service.ProductService;
import org.springframework.stereotype.Service;
import java.util.List;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class ProductSeviceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product saveProduct(ProductRequestDto dto) {
        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category Not found"));
        Product product = new Product();
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setStock(dto.getStock());
        product.setImageUrl(dto.getImageUrl());

        product.setCategory(category);
        return productRepository.save(product);
    }

}
