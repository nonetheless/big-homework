package po;

import java.io.Serializable;

public class GoodPO implements Serializable{
	String name,kind,other;
	int number;
	double price;

	public GoodPO(String name,String kind,String other,int number,double price,double allprice){
		this.kind = kind;
		this.name = name;
		this.number = number;
		this.other = other;
		this.price = price;
		
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getKind(){
		return this.kind;
	}
	
	public String getOther(){
		return this.other;
	}
	
	public int getNumber(){
		return this.number;
	}
	public double getPrice(){
		return this.price;
	}
}