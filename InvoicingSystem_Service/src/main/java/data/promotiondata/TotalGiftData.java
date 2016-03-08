package data.promotiondata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.TotalGiftPO;

public class TotalGiftData {
	
	//save all the gifts with different totalMoney
	ArrayList<TotalGiftPO> list;
	String file=null;
	
	public TotalGiftData(){
		file="file/TotalGift.ser";
		list=read(file);
	}
	
	public ArrayList<TotalGiftPO> getTotalGift(double totalMoney){
		list=read(file);
		ArrayList<TotalGiftPO> array=new ArrayList<TotalGiftPO>();  //save gifts with the same totalMoney
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				if(list.get(i).getTotalMoney()==totalMoney){
					array.add(list.get(i));
				}
			}
		}
		return array;
	}
	
	public String updateTotalGift(double totalMoney,TotalGiftPO po){
		list=read(file);
		String res=null;
		boolean isExist=false;
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				if(list.get(i).getTotalMoney()==totalMoney&&
						list.get(i).getId().equals(po.getId())){
					isExist=true;
					list.get(i).setNum(po.getNum());
					res="Succeed";
					write(list,file);
				}
			}
		}
		if(!isExist){
			res="Not Found";
		}
		return res;
	}
	
	
	public String addTotalGift(double totalMoney,TotalGiftPO po){
		
		list=read(file);
		String res=null;
		boolean isExist=false;
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				if(list.get(i).getTotalMoney()==totalMoney&&
						list.get(i).getId().equals(po.getId())){
					isExist=true;
				}
			}
			if(!isExist){
				list.add(po);
				write(list,file);
				res="Succeed";
			}
			else{
				res="Already Exist";
			}
		}
		else{   //list内无赠品
			list.add(po);
			write(list,file);
			res="Succeed";
		}
		return res;
	}
	
	
	public String delTotalGift(double totalMoney,TotalGiftPO po){
		list=read(file);
		String res=null;
		boolean isExist=false;
		int pos=-1;
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				if(list.get(i).getTotalMoney()==totalMoney&&
						list.get(i).getId().equals(po.getId())){
					isExist=true;
					pos=i;
				}
			}
		}
		if(isExist){
			list.remove(pos);
			write(list,file);
			res="Succeed";
		}
		else{
			res="Not Found";
		}
		return res;
	}
	
	public String delTotalGiftByMoney(double totalMoney){
		list=read(file);
		String res=null;
		boolean isExist=false;
		if(list.size()>0){
			Label1:
			for(int i=0;i<list.size();i++){
				if(list.get(i).getTotalMoney()==totalMoney){
					isExist=true;
					list.remove(i);
					continue Label1;
				}
			}
		}
		if(isExist){
			write(list,file);
			res="Succeed";
		}
		else{
			res="Not Found";
		}
		return res;
	}
	
	public ArrayList<TotalGiftPO> read(String fileName){
		ArrayList<TotalGiftPO> array;
		try {
			FileInputStream fs=new FileInputStream(fileName);
			ObjectInputStream os=new ObjectInputStream(fs);
			array = (ArrayList<TotalGiftPO>)os.readObject();
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
	
	public void write(ArrayList<TotalGiftPO> list,String fileName){
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
