package com.example.demo.bootstrap;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.example.demo.domain.Product;
import com.example.demo.services.crudservices.ProductService;

@Component
public class SpringJPABootStrap implements ApplicationListener<ContextRefreshedEvent> {
	private ProductService productService;
	
	public SpringJPABootStrap() {
		super();	
	}
	
	@Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}


	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if (null != event) {
			loadProduct();
		}
	}

	public void loadProduct() {
		Product p1 = new Product();
		p1.setDescription("product 1");
		p1.setPrice(new BigDecimal("12.99"));
		p1.setImageUrl("http://example.com/product1");
		
		Product p2 = new Product();
		p2.setDescription("product 1");
		p2.setPrice(new BigDecimal("12.99"));
		p2.setImageUrl("http://example.com/product1");
		
		Product p3 = new Product();
		p3.setDescription("product 1");
		p3.setPrice(new BigDecimal("12.99"));
		p3.setImageUrl("http://example.com/product1");
		
		Product p4 = new Product();
		p4.setDescription("product 1");
		p4.setPrice(new BigDecimal("12.99"));
		p4.setImageUrl("http://example.com/product1");
		
		Product p5 = new Product();
		p5.setDescription("product 1");
		p5.setPrice(new BigDecimal("12.99"));
		p5.setImageUrl("http://example.com/product1");
		
		productService.saveOrUpdateProduct(p5);
		productService.saveOrUpdateProduct(p4);
		productService.saveOrUpdateProduct(p3);
		productService.saveOrUpdateProduct(p2);
		productService.saveOrUpdateProduct(p1);
	}

	
	

}
