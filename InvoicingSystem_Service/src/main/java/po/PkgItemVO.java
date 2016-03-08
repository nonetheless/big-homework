package po;

import java.io.Serializable;

public class PkgItemVO implements Serializable{
	
	private String id;    //商品编号
	private String name;   //商品名
	private String kind;    //商品种类
	private int num;    //商品数量
	private double price;    //商品价格
	
	public PkgItemVO(String id,String name,String kind,int num,double price){
		this.id=id;
		this.name=name;
		this.kind=kind;
		this.num=num;
		this.price=price;
	}
	
	public void setId(String id){
		this.id=id;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public void setKind(String kind){
		this.kind=kind;
	}
	
    public void setNum(int num){
		this.num=num;
	}
	
    public void setPrice(double price){
    	this.price=price;
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
	
    public int getNum(){
		return num;
	}
	
    
    public double getPrice(){
    	return price;
    }
}
