package data.promotiondata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import po.VipCouponPO;

public class VipCouponData {
	
	//每个Vip等级只对应一项Coupon
	ArrayList<VipCouponPO> list;
	String file;
	
	public VipCouponData(){
		file="file/VipCoupon.ser";
		list=read(file);
	}
	
	public ArrayList<VipCouponPO> getVipCouponList(){
		list=read(file);
		ArrayList<VipCouponPO> array=list;
		return array;
	}
	
	public VipCouponPO getVipCoupon(int level){
		list=read(file);
		VipCouponPO res=null;
		int pos=-1;
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				if(list.get(i).getVipLevel()==level){
					pos=i;
				}
			}
		}
		if(pos!=-1){
			res=list.get(pos);
		}
		return res;
	}
	
	public String updateVipCoupon(int level,VipCouponPO po){
		
		list=read(file);
		String res=null;
		boolean isExist=false;
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				if(list.get(i).getVipLevel()==level){
					isExist=true;
					list.get(i).setVipLevel(po.getVipLevel());
					list.get(i).setPrice(po.getPrice());
					list.get(i).setNum(po.getNum());
					list.get(i).setSendTime(po.getSendTime());
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
	
	public String addVipCoupon(int level,VipCouponPO po){
		list=read(file);
		String res=null;
		boolean isExist=false;
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				if(list.get(i).getVipLevel()==level){
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
	
	public String delVipCoupon(int level){
		list=read(file);
		String res=null;
		boolean isExist=false;
		int pos=-1;
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				if(list.get(i).getVipLevel()==level){
					isExist=true;
					pos=i;
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
		}
		return res;
	}
	
	
	public ArrayList<VipCouponPO> read(String fileName){
		
		ArrayList<VipCouponPO> array;
		try {
			FileInputStream fs=new FileInputStream(fileName);
			ObjectInputStream os=new ObjectInputStream(fs);
			array = (ArrayList<VipCouponPO>)os.readObject();
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
	
	public void write(ArrayList<VipCouponPO> list,String fileName){
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
