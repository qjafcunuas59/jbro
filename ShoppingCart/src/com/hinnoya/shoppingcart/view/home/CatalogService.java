package com.hinnoya.shoppingcart.view.home;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CatalogService {

	@PersistenceContext(unitName = "TestPU")
	private EntityManager entityManager;

	public List<Product> findAll() {
		return entityManager.createQuery("select o from Product o",
				Product.class).getResultList();
	}

	public Product find(Integer id) {
		return entityManager.find(Product.class, id);
	}

}
