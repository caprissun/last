package com.saeyan.controller.product;



import java.io.File;

import javax.servlet.http.HttpServletRequest;

import com.saeyan.dao.ProductDAO;
import com.saeyan.dto.ProductVO;

import com.saeyan.dao.ProductDAO;
import com.saeyan.dto.ProductVO;

public class ProductDeleteService {
	public void execute(HttpServletRequest request) {
		String goodsNum = request.getParameter("goodsNum");
		ProductDAO dao = new ProductDAO();
		ProductVO dto = dao.productSelectOne(goodsNum);
		int i = dao.productDelete(goodsNum);
		if(i > 0) {
			String realPath 
			// webapp다음 부터의 경로를 가지고 온다.
				= request.getServletContext().getRealPath("/product/images");
			String mainImage = dto.getProductMainStore();
			File file = new File(realPath + "/" + mainImage);
			if(file.exists()) file.delete();
			String images[] = dto.getProductImages().split("`");
			for(String fileName : images) {
				file = new File(realPath + "/" + fileName);
				if(file.exists()) file.delete();
			}
		}	
	}
 }
