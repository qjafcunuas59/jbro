package com.hinnoya.shoppingcart.view.home;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Catalog {

	private List<Product> products = new ArrayList<Product>();

	private static final Catalog instance = new Catalog();

	private Catalog() {
		Product product;
		for (int i = 0; i < 10; i++) {
			product = new Product();
			product.setId(i);
			product.setName("Product n°" + i);
			product.setPrice(new BigDecimal(50 + i));
			products.add(product);
		}
	}

	public static Catalog getInstance() {
		return instance;
	}

	public List<Product> getProducts() {
		return new ArrayList<Product>(products);
	}

	public Product getProduct(Integer id) {
		for (Product product : products) {
			if (product.getId().equals(id)) {
				return product;
			}
		}
		return null;
	}

}
