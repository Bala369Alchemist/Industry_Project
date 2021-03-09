package com.example.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	
	private int productId;
	private String productName;
	private Category category;
	private double price;
	private double discount;
	private String discountDescription;

}
