package po;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class PaycashPO extends BillPO {
	
	double total;
	ArrayList<cashlineitempo> list;
	String account;
	String time;
	public PaycashPO(String ope,ArrayList<cashlineitempo> list1,String acc){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd ");//设置日期格式
		time=df.format(new Date());// new Date()为获取当前系统时间
		SimpleDateFormat ddf=new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String time2=ddf.format(new Date());
		type="XJFKD";
		identifier=type+"-"+time2;
		operator=ope;
		list=list1;
		account=acc;
		total=0;
		for(int i=0;i<list.size();i++){
			cashlineitempo a=list.get(i);
			double d=a.getmoney();
			total=total+d;
		}
	}
	public String getaccount(){
		return account;
	}
	public ArrayList<cashlineitempo> getlist(){
		return list;
	
	}
	public double gettotal(){
		return total;
	}
	public String gettime(){
		return time;
	}

}
