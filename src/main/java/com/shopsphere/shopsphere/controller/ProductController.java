package com.shopsphere.shopsphere.controller;

import com.shopsphere.shopsphere.entity.Product;
import com.shopsphere.shopsphere.service.ProductService;
import com.shopsphere.shopsphere.dto.ProductRequestDto;
import com.shopsphere.shopsphere.dto.ProductResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor

public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<ProductResponseDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping
    public ProductResponseDto saveProduct(@Valid @RequestBody ProductRequestDto dto) {

        return productService.saveProduct(dto);
    }

    @PutMapping("/{id}")
    public ProductResponseDto updateProduct(@PathVariable Long id, @Valid @RequestBody ProductRequestDto dto) {
        return productService.updateProduct(id, dto);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "Product Deleted Sucessfully";
    }

}
