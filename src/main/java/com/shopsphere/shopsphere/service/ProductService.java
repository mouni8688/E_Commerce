package com.shopsphere.shopsphere.service;

import com.shopsphere.shopsphere.dto.ProductRequestDto;
import com.shopsphere.shopsphere.dto.ProductResponseDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    Page<ProductResponseDto> getAllProducts(
        int page,
        int size,
        String sortBy
    );

    ProductResponseDto saveProduct(ProductRequestDto dto);

    ProductResponseDto updateProduct(
            Long id,
            ProductRequestDto dto

    );

    void deleteProduct(Long id);
}
