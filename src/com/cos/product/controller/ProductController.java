package com.cos.product.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.product.action.Action;
import com.cos.product.action.ProductCountListAction;
import com.cos.product.action.ProductCountListProcAction;
import com.cos.product.action.ProductDeleteProcAction;
import com.cos.product.action.ProductHomeAction;
import com.cos.product.action.ProductHomeListProcAction;
import com.cos.product.action.ProductPriceListAction;
import com.cos.product.action.ProductPriceListProcAction;

@WebServlet("/product")
public class ProductController extends HttpServlet {
	private static final String TAG = "ProductController : ";
	private static final long serialVersionUID = 1L;
       
    public ProductController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		System.out.println(TAG + "doProcess : " + cmd);
		Action action = router(cmd);
		action.execute(request, response);
	}
	
	public Action router(String cmd) {
		if (cmd.equals("home")) {
			return new ProductHomeAction();
		} else if (cmd.equals("homeListProc")) {
			return new ProductHomeListProcAction();
		} else if (cmd.equals("priceList")) {
			return new ProductPriceListAction();
		} else if (cmd.equals("priceListProc")) {
			return new ProductPriceListProcAction();
		} else if (cmd.equals("countList")) {
			return new ProductCountListAction();
		} else if (cmd.equals("countListProc")) {
			return new ProductCountListProcAction();
		} else if (cmd.equals("deleteProc")) {
			return new ProductDeleteProcAction();
		}
		return null;
	}

}
