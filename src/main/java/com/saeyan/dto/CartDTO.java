package com.saeyan.dto;

import com.user.dto.NonUserVO; // NonUserVO 클래스를 import
import com.user.dto.UserVO; // UserVO 클래스를 import
import com.saeyan.dto.ProductVO; // ProductVO 클래스를 import

public class CartDTO{
	private int cartNo; //장바구니 고유번호
	private ProductVO ProductVO; //상품 정보
	private int cartQty; // 장바구니에 담긴 특정 상품의 수량
	private UserVO UserVO; //장바구니에 상품을 추가한 사용자 정보
	private NonUserVO nonUserVO; // 비회원 고유번호
	public CartDTO(int cartNo, UserVO UserVO, ProductVO ProductVO,
			       int cartQty, NonUserVO nonUserVO) {
		super();
		this.cartNo = cartNo;  
		this.UserVO = UserVO; 
		this.ProductVO = ProductVO;
		this.cartQty = cartQty;
		this.nonUserVO = nonUserVO;
	}
	public CartDTO() {
		super();
	}
	public int getCartNo() {
		return cartNo;
	}
	public void setCartNo(int cartNo) {
		this.cartNo = cartNo;
	}
	public UserVO getUserVO() {
		return UserVO;
	}
	public void setUserVO(UserVO UserVO) {
		this.UserVO = UserVO;
	}
	public ProductVO getProductVO() {
		return ProductVO;
	}
	public void setProductVO(ProductVO ProductVO) {
		this.ProductVO = ProductVO;
	}
	public int getCartQty() {
		return cartQty;
	}
	public void setCartQty(int cartQty) {
		this.cartQty = cartQty;
	}
    
    public NonUserVO getNonUserVO() {
        return nonUserVO;
    }

    public void setNonUserVO(NonUserVO nonUserVO) {
        this.nonUserVO = nonUserVO;
    }
}
