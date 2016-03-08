package data.promotiondata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import po.TotalCouponPO;
import dataservice.promotiondataservice.TotalCouponPromotionDataService;

public class TotalCouponDataController extends UnicastRemoteObject implements TotalCouponPromotionDataService{
	
	TotalCouponData tcd;
	
	public TotalCouponDataController() throws RemoteException {
		// TODO Auto-generated constructor stub
		tcd=new TotalCouponData();
	}

	public TotalCouponPO getTotalCoupon(double totalMoney)throws RemoteException {
		// TODO Auto-generated method stub
		return tcd.getTotalCoupon(totalMoney);
	}

	public ArrayList<TotalCouponPO> getTotalCouponList() throws RemoteException {
		// TODO Auto-generated method stub
		return tcd.getTotalCouponList();
	}

	public String updateTotalCoupon(double totalMoney, TotalCouponPO po)throws RemoteException {
		// TODO Auto-generated method stub
		return tcd.updateTotalCoupon(totalMoney, po);
	}

	public String addTotalCoupon(double totalMoney, TotalCouponPO po)throws RemoteException {
		// TODO Auto-generated method stub
		return tcd.addTotalCoupon(totalMoney, po);
	}

	public String delTotalCoupon(double totalMoney)throws RemoteException {
		// TODO Auto-generated method stub
		return tcd.delTotalCoupon(totalMoney);
	}
	

}
