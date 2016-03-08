package vo;

public class BuyingVO {
	String id;
	String name;
	String kind;
	double price;
	int number;
	//进货显示进价，销售显示售价
	public BuyingVO(String id,String name,String kind,double price,int number){
		this.id = id;
		this.name = name;
		this.kind =kind;
		this.price =price;
		this.number = number;
	}
	
	public String getId(){
		return id;
		
	}
	
	public String getName(){
		return name;
	}
	
	public String getKind(){
		return kind;
	}
	
	public double getPrice(){
		return price;
	}
	
	public void setPrice(double x){
		price =x;
	}
	
	public int getNumber(){
		return number;
	}
	
	public void setNumber(int x){
		number = x;
	}
	
	
	
	

}
