package data.promotiondata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import po.VipPromotionPO;
import dataservice.promotiondataservice.VipPromotionMethodDataService;

public class VipMethodDataController extends UnicastRemoteObject implements VipPromotionMethodDataService{
	
	VipMethodData vmd;
	
	public VipMethodDataController() throws RemoteException {
		// TODO Auto-generated constructor stub
		vmd=new VipMethodData();
	}

	public ArrayList<VipPromotionPO> getVipMethod() throws RemoteException {
		// TODO Auto-generated method stub
		return vmd.getVipMethod();
	}

	public VipPromotionPO getVipMethod(int level) throws RemoteException {
		// TODO Auto-generated method stub
		return vmd.getVipMethod(level);
	}

	public String updateVipMethod(int level, VipPromotionPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		return vmd.updateVipMethod(level, po);
	}

}
