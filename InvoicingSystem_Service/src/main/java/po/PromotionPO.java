package po;

import java.io.Serializable;

public class PromotionPO implements Serializable{
	
	boolean isGift;
	boolean isCoupon;
	
	public boolean getIsGift(){
		return this.isGift;
	}
	
	public boolean getIsCoupon(){
		return this.isCoupon;
	}
}
