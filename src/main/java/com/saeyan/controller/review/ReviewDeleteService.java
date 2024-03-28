package com.saeyan.controller.review;

import javax.servlet.http.HttpServletRequest;

import com.saeyan.dao.ReviewDAO;

public class ReviewDeleteService {
	public void execute(HttpServletRequest request) {
		String reviewNum = request.getParameter("reviewNum");
		ReviewDAO dao = new ReviewDAO();
		dao.reviewDelete(reviewNum);
	}
}