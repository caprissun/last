package com.saeyan.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.saeyan.dto.ReviewVO;

public class ReviewDAO extends DataBaseInfo{
	public void reviewInsert(ReviewVO vo) {
		con = getConnection();
		sql = " merge into reviews r"
			+ " using (select purchase_num, product_num from purchase_list"
			+ "		   where  purchase_num = ? and product_num = ? ) p "
			+ " on (r.purchase_num = p.purchase_num and r.product_num=p.product_num) "
			+ " WHEN MATCHED THEN "
			+ " update set review_content = ? "
			+ " WHEN NOT MATCHED THEN  "
			+ " insert (purchase_num,product_num,review_date,score"
			+ "			,review_content,member_id  )"
			+ " values(p.purchase_num, p.product_num , sysdate, 5 , ?, ?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getPurchaseNum());
			pstmt.setString(2, vo.getProductNum());
			pstmt.setString(3, vo.getReviewContent());
			pstmt.setString(4, vo.getReviewContent());
			pstmt.setString(5, vo.getMemberId());
			int i = pstmt.executeUpdate();
			System.out.println(i + "개가 병합되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	public ReviewVO reviewSelectOne(String purchaseNum,String productNum) {
		ReviewVO vo = null;
		con = getConnection();
		sql = " select REVIEW_CONTENT from reviews "
			+ " where purchase_Num = ? and product_Num = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, purchaseNum);
			pstmt.setString(2, productNum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo = new ReviewVO();
				vo.setReviewContent(rs.getString("REVIEW_CONTENT"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}
	public void reviewDelete(String reviewNum) {
		con = getConnection();
		sql = " delete from reviews where review_num = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, reviewNum);
			int i = pstmt.executeUpdate();
			System.out.println(i + "개가 삭제되었습니다.");
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public List<ReviewVO> reviewSelectAll(String productNum){
		List<ReviewVO> list = new ArrayList<ReviewVO>();
		con = getConnection();
		sql = " select REVIEW_NUM, REVIEW_CONTENT , review_date,member_id"
			+ " from reviews"
			+ " where product_num = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, productNum);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ReviewVO vo = new ReviewVO();
				vo.setReviewNum(rs.getInt("REVIEW_NUM"));
				vo.setReviewContent(rs.getString("REVIEW_CONTENT"));
				vo.setMemberId(rs.getString("member_id"));
				vo.setReviewDate(rs.getDate("review_date"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {close();}
		
		return list;
	}
}
