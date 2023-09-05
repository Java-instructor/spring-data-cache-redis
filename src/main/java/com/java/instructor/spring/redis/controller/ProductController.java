package com.java.instructor.spring.redis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.instructor.spring.redis.entity.Product;
import com.java.instructor.spring.redis.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	public ProductRepository repository;
	
	@PostMapping
	public Product save(@RequestBody Product p) {
		return repository.save(p);
	}
	
	@GetMapping
	public List<Product> retriveAllProduct() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	@Cacheable(key="#id",value ="Product" ,unless="#result.price >2000")
	public Product getProduct(@PathVariable int id) {
		return repository.findProduct(id);
	}
	
	@DeleteMapping("/{id}")
	@CacheEvict(key="#id",value ="Product")
	public String delete(@PathVariable int id) {
		return repository.delete(id);
	}
	
}
