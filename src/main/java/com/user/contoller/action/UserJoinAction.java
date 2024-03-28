package com.user.contoller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.dao.UserDAO;
import com.user.dto.UserVO;

public class UserJoinAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		int phone = Integer.parseInt(request.getParameter("phone"));
		int jumin = Integer.parseInt(request.getParameter("jumin"));
		String nickname = request.getParameter("nickname");
		String admincheck = request.getParameter("admincheck");
		
		UserVO vo = new UserVO();

		vo.setUserid(id);
		vo.setPwd(pwd);
		vo.setUsername(username);
		vo.setEmail(email);
		vo.setPhone(phone);
		vo.setJumin(jumin);
		vo.setNickname(nickname);
		vo.setAdminCheck(admincheck);	
		
		UserDAO uDao = UserDAO.getInstance();
		int result = uDao.join(vo);
		
		System.out.println("result : " + result + " vo : " + vo);
		HttpSession session = request.getSession();
		
		if(result == 1) {
			session.setAttribute("userid", id);
			request.setAttribute("message", "회원가입에 성공했습니다.");
		}else {
			request.setAttribute("message", "회원가입에 실패했습니다.");
		}
		
		request.getRequestDispatcher("CommandServlet?command=user_login")
			.forward(request, response);
		
	}

}
