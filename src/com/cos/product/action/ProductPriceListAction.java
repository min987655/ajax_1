package com.cos.product.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.product.model.Product;
import com.cos.product.repository.ProductRepository;

public class ProductPriceListAction implements Action {
	private static final String TAG = "ProductHomeAction : ";
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductRepository productRepository = 
				ProductRepository.getInstance();
		
		List<Product> products = productRepository.findAllPrice();
		System.out.println(TAG + products);
		
		request.setAttribute("products", products);
		
		RequestDispatcher dis = 
				request.getRequestDispatcher("home.jsp");
		dis.forward(request, response);
	}
}
