package com.saeyan.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductVO {
	String productNum;
	String productName;
	int productPrice;
	String productContent;
	int deliveryCost;
	
	String empNum;
	
	int visitCount;
	Date productRegist;
	String updateEmpNum;
	Date productUpdateDate;
	
	String productMainStore;
	String productMainStoreImg;
	
	String productImages;
	String productImagesImg;
}