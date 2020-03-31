package com.example.test;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import com.example.model.Packet;
import com.example.model.PacketFactory;

public class ServerTest {
	
  private static int TIME = 0;
  
	public static void main(String[] args) {
		
			System.out.println("即将开始监听");
			try {
				final ServerSocket serverSocket =new ServerSocket(8123);
				System.out.println("server start...");
				
				while (Boolean.TRUE) {
					System.out.println("循环监听");												
					Socket socket=serverSocket.accept();
				    InputStream inputStream=socket.getInputStream();//
				    DataInputStream dis = new DataInputStream(inputStream);
					while (dis.available() <= 4) {				
						if(TIME>9) {
							break;
						}
						Thread.sleep(1000);
						System.out.println("available: " + dis.available());
						TIME++;				
					}
					byte[] data = new byte[dis.available()];
					dis.read(data);
							
					Packet packet;
					packet = PacketFactory.createPacket(data);
					packet.unserialize(data);
					packet.process();			
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
    
}




