package com.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.product.dto.BankAccountVO;


import util.DBManager;

public class BankAccountDAO {
	
	private static BankAccountDAO instance  = new BankAccountDAO();
	private BankAccountVO vo;

private BankAccountDAO() {}

public static BankAccountDAO getInstance() {
	return instance;
}

	
	
	
	public List<BankAccountVO> selectAllbank(){
		   String sql = "select * from account order by accountnum desc";
		   List<BankAccountVO> banklist = new ArrayList<BankAccountVO>();
		   
		   Connection con = null;
		   PreparedStatement pstmt = null;
		   ResultSet rs = null;
		   
		   try {
		      con = DBManager.getConnection();
		      pstmt = con.prepareStatement(sql);
		      rs = pstmt.executeQuery();
		      while(rs.next()) {
		         BankAccountVO vo = new BankAccountVO();
		         
		         vo.setBankName(rs.getString("bankName"));
		         vo.setAccountNum(rs.getString("accountNum"));
		         
		         banklist.add(vo);
		      }
		      
		   }catch(Exception e) {
		      e.printStackTrace();
		   }finally {
		      DBManager.close(con, pstmt, rs);
		   }
		   
		   return banklist;
		} 







//은행정보 가져보기
public BankAccountVO selectOneByBank(String bankName) {

String sql = "select * from account where bankName = ?";

BankAccountVO vo = null;
Connection con = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

try {
con = DBManager.getConnection();
   pstmt = con.prepareStatement(sql);
   pstmt.setString(1, bankName);
   
   rs = pstmt.executeQuery();
  
      if(rs.next()) {
    	 vo = new BankAccountVO();
    	  
     	 vo.setBankName(rs.getString("bankName"));
     	 vo.setAccountNum(rs.getString("accountNum"));
      }
   
   }catch (Exception e) {
e.printStackTrace();
}finally {
DBManager.close(con, pstmt, rs);;
}
return vo;

}
}
