package data.promotiondata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import po.TotalPromotionPO;
import dataservice.promotiondataservice.TotalPromotionMethodDataService;

public class TotalMethodDataController extends UnicastRemoteObject implements TotalPromotionMethodDataService{
	
	TotalMethodData tmd;
	
	public TotalMethodDataController() throws RemoteException {
		// TODO Auto-generated constructor stub
		tmd=new TotalMethodData();
	}

	public TotalPromotionPO getTotalMethod(double totalMoney)
			throws RemoteException {
		// TODO Auto-generated method stub
		return tmd.getTotalMethod(totalMoney);
	}

	public ArrayList<TotalPromotionPO> getTotalMethod() throws RemoteException {
		// TODO Auto-generated method stub
		return tmd.getTotalMethod();
	}

	public String updateTotalMethod(double totalMoney, TotalPromotionPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		return tmd.updateTotalMethod(totalMoney, po);
	}

	public String addTotalMethod(double totalMoney, TotalPromotionPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		return tmd.addTotalMethod(totalMoney, po);
	}

	public String delTotalMethod(double totalMoney)
			throws RemoteException {
		// TODO Auto-generated method stub
		return tmd.delTotalMethod(totalMoney);
	}

}
