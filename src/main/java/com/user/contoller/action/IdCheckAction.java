package com.user.contoller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.dao.UserDAO;

public class IdCheckAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		UserDAO uDao = UserDAO.getInstance();
		
		int result = uDao.confirmID(id);
		
		request.setAttribute("id", id);
		request.setAttribute("result", result);
		
		RequestDispatcher dis = request.getRequestDispatcher("user/idcheck.jsp");
		dis.forward(request, response);
		
	}

}
