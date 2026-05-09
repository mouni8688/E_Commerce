package com.shopsphere.shopsphere.service;

import com.shopsphere.shopsphere.dto.ProductRequestDto;
import com.shopsphere.shopsphere.dto.ProductResponseDto;

import java.util.List;

public interface ProductService {
    List<ProductResponseDto>getAllProducts();
   
    ProductResponseDto saveProduct(ProductRequestDto dto);
}
