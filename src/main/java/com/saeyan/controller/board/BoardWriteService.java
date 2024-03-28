package com.saeyan.controller.board;

import javax.servlet.http.HttpServletRequest;

import com.saeyan.dao.BoardDAO;
import com.saeyan.dto.BoardVO;

public class BoardWriteService {
	// 페이지로 부터 전송된 값은  request가 받아온다.
	public void execute(HttpServletRequest request) {
		try {		
			request.setCharacterEncoding("utf-8");
		}catch(Exception e) {}
		String boardWriter = request.getParameter("boardWriter");
		String boardSubject = request.getParameter("boardSubject");
		String boardContent = request.getParameter("boardContent");
		// request가 받아온 값은 dto에게 저장
		BoardVO vo = new BoardVO();
		vo.setBoardContent(boardContent);
		vo.setBoardSubject(boardSubject);
		vo.setBoardWriter(boardWriter);
		//dto를 dao에게 전달
		BoardDAO dao = new BoardDAO();
		dao.boardInsert(vo);
	}
}
