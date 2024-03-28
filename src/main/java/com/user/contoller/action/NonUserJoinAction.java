package com.user.contoller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.dao.UserDAO;
import com.user.dto.NonUserVO;

public class NonUserJoinAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");

		NonUserVO vo = new NonUserVO();
		
		vo.setPhone(phone);
		vo.setEmail(email);
		
		UserDAO uDao = UserDAO.getInstance();
		int result = uDao.nonUserjoin(vo);
		System.out.println("nonuser vo : " + vo);
	
		HttpSession session = request.getSession();
		
		if(result == 1) {
			session.setAttribute("phone", phone);
			request.setAttribute("message", "비회원가입에 성공했습니다.");
		}else {
			request.setAttribute("message", "비회원가입에 실패했습니다.");
		}
		
		request.getRequestDispatcher("CommandServlet?command=main_form")
			.forward(request, response);
	}

}
