package com.cos.product.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.product.repository.ProductRepository;
import com.cos.product.util.Script;

public class ProductDeleteProcAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int productId = Integer.parseInt(request.getParameter("productId"));
		
		ProductRepository productRepository = 
				ProductRepository.getInstance();
		
		int result = productRepository.deleteById(productId);
		Script.outText(result+"", response);

	}
}
