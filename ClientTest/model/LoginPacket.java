package com.example.model;

public class LoginPacket extends Packet{
	private String userName;
	private String password;
	
	public void process() {
		if (userName.equals("william") && 
				password.equals("123")) {
			System.out.println("login success");
		} else {
			System.out.println("login failed");
		}
	}
}
