package vo;

public class accountVO {
	 String accountname;
	 double accountmoney;
     public accountVO(String s,double d){
    	 accountname=s;
    	 accountmoney=d;
     }
     public String get(){
    	 String s="";
    	 s=s+accountname;
    	 s=s+Double.toString(accountmoney);
    	 return s;
     }

}
