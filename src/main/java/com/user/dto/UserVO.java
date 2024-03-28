package com.user.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
CREATE TABLE users(
    user_no INT PRIMARY KEY,
    userid VARCHAR(40),
    pwd VARCHAR(40),
    username VARCHAR(20),
    email VARCHAR(40),
    phone INT,
    jumin INT,
    nickname VARCHAR(20),
    admincheck VARCHAR(1)
);
*/

@Getter
@Setter
@ToString
public class UserVO {

	private int user_no;
	private String userid;
	private String pwd;
	private String username;
	private String email;
	private int phone;
	private int jumin;
	private String nickname;
	private String adminCheck;

}
