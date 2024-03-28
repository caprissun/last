package com.product.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.product.dao.BankAccountDAO;
import com.product.dao.ShoppingDAO;
import com.product.dto.BankAccountVO;
import com.product.dto.ShoppingVO;


public class bankAccount implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		  String bankName = request.getParameter("bankName");
		  
		  BankAccountVO vo = BankAccountDAO.getInstance().selectOneByBank("bankName");
		   
		   System.out.println("bankaccount : " + vo); 
		 
		   
		request.setAttribute("bankaccount", vo);
		
		String url = "Shopping/bankaccount.jsp";
		
		request.getRequestDispatcher(url).forward(request, response);
		

	}

}
