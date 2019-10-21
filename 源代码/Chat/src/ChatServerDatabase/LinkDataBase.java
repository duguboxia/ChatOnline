package ChatServerDatabase;

import java.sql.*;

import UI.ChatServer;

import com.mysql.jdbc.Statement;

/*****************************************************************************
 * 聊天室数据库调用类
 * 
 * 作者 : 张文 时间: 2019.1.2 版本: 1.0
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
		// addUser(new ChatUser("隔壁老王","123","123"));
		// addFriends(new ChatFriends("123","123"));
		 //addNews(new ChatNews("123","123","生活总得带点绿"));
		//modifyNameForAccount("1", "圣光与你同在");
		//findFriendsListWithAccount("123");
		//modifyUserVisiForAccount("123561",1);
		CloseStatement();
		CloseLink();
		// ChatServer.addText("10");
	}

	
	// 链接数据库
	public static void Link() {

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, account, password);
			ChatServer.addText("连接数据库成功");
		} catch (Exception ex) {
			ChatServer.addText("连接失败");
			ex.printStackTrace();
		}

	}

	// 关闭数据库链接
	public static void CloseLink() {

		try {
			if (conn != null) {
				conn.close();
				ChatServer.addText("数据库链接,关闭成功");
			} else {
				ChatServer.addText("未连接数据库,无需关闭");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 获取Statement
	public static Statement getStatement() {

		try {
			sta = (Statement) conn.createStatement();
			ChatServer.addText("Statement 获取成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sta;
	}

	// 关闭Statement
	public static void CloseStatement() {

		if (sta != null) {
			try {
				sta.close();
				ChatServer.addText("Statement 关闭成功");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			ChatServer.addText("Statement 无需关闭");
		}
	}

	// 增加user true 执行成功 / false 失败
	public static boolean addUser(ChatUser user) {

		String insert = "INSERT INTO user(name,account,password) VALUES('" + user.name + "' , '"
				+ user.account + "' , '" + user.password + "')";
		try {
			sta.executeUpdate(insert);
			ChatServer.addText("增添 user 成功");
		} catch (SQLException e) {
			ChatServer.addText("添加 user 失败");
			return false;
		}
		return true;
	}

	// 增加 friends true 执行成功 / false 失败
	public static boolean addFriends(ChatFriends friends) {

		String name = findNameWithAccount(friends.friendsId);// friends name
		String insert = "INSERT INTO friends VALUES('" + friends.myId + "' , '"
				+ friends.friendsId + "' , '" + name + "')";
		try {
			sta.executeUpdate(insert);
			ChatServer.addText("添加成功");
		} catch (SQLException e) {
			ChatServer.addText("添加失败");
			return false;
		}
		return true;
	}
	
	/*判断account是否被注册*/
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

	// 增加news true 执行成功 / false 失败
	public static boolean addNews(ChatNews news) {

		String insert = "insert into news(from_id,to_id,content,date,time)" + " values(" + "'" + news.from
				+ "','" + news.to + "','" + news.content + "','"
				+ news.date.toString() + "','" + news.time + "')";

		try {
			sta.executeUpdate(insert);
			ChatServer.addText("add 消息 成功");
		} catch (SQLException e) {
			ChatServer.addText("add 消息 失败");
			return false;
		}
		return true;
	}

	// 筛选信息 -- 根据 account 查找 name (结果唯一)
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

	// 筛选信息 -- 根据 account 查询 好友 / 群 列表 反回 resultSet 迭代器 ( 好友 account ,好友name)
	public static ResultSet findFriendsListWithAccount(String account) {

		ResultSet re = null;
		String select = "select friends_id , friends_name  from friends where id = '"
				+ account + "'";

		try {
			re = sta.executeQuery(select);
			ChatServer.addText("搜寻成功");
		} catch (SQLException e) {
			ChatServer.addText("搜寻失败");
			return null;
		}
		return re;
	}

	// 筛选信息 -- 根据 account 查询 聊天记录 返回 resultSet 迭代器 ( 好友account ， news )
	/*
	 * visi - 1 : 全部消息 
	 */
	public static ResultSet findNewsGroupWithAccount(String myId,String FriendsId,String visi) {
		ResultSet ress;
		String select ="select content from news where to_id = '" + myId + "' and 'from' =  ' " + FriendsId +"'"; 
		if(visi != "全"){
			select += " and hava_read = '" + visi + "'";
		}  
		try {
		    ress = sta.executeQuery(select);
		} catch (SQLException e) {
			System.out.println(myId+" findNews  to  "+FriendsId+"  查询出错");
			return null;
		}
		return ress;
	}
	
	public static ResultSet findNewsGroupAll(String myId, String visi){
		ResultSet ress = null;
		String select = "select to_id , content from news where from_id = '" + myId+"'"; 
		if(!visi.equals("全")){
			select += " and hava_read = '" + visi + "'";
		}  
		try {
		    ress = sta.executeQuery(select);
		} catch (SQLException e) {
			System.out.println(myId+" findNews  to  "+"all"+"  查询出错");
			return null;
		}
		return ress;
		
	}

	// 修改 name -- 根据 account 修改 name 执行成功 true / 失败 false
	public static boolean modifyNameForAccount(String account, String name) {

		String modify = "update user set name = " + "'" + name + "'"
				+ " where account = " + "'" + account + "'";
		
		String fri = "update user set friends_name = '" +name+ "' where id = '" +account+ "'";
		try {
			sta.executeUpdate(modify);
			sta.executeUpdate(fri);
			ChatServer.addText("修改成功");
		} catch (SQLException e) {
			ChatServer.addText("修改失败");
			return false;
		}

		return true;
	}

	
	// 更新user 在线 状态 
	

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
		
		String update = "update user set visi = '否'" ;	
		try {
			sta.execute(update);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	/*由账户找密码*/
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

	
	/* 给定账户，判断user visi */
	public static String findUserVisiWithAccount(String account){
		
		
		String find = "select visi from user where account = '" + account +"'";
		try {
			res = sta.executeQuery(find);
			
			if(res.next()){
				return res.getString(1);
			}else{
				return "否";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "否";
	}

	/* 返回所有用户  */
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
	
	/* 将news 设置成已读 */
	public static boolean setNewsReadedToTrue(String id, String friId){
		
		String update = "update news set visi = '已' " +
				"where from_id = '" + id + "' and to_id = '" +friId+ "'";
		try {
			sta.execute(update);
		} catch (SQLException e) {
			System.out.println(id+" modify  to  "+friId+"  查询出错");
			return false;
		}
		return true;
	}
}






