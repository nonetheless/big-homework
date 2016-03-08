package data.billmanegementdata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import po.BillPO;

public class BillData {
	
	public <T extends BillPO> ArrayList<T> getBillList(String fileName){
		ArrayList<T> templist=new ArrayList<T>();
		templist=read(fileName);
		return templist;
	}
	
	public <T extends BillPO> String storeBill(ArrayList<T> list,String fileName){//new update fileName
		String file="file/"+fileName+".ser";
		ArrayList<T> templist=new ArrayList<T>();
		templist=read(file);
		if(templist==null){
			JOptionPane.showMessageDialog(null, "list null pointer");
		}
		for(int i=0;i<list.size();i++){
			templist.add(list.get(i));
		}
		write(templist,file);
		return "Succeed";
	}
	
	public <T extends BillPO> String updateBill(T t,String fileName){//只负责更新所存储的账单
		
		ArrayList<T> templist=new ArrayList<T>();
		templist=read(fileName);
		String res=null;
		boolean isExist=false;;
		
		if(templist.size()>0){
		 for(int i=0;i<templist.size();i++){ 
			 String id=templist.get(i).getIdentifier();
			 if(t.getIdentifier().equals(id)){	
				 templist.remove(i);
				 templist.add(t);
				 write(templist,fileName);
				 res="Succeed";
				 isExist=true;
			}
		 }
		}
		if(!isExist){
			res="Not Found";
		}
		return res;
	}
	
	public <T extends BillPO> String approveBill(T t,String fileName){//只负责删除对应账单
		ArrayList<T> templist=new ArrayList<T>();
		templist=read(fileName);
		String res=null;
		boolean isExist=false;
		
		if(templist.size()>0){
		 for(int i=0;i<templist.size();i++){ 
			 String id=templist.get(i).getIdentifier();
			 if(t.getIdentifier().equals(id)){	
				 templist.remove(i);
				 write(templist,fileName);
				 res="Succeed";
				 isExist=true;
			}
		 }
		}
		if(!isExist){
			res="Not Found";
		}
		return res;
	}
	
	public  <T extends BillPO> ArrayList<T> read(String fileName){
		ArrayList<T> array;
		try {
			FileInputStream fs=new FileInputStream(fileName);
			ObjectInputStream os=new ObjectInputStream(fs);
			array = (ArrayList<T>)os.readObject();
			fs.close();
			os.close();
			return array;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public <T extends BillPO> void write(ArrayList<T> list,String fileName){
		
		try {
			FileOutputStream fs = new FileOutputStream(fileName);
			ObjectOutputStream os=new ObjectOutputStream(fs);
			os.writeObject(list);
			fs.close();
			os.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
