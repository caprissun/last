package com.saeyan.controller.product;

import javax.servlet.http.HttpServletRequest;

import com.saeyan.dao.ProductDAO;

public class ProductVisitCountService {
	public void execute(HttpServletRequest request, String productNum) {
		String goodsNum = request.getParameter("productNum");
		//HttpSession session = request.getSession();
		ProductDAO dao = new ProductDAO();
		//if(session.isNew()) {
			dao.visitCount(productNum);
		//}
	}
}
