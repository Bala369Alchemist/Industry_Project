package com.example.product.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.product.dto.Product;

@Service
public class ProductServiceImpl implements ProductService{

	List<Product> products = new ArrayList<>();
	
	@Override
	public String addProduct(Product product) {
		products.add(product);
		return "success";
	}

	@Override
	public List<Product> listAllProducts() {
		return products;
	}

	@Override
	public List<Product> productCategoryList(String category) {
		return products.stream().filter(product -> product.getCategory().getCategoryName().equalsIgnoreCase(category)).collect(Collectors.toList());
	}

	@Override
	public Product productById(Integer productId) {
		return products.stream()
				.filter(product -> product.getProductId()==productId)
				.findAny()
				.get();
	}

	@Override
	public String updateProduct(Product product) {
		for(Product prod : products) {
			if(prod.getProductId() == product.getProductId()) {
				prod.setProductName(product.getProductName());
				prod.setCategory(product.getCategory());
				prod.setPrice(product.getPrice());
				prod.setDiscount(product.getDiscount());
				prod.setDiscountDescription(product.getDiscountDescription());
				return " product updated successfully";
			}
		}
		return "product update failed";
	}

	@Override
	public String deleteProductById(Integer productId) {
		for(Product prod : products) {
			if(prod.getProductId()==productId) {
				products.remove(prod);
				return "product deleted";
			}
		}
		return "product deletion failed";
	}

}
