package po;

import java.io.Serializable;

public class customerPO implements Serializable{
	String customertype;
    String customername;
    String phonenumber;
    double shouldgive;
    double shouldget;
    public customerPO(String s1,String s2,String s3,double d1,double d2){
    	customertype=s1;
    	customername=s2;
    	phonenumber=s3;
    	shouldgive=d1;
    	shouldget=d2;
    	
    }
    public String get(){
    	StringBuilder builder=new StringBuilder();
    	builder.append(customertype);
    	builder.append(customername);
    	builder.append(phonenumber);
    	builder.append(shouldgive);
    	builder.append(shouldget);
    	
    	String s=builder.toString();
    	return s;
    }

}
