package com.example.demo.services.crudservices;

import java.util.List;

import com.example.demo.domain.Product;

public interface ProductService {

	List<Product> listAllProduct();

	Product saveOrUpdateProduct(Product product);

	
}
