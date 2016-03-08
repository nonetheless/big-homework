package data.paymentdata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import data.commoditydata.PoWriter;
import dataservice.paymentdataservice.paymentoutdataservice;
import po.BillPO;
import po.PaycashPO;
import po.PayinPO;
import po.PayoutPO;
import po.accountPO;
import po.infoPO;

public class paymentoutdata extends UnicastRemoteObject implements paymentoutdataservice{
	String name1="file/payoutdata1.txt";//通过审批未被查看
	String name2="file/payoutdata2.txt";//通过审批且被查看
	String name3="file/payoutdata3.txt";//未过审批
	public paymentoutdata() throws RemoteException{
		//ini();
	}
	public void ini(){
		ArrayList<PayoutPO> p=new ArrayList<PayoutPO>();
		PoWriter p1=new PoWriter(name1);
		p1.write(p);
		
		PoWriter pp1=new PoWriter(name2);
		p1.write(p);
		
		PoWriter s1=new PoWriter(name3);
		p1.write(p);
		
	}
	public ArrayList<PayoutPO> find(infoPO ip) throws RemoteException{
		ArrayList<PayoutPO> p=readfile(name2);
		ArrayList<PayoutPO> ps=new ArrayList<PayoutPO>();
		
		long starttime=0;long time=0;long endtime=0;
		SimpleDateFormat df=new SimpleDateFormat("yyyy-mm-dd");
		try{
			if(ip.gettime1()!=null){
			    starttime=df.parse(ip.gettime1()).getTime();
			}
			if(ip.gettime2()!=null){
			    endtime=df.parse(ip.gettime2()).getTime();
			}
			
		}catch(Exception e){
			
		}
		for(int i=0;i<p.size();i++){
			
			try{
			
			    time=df.parse(p.get(i).gettime()).getTime();
			}catch(Exception e){
				
			}
			if(ip.gettime1()!=null){
				if(time<=starttime){
					continue;
				}
			}
			if(ip.gettime2()!=null){
				if(time>=endtime){
					continue;
				}
			}
			if(ip.getcustomer()!=null){
				if(p.get(i).getcustomer().equals(ip.getcustomer())){
					
				}
				else{
					continue;
				}
			}
			if(ip.getbilltype()!=null){
				if(p.get(i).getType().equals(ip.getbilltype())){
					
				}
				else{
					continue;
				}
			}
			if(ip.getoprator()!=null){
				if(p.get(i).getOperator().equals(ip.getoprator())){
					
				}
				else{
					continue;
				}
			}
			ps.add(p.get(i));
		}
		writefile(p,name2);
		return ps;
		
	}
	public int store(PayoutPO out,int i) throws RemoteException{
		if(i==1){
		ArrayList<PayoutPO> p=readfile(name1);
		p.add(out);
		writefile(p,name1);
		}
		else if(i==0){
			ArrayList<PayoutPO> p=readfile(name3);
			p.add(out);
			writefile(p,name3);
		}
		return 1;
	}
	public ArrayList<ArrayList<PayoutPO>> refresh() throws RemoteException{
		ArrayList<PayoutPO> p1=readfile(name1);
		ArrayList<PayoutPO> p2=readfile(name3);
		ArrayList<PayoutPO> wp=readfile(name2);
		for(int i=0;i<p1.size();i++){
			wp.add(p1.get(i));
		}
		writefile(wp,name2);
		ArrayList<PayoutPO> pa=new ArrayList<PayoutPO>();
		ArrayList<PayoutPO> pb=new ArrayList<PayoutPO>();
		writefile(pa,name1);writefile(pb,name3);
		ArrayList<ArrayList<PayoutPO>> p=new ArrayList<ArrayList<PayoutPO>>();
		p.add(p1);p.add(p2);
		return p;
	}
	private void writefile(ArrayList<PayoutPO> x,String name){
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(name));
			oos.writeObject(x);
			oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}
	private ArrayList<PayoutPO> readfile(String name){
		ArrayList<PayoutPO> s=new ArrayList<PayoutPO>();
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(name));
			s = (ArrayList<PayoutPO>)ois.readObject();
			ois.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}

}
