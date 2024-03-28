package com.saeyan.controller.product;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.saeyan.dao.EmployeeDAO;
import com.saeyan.dao.ProductDAO;
import com.saeyan.dto.AuthInfoVO;
import com.saeyan.dto.ProductVO;

public class ProductWriteService {
	public void execute(HttpServletRequest request, String ProductName) 
			throws UnsupportedEncodingException{
		request.setCharacterEncoding("utf-8");
		
		int fileSize = 1024 * 1024 * 100;
		String realPath 
		// webapp다음 부터의 경로를 가지고 온다.
			= request.getServletContext().getRealPath("/product/images");
		System.out.println(realPath); // 배포폴더 경로가 된다.
		
		try {
			// 파일저장
			MultipartRequest multi = new MultipartRequest(request, realPath, fileSize,
						"utf-8", new DefaultFileRenamePolicy());
			
			String productNum = multi.getParameter("productNum");
			String product = multi.getParameter("productName");
			String productPrice = multi.getParameter("productPrice");
			String productcontent = multi.getParameter("productContent");
			String deliveryCost = multi.getParameter("deliveryCost");
			 			
			// 파일명만 받아옴
			String mainImageStoreName = multi.getFilesystemName("mainImage");
			String mainOriginalName = multi.getOriginalFileName("mainImage");
			                        // 저장된 파일명을 가져올 때
			String image1StoreName = multi.getFilesystemName("image1");
			                        // 전송된 파일명을 가져올 때
			String image1OriginalName = multi.getOriginalFileName("image1");
			
			String image2StoreName = multi.getFilesystemName("image2");
			String image2OriginalName = multi.getOriginalFileName("image2");
			String image3StoreName = multi.getFilesystemName("image3");
			String image3OriginalName = multi.getOriginalFileName("image3");
			
			String productImages = image1StoreName + "`"  // 문자열 붙이기
			                   + image2StoreName + "`"
			                   + image3StoreName;
			String productImagesImg = image1OriginalName + "`"
					              + image2OriginalName + "`"
					              + image3OriginalName;
			
			
			ProductVO vo = new ProductVO();
			vo.setDeliveryCost(Integer.parseInt(deliveryCost));
			vo.setProductContent(productcontent);
			vo.setProductName(ProductName);
			vo.setProductNum(productNum);
			vo.setProductPrice(Integer.parseInt(productPrice));
			vo.setProductMainStore(mainImageStoreName); //  파일명만 저장
			vo.setProductMainStoreImg(mainOriginalName);
			vo.setProductImages(productImages);
			vo.setProductImagesImg(productImagesImg);
			
			// empNum을 가져오기 위한 코드 시작
			HttpSession session = request.getSession();
			AuthInfoVO auth = (AuthInfoVO)session.getAttribute("auth");
			EmployeeDAO empDao = new EmployeeDAO();
			String empNum = empDao.getEmpNum(auth.getUserId());
			// empNum을 가져오기 위한 코드 끝
			vo.setEmpNum(empNum);		
			
			ProductDAO dao = new ProductDAO();		
			dao.productInsert(vo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
	}
}
