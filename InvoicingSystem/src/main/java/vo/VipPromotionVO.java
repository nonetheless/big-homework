package vo;

public class VipPromotionVO extends PromotionVO{
	
	private int vipLevel;
	private boolean isDiscount;
	
	public VipPromotionVO(int vipLevel){
		this.vipLevel=vipLevel;
		this.isCoupon=false;
		this.isGift=false;
		this.isGift=false;
	}
	
	public VipPromotionVO(int vipLevel,boolean isCoupon,boolean isGift,boolean isDiscount){
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
	
}
