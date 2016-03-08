package businesslogic.paymentbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import main.IPAddress;
import businesslogic.accountbl.accountcontroller;
import businesslogic.billmanagementbl.SendBillToManager;
import dataservice.accountdataservice.accountdataservice;
import dataservice.paymentdataservice.paymentcashdataservice;
import po.PaycashPO;
import po.cashlineitempo;
import po.infoPO;
import vo.cashlineitemVO;

public class paycash {
	cashlist list=new cashlist();
	IPAddress ipa=new IPAddress();
	String  account;
	paymentcashdataservice p;
	public paycash(){
		try {
			p = (paymentcashdataservice)Naming.lookup("rmi://"+ipa.ip+":8822/paycashdata");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		} 
	}
	public int addaccount(String s){
		account=s;
		return 1;
	}
	public int addcashlist(cashlineitemVO v){
		int i=0;
		i=list.add(v);
		return i;
		
	}
	public int delcashlist(cashlineitemVO v){
		int i=0;
		i=list.del(v);
		return i;
		
	}
	public ArrayList<ArrayList<PaycashPO>> refresh(){
		ArrayList<ArrayList<PaycashPO>> pcp=new ArrayList<ArrayList<PaycashPO>>();
		try{
			pcp=p.refresh();
		}catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return pcp;
	}
	public int submit(String oper){
		ArrayList<cashlineitempo> clp=new ArrayList<cashlineitempo>();
		ArrayList<cashlineitem> cl=list.list;
		for(int i=0;i<cl.size();i++){
			clp.add(new cashlineitempo(cl.get(i).item,cl.get(i).money,cl.get(i).remark));
		}
		PaycashPO p=new PaycashPO(oper,clp,account);
		SendBillToManager s=new SendBillToManager();
		s.sendBill(p, "XJFKD");
		return 1;
	}
	public ArrayList<PaycashPO> find(infoPO ip){
		ArrayList<PaycashPO> pcp=new ArrayList<PaycashPO>();
		try{
			pcp=p.find(ip);
		}catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return pcp;
	}
	public int store(PaycashPO cp,int i){
		int k=0;
		double d=0-cp.gettotal();
		String s=cp.getaccount();
		accountcontroller c=new accountcontroller();
		c.change2(s, d);
		try{
			k=p.store(cp, i);
		}catch(RemoteException e1){
			e1.printStackTrace();
		}
		return k;
	}

}
