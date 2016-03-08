package data.promotiondata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import po.TotalGiftPO;
import dataservice.promotiondataservice.TotalGiftPromotionDataService;

public class TotalGiftDataController extends UnicastRemoteObject implements TotalGiftPromotionDataService{
	
	TotalGiftData tgd;
	
	public TotalGiftDataController() throws RemoteException {
		// TODO Auto-generated constructor stub
		tgd=new TotalGiftData();
	}

	public ArrayList<TotalGiftPO> getTotalGift(double totalMoney)
			throws RemoteException {
		// TODO Auto-generated method stub
		return tgd.getTotalGift(totalMoney);
	}

	public String updateTotalGift(double totalMoney, TotalGiftPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		return tgd.updateTotalGift(totalMoney, po);
	}

	public String addTotalGift(double totalMoney, TotalGiftPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		return tgd.addTotalGift(totalMoney, po);
	}

	public String delTotalGift(double totalMoney, TotalGiftPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		return tgd.delTotalGift(totalMoney, po);
	}

	public String delTotalGiftByMoney(double totalMoney)throws RemoteException{
		// TODO Auto-generated method stub
		return tgd.delTotalGiftByMoney(totalMoney);
	}

}
