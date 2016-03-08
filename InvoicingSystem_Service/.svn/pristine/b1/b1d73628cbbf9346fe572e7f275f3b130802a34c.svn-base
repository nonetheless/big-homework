package dataservice.promotiondataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.VipGiftPO;

public interface VipGiftPromotionDataService extends Remote{
	
	public ArrayList<VipGiftPO> getVipGift(int level)throws RemoteException;
	public String updateVipGift(int level,VipGiftPO po)throws RemoteException;
	public String addVIPGift(int level,VipGiftPO po)throws RemoteException;
	public String delVIPGift(int level,VipGiftPO po)throws RemoteException;
	public String delVipGiftByLevel(int level)throws RemoteException;
}
