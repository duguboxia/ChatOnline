package eg;

import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ChatServerDatabase.ChatFriends;
import ChatServerDatabase.ChatNews;
import ChatServerDatabase.ChatUser;
import ChatServerDatabase.LinkDataBase;
import UI.ChatServer;

public class Message extends Thread {
	
	Affari l = null;
	

	public Message(Affari a){
		this.l = a;
	}
	
	public void run(){
		executeAffari();
	}
	
	private void executeAffari(){
		
		if (l.affari == null){
			System.out.println(l.from+" affari = null "+l.to + "  "+l.clientsOut);
			return;
		}
		
		if(l.affari.equals(OrderType.REGISTER.orderValue)){
			ChatServer.addText("注册模块");
			exeuteRegister();
		}else if(l.affari.equals(OrderType.LOAD.orderValue)){
			ChatServer.addText("登陆模块");
			executeLoad();
		}else if(l.affari.equals(OrderType.ONLINE.orderValue)){
			ChatServer.addText("主界面回包");
			executeReturnMainWin();
		}else if(l.affari.equals(OrderType.DOWNLINE.orderValue)){
			ChatServer.addText("主动下线板块");
			executeDownLine();
		}else if(l.affari.equals(OrderType.SENDMESSAGE.orderValue)){
			ChatServer.addText("转发消息模块");
			forWard();
		}else if(l.affari.equals(OrderType.ADDGETCHAR.orderValue)){
			ChatServer.addText("添加好友申诉模块");
			executeAddFriends();
		}else if(l.affari.equals(OrderType.AGERR.orderValue)){
			ChatServer.addText("返回 - 添加好友申诉");
			executeReturnAddFri();
		}else if(l.affari.equals(OrderType.DROPGETCHAR.orderValue)){
			ChatServer.addText("delete Friends");
			executeDropFriends();
		}else if(l.affari.equals(OrderType.READED.orderValue)){
			ChatServer.addText("setNewsToReaded");
			executeSetNewsReaded();
		}else if(l.affari.equals(OrderType.MIANRETURNFRIENDS.orderValue)||l.affari.equals(OrderType.MIANRETURNNEWS.orderValue)){
			this.returnAffari(l);
		}
		l = null;
			
	}
		
	//主动下线
	private void executeDownLine() {
		ResultSet res = LinkDataBase.findUserAccountAll();
		List<String> account = new ArrayList<String>();
		account = transForm(res,1);
		noticeAllList(l,account);
		LinkDataBase.modifyUserVisiForAccount(l.from, "否");
		removeClientWithOut(this.findOutWithAccount(l.from));
		//ServerFrame.accounts.remove();
	}

	//回包
	private void returnAffari(Affari l){
		
		if(l.clientsOut == null){
			System.out.println(l.from+" "+ OrderType.getOrderWithValue(l.affari).orderName +"   " +l.to+ "   client = null" + andContent(l.content));
			return;
		}
		l.clientsOut.println(OrderType.BEGINE.orderValue);
		l.clientsOut.println(OrderType.SETFROM.orderValue+ l.from);
		l.clientsOut.println(OrderType.SETTO.orderValue + l.to);
		l.clientsOut.println(OrderType.SETAFFARI.orderValue+l.affari);
		for(int index = 0; index < l.content.size(); index++){
			l.clientsOut.println(OrderType.SETCONTENT.orderValue + l.content.get(index));
		}
		l.clientsOut.println(OrderType.SUBMIT.orderValue);
		ChatServer.addText(l.from + "     " + l.affari);
		System.out.println(l.from + "  " + l.affari + "  "+ l.to);
		return;
	}

	//注册函数
	private void exeuteRegister(){
		
		if(ChatServerDatabase.LinkDataBase.registerUser(l.content.get(0))){
			l.affari = OrderType.REGISTERSUCCESS.orderValue;
			LinkDataBase.addUser(new ChatUser(l.content.get(0), l.content.get(0), l.content.get(1)));
			ChatServer.addText("注册成功");
			l.submit();
		}else{
			l.affari = OrderType.REGISTERERROR.orderValue;
			l.submit();
			ChatServer.addText("注册失败");
		}
		returnAffari(l);
	}

	//登陆函数
	private void executeLoad(){
		
		List<String> account = new ArrayList<String>();
		//l.clientsOut = this.findOutWithAccount(l.content.get(1));
		if(LinkDataBase.findNameWithAccount(l.content.get(0)) == null){
			l.affari = OrderType.LOADERROR1.orderValue;
			ChatServer.addText(l.content.get(0) + "   "+l.content.get(1)+"   "+OrderType.LOADERROR1.orderName);
			returnAffari(l);
			ChatServer.addText(l.content.get(0) + "   "+l.content.get(1)+"   "+OrderType.LOADERROR3.orderName);
			return;
		}else if(!LinkDataBase.findPasswordWithAccount(l.content.get(0)).equals(l.content.get(1))){
			l.affari = OrderType.LOADERROR2.orderValue;
			ChatServer.addText(l.content.get(0) + "   "+l.content.get(1)+"   "+OrderType.LOADERROR2.orderName);
			returnAffari(l);
			ChatServer.addText(l.content.get(0) + "   "+l.content.get(1)+"   "+OrderType.LOADERROR3.orderName);
			return;
		}else if(LinkDataBase.findUserVisiWithAccount(l.content.get(0)).equals("在")){
			l.affari = OrderType.LOADERROR3.orderValue;
			returnAffari(l);
			System.out.println(OrderType.LOADERROR3.orderValue);
			ChatServer.addText(l.content.get(0) + "   "+l.content.get(1)+"   "+OrderType.LOADERROR3.orderName);
			return;
		}else{
			ServerFrame.clients.add(l.clientsOut);
			ServerFrame.accounts.add(l.content.get(0));
			l.affari = OrderType.LOADSUCCESS.orderValue;
			ResultSet res = LinkDataBase.findUserAccountAll();
			account = transForm(res,1);
			LinkDataBase.modifyUserVisiForAccount(l.content.get(0), "在");
			noticeAllList(l,account);
		}
		
		return;
	}
	
	//回应 mainwin -- 请求返回 : 先账户 ,后昵称 ，再消息.
	private void executeReturnMainWin(){
		Affari friends = new Affari();
		Affari news = new Affari();
		
		friends.clientsOut = l.clientsOut;
		news.clientsOut =l.clientsOut;
		
		try {
			//返回列表
			friends.affari = OrderType.MIANRETURNFRIENDS.orderValue;
			ResultSet ress = LinkDataBase.findUserAccountAll();
			List<String> f1 = this.transForm(ress, 1);
			String str = null;
			if(ress != null){
				for(int index = 0; index < f1.size();index++){
					//System.out.println("sdsad");
					ress = LinkDataBase.findFriendsListWithAccount(f1.get(index));
					if(ress.next())
					   str = ress.getString(1);
					friends.content.add("在线："+LinkDataBase.findUserVisiWithAccount(f1.get(index))+"  账号： "+f1.get(index)+"  昵称： "+ str);
					System.out.println("  fsdgz-----------" +index);
				}
				friends.submit();
				System.out.println("--------------------  ");
			}else{
				System.out.println(" friensList ress == null");
			}
			
			
			// 返回news
			ress = null;
			ress = LinkDataBase.findNewsGroupAll(l.from, "未");
			news.affari = OrderType.MIANRETURNNEWS.orderValue;
			news.clientsOut = this.findOutWithAccount(l.from);
			if(ress != null){
				while(ress.next()){
					//添加未读消息
					news.addContent(ress.getString(1) +"@"+ress.getString(2));
				}
				news.submit();
			}else{
				System.out.println(" newslist ress == null");
			}
			
			
		} catch (SQLException e) {
			System.out.println("回报出错.");
			e.printStackTrace();
		}
		
		return;
	}
	
	//转发消息
	private void forWard(){
		
		String str = andContent(l.content);
		ChatServer.addText(str);
		Affari aff = l;
		aff.affari = OrderType.GETMESSAGE.orderValue;
		aff.from = l.from;
		aff.to = l.to;
		
		LinkDataBase.addNews(new ChatNews(l.from,l.to,str));
		if(l.to.equals("all")){
			ResultSet res = LinkDataBase.findUserAccountAll();
			List<String> account  = null;
			account = ServerFrame.accounts;
			noticeAllList(l,account);
		}else{
			aff.clientsOut = this.findOutWithAccount(l.to);
			returnAffari(aff);
		}
		return ;
		
	}
	
	//整合contentList
	private String andContent(List<String> content){
		
		StringBuffer str = new StringBuffer();
		for(int index = 0; index < content.size(); index++){
			str.append(content.get(index));
		}
		return str.substring(0);
	}
	
	//根据账户找out对象。
	private PrintWriter findOutWithAccount(String account){
		
		for(int index = 0 ; index < ServerFrame.accounts.size(); index++){
			if(ServerFrame.accounts.get(index).equals(account)){
				return ServerFrame.clients.get(index);
			}
		}
		return null;
	}
	
	//------
	private void removeClientWithOut(PrintWriter out){
		ServerFrame.accounts.remove(l.from);
		ServerFrame.clients.remove(out);
	}
	
	//转发添加好友请求
 	private void executeAddFriends(){
		l.affari = OrderType.RETURNNEED.orderValue;
		returnAffari(l);
	}

	//处理 添加好友请求返回
	private void executeReturnAddFri(){
		
		l.clientsOut = findOutWithAccount(l.to);
		if(l.content.get(0).equals("true")){
			LinkDataBase.addFriends(new ChatFriends(l.from, l.to));
			LinkDataBase.addFriends(new ChatFriends(l.to, l.from));
		}
		returnAffari(l);
	}
	
	//dropFriend
	private void executeDropFriends(){
		LinkDataBase.DropFriends(l.from,l.to);
		l.content.add("true");
		returnAffari(l);
	}

	//setNewsToReaded
	private void executeSetNewsReaded(){
		LinkDataBase.setNewsReadedToTrue(l.from,l.to);
	}

	//notice All Affari
	private void noticeAllList(Affari aff , List<String> account){
		
		for(int index = 0; index < account.size(); index++){
			//aff.to = account.get(index);
			aff.clientsOut = findOutWithAccount(account.get(index));
			returnAffari(aff);
		}
	}

	private List<String> transForm(ResultSet res,int index){
		List<String> list = new ArrayList<String>();
		
		try {
			while(res.next()){
				list.add(res.getString(index));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	
	
}
