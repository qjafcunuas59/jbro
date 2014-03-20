package com.hinnoya.shoppingcart.view.jsf;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Named;

import com.hinnoya.shoppingcart.view.home.CatalogService;
import com.hinnoya.shoppingcart.view.home.Product;

@Named
public class CatalogController {

	@Inject
	private CatalogService service;

	@Inject
	private CatalogModel model;

	public void load() {
		if (!model.isLoaded()) {
			model.setProducts(new ArrayList<Product>(service.findAll()));
			model.setLoaded(true);
		}
	}
	public String select() {
		return "";
	}

	public String select(Product product) {
		model.setSelected(product);
		model.getProducts().remove(product);
		return "";
	}

}
