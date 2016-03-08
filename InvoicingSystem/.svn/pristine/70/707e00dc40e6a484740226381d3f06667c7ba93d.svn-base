package vo;

import po.StockBillsPo;

public class StockBillsVo extends BillVO{
private String type;
private String identifier;
private String date;
private String operator;
private String commodity;
private String modelNum;
private int factualNum;
private String storeHouse;



public StockBillsVo(String type,String iden,String date,String operator,
		String commodity,String modelNum,int factualNum,String storeHouse){
	super();
	this.type=type;
	this.identifier=iden;
	this.date=date;
	this.operator=operator;
	this.commodity=commodity;
	this.modelNum=modelNum;
	this.factualNum=factualNum;
	this.storeHouse=storeHouse;
}
public StockBillsVo(StockBillsPo po){
	this.type=po.getType();
	this.identifier=po.getIdentifier();
	
	this.date=po.get_date();
	this.operator=po.getOperator();
	this.commodity=po.getCommodityName();
	this.modelNum=po.get_ModelNum();
	this.factualNum=po.getFactualNum();
	this.storeHouse=po.get_storeHouse();
}



public String get_type(){
	return this.type;
}
public String get_modelNum(){
	return modelNum;
}
public String get_operator(){
	return operator;
}

public String get_date(){
	return date;
}

public String get_commodity(){
	return commodity;
}
public int get_factualNum(){
	return factualNum;
}
public String get_iden(){
	return identifier;
}
public String get_storeHouse(){
	return storeHouse;
}
public String toString(){
	return this.type+";"+this.identifier+";"+";"+this.date+";"+this.operator+";"+
    this.commodity+";"+String.valueOf(this.factualNum)+";"+this.storeHouse;
}
public void set_date(String date){
	this.date=date;
}
public void set_iden(String iden){
	this.identifier=iden;
}

}
