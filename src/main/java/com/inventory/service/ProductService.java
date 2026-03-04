package com.inventory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.model.Products;
import com.inventory.repository.ProductRepository;

@Service
public class ProductService 
{
	@Autowired
	private ProductRepository productRepository;
	
	public List<Products> getAllProducts()
	{
		return productRepository.findAll();
	}
	
	public Optional<Products> getProductById(int id)
	{
		return productRepository.findById(id);
	}
	
	public Products saveProduct(Products product)
	{
		return productRepository.save(product);
	}
	
	public void deleteProductById(int id)
	{
		productRepository.deleteById(id); 
	}
}
 