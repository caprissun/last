package com.saeyan.controller.product;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.saeyan.dao.ProductDAO;
import com.saeyan.dto.ProductVO;

public class ProductListService {
	public void execute(HttpServletRequest request, String productWord, Object ProductWord) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String goodsWord = request.getParameter("search");
		ProductDAO dao = new ProductDAO();
		List<ProductVO> list = dao.productSelectList(productWord);
		request.setAttribute("dtos", list);
		System.out.println("ProductListService" + list.size());
		request.setAttribute("search", ProductWord);
	}
}
