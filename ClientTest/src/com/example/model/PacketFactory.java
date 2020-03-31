package com.example.model;

import com.example.utils.Util;


public class PacketFactory {
	public static Packet createPacket(byte[] data) throws Exception {
		Packet packet;
		
		byte[] packetTypeBuffer = new byte[Util.INT_SIZE];
		System.arraycopy(data, 0, packetTypeBuffer, 0, Util.INT_SIZE);
		int packetType = Util.byte2int(packetTypeBuffer);
		
		if (packetType == Util.PACKET_TYPE_LOGIN) {
			packet = new LoginPacket();
		} else if(packetType == Util.PACKET_TYPE_MESSAGE) {
			packet = new MessagePacket();
		} else {
			throw new Exception("unknown packet!!!!");
		}
		return packet;
	}
}
