package com.saeyan.controller.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.saeyan.dao.BoardDAO;
import com.saeyan.dto.BoardVO;

public class BoardListService {
	public void execute(HttpServletRequest request) {
		BoardDAO dao = new BoardDAO();
		// list에  dto를 저장한 값을 반환받는다.
		List<BoardVO> list = dao.boardSelectAll();
		request.setAttribute("list", list);
	}	
}
