package com.example.model;

import com.example.utils.Util;


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
	
	public byte[] serialize() {
		byte[] data = new byte[userName.length() + password.length() + 8];
		int offset = 0;
		
		// copy packet type to data
		byte[] packetType = Util.int2byte(Util.PACKET_TYPE_LOGIN);
		System.arraycopy(packetType, 0, data, offset, Util.INT_SIZE);
		offset += Util.INT_SIZE;
		
		// copy user name length to data
		byte[] userNameLength = Util.int2byte(userName.length());
		System.arraycopy(userNameLength, 0, data, offset, Util.INT_SIZE);
		offset += Util.INT_SIZE;
		
		// copy user name to data
		System.arraycopy(userName.getBytes(), 0, data, offset, userName.length());
		offset += userName.length();
		
		// copy passord to data
		System.arraycopy(password.getBytes(), 0, data, offset, password.length());
		offset += password.length();
		return data;
	}
	
	public void unserialize(byte[] data) {
		int offset = Util.INT_SIZE;
		
		byte[] userNameLengthBuffer = new byte[Util.INT_SIZE];
		System.arraycopy(data, offset, userNameLengthBuffer, 0, Util.INT_SIZE);
		int userNameLength = Util.byte2int(userNameLengthBuffer);
		offset += Util.INT_SIZE;
		
		userName = new String(data, offset, userNameLength);
		offset += userNameLength;
		
		
		password = new String(data, offset, data.length - 2 * Util.INT_SIZE - userNameLength);
		
		
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
