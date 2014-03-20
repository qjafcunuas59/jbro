package com.hinnoya.shoppingcart.view.jsf;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.hinnoya.shoppingcart.view.home.Product;

@Named
@SessionScoped
public class CatalogModel implements Serializable {
	
	private boolean loaded;

	private List<Product> products;

	private Product selected;

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product getSelected() {
		return selected;
	}

	public void setSelected(Product selected) {
		this.selected = selected;
	}

	public boolean isLoaded() {
		return loaded;
	}

	public void setLoaded(boolean loaded) {
		this.loaded = loaded;
	}

}
