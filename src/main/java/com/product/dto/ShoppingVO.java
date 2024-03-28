package com.product.dto;




import lombok.Getter;

import lombok.Setter;
import lombok.ToString;

/*
CREATE TABLE product (
    productKey INT PRIMARY KEY,
    productcategory VARCHAR(50) NOT NULL,
    productName VARCHAR(50) NOT NULL,
    productPrice INT NOT NULL,
    productStock INT NOT NULL,
    productDescription VARCHAR(300) NOT NULL,
    productdate DATE DEFAULT SYSDATE
);
*/
@Setter
@Getter
@ToString
public class ShoppingVO {
	private int productKey;
	private String productCategory;
	private String productName;
	private int productPrice;
	private int productStock;
	private String productDescription;
	private java.sql.Timestamp productdate;


}
	
	
	
	


