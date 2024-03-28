package com.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.user.dto.AddressVO;
import com.user.dto.NonUserVO;
import com.user.dto.UserVO;

import util.DBManager;

public class UserDAO {

	private static UserDAO instance = new UserDAO();
	
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private UserDAO() {}
	
	public static UserDAO getInstance() {
		return instance;
	}

	public int join(UserVO vo) {
		int result = -1;
		
	    String sql = "INSERT INTO users VALUES (user_no.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			con = DBManager.getConnection();			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, vo.getUserid());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getUsername());
			pstmt.setString(4, vo.getEmail());
			pstmt.setInt(5, vo.getPhone());
			pstmt.setInt(6, vo.getJumin());
			pstmt.setString(7, vo.getNickname());
			pstmt.setString(8, vo.getAdminCheck());
			
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {		
			DBManager.close(con, pstmt, rs);
		}
		return result;
	}
	
	public int addressinsert(AddressVO vo) {

	    int result = -1;

	    String sql = "INSERT INTO address (address, address_detail, delivery_request) "
	    		+ " VALUES (?, ?, ?)";

	    try {
	        con = DBManager.getConnection();            
	        pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, vo.getAddress());
	        pstmt.setString(2, vo.getAddressDetail());
	        pstmt.setString(3, vo.getDeliveryRequest());

	        result = pstmt.executeUpdate();

	    } catch(SQLException e) {
	        e.printStackTrace();
	    } finally {
	        DBManager.close(con, pstmt, rs);
	    }
	    return result;
	}
	
	//비회원
	public int nonUserjoin(NonUserVO vo) {
		int result = -1;
		
		String sql = "INSERT INTO nonuser (phone, email) VALUES (?, ?)";

		try {
			con = DBManager.getConnection();			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getPhone());
			pstmt.setString(2, vo.getEmail());
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, rs);
		}
		return result;
	}
	
	//아이디 체크
	public int idCheck(String id, String pwd) {
		int result = -1;
		
		String sql = "select pwd from users where userid = ? ";
		
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("pwd").equals(pwd)) {
					result = 1; // 아이디 /비밀번호 일치
				}else {
					result = -1; //비빌번호 불일치
				}
			}else {
				result = 0; //아이디 불일치
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, rs);
		}
		
		return result;
	}
	
	//로그인 한 회원정보 가져오기
	public UserVO getUser(String userid) {
		
		String sql = "select * from users where userid=?";
		UserVO vo = new UserVO();
		
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String username = rs.getString("username");
				
				vo.setUsername(username);
				vo.setUserid(rs.getString("userid"));
				vo.setPwd(rs.getString("pwd"));
				vo.setEmail(rs.getString("email"));
				vo.setPhone(Integer.parseInt(rs.getString("phone")));
				vo.setJumin(Integer.parseInt(rs.getString("jumin")));
				vo.setNickname(rs.getString("nickname"));
				vo.setAdminCheck(rs.getString("admincheck"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			DBManager.close(con, pstmt, rs);
		}
		
		return vo;
	}
	
	//ID 중복체크
	public int confirmID(String id) {
		int result = -1;
		
		String sql = "select userid from users where userid = ?";
		
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = 1;  //사용 가능
			}else {
				result = -1; //사용 불가
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, rs);
		}
		return result;
	}

	
	
	
	
}
