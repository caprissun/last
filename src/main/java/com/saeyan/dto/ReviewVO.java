package com.saeyan.dto;

import java.util.Date;

public class ReviewVO {
	int reviewNum;
	String productNum;
	String purchaseNum;
	String reviewContent;
	String memberId;
	String productName;
	
	Date reviewDate;

	public int getReviewNum() {
		return reviewNum;
	}

	public void setReviewNum(int reviewNum) {
		this.reviewNum = reviewNum;
	}

	public String getProductNum() {
		return productNum;
	}

	public void setGoodsNum(String goodsNum) {
		this.productNum = productNum;
	}

	public String getPurchaseNum() {
		return purchaseNum;
	}

	public void setPurchaseNum(String purchaseNum) {
		this.purchaseNum = purchaseNum;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getProductName() {
		return productName;
	}

	public void setGoodsName(String goodsName) {
		this.productName = productName;
	}

	public Date getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}
	
}