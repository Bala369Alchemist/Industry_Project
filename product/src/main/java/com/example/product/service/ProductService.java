package com.example.product.service;

import java.util.List;

import com.example.product.dto.Product;

public interface ProductService {

	String addProduct(Product product);

	List<Product> listAllProducts();

	List<Product> productCategoryList(String category);

	Product productById(Integer productId);

	String updateProduct(Product product);

	String deleteProductById(Integer productId);

}
