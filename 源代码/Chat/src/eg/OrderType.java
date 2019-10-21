package eg;

import java.util.LinkedList;
import java.util.List;

public class OrderType {

	/****************************************************************
	 * 
	 * 		ָ�����;�̬��
	 * 		
	 * 		���ߣ� ����
	 * 		ʱ�䣺 2019.1.6
	 * 		�汾�� 1.0
	 * 
	 * 		���ڸ�ʽ��ָ�����ͣ�����server��client�����ݴ���ĶԽӹ�����
	 * 		orderName: ָ����
	 *      orderValue: ָ����ֵ
	 *       
	 ************************************************************** */
	
	String orderName;
	String orderValue; 

	public static List<OrderType> ts = new LinkedList<OrderType>();
	static int index = 0;

	// һ������Ŀ�ʼ
	public static final OrderType BEGINE =  setType("begine","000");
	
	// ָ����������
	public static final OrderType SETAFFARI = setType("setAffari","233");

	//����from
	public static final OrderType SETFROM = setType("setFrom","998");
	
	//����to
	public static final OrderType SETTO = setType("setTo","997");
	
	//set Content
	public static final OrderType SETCONTENT = setType("setContent","996");
	
	// �ύ
	public static final OrderType SUBMIT = setType("submit","999");
	
	// ��½
	public static final OrderType LOAD =  setType("load","001");
	
	// ¼���˺�
	public static final OrderType SETACCOUNT =  setType("setAccount","002");
	
	// ¼������
	public static final OrderType SETPASSWORD =  setType("setPassword","003");
	
	// ע��
	public static final OrderType REGISTER =  setType("register","004");
	
	//��½ʧ�� -- �˻�������
	public static final OrderType LOADERROR1 =  setType("loadError1","005");
	
	//��½ʧ�� -- �������
	public static final OrderType LOADERROR2 =  setType("loadError2","006");

	//���е�½
	public static final OrderType LOADERROR3 =  setType("loadError3","555");
	
	//��½�ɹ� 
	public static final OrderType LOADSUCCESS =  setType("loadSuccess","007");
	
	//ע��ʧ�� -- �˺ű�����
	public static final OrderType REGISTERERROR =  setType("registerError","008");
	
	// ע��ɹ�
	public static final OrderType REGISTERSUCCESS =  setType("registerSuccess","009");
	
	// ������ ���� (c -> s)
	public static final OrderType ONLINE =  setType("online","101");
	
	//������ ���� �ǳ�|�����б� - ����״̬|(s -> c)
	public static final OrderType MIANRETURNFRIENDS =setType("mainReturnFriends","102");
	
	//������ ���� �ǳ���Ϣ - visi|(s -> c)
	public static final OrderType MIANRETURNNEWS =setType("mainReturnNews","106");
	
	//������ ÿ��һ�뷢������(c -> s)
	public static final OrderType SENDNEED =setType("sendneed","103");

	
//	//������ ����������(s -> c)
//	public static final OrderType CLIENTRETURN =setType("clientreturn","104");
	
	//������ ����(c -> s)
	public static final OrderType DOWNLINE = setType("downline","105");
	
	//����ˢ����ʾ�������ж��Ƿ����ߣ���
	public static final OrderType UPDATE = setType("update","888");
	
	//�����Ӻ��Ѵ�һ���˺�(c ->s)
	public static final OrderType ADDGETCHAR =setType("addgetchar","201");
		
	//��ӷ�����ת����������(s -> c')
	public static final OrderType RETURNNEED =setType("returnneed","202");
	
	//��Ӻ��� ͬ�����(c' -> s)
	public static final OrderType AGERR =setType("agree","203");
	
	//ɾ������ ɾ�����Ѵ�һ���˺�char(c ->s)
	public static final OrderType DROPGETCHAR =setType("dropgetchar","204");
	
	//������Ϣ  ����������ͶԻ����� Ŀ�� ���� (c -> s)
	public static final OrderType SENDMESSAGE =setType("sendmessage","301");
	
	//������Ϣ  ��������ͻ���ת����Ϣ[�Ѿ��򿪵ĶԻ���] (s -> c)
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
