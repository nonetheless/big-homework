package po;

import java.io.Serializable;

public class DiscountPO implements Serializable{
	private int vipLevel;
	private double discount;
	
	public DiscountPO(int vipLevel,double discount){
		this.vipLevel=vipLevel;
		this.discount=discount;
	}
	
	public int getVipLevel(){
		return this.vipLevel;
	}
	
	public double getDiscount(){
		return this.discount;
	}
	
	public void setDiscount(double d){
		this.discount=d;
	}
	
}
