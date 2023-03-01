package com.batch2.onlineshopping.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.batch2.onlineshopping.dto.ProductDTO;
import com.batch2.onlineshopping.entity.Products;
import com.batch2.onlineshopping.repository.ProductsRepository;

@Service
public class ProductsServiceImpl implements ProductsService {
	@Autowired
	ProductsRepository productsRepository;

	@Override
	public ProductDTO addProducts(ProductDTO productdto) {
		if (productdto.getCost() > 0 && productdto.getQuantity() > 0) {
			Products product = new Products(0, productdto.getName(), productdto.getCategory(), productdto.getBrand(),
					productdto.getDescription(), productdto.getCost(), productdto.getQuantity());
			Products product1 = productsRepository.save(product);

			ProductDTO productdto1 = new ProductDTO(product1.getName(), product1.getCategory(), product1.getBrand(),
					product1.getDescription(), product1.getCost(), product1.getQuantity());
			return productdto1;
		}
		return new ProductDTO();
	}

	@Override
	public ProductDTO getProducts(int id) {
		Optional<Products> product = productsRepository.findById(id);
		ProductDTO productdto = new ProductDTO(product.get().getName(), product.get().getCategory(),
				product.get().getBrand(), product.get().getDescription(), product.get().getCost(),
				product.get().getQuantity());
		return productdto;
	}

	@Override
	public ProductDTO updateProducts(ProductDTO productdto, int id) {
		if (productdto.getCost() > 0 && productdto.getQuantity() > 0) {
			Products product = new Products(id, productdto.getName(), productdto.getCategory(), productdto.getBrand(),
					productdto.getDescription(), productdto.getCost(), productdto.getQuantity());
			Products product1 = productsRepository.save(product);

			ProductDTO productdto1 = new ProductDTO(product1.getName(), product1.getCategory(), product1.getBrand(),
					product1.getDescription(), product1.getCost(), product1.getQuantity());
			return productdto1;
		}
		return new ProductDTO();

	}

	@Override
	public String deleteProducts(int id) {
		if (productsRepository.existsById(id)) {

			productsRepository.deleteById(id);

			return "Product deleted successfuly";
		}
		return "Product can't find";
	}

	@Override
	public List<Products> getProductsByCategory(String category) {

		return null;
	}

	@Override
	public List<ProductDTO> getProducts() {
		List<Products> products = productsRepository.findAll();
		List<ProductDTO> productdtos = products.stream()
				.map(product -> new ProductDTO(product.getName(), product.getCategory(), product.getBrand(),
						product.getDescription(), product.getCost(), product.getQuantity()))
				.collect(Collectors.toList());
		return productdtos;
	}
}
