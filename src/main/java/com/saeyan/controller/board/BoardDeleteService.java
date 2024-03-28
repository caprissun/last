package com.saeyan.controller.board;

import javax.servlet.http.HttpServletRequest;

import com.saeyan.dao.BoardDAO;

public class BoardDeleteService {
	public void execute(HttpServletRequest request) {
		String boardNum = request.getParameter("num");
		BoardDAO dao = new BoardDAO();
		dao.boardDelete(boardNum);
	}
}	
