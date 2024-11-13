package com.roczyno.fl_lab4project.service;

import com.roczyno.fl_lab4project.model.Product;
import com.roczyno.fl_lab4project.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
	private final ProductRepository productRepository;

	@Override
	public Product addProduct(Product createProductRequest) {
		createProductRequest.setCreatedAt(LocalDateTime.now());
		productRepository.save(createProductRequest);
		return null;
	}

	@Override
	public List<Product> getProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product getProduct(Long productId) {
		return productRepository.findById(productId)
				.orElseThrow(()->new IllegalArgumentException("product with id not found"));
	}

	@Override
	public String deleteProduct(Long productId) {
		Product product=getProduct(productId);
		productRepository.delete(product);
		return "product deleted successfully";
	}

	@Override
	public Product updateProduct(Long productId, Product updateProductRequest) {
		Product product=getProduct(productId);
		if(updateProductRequest.getName()!=null){
			product.setName(updateProductRequest.getName());
		}
		if (updateProductRequest.getDescription()!=null){
			product.setDescription(updateProductRequest.getDescription());
		}
		return productRepository.save(product);
	}
}
