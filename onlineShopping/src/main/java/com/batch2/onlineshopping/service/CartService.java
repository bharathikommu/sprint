package com.batch2.onlineshopping.service;

import java.util.List;

import com.batch2.onlineshopping.entity.Cart;
import com.batch2.onlineshopping.entity.Products;

public interface CartService {
	List<Products> getCart(Integer id);

//	String addCart(Cart cart);

	String addCart(int userId, int productId);
}
