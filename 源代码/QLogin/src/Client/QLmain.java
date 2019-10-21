package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.LinkedList;
import java.util.Queue;

import QL.ClientGroupChatFrame;
import QL.ClientPrivateChat;
import QL.QLinterface;
import QL.QLogin;
import Client.Affari;

public class QLmain {
	
	public static int port = 2233;
	public static String address = "192.168.43.74";// 192.168.43.74 
	public static Socket socket = null;
	public static PrintWriter pw = null;
	public static QLogin QL = new QLogin(); //µÇÂ¼¿ò
	public static String account = null;
	public static String password = null;
	public static String name = null;
	public static volatile Queue<Affari> affariList = new LinkedList<Affari>();
	public static ClientGroupChatFrame GroupChat = new ClientGroupChatFrame();
	public static ClientPrivateChat PrivateChat = new ClientPrivateChat();
	public static void main(String[] args) {
		
//		QLinterface QLinterface = new QLinterface();
//		QLinterface.setVisible(true);
		QL.setVisible(true);
		try {
			socket  = new Socket(address,port);
			pw = new PrintWriter(socket.getOutputStream(),true);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		new Recieve();
//		PrivateChat.setVisible(true);
//		GroupChat.setVisible(true);
		
	}
}