package vo;

import java.util.ArrayList;

import po.cashlineitempo;

public class PaycashVO {
	
	ArrayList<cashlineitempo> list;
	String account;
	public PaycashVO(String ide,String ope,ArrayList<cashlineitempo> list1,String acc){
		
		
		
		
		list=list1;
		account=acc;
		
		
	}
	public String getaccount(){
		return account;
	}
	public ArrayList<cashlineitempo> getlist(){
		return list;
	
	}
	

}
