package com.saeyan.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.saeyan.dto.EmployeeVO;



public class EmployeeDAO extends DataBaseInfo {
	public String empAutoNum() {
		String empNum = "";
		con = getConnection();
		sql = " select concat('emp',nvl(substr(max(emp_num),4),1000000) + 1) "
			+ " from employees ";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			empNum = rs.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empNum;
	}
	public void employeeInsert(EmployeeVO vo) {
		con = getConnection();
		sql = "insert into employees("
				+ " emp_num, emp_name, emp_id, emp_pw,"
				+ " emp_addr, emp_addr_detail, emp_post,"
				+ " emp_phone, emp_email, emp_enter_date,"
				+ " emp_jumin)"
			+ "values(?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getEmpNum());
			pstmt.setString(2, vo.getEmpName());
			pstmt.setString(3, vo.getEmpId() );
			pstmt.setString(4, vo.getEmpPw());
			pstmt.setString(5, vo.getEmpAddr());
			pstmt.setString(6, vo.getEmpAddrDetail());
			pstmt.setString(7, vo.getEmpPost());
			pstmt.setString(8, vo.getEmpPhone());
			pstmt.setString(9, vo.getEmpEmail());
			pstmt.setDate(10,  new java.sql.Date(vo.getEmpEnterDate().getTime()));
			pstmt.setString(11,vo.getEmpJumin());
			int i = pstmt.executeUpdate();
			System.out.println(i + "개 행이(가) 삽입되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
	public List<EmployeeVO> selectAll(){
		List<EmployeeVO> list = new ArrayList<EmployeeVO>();
		con = getConnection();
		sql = "select emp_num, emp_name, emp_id, emp_pw,"
				+ "	 emp_addr, emp_addr_detail, emp_post,"
				+ "	 emp_phone, emp_email, emp_enter_date,"
				+ "	 emp_jumin"
				+ " from employees";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				EmployeeVO vo = new EmployeeVO();
				vo.setEmpAddr(rs.getString(5));
				vo.setEmpAddrDetail(rs.getString(6));
				vo.setEmpEmail(rs.getString("emp_email"));
				vo.setEmpEnterDate(rs.getDate("emp_enter_date"));
				vo.setEmpId(rs.getString(3));
				vo.setEmpJumin(rs.getString(11));
				vo.setEmpName(rs.getString(2));
				vo.setEmpNum(rs.getString(1));
				vo.setEmpPhone(rs.getString(8));
				vo.setEmpPost(rs.getString(7));
				vo.setEmpPw(rs.getString(4));
				list.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		
		return list;
	}
	public EmployeeVO selectOne(String empNum) {
		EmployeeVO vo = new EmployeeVO();
		con = getConnection();
		sql = "select emp_num, emp_name, emp_id, emp_pw,"
				+ "	 emp_addr, emp_addr_detail, emp_post,"
				+ "	 emp_phone, emp_email, emp_enter_date,"
				+ "	 emp_jumin"
				+ " from employees"
				+ " where emp_num = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, empNum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo.setEmpAddr(rs.getString(5));
				vo.setEmpAddrDetail(rs.getString(6));
				vo.setEmpEmail(rs.getString("emp_email"));
				vo.setEmpEnterDate(rs.getDate("emp_enter_date"));
				vo.setEmpId(rs.getString(3));
				vo.setEmpJumin(rs.getString(11));
				vo.setEmpName(rs.getString(2));
				vo.setEmpNum(rs.getString(1));
				vo.setEmpPhone(rs.getString(8));
				vo.setEmpPost(rs.getString(7));
				vo.setEmpPw(rs.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return vo;
	}
	
	public void employeeUpdate(EmployeeVO vo) {
		con = getConnection();
		sql = "update employees "
				+ " set emp_name = ?, emp_Addr = ? , emp_Addr_Detail = ?,"
				+ "     emp_Post = ?, emp_Phone = ?, emp_Jumin = ?, "
				+ "     emp_Email = ?, emp_Enter_Date = ?"
				+ " where emp_Num = ? ";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getEmpName());
			pstmt.setString(2, vo.getEmpAddr());
			pstmt.setString(3, vo.getEmpAddrDetail());
			pstmt.setString(4, vo.getEmpPost());
			pstmt.setString(5, vo.getEmpPhone());
			pstmt.setString(7, vo.getEmpEmail());
			pstmt.setDate(8, new java.sql.Date(vo.getEmpEnterDate().getTime()));
			pstmt.setString(6,vo.getEmpJumin());
			pstmt.setString(9,vo.getEmpNum());
			int i = pstmt.executeUpdate();
			System.out.println(i + "개 행이(가) 수정되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
	}
	public void employeeDelete(String empNum) {
		con = getConnection();
		sql = " delete from employees where emp_num = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, empNum);
			int i = pstmt.executeUpdate();
			System.out.println(i + "개 행이(가) 삭제되었습니다.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getEmpNum(String empId) {
		String empNum = "";
		con = getConnection();
		sql = " select emp_num from employees "
			+ " where emp_id = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, empId);
			rs = pstmt.executeQuery();
			rs.next();
			empNum = rs.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return empNum;
	}
	
	
	
	
	
}
