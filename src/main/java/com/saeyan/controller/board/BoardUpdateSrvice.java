package com.saeyan.controller.board;

import javax.servlet.http.HttpServletRequest;

import com.saeyan.dao.BoardDAO;
import com.saeyan.dto.BoardVO;

public class BoardUpdateSrvice {
	public void execute(HttpServletRequest request) {
		//  수정코드나 insert 코드는 같다.
		try {		
			request.setCharacterEncoding("utf-8");
		}catch(Exception e) {}
		String boardWriter = request.getParameter("boardWriter");
		String boardSubject = request.getParameter("boardSubject");
		String boardContent = request.getParameter("boardContent");
		String boardNum = request.getParameter("boardNum");
		// request가 받아온 값은 dto에게 저장
		BoardVO vo = new BoardVO();
		vo.setBoardContent(boardContent);
		vo.setBoardSubject(boardSubject);
		vo.setBoardWriter(boardWriter);
		//추가
		vo.setBoardNum(Integer.parseInt(boardNum));
		
		BoardDAO dao = new BoardDAO();
		// 수정할 메서드가 필요하다.
		dao.boardUpdate(vo);
	}
}
