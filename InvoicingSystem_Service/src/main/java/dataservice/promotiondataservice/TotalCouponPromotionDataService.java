package dataservice.promotiondataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.TotalCouponPO;

public interface TotalCouponPromotionDataService extends Remote{
	
	public TotalCouponPO getTotalCoupon(double totalMoney)throws RemoteException;
	public ArrayList<TotalCouponPO> getTotalCouponList()throws RemoteException; 
	public String updateTotalCoupon(double totalMoney,TotalCouponPO po)throws RemoteException;
	public String addTotalCoupon(double totalMoney,TotalCouponPO po)throws RemoteException;
	public String delTotalCoupon(double totalMoney)throws RemoteException;

}
