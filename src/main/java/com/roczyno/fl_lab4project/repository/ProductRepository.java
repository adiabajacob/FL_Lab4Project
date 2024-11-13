package com.roczyno.fl_lab4project.repository;

import com.roczyno.fl_lab4project.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
