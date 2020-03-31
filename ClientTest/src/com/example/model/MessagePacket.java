package com.example.model;


import com.example.utils.Util;

public class MessagePacket extends Packet {
	private String mfriendName;
	private String mContent;
	
	public void process() {
		System.out.println("message to: " + mfriendName + ", content: " + mContent);
	}
	
	/**
	 * 许序列化数据
	 */
	@Override
	public byte[] serialize() {
		byte[] message = new byte[Util.INT_TYPE+Util.INT_NAME+mfriendName.length()+mContent.length()];
		int offset = 0;
		
		// 存入包的类型  占4个长度
		byte[] type = Util.int2byte(Util.PACKET_TYPE_MESSAGE);
		System.arraycopy(type, 0, message, offset, Util.INT_TYPE); // 最后一个参数为数据所占的长度
		offset+=Util.INT_TYPE;
		
		// 存入friendName的长度  占4个长度
		byte[] nameLength = Util.int2byte(mfriendName.length());
		System.arraycopy(nameLength, 0, message, offset, Util.INT_NAME);
		offset+=Util.INT_NAME;
		
		//存入friendName 占用friendName.length()个长度
		System.arraycopy(mfriendName.getBytes(), 0, message, offset, mfriendName.length());
		offset+=mfriendName.length();
		
		// 最后存入需要发送的消息
		System.arraycopy(mContent.getBytes(), 0, message, offset, mContent.length());
		offset+=mContent.length();
		
		return message;
	}

	public String getMfriendName() {
		return mfriendName;
	}

	public void setMfriendName(String mfriendName) {
		this.mfriendName = mfriendName;
	}

	public String getmContent() {
		return mContent;
	}

	public void setmContent(String mContent) {
		this.mContent = mContent;
	}
	
	
}
