package businesslogic.paymentbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import main.IPAddress;
import businesslogic.accountbl.accountcontroller;
import businesslogic.billmanagementbl.SendBillToManager;
import businesslogic.memberbl.Member;
import businesslogic.memberbl.MemberControl;
import dataservice.paymentdataservice.paymentcashdataservice;
import dataservice.paymentdataservice.paymentindataservice;
import vo.MemberVO;
import vo.accountlineitemVO;
import po.PaycashPO;
import po.PayinPO;
import po.accountPO;
import po.accountlineitempo;
import po.cashlineitempo;
import po.infoPO;

public class payin {
	accountlist2 list=new accountlist2();
	String  customer="sd";
	IPAddress ipa=new IPAddress();
	paymentindataservice p;
	public payin(){
		try {
			p = (paymentindataservice)Naming.lookup("rmi://"+ipa.ip+":8812/payindata");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		} 
	}
	public int addcustomer(String s){
		
		customer=s;
		//System.out.println(customer);
		return 1;
	}
	public int addaccountlist(accountlineitemVO v){
		int i=0;
		i=list.add(v);
		return i;
	}
	public int delaccountlist(accountlineitemVO v){
		int i=0;
		i=list.del(v);
		return i;
	}
	public ArrayList<ArrayList<PayinPO>> refresh(){
		ArrayList<ArrayList<PayinPO>> pcp=new ArrayList<ArrayList<PayinPO>>();
		try{
			pcp=p.refresh();
		}catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return pcp;
		
	}
	public int submit(String oper){
		ArrayList<accountlineitempo> clp=new ArrayList<accountlineitempo>();
		ArrayList<accountlineitem2> cl=list.list;
		for(int i=0;i<cl.size();i++){
			clp.add(new accountlineitempo(cl.get(i).name,cl.get(i).money,cl.get(i).remark));
		}
		PayinPO po=new PayinPO(customer,oper,clp);
		//System.out.println(customer);
		SendBillToManager s=new SendBillToManager();
		s.sendBill(po, "SKD");
		return 1;
	}
	public ArrayList<PayinPO> find(infoPO ip){
		ArrayList<PayinPO> pcp=new ArrayList<PayinPO>();
		try{
			pcp=p.find(ip);
		}catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return pcp;
	}
    public int store(PayinPO ip,int i){
    	int k=0;
    	Member m=new Member();
    	ArrayList<MemberVO> mp=m.findmember(ip.getcustomer(), "");
        String mid=mp.get(0).getId();
    	accountcontroller a=new accountcontroller();
    	m.payMoney(mid, (0-ip.gettotal()));
    	
    	for(int j=0;j<ip.getlist().size();j++){
    		a.change2(ip.getlist().get(j).getname(), ip.getlist().get(j).getmoney());
    	}
    	try{
    		k=p.store(ip, i);
    	}catch(RemoteException e1){
    		e1.printStackTrace();
    	}
    	return k;
    }
   public static void main(String args[]){
    	payin pin=new payin();
    	pin.addcustomer("liuzhijia");
    	System.out.println(pin.customer);
    	accountlineitempo po=new accountlineitempo("zhanghu1",20,"wu");
    	ArrayList<accountlineitempo> clp=new ArrayList<accountlineitempo>();
    	clp.add(po);
    	PayinPO acp=new PayinPO(pin.customer,"hc",clp);
    	SendBillToManager s=new SendBillToManager();
		s.sendBill(acp, "SKD");
   }
}
