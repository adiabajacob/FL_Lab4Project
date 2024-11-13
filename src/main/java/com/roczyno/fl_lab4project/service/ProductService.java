package com.roczyno.fl_lab4project.service;

import com.roczyno.fl_lab4project.model.Product;

import java.util.List;

public interface ProductService {
	Product addProduct(Product createProductRequest);
	List<Product> getProducts();
	Product getProduct(Long productId);
	String deleteProduct(Long product);
	Product updateProduct(Long productId,Product updateProductRequest);

}
