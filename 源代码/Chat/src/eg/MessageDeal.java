package eg;

public class MessageDeal extends Thread {
	
	private volatile boolean exit = false;
	private Affari l = null;
	
	public void run(){
		while(!exit){
		
			try {
				sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(ServerFrame.affariList.isEmpty()){
				//ChatServer.addText("�ȴ�ing......");
				continue;
			}
			l = ServerFrame.affariList.poll();
			ServerFrame.massage.execute(new Message(l));
		}
	}
	
	//����ģ��

	
}
