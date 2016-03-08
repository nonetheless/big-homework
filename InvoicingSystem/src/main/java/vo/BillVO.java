package vo;

public class BillVO {
	
	 String type;          //单据类型
	 String identifier;    //编号
	 String operator;      //操作员
	
	 public BillVO(){};
	 
	public BillVO(String type,String identifier,String operator){
		this.type=type;
		this.identifier=identifier;
		this.operator=operator;
	} 
	
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
