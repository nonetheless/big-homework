package vo;

public class VipGiftVO extends GiftVO{
	
	private int vipLevel;
	private String sendTime;
	
	public VipGiftVO(int vipLevel,String id, String name, String kind,double price,int num,String sendTime){
		this.vipLevel=vipLevel;
		this.name=name;
		this.id=id;
		this.kind=kind;
		this.price=price;
		this.num=num;
		this.sendTime=sendTime;
	}
	
	public VipGiftVO(int vipLevel,String name){
		this.vipLevel=vipLevel;
		this.name=name;
	}
	
	public int getVipLevel(){
		return this.vipLevel;
	}
	
	public String getSendTime(){
		return this.sendTime;
	}

}
