package com.roczyno.fl_lab4project.controller;

import com.roczyno.fl_lab4project.model.Product;
import com.roczyno.fl_lab4project.service.ProductService;
import lombok.RequiredArgsConstructor;
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

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {
	private final ProductService productService;

	@PostMapping
	public ResponseEntity<Product> addProduct(@RequestBody Product product){
		return new ResponseEntity<>(productService.addProduct(product), HttpStatus.CREATED);
	}
	@GetMapping
	public ResponseEntity<List<Product>> getProducts(){
		return new ResponseEntity<>(productService.getProducts(),HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable Long id){
		return new ResponseEntity<>(productService.getProduct(id),HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable Long id,@RequestBody Product product){
		return new ResponseEntity<>(productService.updateProduct(id,product),HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable Long id){
		return new ResponseEntity<>(productService.deleteProduct(id),HttpStatus.OK);
	}
}
