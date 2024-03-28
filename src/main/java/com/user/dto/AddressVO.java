package com.user.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
CREATE TABLE address (
    address_no INT PRIMARY KEY,
    userid VARCHAR(20),
    addressid VARCHAR(20),
    username VARCHAR(20),
    adminCheck VARCHAR(1),
    nickname VARCHAR(20),
    address VARCHAR(100),
    addressDetail VARCHAR(50),
    deliveryRequest VARCHAR(200)
);
*/
@Setter
@Getter
@ToString
public class AddressVO {
		
	private int address_no;
	private String userid;
	private String addressid;
	private String username;
	private String adminCheck;
	private String nickname;
	private String address;
	private String addressDetail;
	private String deliveryRequest;

}
