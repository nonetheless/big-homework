package dataservice.promotiondataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.VipPromotionPO;

public interface VipPromotionMethodDataService extends Remote{
	
	public ArrayList<VipPromotionPO> getVipMethod()throws RemoteException;
	public VipPromotionPO getVipMethod(int level)throws RemoteException;
	public String updateVipMethod(int level,VipPromotionPO po)throws RemoteException;
}
