package data.promotiondata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import po.VipCouponPO;
import dataservice.promotiondataservice.VipCouponPromotionDataService;

public class VipCouponDataController extends UnicastRemoteObject implements VipCouponPromotionDataService{
	
	VipCouponData vcd;
	
	public VipCouponDataController() throws RemoteException {
		// TODO Auto-generated constructor stub
		vcd=new VipCouponData();
	}

	public ArrayList<VipCouponPO> getVipCouponList() throws RemoteException {
		// TODO Auto-generated method stub
		return vcd.getVipCouponList();
	}

	public VipCouponPO getVipCoupon(int level) throws RemoteException {
		// TODO Auto-generated method stub
		return vcd.getVipCoupon(level);
	}

	public String updateVipCoupon(int level, VipCouponPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		return vcd.updateVipCoupon(level, po);
	}

	public String addVipCoupon(int level, VipCouponPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		return vcd.addVipCoupon(level, po);
	}

	public String delVipCoupon(int level)
			throws RemoteException {
		// TODO Auto-generated method stub
		return vcd.delVipCoupon(level);
	}

}
