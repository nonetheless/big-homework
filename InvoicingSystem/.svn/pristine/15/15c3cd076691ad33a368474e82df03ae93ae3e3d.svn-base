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
import dataservice.paymentdataservice.paymentindataservice;
import dataservice.paymentdataservice.paymentoutdataservice;
import po.PayinPO;
import po.PayoutPO;
import po.accountlineitempo;
import po.infoPO;
import vo.MemberVO;
import vo.accountlineitemVO;

public class payout {
	accountlist2 list=new accountlist2();
	String  customer;
	IPAddress ipa=new IPAddress();
	paymentoutdataservice p;
	public payout(){
		try {
			p = (paymentoutdataservice)Naming.lookup("rmi://"+ipa.ip+":8813/payoutdata");
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
	public ArrayList<ArrayList<PayoutPO>> refresh(){
		ArrayList<ArrayList<PayoutPO>> pcp=new ArrayList<ArrayList<PayoutPO>>();
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
		PayoutPO p=new PayoutPO(customer,oper,clp);
		SendBillToManager s=new SendBillToManager();
		s.sendBill(p, "FKD");
		return 1;
	}
	public ArrayList<PayoutPO> find(infoPO ip){
		ArrayList<PayoutPO> pcp=new ArrayList<PayoutPO>();
		try{
			pcp=p.find(ip);
		}catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return pcp;
	}
    public int store(PayoutPO op,int i){
    	int k=0;
    	
    	Member m=new Member();
        ArrayList<MemberVO> mp=m.findmember(op.getcustomer(), "");
        String mid=mp.get(0).getId();
    	accountcontroller a=new accountcontroller();
    	m.getMoney(mid, (0-op.gettotal()));
    	for(int j=0;j<op.getlist().size();j++){
    		a.change2(op.getlist().get(j).getname(), 0-op.getlist().get(j).getmoney());
    	}
    	try{
    		k=p.store(op, i);
    	}catch(RemoteException e1){
    		e1.printStackTrace();
    	}
    	
    	return k;
    }
}
