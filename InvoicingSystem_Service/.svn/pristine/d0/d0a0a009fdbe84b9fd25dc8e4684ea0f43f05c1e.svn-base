package po;

import java.io.Serializable;

public class TotalPromotionPO extends PromotionPO implements Serializable{
	
	private double totalPrice;
	
	public TotalPromotionPO(double totalPrice){
		this.totalPrice=totalPrice;
		this.isGift=false;
		this.isCoupon=false;
	}
	
	public TotalPromotionPO(double totalPrice,boolean isCoupon,boolean isGift){
		this.totalPrice=totalPrice;
		this.isCoupon=isCoupon;
		this.isGift=isGift;
	}
	
	public double getTotalPrice(){
		return this.totalPrice;
	}
	
	public void setGift(boolean a){
		this.isGift=a;
	}
	
	public void setCoupon(boolean a){
		this.isCoupon=a;
	}
	
}
