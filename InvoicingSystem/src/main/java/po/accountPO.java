package po;

import java.io.Serializable;

public class accountPO implements Serializable{
	 String accountname;
	 double accountmoney;
     public accountPO(String s,double d){
    	 accountname=s;
    	 accountmoney=d;
     }
     public String get(){
    	 String s="";
    	 s=s+accountname;
    	 s=s+";";
    	 s=s+Double.toString(accountmoney);
    	 return s;
     }
     public String getname(){
    	 return accountname;
     }
     public int setname(String name){
    	 accountname=name;
    	 return 1;
     }
     public int setmoney(double d){
    	 accountmoney=accountmoney+d;
    	 return 1;
     }
}
