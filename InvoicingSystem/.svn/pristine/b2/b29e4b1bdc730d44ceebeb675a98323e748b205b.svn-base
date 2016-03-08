package businesslogic.accountbl;

import java.util.ArrayList;

import po.accountPO;
import businesslogicservice.accountblservice.accountblservice;

public class accountcontroller implements accountblservice{
	accountbl ac=new accountbl();
	public int add(String name,double money){
		int i=ac.add(name, money);
		return i;
	}
	public int del(String name){
		int i=ac.del(name);
		return i;
	}
	public int change(String name1,String name2){
		int i=ac.change(name1, name2);
		return i;
	}
	public String find(String name){
		accountPO p=ac.find(name);
		String s=p.get();
		return s;
	}
	public int change2(String name,double money){
		int i=ac.change2(name, money);
		return i;
	}
	public int accountini(){
		int i=ac.accountini();
		return i;
	}
	public ArrayList<accountPO> find2(String year){
		ArrayList<accountPO> p=ac.find2(year);
		return p;
	}
	

}
