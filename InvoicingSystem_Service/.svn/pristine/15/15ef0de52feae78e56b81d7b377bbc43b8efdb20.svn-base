package po;

import java.io.Serializable;

public class TotalGiftPO extends GiftPO implements Serializable{
	
private double totalMoney;
	
	public TotalGiftPO(double totalMoney,String id, String name, String kind,double price,int num){
		this.totalMoney=totalMoney;
		this.name=name;
		this.id=id;
		this.kind=kind;
		this.price=price;
		this.num=num;
	}
	
	public TotalGiftPO(double totalMoney,String name){
		this.totalMoney=totalMoney;
		this.name=name;
	}
	
	public double getTotalMoney(){
		return this.totalMoney;
	}
	
	public void setNum(int n){
		this.num=n;
	}
	
	public void add(int n){
		num=num+n;
	}
	
}
