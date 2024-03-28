package com.saeyan.controller.board;

import javax.servlet.http.HttpServletRequest;

import com.saeyan.dao.BoardDAO;
import com.saeyan.dto.BoardVO;

public class BoardDetailService {
	 public void execute(HttpServletRequest request) {
		 String boardNum = request.getParameter("num");
		 BoardDAO dao = new BoardDAO();
		 // 행을 dto 에 저장해서 가져오므로  dto로 받아야 한다.
		 BoardVO vo = dao.boardSelectOne(boardNum);
		 request.setAttribute("vo", vo);
	 }
}
