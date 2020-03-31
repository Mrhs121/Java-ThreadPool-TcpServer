package com.example.model;

import com.example.utils.Util;

public class MessagePacket extends Packet {
	private String friendName;
	private String content;
	
	public void process() {
		System.out.println("message to: " + friendName + "    content: " + content);
	}
	  
	
	public void unserialize(byte[] data) {
		int offset = Util.INT_TYPE;
		
		byte[] friendNameLengthBuffer = new byte[Util.INT_NAME];
		System.arraycopy(data, offset, friendNameLengthBuffer, 0, Util.INT_NAME);
		int friendNameLength = Util.byte2int(friendNameLengthBuffer);
		offset += Util.INT_SIZE;
		
		friendName = new String(data, offset, friendNameLength);
		System.out.println("friendName = "+friendName);
		offset += friendNameLength;
		
		content = new String(data, offset, data.length - 2 * Util.INT_SIZE - friendNameLength);
		System.out.println("content = "+content);
		System.out.println("friendName:"+friendName+",content:"+content);
	}
	
//	public byte[] serialize() {
//		
//	}
}
请问contains和equals有什么区别