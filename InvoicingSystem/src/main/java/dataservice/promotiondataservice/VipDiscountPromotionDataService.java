package dataservice.promotiondataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.DiscountPO;

public interface VipDiscountPromotionDataService extends Remote{
	
	public ArrayList<DiscountPO> getDiscount()throws RemoteException;
	public DiscountPO getDiscount(int vipLevel)throws RemoteException;
	public String addDiscount(DiscountPO po)throws RemoteException;
	public String editDiscount(DiscountPO po)throws RemoteException;
	public String delDiscount(int level)throws RemoteException;
}
