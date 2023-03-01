package com.batch2.onlineshopping.service;

import java.util.List;
import java.util.Optional;

import com.batch2.onlineshopping.dto.ProductDTO;
import com.batch2.onlineshopping.entity.Products;

public interface ProductsService {
	ProductDTO addProducts(ProductDTO productdto);

	ProductDTO getProducts(int id);

	ProductDTO updateProducts(ProductDTO productdto, int id);

	String deleteProducts(int id);

	List<Products> getProductsByCategory(String category);

	List<ProductDTO> getProducts();
	}
