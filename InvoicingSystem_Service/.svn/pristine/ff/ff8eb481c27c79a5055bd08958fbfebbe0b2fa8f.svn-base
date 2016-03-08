package data.promotiondata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import po.TotalPromotionPO;

public class TotalMethodData {
	
	//ArrayList按总价额从小到大存储对象
	//get方法传入的参数totalMoney是实际金额
	//增加新种类优惠政策用add
    //修改同种类优惠政策用update
	ArrayList<TotalPromotionPO> list;
	String file=null;
	
	public TotalMethodData(){
		file="file/TotalMethod.ser";
		list=read(file);
	}
	
	public TotalPromotionPO getTotalMethod(double totalMoney){   //totalMoney为具体金额
		list=read(file);
		TotalPromotionPO po=null;
		int pos=-1;
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				if(totalMoney==list.get(i).getTotalPrice()){
					pos=i;
				}
			}
		}
		if(pos>=0){
			po=list.get(pos);
		}
		return po;
	}
	
	public ArrayList<TotalPromotionPO> getTotalMethod(){
		list=read(file);
		ArrayList<TotalPromotionPO> array=list;
		return array;
	}
	
	public String updateTotalMethod(double totalMoney,TotalPromotionPO po){
		list=read(file);
		String res=null;
		boolean isExist=false;
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				if(list.get(i).getTotalPrice()==totalMoney){
					list.get(i).setCoupon(po.getIsCoupon());
					list.get(i).setGift(po.getIsGift());
					write(list,file);
					isExist=true;
					res="Succeed";
				}
			}
		}
		if(!isExist){
			res="Not Foound";
		}
		return res;
	}
	
	public String addTotalMethod(double totalMoney,TotalPromotionPO po){
		list=read(file);
		String res=null;
		boolean isExist=false;
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				if(list.get(i).getTotalPrice()==totalMoney){
					isExist=true;
				}
			}
			if(!isExist){
				TotalPromotionPO tp=new TotalPromotionPO(totalMoney,po.getIsCoupon(),po.getIsGift());
				list.add(tp);
				write(list,file);
				res="Succeed";
			}
			else{
				res="Already Exist";
			}
		}
		else{
			TotalPromotionPO tp=new TotalPromotionPO(totalMoney,po.getIsCoupon(),po.getIsGift());
			list.add(po);
			write(list,file);
			res="Succeed";
		}
		return res;
	}
	
	public String delTotalMethod(double totalMoney){
		list=read(file);
		String res=null;
		boolean isExist=false;
		int pos=-1;
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				if(list.get(i).getTotalPrice()==totalMoney){
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
	
	public ArrayList<TotalPromotionPO> read(String fileName){
		ArrayList<TotalPromotionPO> array;
		try {
			FileInputStream fs=new FileInputStream(fileName);
			ObjectInputStream os=new ObjectInputStream(fs);
			array = (ArrayList<TotalPromotionPO>)os.readObject();
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
	
	public void write(ArrayList<TotalPromotionPO> list,String fileName){
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
