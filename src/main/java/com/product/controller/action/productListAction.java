package com.product.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.product.dao.ShoppingDAO;
import com.product.dto.ShoppingVO;



public class productListAction implements Action{

	

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		   String url = "/Shopping/productList.jsp";
		   
		   ShoppingDAO bDao = ShoppingDAO.getInstance();
		   List<ShoppingVO> product = bDao.selectAllproduct();
		   
		   System.out.println("product >> " + product);
				
		   request.setAttribute("productlist", product);
		   
		   request.getRequestDispatcher(url).forward(request, response);
		   


	}

}
