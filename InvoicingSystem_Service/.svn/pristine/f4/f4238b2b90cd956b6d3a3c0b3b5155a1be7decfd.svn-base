package dataservice.promotiondataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.TotalGiftPO;

public interface TotalGiftPromotionDataService extends Remote{
	
	public ArrayList<TotalGiftPO> getTotalGift(double totalMoney) throws RemoteException;
	public String updateTotalGift(double totalMoney,TotalGiftPO po) throws RemoteException;
	public String addTotalGift(double totalMoney,TotalGiftPO po) throws RemoteException;
	public String delTotalGift(double totalMoney,TotalGiftPO po) throws RemoteException;
	public String delTotalGiftByMoney(double totalMoney) throws RemoteException;
}
