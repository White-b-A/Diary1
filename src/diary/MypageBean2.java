package diary;

import java.io.Serializable;
import java.util.ArrayList;

public class MypageBean2 implements Serializable{
	
	private ArrayList<MypageBean1> DiaryArray = new ArrayList<MypageBean1>();

	//constructor
	public MypageBean2() {

	}

	public ArrayList<MypageBean1> getDiaryArray(){
		return DiaryArray;
		
	}
	
	public void addDiaryArray(MypageBean1 obj){
		DiaryArray.add(obj);
	}
	
	public int getArraySize() {
		return DiaryArray.size();
	}
	
}
