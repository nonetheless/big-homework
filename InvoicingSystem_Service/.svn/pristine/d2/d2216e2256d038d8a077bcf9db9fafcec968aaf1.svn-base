package data.promotiondata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import po.VipPromotionPO;

public class VipMethodData {
	
	//list中始终包含5项vip数据
	ArrayList<VipPromotionPO> list;
	String file=null;
	
	public VipMethodData(){
		file="file/VipMethod.ser";
		list=read(file);
	}
	
	public ArrayList<VipPromotionPO> getVipMethod(){
		list=read(file);
		ArrayList<VipPromotionPO> array=list;
		return array;
	}
	
	public VipPromotionPO getVipMethod(int level){
		list=read(file);
		VipPromotionPO po=null;
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				if(list.get(i).getVipLevel()==level){
					po=list.get(i);
				}
			}
		}
		return po;
	}
	
	public String updateVipMethod(int level,VipPromotionPO po){
		list=read(file);
		String res=null;
		boolean isExist=false;
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				if(list.get(i).getVipLevel()==level){
					list.get(i).setIsCoupon(po.getIsCoupon());
					list.get(i).setIsGift(po.getIsGift());
					list.get(i).setIsDiscount(po.getIsDiscount());
					write(list,file);
					isExist=true;
					res="Succeed";
				}	
			}	
		}
		if(!isExist){
			res="Not Found";
		}
		return res;
	}
	
	
	public ArrayList<VipPromotionPO> read(String fileName){
		ArrayList<VipPromotionPO> array;
		try {
			FileInputStream fs=new FileInputStream(fileName);
			ObjectInputStream os=new ObjectInputStream(fs);
			array = (ArrayList<VipPromotionPO>)os.readObject();
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
	
	public void write(ArrayList<VipPromotionPO> list,String fileName){
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
