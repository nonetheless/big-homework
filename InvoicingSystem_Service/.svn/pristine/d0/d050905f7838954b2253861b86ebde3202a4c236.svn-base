package po;

import java.io.Serializable;

public class VipCouponPO extends CouponPO implements Serializable{
	
	private int vipLevel;
	private String sendTime;
	
	public VipCouponPO(int vipLevel,int Price,int num,String sendTime,String endDate){
		this.vipLevel=vipLevel;
		this.price=Price;
		this.num=num;
		this.sendTime=sendTime;
		this.endDate=endDate;
	}
	
	public int getVipLevel(){
		return this.vipLevel;
	}
	
	public String getSendTime(){
		return sendTime;
	}
	
	public void setVipLevel(int a){
		this.vipLevel=a;
	}
	
	public void setPrice(int a){
		this.price=a;
	}
	
	public void setNum(int a){
		this.num=a;
	}
	
	public void setSendTime(String sendTime){
		this.sendTime=sendTime;
	}
	
	public void setEndDate(String endDate){
		this.endDate=endDate;
	}
	
	public void add(int n){
		num=num+n;
	}
}
