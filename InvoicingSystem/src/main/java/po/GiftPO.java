package po;

import java.io.Serializable;

public class GiftPO implements Serializable{
	
	String id;
	String name;
	String kind;
	double price;
	int num;
	
	public String getName(){
		return this.name;
	}
	
	public String getId(){
		return this.id;
	}
	
	public String getKind(){
		return this.kind;
	}
	
	public double getPrice(){
		return this.price;
	}
	
	public int getNum(){
		return this.num;
	}
}
