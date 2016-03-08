package po;

import java.io.Serializable;

public class accountlineitempo implements Serializable{
	String name;
	double money;
	String remark;
	public accountlineitempo(String n,double m,String r){
		name=n;money=m;remark=r;
	}
	public String getname(){
		return name;
	}
	public double getmoney(){
		return money;
	}
	public String getremark(){
		return remark;
	}
	public String getbill(){
		String s="";
		s=s+name;s=s+";";
		s=s+Double.toString(money);s=s+";";
		s=s+remark;s=s+";";
		return s;
	}

}
