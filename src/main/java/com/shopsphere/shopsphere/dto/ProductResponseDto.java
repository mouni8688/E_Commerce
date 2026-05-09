package com.shopsphere.shopsphere.dto;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter

public class ProductResponseDto {
    private Long Id;
    private String name;
    private BigDecimal price;
    private String categoryName;
    
}
