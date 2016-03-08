package po;

import java.io.Serializable;





public class StockBillsPo  extends BillPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private String type;
	//private String identifier;
	private String date;
	//private String operator;
	private String commodity;
	private String modelNum;
	private int factualNum;
	private String storeHouse;
	

	 
public StockBillsPo(String type,String operator,String date,
		String commodityName,String modelNum,int factualNum,String iden,String storeHouse){
	
	this.type=type;
	this.operator=operator;
	this.date=date;
	this.commodity=commodityName;
	this.modelNum=modelNum;
	this.factualNum=factualNum;
	this.identifier=iden;
	this.storeHouse=storeHouse;
}

	
public String getType(){
	return this.type;
}
	
public String getOperator(){
	return this.operator;
}

public String get_date(){
	return this.date;
}


public String getCommodityName(){
	return this.commodity;
}
public String get_ModelNum(){
	return this.modelNum;
}
public int getFactualNum(){
	return this.factualNum;
}
/*public String get_iden(){
	return identifier;
}*/
public String get_storeHouse(){
	return storeHouse;
}
/*
public String getidentiter(){
	return identifier;
}*/


public String toString(){
	String str=this.type+";"+this.identifier+";"+this.date+
			";"+this.operator+";"+this.commodity+";"+this.modelNum+";"+this.factualNum+";"+this.storeHouse;
	return str;
}
public void set_date(String date){
	this.date=date;
}
	
}
