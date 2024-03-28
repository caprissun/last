package com.saeyan.dao;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.saeyan.dto.ProductVO;



public class ProductDAO extends DataBaseInfo {
	public void productInsert(ProductVO vo) {
		con = getConnection();
		sql = " insert into goods (product_Num, product_name, product_price"
			+ "                   ,product_content,delivery_cost,emp_num"
			+ "					  ,product_regist, visit_count"
			+ " 				  ,product_main_store, product_main_store_img "
			+ " 				  ,product_images, product_images_img "
			+ "                   ) "
			+ " values(?,?,?,?,?,?,sysdate,0,?,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getProductNum());
			pstmt.setString(2, vo.getProductName());
			pstmt.setInt(3, vo.getProductPrice());
			pstmt.setString(4, vo.getProductContent());
			pstmt.setInt(5, vo.getDeliveryCost());
			pstmt.setString(6, vo.getEmpNum());
			pstmt.setString(7, vo.getProductMainStore());
			pstmt.setString(8, vo.getProductMainStoreImg());
			pstmt.setString(9, vo.getProductImages());
			pstmt.setString(10, vo.getProductImagesImg());
			int i = pstmt.executeUpdate();
			System.out.println(i + "개행이(가) 삽입되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {close();}
	}
	public String productAutoNum() {
		String productNum = null;
		con = getConnection();
		sql = " select concat('hk' , nvl(max(substr(goods_num,3)),100000) + 1) from goods ";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			productNum = rs.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {close();}		
		return productNum;
	}
	
	public List<ProductVO> productSelectList(String productWord) {
		List<ProductVO> list = new ArrayList<ProductVO>();
		String search = "";
		if(productWord != null) {
			search = " and product_name like '%" + productWord + "%'";
		}
		con = getConnection();
		sql = " select product_num, product_name, product_price, product_content "
			+ "       ,delivery_cost,visit_count, emp_num, product_regist "
			+ "       ,update_emp_num, product_update_date "
			+ "       ,product_main_store,product_main_store_img "
			+ "       ,product_images,product_images_img  "
			+ " from product "
			+ " where 1=1 " + search;
		System.out.println(sql);
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductVO vo = new ProductVO();
				vo.setProductNum(rs.getString(1));
				vo.setProductName(rs.getString(2));
				vo.setProductPrice(rs.getInt(3));
				vo.setProductContent(rs.getString(4));
				vo.setDeliveryCost(rs.getInt(5));
				vo.setEmpNum(rs.getString(7));
				vo.setProductMainStore(rs.getString("product_main_store"));
				vo.setProductMainStoreImg(rs.getString("product_main_store_img"));
				vo.setProductImages(rs.getString("product_images"));
				vo.setProductImagesImg(rs.getString("product_images_img"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return list;
	}
	
	
	public ProductVO productSelectOne(String productNum) {
		ProductVO vo = null;
		con = getConnection();
		sql = " select product_num, product_name, product_price, product_content "
				+ "       ,delivery_cost,visit_count, emp_num, product_regist "
				+ "       ,update_emp_num, product_update_date "
				+ "       ,product_main_store,product_main_store_img "
				+ "       ,product_images,product_images_img  "
				+ " from product "
				+ " where product_num = ? " ;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, productNum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo = new ProductVO();
				vo.setProductNum(rs.getString(1));
				vo.setProductName(rs.getString(2));
				vo.setProductPrice(rs.getInt(3));
				vo.setProductContent(rs.getString(4));
				vo.setDeliveryCost(rs.getInt(5));
				vo.setEmpNum(rs.getString(7));
				vo.setVisitCount(rs.getInt(6));
				vo.setProductRegist(rs.getDate(8));
				vo.setUpdateEmpNum(rs.getString(9));
				vo.setProductUpdateDate(rs.getDate(10)); 
				vo.setProductMainStore(rs.getString("product_main_store"));
				vo.setProductMainStoreImg(rs.getString("product_main_store_img"));
				vo.setProductImages(rs.getString("product_images"));
				vo.setProductImagesImg(rs.getString("product_images_img"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vo;
	}
	
	public void productUpdate(ProductVO vo) {
		con = getConnection();
		sql = " update goods "
			+ " set GOODS_NAME = ?, PRODUCT_PRICE = ? "
			+ "		,delivery_cost = ?,PRODUCT_CONTENT = ?"
			+ "     ,update_emp_num = ?, product_update_date = sysdate"
			+ " where product_num = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getProductName());
			pstmt.setInt(2, vo.getProductPrice());
			pstmt.setInt(3,vo.getDeliveryCost());
			pstmt.setString(4, vo.getProductContent());
			pstmt.setString(5, vo.getUpdateEmpNum());
			pstmt.setString(6, vo.getProductNum());
			int i = pstmt.executeUpdate();
			System.out.println(i + "개 행이(가) 수정되었습니다.");			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {close();}
		
		
	}
	public int productDelete(String productNum) {
		con = getConnection();
		sql = " delete from product "
			+ " where  product_num = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, productNum);
			int i = pstmt.executeUpdate();
			System.out.println(i + "개 행이(가) 수정되었습니다.");
			return i;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}finally {close();}		
	}
	public void visitCount(String productNum) {
		con = getConnection();
		sql = " update product "
			+ " set VISIT_COUNT = VISIT_COUNT + 1 "
			+ " where PRODUCT_NUM = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, productNum);
			int i = pstmt.executeUpdate();
			System.out.println("조회수가 1증가했습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {close();}		
		
	}
}








