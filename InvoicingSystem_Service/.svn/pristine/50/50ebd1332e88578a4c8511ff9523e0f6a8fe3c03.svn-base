package data.promotiondata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import po.TotalCouponPO;

public class TotalCouponData {
	
	//一个总价额只能对应一种代金券
	//增加新种类代金券用add
	//增加同种类种类代金券用update
	ArrayList<TotalCouponPO> list;
	String file=null;
	
	public TotalCouponData(){
		file="file/TotalCoupon.ser";
		list=read(file);
	}
	
	public TotalCouponPO getTotalCoupon(double totalMoney){
		list=read(file);
		TotalCouponPO res=null;
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				if(totalMoney==list.get(i).getTotalMoney()){
					res=list.get(i);
				}
			}
		}
		return res;
	}
	
	public ArrayList<TotalCouponPO> getTotalCouponList(){
		
		list=read(file);
		ArrayList<TotalCouponPO> array=list;
		return array;
	} 
	
	public String updateTotalCoupon(double totalMoney,TotalCouponPO po){
		
		list=read(file);
		String res=null;
		boolean isExist=false;
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				if(list.get(i).getTotalMoney()==totalMoney){
					isExist=true;
					list.get(i).setMoney(po.getTotalMoney());
					list.get(i).setPrice(po.getPrice());
					list.get(i).setNum(po.getNum());
					list.get(i).setEndDate(po.getEndDate());
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
	
	public String addTotalCoupon(double totalMoney,TotalCouponPO po){
		
		list=read(file);
		String res=null;
		boolean isExist=false;
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				if(list.get(i).getTotalMoney()==totalMoney){
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
		else{
			list.add(po);
			write(list,file);
			res="Succeed";
		}
		
		return res;
	}
	
	public String delTotalCoupon(double totalMoney){
		
		list=read(file);
		String res=null;
		boolean isExist=false;
		int pos=-1;
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				if(list.get(i).getTotalMoney()==totalMoney){
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
	
	public  ArrayList<TotalCouponPO> read(String fileName){
		ArrayList<TotalCouponPO> array;
		try {
			FileInputStream fs=new FileInputStream(fileName);
			ObjectInputStream os=new ObjectInputStream(fs);
			array = (ArrayList<TotalCouponPO>)os.readObject();
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
	
	public void write(ArrayList<TotalCouponPO> list,String fileName){
		
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
