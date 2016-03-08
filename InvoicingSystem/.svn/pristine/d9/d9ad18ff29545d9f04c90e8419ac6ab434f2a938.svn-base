package dataservice.promotiondataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.VipCouponPO;

public interface VipCouponPromotionDataService extends Remote{
	
	public ArrayList<VipCouponPO> getVipCouponList() throws RemoteException;
	public VipCouponPO getVipCoupon(int level)throws RemoteException;
	public String updateVipCoupon(int level,VipCouponPO po)throws RemoteException;
	public String addVipCoupon(int level,VipCouponPO po)throws RemoteException;
	public String delVipCoupon(int level)throws RemoteException;

}
