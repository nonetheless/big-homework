package businesslogic.billmanagementbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import main.IPAddress;
import po.BillPO;
import dataservice.billmanagementdataservice.BillManagementDataService;

public class BillManage {
	
	BillManagementDataService bmd;
	
	public BillManage(){
		try {
			bmd=(BillManagementDataService)Naming.lookup("rmi://"+IPAddress.ip+":8808/BillData");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public <T extends BillPO> ArrayList<T> getBillList(String fileName){
		ArrayList<T> list=null;
		ArrayList<T> res=new ArrayList<T>();
		try {
			list= bmd.getBillList(fileName);
			if(list==null){
				System.out.println("bill: "+fileName+" null pointer");
			}
			System.out.println("bill: "+fileName);
			System.out.println("bill: "+list.size());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<list.size();i++){
			res.add(list.get(i));
		}
		return res;	
	}
	
	public <T extends BillPO> String storeBill(ArrayList<T> list,String fileName){
		String res=null;
		try {
			System.out.println(fileName);
			res=bmd.storeBill(list, fileName);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	public <T extends BillPO> String updateBill(T t,String fileName){
		String res=null;
		try {
			res=bmd.updateBill(t, fileName);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
		
	}
	
	public <T extends BillPO> String approveBill(T t,String fileName){
		String res=null;
		try {
			res=bmd.approveBill(t, fileName);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
}
