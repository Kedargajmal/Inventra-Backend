package com.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.inventory.model.Products;

@Repository
public interface ProductRepository extends JpaRepository<Products, Integer>
{
	
}
