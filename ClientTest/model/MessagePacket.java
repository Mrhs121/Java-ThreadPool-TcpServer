package com.example.model;

public class MessagePacket extends Packet {
	private String friendName;
	private String content;
	
	public void process() {
		System.out.println("message to: " + friendName + ", content: " + content);
	}
}
