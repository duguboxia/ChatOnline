package ChatServerDatabase;

import java.sql.Date;

public class ChatNews {

	String from;
	String to;
	String content;
	Date date = null;
	String time;
	java.util.Date uDate;

	// 创建时不需要指定日期.
	public ChatNews(String from, String to, String content) {

		uDate = new java.util.Date();
		date = new Date(uDate.getTime());
		time = this.getTime();
		this.from = from;
		this.to = to;
		this.content = content;
	}

	private String getTime() {

		String time;
		if (uDate.getHours() < 10) {
			time = "0" + uDate.getHours() + " : ";
		} else {
			time = uDate.getHours() + " : ";
		}

		if (uDate.getMinutes() < 10) {
			time += "0" + uDate.getMinutes() + " : ";
		} else {
			time += uDate.getMinutes() + " : ";
		}

		if (uDate.getSeconds() < 10) {
			time += "0" + uDate.getSeconds();
		} else {
			time += uDate.getSeconds();
		}
		return time;
	}

}
