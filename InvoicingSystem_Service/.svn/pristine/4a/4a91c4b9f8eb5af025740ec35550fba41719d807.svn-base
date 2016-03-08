package dataservice.billmanagementdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import po.BillPO;

public interface BillManagementDataService extends Remote{
	
	public <T extends BillPO> ArrayList<T> getBillList(String fileName) throws RemoteException;
	public <T extends BillPO> String storeBill(ArrayList<T> list,String fileName) throws RemoteException;
	public <T extends BillPO> String updateBill(T t,String fileName) throws RemoteException;
	public <T extends BillPO> String approveBill(T t,String fileName) throws RemoteException;
}
