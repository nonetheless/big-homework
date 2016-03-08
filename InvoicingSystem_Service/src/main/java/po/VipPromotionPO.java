package po;

import java.io.Serializable;

public  class VipPromotionPO extends PromotionPO implements Serializable{
	
	private int vipLevel;
	private boolean isDiscount;
	
	public VipPromotionPO(int vipLevel,boolean isCoupon,boolean isGift,boolean isDiscount){
		this.vipLevel=vipLevel;
		this.isCoupon=isCoupon;
		this.isGift=isGift;
		this.isDiscount=isDiscount;
	}
	
	public int getVipLevel(){
		return vipLevel;
	}
	
	public boolean getIsDiscount(){
		return isDiscount;
	}
	
	public void setIsGift(boolean a){
		this.isGift=a;
	}
	
	
	public void setIsCoupon(boolean a){
		this.isCoupon=a;
	}
	
	
	public void setIsDiscount(boolean a){
		this.isDiscount=a;
	}

}
