package com.example.product.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.product.dto.Product;
import com.example.product.service.ProductService;

@RestController
@RequestMapping(value = "/v1")
public class ProductController {

	private static final Logger logger  = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private final ProductService productService;

	// Dependency Injection using constructor
	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}

	// add product
	@PostMapping(value = "/addProduct")
	ResponseEntity<Product> addProduct(@RequestBody Product product) {
		String status = productService.addProduct(product);
		
		logger.info("Product added status ={}",status);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(product);
	}
	
	// get all products
	@GetMapping(value = "/productList")
	List<Product> productList(){
		return productService.listAllProducts();
	}
	
	@GetMapping(value = "/productList/{category}")
	List<Product> productCategoryList(@PathVariable String category){
		return productService.productCategoryList(category);
	}
	
	@GetMapping(value = "/product/{productId}")
	Product productById(@PathVariable Integer productId) {
		return productService.productById(productId);
	}
	
	@PutMapping(value="/productUpdate")
	String updateProduct(@RequestBody Product product) {
		return productService.updateProduct(product);
	}
	
	@DeleteMapping(value = "/deleteProduct/{productId}")
	String deleteProductById(@PathVariable Integer productId) {
		return productService.deleteProductById(productId);
	}

}
