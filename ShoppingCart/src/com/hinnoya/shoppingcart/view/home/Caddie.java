package com.hinnoya.shoppingcart.view.home;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Caddie {

	private List<Product> products = new ArrayList<Product>();
	
	public Caddie() {
	}

	public List<Product> getProducts() {
		return products;
	}
	
	public BigDecimal getPrice() {
		BigDecimal total = BigDecimal.ZERO;
		for (Product product : products) {
			total = total.add(product.getPrice());
		}
		return total;
	}

}
