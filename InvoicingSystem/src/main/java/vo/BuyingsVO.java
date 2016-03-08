package vo;

import java.util.ArrayList;

public class BuyingsVO {
	ArrayList<BuyingVO> list1;
	ArrayList<String> list2;
	public BuyingsVO(ArrayList<BuyingVO> list1,ArrayList<String> list2){
		this.list1=list1;
		this.list2 = list2;
	}
	
	public ArrayList<BuyingVO> getCommodity(){
		return list1;
	}
	
	public ArrayList<String> getFile(){
		return list2;
	}
}
