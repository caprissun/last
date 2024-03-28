package com.user.contoller.action;

import com.cart.controller.CartController;

public class ActionFactory {
	
	private static ActionFactory instance = new ActionFactory();
	
	private ActionFactory() {}
	
	public static ActionFactory getInstance() {
		return instance;
	}
	
	public Action getAciton(String command) {
		Action action = null;
		
		if(command.equals("user_login_form")) {
			action = new UserLoginForm();
		}else if(command.equals("user_login")) {
			action = new UserLoginAction();
		}else if(command.equals("user_join_form")) {
			action = new UserJoinForm();
		}else if(command.equals("user_join")) {
			action = new UserJoinAction();
		}else if(command.equals("nonuser_join_form")) {
			action = new NonUserJoinForm();
		}else if(command.equals("nonuser_join")) {
			action = new NonUserJoinAction();
		}else if(command.equals("idcheck")) {
			action = new IdCheckAction();
		}else if(command.equals("idcheck_form")) {
			action = new IdCheckForm();
		}else if(command.equals("main")) {
			action = new MainAction();
		}else if(command.equals("main_form")) {
			action = new MainForm();
		}else if(command.equals("mypage")) {
			action = new MypageAction();
		}else if(command.equals("mypage_form")) {
			action = new Mypageform();
		}else if(command.equals("refund")) {
			action = new RefundAction();
		}else if(command.equals("refund_form")) {
			action = new Refundform();
		}else if(command.equals("CartController")) {
			action = new cartcontroller();
		}
		
		
		return action;
	
	}
	
	
	
	
	
}
