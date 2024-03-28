package com.user.contoller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.dao.UserDAO;
import com.user.dto.AddressVO;

public class MypageAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String address = request.getParameter("address");
		String addressDetail = request.getParameter("addressDetail");
		String deliveryRequest = request.getParameter("deliveryRequest");
		
		AddressVO vo = new AddressVO();	

		vo.setAddress(address);
		vo.setAddressDetail(addressDetail);
		vo.setDeliveryRequest(deliveryRequest);


		UserDAO uDao = UserDAO.getInstance();
		int result = uDao.addressinsert(vo);
		
		System.out.println("result>>> : " + result);
		HttpSession session = request.getSession();
		System.out.println("vo >: " + vo);

		if(result == 1) {
			session.setAttribute("address", address);
			request.setAttribute("message", "마이페이지 등록했습니다.");
		}else {
			request.setAttribute("message", "마이페이지 등록에 실패했습니다.");
		}
	
		request.getRequestDispatcher("ShoppingServlet?command=product_list")
			.forward(request, response);
	}

}
