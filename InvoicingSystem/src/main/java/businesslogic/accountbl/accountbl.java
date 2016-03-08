package businesslogic.accountbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import main.IPAddress;
import po.accountPO;
import dataservice.accountdataservice.accountdataservice;


public class accountbl  {
	accountdataservice ac;
	IPAddress ipa=new IPAddress();
	public accountbl(){
		try {
			ac = (accountdataservice)Naming.lookup("rmi://"+ipa.ip+":8811/accountdata");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		} 
	}
	public int add(String name,double money){
		accountPO p=new accountPO(name,money);int i=0;
		try{
	       i=ac.add(p);
		
		}catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return i;
	}
	public int del(String name){
		int i=0;
		try{
			i=	ac.del(name);
		}catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return i;
	}
	public int change(String name1,String name2){
		int i=0;
		try{
		   i=ac.change(name1, name2);
		}catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return i;
	}
	public accountPO find(String acname){
		accountPO p=new accountPO(null,-9);
		try{		
			p=ac.find(acname);
		}catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//System.out.println(p.get()+"p");
		return p;
	}
	public int change2(String name,double money){
		int i=0;
		try{
			i=ac.change2(name, money);
		}catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return i;
	}
	public int accountini(){
		int i=0;
		try{
			i=ac.accountini();
		}catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return i;
	}
	public ArrayList<accountPO> find2(String year){
		ArrayList<accountPO> p=new ArrayList<accountPO>();
		try{
			p=ac.find2(year);
		}catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return p;
	}
	/*public static void main(String args[]){
		accountbl b=new accountbl();
		String ssd="zhanghu1";
		b.find(ssd);
	}*/

}
