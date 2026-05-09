package com.shopsphere.shopsphere.service;
import com.shopsphere.shopsphere.entity.Product;
import com.shopsphere.shopsphere.dto.ProductRequestDto;
import java.util.List;

public interface ProductService {
    List<Product>getAllProducts();
   
    Product saveProduct(ProductRequestDto dto);
}
