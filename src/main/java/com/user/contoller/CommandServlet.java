package com.user.contoller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.contoller.action.Action;
import com.user.contoller.action.ActionFactory;


@WebServlet("/CommandServlet")
public class CommandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String command = request.getParameter("command");
		
		System.out.println(" CommandServlet : " + command);
		
		ActionFactory af = ActionFactory.getInstance();
		
		Action action = af.getAciton(command);
		
		if(action != null) {
			action.execute(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
