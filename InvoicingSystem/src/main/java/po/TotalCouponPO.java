package po;

import java.io.Serializable;

public class TotalCouponPO extends CouponPO implements Serializable {
	
	private double totalMoney;
	
	public TotalCouponPO(double totalMoney,int price,int num,String endDate){
		this.totalMoney=totalMoney;
		this.price=price;
		this.num=num;
		this.endDate=endDate;
	}
	
	public double getTotalMoney(){
		return this.totalMoney;
	}
	
	public void setMoney(double a){
		this.totalMoney=a;
	}
	
	public void setPrice(int a){
		this.price=a;
	}
	
	public void setNum(int a){
		this.num=a;
	}
	
	public void setEndDate(String s){
		this.endDate=s;
	}
	
	public void add(int n){
		num=num+n;
	}
	
}
