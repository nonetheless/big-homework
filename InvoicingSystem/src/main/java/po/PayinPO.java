package po;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;



public class PayinPO extends BillPO{
	String customer;
	double total;
	ArrayList<accountlineitempo> list;
	String time;
	public PayinPO(String cus,String ope,ArrayList<accountlineitempo> list1){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd ");//设置日期格式
		time=df.format(new Date());// new Date()为获取当前系统时间
		customer=cus;
		SimpleDateFormat ddf=new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String time2=ddf.format(new Date());
		type="SKD";
		identifier=type+"-"+time2;
		operator=ope;
		list=list1;
		total=0;
		for(int i=0;i<list.size();i++){
			accountlineitempo a=list.get(i);
			double d=a.getmoney();
			total=total+d;
		}
	}
	public String getcustomer(){
		return customer;
	}
	public ArrayList<accountlineitempo> getlist(){
		return list;
	
	}
	public double gettotal(){
		return total;
	}
	public String gettime(){
		return time;
	}
	
	
	

}
