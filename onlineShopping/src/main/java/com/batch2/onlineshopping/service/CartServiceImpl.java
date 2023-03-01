package com.batch2.onlineshopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.batch2.onlineshopping.entity.Cart;
import com.batch2.onlineshopping.entity.Products;
import com.batch2.onlineshopping.entity.User;
import com.batch2.onlineshopping.repository.ProductsRepository;
import com.batch2.onlineshopping.repository.UserRepository;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	ProductsRepository productRepository;

	public String addCart(int userId,int productId) {
		System.out.println(productId);
		System.out.println(userId);
		if (productRepository.existsById(productId) && userRepository.existsById(userId)) {
			Products products = productRepository.getProductsById(productId);
			User user = userRepository.getUserById(userId);
			user.getProducts().add(products);
			products.getUsers().add(user);
			userRepository.save(user);
			return "Product added to cart Successfuly";
		}
		return "Unable to add product to cart";
	}

	@Override
	public List<Products> getCart(Integer id) {
		System.out.println(id);
		List<Products> products = userRepository.getUserById(id).getProducts();
		return products;
	}

}
