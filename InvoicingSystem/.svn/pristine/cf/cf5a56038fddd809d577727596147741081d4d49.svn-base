package po;

import java.io.Serializable;

public class MemberPO implements Serializable{
	int level;
	String kind,name,tel,address,youbian,email,saler,id;
	double memberShouldPay,memberShouldGet,memberLimit;
	
	public MemberPO(String id1,int memberLevel,String memberKind,String memberName,String memberTel,String memberAd,String memberYB,String memberE,String saler,double pay,double get,double limit){
		id = id1;
		level = memberLevel;
		kind = memberKind;
		name = memberName;
		tel = memberTel;
		address = memberAd;
		youbian = memberYB;
		email = memberE;
		this.saler = saler;
		memberShouldPay = pay;
		memberShouldGet = get;
		memberLimit = limit;
		
		
	}
	public String getId(){
		return id;
	}
	
	
	public int getLevel(){
		return level;
	}
	
	public void setLevel(int level){
		this.level = level;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getKind(){
		return this.kind;
	}
	
	public String getTel(){
		return this.tel;
	}
	
	public void setTel(String tel){
		this.tel = tel;
	}
	
	public String getAd(){
		return this.address;
	}
	
	public void setAd(String ad){
		this.address=ad;
	}
	
	public String getYB(){
		return this.youbian;
	}
	
	public void setYB(String yb){
		this.youbian  = yb;
	}
	
	public String getE(){
		return this.email ;
	}
	public void setE(String e){
		this.email  = e;
	}
	
	public String getSaler(){
		return this.saler;
	}
	
	public void setSaler(String s ){
		this.saler = s;
	}
	
	public double getPay(){
		return this.memberShouldPay;
	}
	public void setPay(double s){
		this.memberShouldPay = s;
	}
	
	public double getGet(){
		return this.memberShouldGet;
	}
	
	public void setGet(double s){
		this.memberShouldGet=s;
	}
	public double getLimit(){
		return this.memberLimit;
	}
	public void setLimit(double s){
		this.memberLimit=s;
	}
	
	public String toString(){
		return kind+"-"+name+"-"+tel+"-"+address+"-"+youbian+"-"+email+"-"+saler+"-"+id;
	}

}
