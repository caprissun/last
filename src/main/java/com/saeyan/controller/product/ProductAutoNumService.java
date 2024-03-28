package com.saeyan.controller.product;

import javax.servlet.http.HttpServletRequest;

import com.saeyan.dao.ProductDAO;

public class ProductAutoNumService {
	public void execute(HttpServletRequest request) {
		ProductDAO dao = new ProductDAO();
		String productNum = dao.productAutoNum();
		request.setAttribute("productNum", productNum);
	}
}
