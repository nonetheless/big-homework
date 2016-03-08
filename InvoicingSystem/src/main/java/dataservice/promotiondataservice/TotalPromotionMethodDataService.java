package dataservice.promotiondataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.TotalPromotionPO;

public interface TotalPromotionMethodDataService extends Remote{
	
	public TotalPromotionPO getTotalMethod(double totalMoney)throws RemoteException;
	public ArrayList<TotalPromotionPO> getTotalMethod()throws RemoteException;
	public String updateTotalMethod(double totalMoney,TotalPromotionPO po)throws RemoteException;
	public String addTotalMethod(double totalMoney,TotalPromotionPO po)throws RemoteException;
	public String delTotalMethod(double totalMoney)throws RemoteException;

}
