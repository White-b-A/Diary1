package diary;

import java.io.Serializable;

public class MypageBean1 implements Serializable{

	private String day;
	private String title;

	//constructor
	public MypageBean1() {

	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getDay() {
		return this.day;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}


}
