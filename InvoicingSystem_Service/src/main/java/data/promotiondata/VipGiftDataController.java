package data.promotiondata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import po.VipGiftPO;
import dataservice.promotiondataservice.VipGiftPromotionDataService;

public class VipGiftDataController extends UnicastRemoteObject implements VipGiftPromotionDataService{
	
	VipGiftData vgd;
	
	public VipGiftDataController() throws RemoteException {
		// TODO Auto-generated constructor stub
		vgd=new VipGiftData();
	}

	public ArrayList<VipGiftPO> getVipGift(int level) throws RemoteException {
		// TODO Auto-generated method stub
		return vgd.getVipGift(level);
	}

	public String updateVipGift(int level, VipGiftPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return vgd.updateVipGift(level, po);
	}

	public String addVIPGift(int level, VipGiftPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return vgd.addVIPGift(level, po);
	}

	public String delVIPGift(int level, VipGiftPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return vgd.delVIPGift(level, po);
	}

	public String delVipGiftByLevel(int level) throws RemoteException {
		// TODO Auto-generated method stub
		return vgd.delVipGiftByLevel(level);
	}

}
