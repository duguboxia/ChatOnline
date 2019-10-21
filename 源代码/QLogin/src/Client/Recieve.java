package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.JOptionPane;

import QL.QLinterface;
import QL.QLogin;

public class Recieve{
	
	
	public Recieve() {
		try {
			
				System.out.println("Recieve 已运行");
//					sleep(1000);
					ClientToServerThread ctst = new ClientToServerThread(0);
					ctst.start();
					System.out.println("ClientToServerThread 已运行");
					MessageDeal msgdl = new MessageDeal();
					msgdl.start();
					System.out.println("MessageDeal 已运行");
				} catch (Exception e) {
					e.printStackTrace();
				}
		} 
}
