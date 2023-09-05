package com.java.instructor.spring.redis.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.java.instructor.spring.redis.entity.Product;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class ProductRepository {
	
	public static final String KEY="Product";
	
	@Autowired
	private RedisTemplate redisTemplate;
	
	public Product save(Product p) {
		redisTemplate.opsForHash().put(KEY, p.getId(), p);
		return p;
	}
	
	public List<Product> findAll(){
		return redisTemplate.opsForHash().values(KEY);
	}
	public Product findProduct(int id) {
		System.out.println("finding the product from Redis DB ->"+ id);
		return  (Product) redisTemplate.opsForHash().get(KEY,id);
	}

	public String delete(int id) {
		System.out.println("deleting the product from Redis DB ->"+ id);
		 redisTemplate.opsForHash().delete(KEY,id);
		 return id+" deleted succssfully ";
	}
}
