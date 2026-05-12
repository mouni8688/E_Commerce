package com.shopsphere.shopsphere.service.impl;

import com.shopsphere.shopsphere.entity.Product;
import com.shopsphere.shopsphere.entity.Category;
import com.shopsphere.shopsphere.repository.CategoryRepository;
import com.shopsphere.shopsphere.dto.ProductRequestDto;
import com.shopsphere.shopsphere.dto.ProductResponseDto;
import com.shopsphere.shopsphere.repository.ProductRepository;
import com.shopsphere.shopsphere.service.ProductService;
import com.shopsphere.shopsphere.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class ProductSeviceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Override
public Page<ProductResponseDto> getAllProducts(
        int page,
        int size,
        String sortBy
) {

    Pageable pageable =
            PageRequest.of(
                    page,
                    size,
                    Sort.by(sortBy)
            );

    Page<Product> products =
            productRepository.findAll(pageable);

    return products.map(this::mapToDto);

}


    @Override
    public ProductResponseDto saveProduct(ProductRequestDto dto) {
        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category Not found"));
        Product product = new Product();
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setStock(dto.getStock());
        product.setImageUrl(dto.getImageUrl());

        product.setCategory(category);
        Product savedProduct = productRepository.save(product);
        return mapToDto(savedProduct);
    }

    private ProductResponseDto mapToDto(Product product) {
        ProductResponseDto dto = new ProductResponseDto();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());

        dto.setCategoryName(
                product.getCategory().getName());
        return dto;
    }

    @Override
    public ProductResponseDto updateProduct(Long id, ProductRequestDto dto) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product Not found"));

        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category Not Found"));
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setStock(dto.getStock());
        product.setImageUrl(dto.getImageUrl());

        product.setCategory(category);

        Product updatedProduct = productRepository.save(product);

        return mapToDto(updatedProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product Not Found"));
        productRepository.delete(product);
    }

}



    // @Override
    // public List<ProductResponseDto> getAllProducts() {
    //     List<Product> products = productRepository.findAll();
    //     return products.stream()
    //             .map(this::mapToDto)
    //             .collect(Collectors.toList());
    // }
