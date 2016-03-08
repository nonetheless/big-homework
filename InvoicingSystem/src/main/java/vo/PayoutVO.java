package vo;

import java.util.ArrayList;

import po.accountlineitempo;

public class PayoutVO {
    String customer;
	ArrayList<accountlineitempo> list;
	public PayoutVO(String cus,ArrayList<accountlineitempo> list1){
		customer=cus;
		list=list1;
	}
	public String getcustomer(){
		return customer;
	}
	public ArrayList<accountlineitempo> getlist(){
		return list;
	
	}

}
