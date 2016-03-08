package data.promotiondata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import po.DiscountPO;
import dataservice.promotiondataservice.VipDiscountPromotionDataService;

public class VipDiscountDataController extends UnicastRemoteObject implements VipDiscountPromotionDataService{
	
	VipDiscountData vdd;
	
	public VipDiscountDataController() throws RemoteException {
		// TODO Auto-generated constructor stub
		vdd=new VipDiscountData();
	}

	public ArrayList<DiscountPO> getDiscount() throws RemoteException {
		// TODO Auto-generated method stub
		return vdd.getDiscount();
	}

	public DiscountPO getDiscount(int vipLevel) throws RemoteException {
		// TODO Auto-generated method stub
		return vdd.getDiscount(vipLevel);
	}

	public String addDiscount(DiscountPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return vdd.addDiscount(po);
	}

	public String editDiscount(DiscountPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return vdd.editDiscount(po);
	}

	public String delDiscount(int level) throws RemoteException {
		// TODO Auto-generated method stub
		return vdd.delDiscount(level);
	}
	
}
