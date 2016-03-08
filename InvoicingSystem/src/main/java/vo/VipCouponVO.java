package vo;

public class VipCouponVO extends CouponVO{
	
	private int vipLevel;
	private String sendTime;
	
	
	public VipCouponVO(int vipLevel,int price,int num,String sendTime,String endDate){
		this.vipLevel=vipLevel;
		this.price=price;
		this.num=num;
		this.sendTime=sendTime;
		this.endDate=endDate;
	}
	
	public int getVipLevel(){
		return this.vipLevel;
	}
	
	public String getSendTime(){
		return this.sendTime;
	}
	
	public void addNum(int n){
		num=num+n;
	}
	
}
