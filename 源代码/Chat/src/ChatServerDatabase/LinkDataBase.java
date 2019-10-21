package ChatServerDatabase;

import java.sql.*;

import UI.ChatServer;

import com.mysql.jdbc.Statement;

/*****************************************************************************
 * ���������ݿ������
 * 
 * ���� : ���� ʱ��: 2019.1.2 �汾: 1.0
 * 
 *****************************************************************************/

public class LinkDataBase {

	static String driver = "com.mysql.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/chat_database?characterEncoding=utf-8";
	static String account = "root";
	static String password = "root";
	static Connection conn = null;
	static Statement sta = null;
	static ResultSet res = null;

	public static void main(String[] args) {
		Link();
		getStatement();
		// addUser(new ChatUser("��������","123","123"));
		// addFriends(new ChatFriends("123","123"));
		 //addNews(new ChatNews("123","123","�����ܵô�����"));
		//modifyNameForAccount("1", "ʥ������ͬ��");
		//findFriendsListWithAccount("123");
		//modifyUserVisiForAccount("123561",1);
		CloseStatement();
		CloseLink();
		// ChatServer.addText("10");
	}

	
	// �������ݿ�
	public static void Link() {

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, account, password);
			ChatServer.addText("�������ݿ�ɹ�");
		} catch (Exception ex) {
			ChatServer.addText("����ʧ��");
			ex.printStackTrace();
		}

	}

	// �ر����ݿ�����
	public static void CloseLink() {

		try {
			if (conn != null) {
				conn.close();
				ChatServer.addText("���ݿ�����,�رճɹ�");
			} else {
				ChatServer.addText("δ�������ݿ�,����ر�");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ��ȡStatement
	public static Statement getStatement() {

		try {
			sta = (Statement) conn.createStatement();
			ChatServer.addText("Statement ��ȡ�ɹ�");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sta;
	}

	// �ر�Statement
	public static void CloseStatement() {

		if (sta != null) {
			try {
				sta.close();
				ChatServer.addText("Statement �رճɹ�");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			ChatServer.addText("Statement ����ر�");
		}
	}

	// ����user true ִ�гɹ� / false ʧ��
	public static boolean addUser(ChatUser user) {

		String insert = "INSERT INTO user(name,account,password) VALUES('" + user.name + "' , '"
				+ user.account + "' , '" + user.password + "')";
		try {
			sta.executeUpdate(insert);
			ChatServer.addText("���� user �ɹ�");
		} catch (SQLException e) {
			ChatServer.addText("��� user ʧ��");
			return false;
		}
		return true;
	}

	// ���� friends true ִ�гɹ� / false ʧ��
	public static boolean addFriends(ChatFriends friends) {

		String name = findNameWithAccount(friends.friendsId);// friends name
		String insert = "INSERT INTO friends VALUES('" + friends.myId + "' , '"
				+ friends.friendsId + "' , '" + name + "')";
		try {
			sta.executeUpdate(insert);
			ChatServer.addText("��ӳɹ�");
		} catch (SQLException e) {
			ChatServer.addText("���ʧ��");
			return false;
		}
		return true;
	}
	
	/*�ж�account�Ƿ�ע��*/
	public static boolean registerUser(String account){
		
		if(account == null){
			return false;
		}
		String select = "SELECT * from user where account = '" + account + "'";
		try {
			res = sta.executeQuery(select);
			if(res.next()){
				return false;
			}else{
				return true;
			}
		} catch (SQLException e) {
			return true;
		}
	}

	// ����news true ִ�гɹ� / false ʧ��
	public static boolean addNews(ChatNews news) {

		String insert = "insert into news(from_id,to_id,content,date,time)" + " values(" + "'" + news.from
				+ "','" + news.to + "','" + news.content + "','"
				+ news.date.toString() + "','" + news.time + "')";

		try {
			sta.executeUpdate(insert);
			ChatServer.addText("add ��Ϣ �ɹ�");
		} catch (SQLException e) {
			ChatServer.addText("add ��Ϣ ʧ��");
			return false;
		}
		return true;
	}

	// ɸѡ��Ϣ -- ���� account ���� name (���Ψһ)
	public static String findNameWithAccount(String account) {

		String select = "select name from user where account = '" + account
				+ "'";
		String seeked = null;
		try {
			ResultSet re = sta.executeQuery(select);
			re.next();
			seeked = re.getString(1);
		} catch (SQLException e) {
			return null;
		}

		return seeked;
	}

	// ɸѡ��Ϣ -- ���� account ��ѯ ���� / Ⱥ �б� ���� resultSet ������ ( ���� account ,����name)
	public static ResultSet findFriendsListWithAccount(String account) {

		ResultSet re = null;
		String select = "select friends_id , friends_name  from friends where id = '"
				+ account + "'";

		try {
			re = sta.executeQuery(select);
			ChatServer.addText("��Ѱ�ɹ�");
		} catch (SQLException e) {
			ChatServer.addText("��Ѱʧ��");
			return null;
		}
		return re;
	}

	// ɸѡ��Ϣ -- ���� account ��ѯ �����¼ ���� resultSet ������ ( ����account �� news )
	/*
	 * visi - 1 : ȫ����Ϣ 
	 */
	public static ResultSet findNewsGroupWithAccount(String myId,String FriendsId,String visi) {
		ResultSet ress;
		String select ="select content from news where to_id = '" + myId + "' and 'from' =  ' " + FriendsId +"'"; 
		if(visi != "ȫ"){
			select += " and hava_read = '" + visi + "'";
		}  
		try {
		    ress = sta.executeQuery(select);
		} catch (SQLException e) {
			System.out.println(myId+" findNews  to  "+FriendsId+"  ��ѯ����");
			return null;
		}
		return ress;
	}
	
	public static ResultSet findNewsGroupAll(String myId, String visi){
		ResultSet ress = null;
		String select = "select to_id , content from news where from_id = '" + myId+"'"; 
		if(!visi.equals("ȫ")){
			select += " and hava_read = '" + visi + "'";
		}  
		try {
		    ress = sta.executeQuery(select);
		} catch (SQLException e) {
			System.out.println(myId+" findNews  to  "+"all"+"  ��ѯ����");
			return null;
		}
		return ress;
		
	}

	// �޸� name -- ���� account �޸� name ִ�гɹ� true / ʧ�� false
	public static boolean modifyNameForAccount(String account, String name) {

		String modify = "update user set name = " + "'" + name + "'"
				+ " where account = " + "'" + account + "'";
		
		String fri = "update user set friends_name = '" +name+ "' where id = '" +account+ "'";
		try {
			sta.executeUpdate(modify);
			sta.executeUpdate(fri);
			ChatServer.addText("�޸ĳɹ�");
		} catch (SQLException e) {
			ChatServer.addText("�޸�ʧ��");
			return false;
		}

		return true;
	}

	
	// ����user ���� ״̬ 
	

	public static boolean modifyUserVisiForAccount(String account, String visi){
		
		String update = "update user set visi = '" + visi +"' where account = '" + account+"'";
		
		try {
			sta.execute(update);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	public static boolean modifyUserVisiAll(){
		
		String update = "update user set visi = '��'" ;	
		try {
			sta.execute(update);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	/*���˻�������*/
	public static String findPasswordWithAccount(String account){
		
		String find = "select password from user where account = '" + account + "'";
		try {
			res = sta.executeQuery(find);
			if(!res.next()){
				return null;
			}else{
				return res.getString(1) ;
			}
		} catch (SQLException e) {
			return null;
		}
		
	}

	
	/* �����˻����ж�user visi */
	public static String findUserVisiWithAccount(String account){
		
		
		String find = "select visi from user where account = '" + account +"'";
		try {
			res = sta.executeQuery(find);
			
			if(res.next()){
				return res.getString(1);
			}else{
				return "��";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "��";
	}

	/* ���������û�  */
	public static ResultSet findUserAccountAll(){
		ResultSet re = null;
		String find = "SELECT account from user";
		try {
			re = sta.executeQuery(find);
		} catch (SQLException e) {
			return null;
			//e.printStackTrace();
		}
		return re;
	}
	
	/* dropFriends */
	public static boolean DropFriends(String id, String friId){
		
		String drop = "delete from friends where id = '" +id +"' and ' friends_id = '" + friId + "'";
		try {
			sta.execute(drop);
		} catch (SQLException e) {
			return false;
		}
		drop = "delete from friends where id = '" + friId +"' and ' friends_id = '" + id + "'";
		try {
			sta.execute(drop);
		} catch (SQLException e) {
			return false;
		}
		
		return true;
	}
	
	/* ��news ���ó��Ѷ� */
	public static boolean setNewsReadedToTrue(String id, String friId){
		
		String update = "update news set visi = '��' " +
				"where from_id = '" + id + "' and to_id = '" +friId+ "'";
		try {
			sta.execute(update);
		} catch (SQLException e) {
			System.out.println(id+" modify  to  "+friId+"  ��ѯ����");
			return false;
		}
		return true;
	}
}






