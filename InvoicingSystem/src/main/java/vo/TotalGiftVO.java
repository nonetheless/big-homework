package vo;

public class TotalGiftVO extends GiftVO{
	
	private double totalMoney;
	
	public TotalGiftVO(double totalMoney,String id, String name, String kind,double price,int num){
		this.totalMoney=totalMoney;
		this.name=name;
		this.id=id;
		this.kind=kind;
		this.price=price;
		this.num=num;
	}
	
	public TotalGiftVO(double totalMoney,String name){
		this.totalMoney=totalMoney;
		this.name=name;
	}
	
	public double getTotalMoney(){
		return this.totalMoney;
	}
	
	public void add(int n){
		num=num+n;
	}
	
}
