package com.product.dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.product.dto.ShoppingVO;
import com.saeyan.*;


import util.DBManager;

public class ShoppingDAO {
	private static ShoppingDAO instance  = new ShoppingDAO();
	
	private ShoppingDAO() {}
	
	public static ShoppingDAO getInstance() {
		return instance;
	}

	//전체 상품리스트
	public List<ShoppingVO> selectAllproduct(){
		   //최근 등록한 상품 리스트 출력하기
		   String sql = "select * from product order by productKey desc";
		   List<ShoppingVO> list = new ArrayList<ShoppingVO>();
		   
		   Connection con = null;
		   PreparedStatement pstmt = null;
		   ResultSet rs = null;
		   
		   try {
		      con = DBManager.getConnection();
		      pstmt = con.prepareStatement(sql);
		      rs = pstmt.executeQuery();
		      while(rs.next()) {
		         ShoppingVO vo = new ShoppingVO();
		         
		         vo.setProductKey(rs.getInt("productKey"));
		         vo.setProductCategory(rs.getString("productCategory"));
		         vo.setProductName(rs.getString("productName"));
		         vo.setProductPrice(rs.getInt("productPrice"));
		         vo.setProductStock(rs.getInt("productStock"));
		         vo.setProductDescription(rs.getString("ProductDescription"));
		         vo.setProductdate(rs.getTimestamp("productdate"));
		         
		         list.add(vo);
		      }
		      
		   }catch(Exception e) {
		      e.printStackTrace();
		   }finally {
		      DBManager.close(con, pstmt, rs);
		   }
		   
		   return list;
		} 
		//상품 상세 내용보기
		public ShoppingVO selectOneByName(String productName) {

		   String sql = "select * from product where productName = ?";
		   
		   ShoppingVO vo = null;
		   Connection con = null;
		   PreparedStatement pstmt = null;
		   ResultSet rs = null;
		   
		   try {
		      con = DBManager.getConnection();
		      pstmt = con.prepareStatement(sql);
		      pstmt.setString(1, productName);
		      
		      rs = pstmt.executeQuery();
		      
		      if(rs.next()) {
		         vo = new ShoppingVO();
		         
		         vo.setProductKey(rs.getInt("productKey"));
		         vo.setProductCategory(rs.getString("productCategory"));
		         vo.setProductName(rs.getString("productName"));
		         vo.setProductPrice(rs.getInt("productPrice"));
		         vo.setProductStock(rs.getInt("productStock"));
		         vo.setProductDescription(rs.getString("productDescription"));
		         vo.setProductdate(rs.getTimestamp("productdate"));
		         
		         
		      }
		      
		   }catch (Exception e) {
		      e.printStackTrace();
		   }finally {
		      DBManager.close(con, pstmt, rs);
		   }
		   
		   return vo;
		   
		}
		
}