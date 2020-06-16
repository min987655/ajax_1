package com.cos.product.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.product.model.Product;
import com.cos.product.repository.ProductRepository;
import com.cos.product.util.Script;
import com.google.gson.Gson;

public class ProductHomeListProcAction implements Action {
	private static final String TAG = "ProductHomeListProcAction : ";
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BufferedReader br = request.getReader();
		StringBuffer sb = new StringBuffer();
		String input = null;
		while ((input = br.readLine()) != null) {
			sb.append(input);
		}
		Gson gson = new Gson();
		
		ProductRepository productRepository =
				ProductRepository.getInstance();
		
		List<Product> products = productRepository.findAll();
		String productsJson = gson.toJson(products);
		Script.outJson(productsJson, response);
	}
}
