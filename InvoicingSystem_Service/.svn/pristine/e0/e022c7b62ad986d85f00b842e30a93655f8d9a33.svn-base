package data.promotiondata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.VipGiftPO;

public class VipGiftData {
	
	ArrayList<VipGiftPO> list;
	String file;
	
	public VipGiftData(){
		file="file/VipGift.ser";
		list=read(file);
	}
	
	public ArrayList<VipGiftPO> getVipGift(int level){
		list=read(file);
		ArrayList<VipGiftPO> array=new ArrayList<VipGiftPO>();
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				if(list.get(i).getVipLevel()==level){
					array.add(list.get(i));
				}
			}
		}
		return array;
	}
	
	public String updateVipGift(int level,VipGiftPO po){
		list=read(file);
		String res=null;
		boolean isExist=false;
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				if(list.get(i).getVipLevel()==level
						&&list.get(i).getId().equals(po.getId())){
					isExist=true;
					list.get(i).setNum(po.getNum());
					list.get(i).setSendTime(po.getSendTime());
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
	
	public String addVIPGift(int level,VipGiftPO po){
		list=read(file);
		String res=null;
		boolean isExist=false;
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				if(list.get(i).getVipLevel()==level
						&&list.get(i).getId().equals(po.getId())){
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
	
	public String delVIPGift(int level,VipGiftPO po){
		list=read(file);
		String res=null;
		boolean isExist=false;
		int pos=-1;
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				if(list.get(i).getVipLevel()==level
						&&list.get(i).getId().equals(po.getId())){
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
	
	public String delVipGiftByLevel(int level){
		// TODO Auto-generated method stub
		list=read(file);
		String res=null;
		boolean isExist=false;
		if(list.size()>0){
			Label1:
			for(int i=0;i<list.size();i++){
				if(list.get(i).getVipLevel()==level){
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
	
	public ArrayList<VipGiftPO> read(String fileName){
		ArrayList<VipGiftPO> array;
		try {
			FileInputStream fs=new FileInputStream(fileName);
			ObjectInputStream os=new ObjectInputStream(fs);
			array = (ArrayList<VipGiftPO>)os.readObject();
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
	
	public void write(ArrayList<VipGiftPO> list,String fileName){
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
