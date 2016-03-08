package dataservice.marketdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.GiftListPO;
import po.MarketListPO;
import po.SaleListPO;
import po.StackListPO;
import po.UnsaleListPO;
import po.UnstackListPO;

public interface MarketDataService extends Remote{
	public ArrayList<SaleListPO> findSale(String start,String end,String thingid,String memberid,String salerid,String house) throws RemoteException;
	
	public ArrayList<StackListPO> findStack(String start,String end,String thingid,String memberid,String salerid,String house) throws RemoteException;
	
	public ArrayList<UnsaleListPO> findUnsale(String start,String end,String thingid,String memberid,String salerid,String house) throws RemoteException;
	
	public ArrayList<UnstackListPO> findUnstack(String start,String end,String thingid,String memberid,String salerid,String house) throws RemoteException;

	public ArrayList<GiftListPO> findGift(String start,String end,String thingid,String memberid,String salerid,String house) throws RemoteException;

	public String insertSale(SaleListPO po,int ok) throws RemoteException;

	public String insertGift(GiftListPO po,int ok) throws RemoteException;
	
	public String insertStack(StackListPO po,int ok) throws RemoteException;
	
	public String insertUnsale(UnsaleListPO po,int ok) throws RemoteException;
	
	public String insertUnstack(UnstackListPO po,int ok) throws RemoteException;
	
    public String getId(String n) throws RemoteException;

	
    public int[] check() throws RemoteException;
	
	public ArrayList<MarketListPO> showList(int i) throws RemoteException;
	
}
