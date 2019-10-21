package eg;

import java.util.LinkedList;
import java.util.List;

public class OrderType {

	/****************************************************************
	 * 
	 * 		指令类型静态类
	 * 		
	 * 		作者： 张文
	 * 		时间： 2019.1.6
	 * 		版本： 1.0
	 * 
	 * 		用于格式化指令类型，方便server与client的数据传输的对接工作。
	 * 		orderName: 指令名
	 *      orderValue: 指令数值
	 *       
	 ************************************************************** */
	
	String orderName;
	String orderValue; 

	public static List<OrderType> ts = new LinkedList<OrderType>();
	static int index = 0;

	// 一条事务的开始
	public static final OrderType BEGINE =  setType("begine","000");
	
	// 指定请求类型
	public static final OrderType SETAFFARI = setType("setAffari","233");

	//设置from
	public static final OrderType SETFROM = setType("setFrom","998");
	
	//设置to
	public static final OrderType SETTO = setType("setTo","997");
	
	//set Content
	public static final OrderType SETCONTENT = setType("setContent","996");
	
	// 提交
	public static final OrderType SUBMIT = setType("submit","999");
	
	// 登陆
	public static final OrderType LOAD =  setType("load","001");
	
	// 录入账号
	public static final OrderType SETACCOUNT =  setType("setAccount","002");
	
	// 录入密码
	public static final OrderType SETPASSWORD =  setType("setPassword","003");
	
	// 注册
	public static final OrderType REGISTER =  setType("register","004");
	
	//登陆失败 -- 账户不存在
	public static final OrderType LOADERROR1 =  setType("loadError1","005");
	
	//登陆失败 -- 密码错误
	public static final OrderType LOADERROR2 =  setType("loadError2","006");

	//已有登陆
	public static final OrderType LOADERROR3 =  setType("loadError3","555");
	
	//登陆成功 
	public static final OrderType LOADSUCCESS =  setType("loadSuccess","007");
	
	//注册失败 -- 账号被抢了
	public static final OrderType REGISTERERROR =  setType("registerError","008");
	
	// 注册成功
	public static final OrderType REGISTERSUCCESS =  setType("registerSuccess","009");
	
	// 主界面 上线 (c -> s)
	public static final OrderType ONLINE =  setType("online","101");
	
	//主界面 返回 昵称|好友列表 - 在线状态|(s -> c)
	public static final OrderType MIANRETURNFRIENDS =setType("mainReturnFriends","102");
	
	//主界面 返回 昵称消息 - visi|(s -> c)
	public static final OrderType MIANRETURNNEWS =setType("mainReturnNews","106");
	
	//主界面 每隔一秒发送请求(c -> s)
	public static final OrderType SENDNEED =setType("sendneed","103");

	
//	//主界面 服务器返回(s -> c)
//	public static final OrderType CLIENTRETURN =setType("clientreturn","104");
	
	//主界面 下线(c -> s)
	public static final OrderType DOWNLINE = setType("downline","105");
	
	//主动刷新提示（用于判断是否在线）。
	public static final OrderType UPDATE = setType("update","888");
	
	//添加添加好友传一个账号(c ->s)
	public static final OrderType ADDGETCHAR =setType("addgetchar","201");
		
	//添加服务器转发好友请求(s -> c')
	public static final OrderType RETURNNEED =setType("returnneed","202");
	
	//添加好友 同意与否(c' -> s)
	public static final OrderType AGERR =setType("agree","203");
	
	//删除好友 删除好友传一个账号char(c ->s)
	public static final OrderType DROPGETCHAR =setType("dropgetchar","204");
	
	//发送消息  向服务器发送对话请求 目标 内容 (c -> s)
	public static final OrderType SENDMESSAGE =setType("sendmessage","301");
	
	//接受消息  服务器向客户端转发信息[已经打开的对话框] (s -> c)
	public static final OrderType GETMESSAGE =setType("getmessage","401");
	
	//readed
	public static final OrderType READED = setType("readed","777");
	
	private OrderType(String name,String order) {
		this.orderName = name;
		this.orderValue = order;
	}

	public static OrderType setType(String name,String order){
		OrderType o = new OrderType(name,order);
		//ChatServer.addText(o.getClass());
		ts.add(o);
		return o;
	}
	
	static OrderType getOrderWithValue(String value){
		
		for(int i = 0; i < ts.size(); i++){
			if(ts.get(i).orderValue.equals(value)){
				return ts.get(i);
			}
		}
		return null;
	}

	static OrderType getOrderWithName(String name){
		
		for(int i = 0; i < ts.size(); i++){
			if(ts.get(i).orderName.equals(name)){
				return ts.get(i);
			}
		}
		return null;
	}
	
}
