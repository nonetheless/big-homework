package po;

import java.io.Serializable;

public class VipGiftPO extends GiftPO implements Serializable{
	
	private int vipLevel;
	private String sendTime;
	
	public VipGiftPO(int vipLevel,String id, String name, String kind,double price,int num,String sendTime){
		this.vipLevel=vipLevel;
		this.name=name;
		this.id=id;
		this.kind=kind;
		this.price=price;
		this.num=num;
		this.sendTime=sendTime;
	}
	
	public VipGiftPO(int vipLevel,String name){
		this.vipLevel=vipLevel;
		this.name=name;
	}
	
	public int getVipLevel(){
		return this.vipLevel;
	}
	
	public void setNum(int a){
		this.num=a;
	}
	
	public void setSendTime(String s){
		this.sendTime=s;
	}
	
	public String getSendTime(){
		return this.sendTime;
	}
	
}
