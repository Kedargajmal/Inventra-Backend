package com.inventory.Controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.model.Products;
import com.inventory.service.ProductService;

@RestController
@RequestMapping("/productapi")
@CrossOrigin("*") 
public class ProductController 
{
	@Autowired
	private ProductService productService;
	
	@GetMapping("/allproducts")
	public List<Products> findAllProducts()
		{
			return productService.getAllProducts();  
		} 
	
	@GetMapping("/{id}")
	public Optional<Products> findProductById(@PathVariable int id)
		{
			return Optional.ofNullable(productService.getProductById(id).orElseThrow());
		}
	
	@PostMapping("/addproducts")
	public Products savingProducts(@RequestBody Products product)
		{
			return productService.saveProduct(product);
		}  
	
	@PutMapping("/updateProduct/{id}")
	public Products updateProductsById(@PathVariable int id ,@RequestBody Products productdata)
		{
			Products product = productService.getProductById(id).orElseThrow();
		
			product.setName(productdata.getName());
			product.setTagline(productdata.getTagline());
			product.setPrice(productdata.getPrice());		
			return productService.saveProduct(product);
		}
	
	@DeleteMapping("/deleteProduct/{id}")
	public void deleteProduct(@PathVariable int id)
		{
			productService.deleteProductById(id);
		} 
}
