package po;

import java.io.Serializable;



public  class BillPO implements Serializable{
	
	 String type;          //单据类型
	 String identifier;    //编号
	 String operator;      //操作员
	
	 
	
	public String getType(){
		return this.type;
	}
	
	public String getIdentifier(){
		return this.identifier;
	}
	
	public String getOperator(){
		return this.operator;
	}
	
	
	
	public void setType(String type){
		this.type=type;
	}
	
	public void setIdentifier(String identifier){
		this.identifier=identifier;
	}
	
	public void setOperator(String operator){
		this.operator=operator;
	}
	public String toString(){
		return null;
	}
	
}
