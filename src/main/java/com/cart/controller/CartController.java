package com.cart.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.product.controller.action.Action;
import com.product.controller.action.ActionFactory;
import com.saeyan.dao.CartDAO;
import com.saeyan.dao.CartDAOe;
import com.saeyan.dto.CartDTO;

@WebServlet("/cartController")
public class CartController extends HttpServlet implements Action {
    private static final long serialVersionUID = 1L;

    // 클라이언트의 GET 요청을 처리하는 메서드
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);

    }

    // 클라이언트의 POST 요청을 처리하는 메서드
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");

        // 요청에 따라 적절한 기능을 수행하는 메서드 호출
        if (action.equals("selectAll")) {
            selectAll(request, response);
        } else if (action.equals("insert")) {
            insert(request, response);
        } else if (action.equals("update")) {
            update(request, response);
        } else if (action.equals("delete")) {
            delete(request, response);
        }
    }

    // 모든 장바구니 정보를 가져오는 메서드
    private void selectAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int userCode = Integer.parseInt(request.getParameter("userCode"));

        CartDAO cartDAO = new CartDAOe();
        List<CartDTO> cartList = cartDAO.selectAll(userCode);

        // 가져온 장바구니 정보를 request에 저장
        request.setAttribute("cartList", cartList);

        // cart.jsp로 포워딩
        request.getRequestDispatcher("cart.jsp").forward(request, response);
    }

    // 새로운 장바구니 항목을 추가하는 메서드
    private void insert(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int userNo = Integer.parseInt(request.getParameter("userNo"));
        int productNo = Integer.parseInt(request.getParameter("productNo"));
        int cartQty = Integer.parseInt(request.getParameter("cartQty"));

        CartDAO cartDAO = new CartDAOe();
        try {
            int result = cartDAO.insert(userNo, productNo, cartQty);
            PrintWriter out = response.getWriter();
            out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 특정 장바구니 항목의 수량을 업데이트하는 메서드
    private void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int cartNo = Integer.parseInt(request.getParameter("cartNo"));
        int cartQty = Integer.parseInt(request.getParameter("cartQty"));

        CartDAO cartDAO = new CartDAOe();
        try {
            int result = cartDAO.update(cartNo, cartQty);
            PrintWriter out = response.getWriter();
            out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 특정 장바구니 항목을 삭제하는 메서드
    private void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int cartNo = Integer.parseInt(request.getParameter("cartNo"));

        CartDAO cartDAO = new CartDAOe();
        try {
            int result = cartDAO.delete(cartNo);
            PrintWriter out = response.getWriter();
            out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}