package data.promotiondata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import po.DiscountPO;

public class VipDiscountData {
	
	ArrayList<DiscountPO> list;
	String file;
	
	public VipDiscountData(){
		file="file/VipDiscount.ser";
		list=read(file);
	}
	
	public ArrayList<DiscountPO> getDiscount(){
		list=read(file);
		ArrayList<DiscountPO> array=list;
		return array;
	}
	
	public DiscountPO getDiscount(int vipLevel){
		list=read(file);
		DiscountPO po=null;
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				if(list.get(i).getVipLevel()==vipLevel){
					po=list.get(i);
				}
			}
		}
		return po;
	}
	
	public String addDiscount(DiscountPO po){
		
		list=read(file);
		String res=null;
		boolean isExist=false;
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				if(list.get(i).getVipLevel()==po.getVipLevel()){
					isExist=true;
				}
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
		return res;
	}
	
	public String editDiscount(DiscountPO po){
		
		list=read(file);
		String res=null;
		boolean isExist=false;
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				if(list.get(i).getVipLevel()==po.getVipLevel()){
					isExist=true;
					list.get(i).setDiscount(po.getDiscount());
					write(list,file);
					res="Succeed";
				}
			}	
		}
		if(!isExist){
			res="Not Found";
		}
		return res;
	}
	
	public String delDiscount(int level){
		
		list=read(file);
		String res=null;
		boolean isExist=false;
		int pos=-1;
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				if(list.get(i).getVipLevel()==level){
					pos=i;
					isExist=true;
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
	
	public ArrayList<DiscountPO> read(String fileName){
		ArrayList<DiscountPO> array;
		try {
			FileInputStream fs=new FileInputStream(fileName);
			ObjectInputStream os=new ObjectInputStream(fs);
			array = (ArrayList<DiscountPO>)os.readObject();
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
	
	public void write(ArrayList<DiscountPO> list,String fileName){
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
