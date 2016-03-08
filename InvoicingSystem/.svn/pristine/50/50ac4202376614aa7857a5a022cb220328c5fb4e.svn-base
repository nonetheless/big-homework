package businesslogic.paymentbl;




import java.util.ArrayList;

import businesslogic.billmanagementbl.paymentBill;
import businesslogicservice.paymentblservice.paymentblservice;



import vo.accountlineitemVO;
import vo.cashlineitemVO;
import vo.infoVO;
import po.*;

public class paymentcontroller implements paymentblservice , paymentBill{
	payin in=new payin();
	payout out=new payout();
	paycash cash=new paycash(); //必须初始化，否则空指针
	String s;//操作单据类型
	//in：收款单    
	//out:付款单
	//cash：现金支付单
	public paymentcontroller(String ss){
		s=ss;
	}
	public int addaccountlist(accountlineitemVO v){
		int i=0;
		if(s=="in"){i=in.addaccountlist(v);}
		else if(s=="out"){i=out.addaccountlist(v);}
		return i;
	}
	public int delaccountlist(accountlineitemVO v){
		int i=0;
		if(s=="in"){i=in.delaccountlist(v);}
		else if(s=="out"){i=out.delaccountlist(v);}
		return i;
	}
	public int addaccount(String s){
		int i=cash.addaccount(s);
		return i;
		
	}
	
    public int addcustomer(String cus){
    	//局部变量不能与全局变量重复！！！！！！！！！
		int i=0;//System.out.println(s);
		if(s=="in"){i=in.addcustomer(cus);}//System.out.println("s");
		else if(s=="out"){i=out.addcustomer(cus);}
		return 1;
		
	}
	public int addcashlist(cashlineitemVO v){
		int i=cash.addcashlist(v);
		return i;
		
	}
	public int delcashlist(cashlineitemVO v){
		int i=cash.delcashlist(v);
		return i;
		
	}
	public int submit(String oper){//将操作员传给方法
		int i=0;
		if(s=="in"){i=in.submit(oper);}
		else if(s=="out"){i=out.submit(oper);}
		else if(s=="cash"){i=cash.submit(oper);}
		return i;
	}
	public ArrayList<BillPO> find(infoVO v){
		infoPO p=new infoPO(v.gettime1(),v.gettime2(),v.getgoods(),v.getcustomer(),v.getoprator(),v.getstorehouse(),v.getbilltype());
		ArrayList<PayinPO> p1=findin(p);
		ArrayList<PayoutPO> p2=findout(p);
		ArrayList<PaycashPO> p3=findcash(p);
		ArrayList<BillPO> bp=new ArrayList<BillPO>();
		for(int i=0;i<p1.size();i++){
			bp.add(p1.get(i));
		}
		for(int i=0;i<p2.size();i++){
			bp.add(p2.get(i));
		}
		for(int i=0;i<p3.size();i++){
			bp.add(p3.get(i));
		}
		return bp;
	}
	private ArrayList<PayinPO> findin(infoPO ip){
		ArrayList<PayinPO> p=in.find(ip);
		return p;
	}
	private ArrayList<PayoutPO> findout(infoPO ip){
		ArrayList<PayoutPO> p=out.find(ip);
		return p;
	}
	private ArrayList<PaycashPO> findcash(infoPO p){
		return cash.find(p);
	}
	
	public ArrayList<ArrayList<BillPO>> refresh(){
		ArrayList<BillPO> a1=new ArrayList<BillPO>();
		ArrayList<BillPO> a2=new ArrayList<BillPO>();
		ArrayList<ArrayList<BillPO>> result=new ArrayList<ArrayList<BillPO>>();
		ArrayList<ArrayList<PayinPO>> in=refreshin();
		ArrayList<ArrayList<PayoutPO>> out=refreshout();
		ArrayList<ArrayList<PaycashPO>> cash=refreshcash();
		for(int i=0;i<2;i++){
			ArrayList<PayinPO> pip=in.get(i);
			ArrayList<PayoutPO> pop=out.get(i);
			ArrayList<PaycashPO> pcp=cash.get(i);
			if(i==0){
				for(int j=0;j<pip.size();j++){
					a1.add(pip.get(j));
				}
				for(int j=0;j<pop.size();j++){
					a1.add(pop.get(j));
				}
				for(int j=0;j<pcp.size();j++){
					a1.add(pcp.get(j));
				}
			}
			else if(i==1){
				for(int j=0;j<pip.size();j++){
					a2.add(pip.get(j));
				}
				for(int j=0;j<pop.size();j++){
					a2.add(pop.get(j));
				}
				for(int j=0;j<pcp.size();j++){
					a2.add(pcp.get(j));
				}
			}
		}
		result.add(a1);result.add(a2);
		return result;
	}
	private ArrayList<ArrayList<PayinPO>> refreshin(){
		return in.refresh();
	}
    private ArrayList<ArrayList<PayoutPO>> refreshout(){
		return out.refresh();
	}
    private ArrayList<ArrayList<PaycashPO>> refreshcash(){
    	return cash.refresh();
	
    }
    
    
    public void store(BillPO bp,int i){
    	int k=0;
    	if(s.equals("in")){
    		k=in.store((PayinPO)bp, i);
    	}
    	else if(s.equals("out")){
    		k=out.store((PayoutPO)bp, i);
    	}
    	else if(s.equals("cash")){
    		k=cash.store((PaycashPO)bp, i);
    	}
    	
    }

}
