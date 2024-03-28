package com.saeyan.controller.product;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.saeyan.dao.EmployeeDAO;
import com.saeyan.dao.ProductDAO;
import com.saeyan.dto.AuthInfoVO;
import com.saeyan.dto.ProductVO;

public class ProductUpdateService {
	public void execute(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		String productPrice = request.getParameter("productPrice");
		String deliveryCost = request.getParameter("deliveryCost");
		
		ProductVO vo = new ProductVO();
		vo.setProductContent(request.getParameter("productContent"));
		vo.setProductName(request.getParameter("productName"));
		vo.setProductNum(request.getParameter("productNum"));
		vo.setProductPrice(Integer.parseInt(productPrice));
		vo.setDeliveryCost(Integer.parseInt(deliveryCost));
		
		HttpSession session = request.getSession();
		AuthInfoVO auth = (AuthInfoVO)session.getAttribute("auth");
		EmployeeDAO empDao = new EmployeeDAO();
		String empNum = empDao.getEmpNum(auth.getUserId());
		
		vo.setUpdateEmpNum(empNum);
		
		ProductDAO dao = new ProductDAO();
		dao.productUpdate(vo);
		
	}
}



