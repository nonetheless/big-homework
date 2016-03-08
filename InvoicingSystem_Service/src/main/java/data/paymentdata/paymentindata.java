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

import po.PaycashPO;
import po.PayinPO;
import po.PayoutPO;
import po.infoPO;
import data.commoditydata.PoWriter;
import dataservice.paymentdataservice.paymentindataservice;

public class paymentindata extends UnicastRemoteObject implements paymentindataservice{
	String name1="file/payindata1.txt";//通过审批的单据未被查看
	String name2="file/payindata2.txt";//通过审批的单据且已被查看
	String name3="file/payindata3.txt";//未通过审批，不存在
	public paymentindata() throws RemoteException{
		//ini();
	}
	public void ini(){
		ArrayList<PayinPO> p=new ArrayList<PayinPO>();
		PoWriter p1=new PoWriter(name1);
		p1.write(p);
		
		PoWriter pp1=new PoWriter(name2);
		p1.write(p);
		
		PoWriter s1=new PoWriter(name3);
		p1.write(p);
		
	}
	public ArrayList<PayinPO> find(infoPO ip) throws RemoteException{
		ArrayList<PayinPO> p=readfile(name2);
		ArrayList<PayinPO> ps=new ArrayList<PayinPO>();
		
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
	public int store(PayinPO in,int i) throws RemoteException{
		if(i==1){
			ArrayList<PayinPO> p=readfile(name1);
			p.add(in);
			writefile(p,name1);
		}
		else if(i==0){
			ArrayList<PayinPO> p=readfile(name3);
			p.add(in);
			writefile(p,name3);
		}
		return 1;
	}
	public ArrayList<ArrayList<PayinPO>> refresh() throws RemoteException {
		ArrayList<ArrayList<PayinPO>> p=new ArrayList<ArrayList<PayinPO>>();
		ArrayList<PayinPO> p1=readfile(name1);
		ArrayList<PayinPO> p2=readfile(name3);
		p.add(p1);p.add(p2);
		ArrayList<PayinPO> wp=readfile(name2);
		for(int i=0;i<p1.size();i++){
			wp.add(p1.get(i));
		}
		writefile(wp,name2);
		ArrayList<PayinPO> pa=new ArrayList<PayinPO>();
		ArrayList<PayinPO> pb=new ArrayList<PayinPO>();
		writefile(pa,name1);writefile(pb,name3);
		return p;
	}
	private void writefile(ArrayList<PayinPO> x,String name){
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
	private ArrayList<PayinPO> readfile(String name){
		ArrayList<PayinPO> s=new ArrayList<PayinPO>();
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(name));
			s = (ArrayList<PayinPO>)ois.readObject();
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
