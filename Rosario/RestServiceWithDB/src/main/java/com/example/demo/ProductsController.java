package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductsController {

	private ProductRepo pr;
	
	@Autowired
	public ProductsController(ProductRepo pr) {
		this.pr = pr;
		
		
		pr.save(new Product(1L,"Pasta",10));
		pr.save(new Product(2L,"Uova",15));
		pr.save(new Product(3L,"Latte",21));
		
	}
	
	
	@GetMapping("/products")
	public List<Product> getAllProducts(){
		return pr.findAll();
	}
	
	@GetMapping("/products/{id}")
	public Product getProduct(@PathVariable Long id) {
		return pr.findById(id).get();
	}
	
	@PostMapping("/products")
	public Product newProduct(@RequestBody Product prod) {
		return pr.save(prod);
	}
	
	@PutMapping("/products/")
	public Product replaceProduct(@RequestBody Product prod) {
		
		pr.save(prod);
		return prod;
	}
	
	@DeleteMapping("/products/{id}")
	public void deleteProduct(@PathVariable Long id) {
		Product x = pr.findById(id).get();
		pr.delete(x);
	}
	
	
}
