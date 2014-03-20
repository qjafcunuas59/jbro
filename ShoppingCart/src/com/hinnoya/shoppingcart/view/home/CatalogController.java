package com.hinnoya.shoppingcart.view.home;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CatalogController
 */
@WebServlet("/CatalogController")
public class CatalogController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private CatalogService service;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CatalogController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action == null || "init".equals(action)) {
			redirect(request, response);
		} else if ("caddie".equals(action)) {
			addIntoCaddie(request, response);
		}
	}

	private void redirect(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Product> products = service.findAll();
		HttpSession session = request.getSession();
		Caddie caddie = (Caddie) session.getAttribute("caddie");
		if (caddie != null) {
			products.removeAll(caddie.getProducts());
		}
		request.setAttribute("products", products);
		request.getRequestDispatcher("catalog.jsp").forward(request, response);
	}

	private void addIntoCaddie(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Caddie caddie = (Caddie) session.getAttribute("caddie");
		if (caddie == null) {
			caddie = new Caddie();
			session.setAttribute("caddie", caddie);
		}
		Integer id = Integer.valueOf(request.getParameter("id"));
		Product product = service.find(id);
		if (!caddie.getProducts().contains(product)) {
			caddie.getProducts().add(product);
		}
		redirect(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
