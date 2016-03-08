package po;

import java.io.Serializable;

public class cashlineitempo implements Serializable{
	String item;
	double money;
	String remark;
	public cashlineitempo(String n,double m,String r){
		item=n;money=m;remark=r;
	}
	public String getname(){
		return item;
	}
	public double getmoney(){
		return money;
	}
	public String getremark(){
		return remark;
	}
	public String getbill(){
		String s="";
		s=s+item;s=s+";";
		s=s+Double.toString(money);s=s+";";
		s=s+remark;s=s+";";
		return s;
	}

}
