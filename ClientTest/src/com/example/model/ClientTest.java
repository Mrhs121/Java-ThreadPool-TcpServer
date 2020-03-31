package com.example.model;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientTest {

	public static void main(String[] args) {
		Socket socket;
		for(int i=0;i<8;i++) {
			try {
				socket = new Socket("127.0.0.1",8123);
				OutputStream outputStream=socket.getOutputStream();
				DataOutputStream dos = new DataOutputStream(outputStream);
				
//				LoginPacket login = new LoginPacket();
//				login.setUserName("huangsheng----"+i);
//				login.setPassword("123");
				
				MessagePacket msg = new MessagePacket();
				msg.setMfriendName("huangsheng");
				msg.setmContent("nizaiganshenmea");
				dos.write(msg.serialize());  // 将消息包转换成指定格式的数据
				dos.flush();
				
				socket.shutdownOutput();//
				dos.close();
				outputStream.close();
				socket.close();
                
						
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
