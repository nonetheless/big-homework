package data.billmanegementdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import po.BillPO;
import dataservice.billmanagementdataservice.BillManagementDataService;

public class BillDataController extends UnicastRemoteObject implements BillManagementDataService{
	
	BillData bd;

	public BillDataController() throws RemoteException {
		// TODO Auto-generated constructor stub
		bd=new BillData();
	}

	public <T extends BillPO> ArrayList<T> getBillList(String fileName)
			throws RemoteException {
		// TODO Auto-generated method stub
		return bd.getBillList(fileName);
	}

	public <T extends BillPO> String storeBill(ArrayList<T> list,
			String fileName) throws RemoteException {
		// TODO Auto-generated method stub
		return bd.storeBill(list, fileName);
	}

	public <T extends BillPO> String updateBill(T t, String fileName)
			throws RemoteException {
		// TODO Auto-generated method stub
		return bd.updateBill(t, fileName);
	}

	public <T extends BillPO> String approveBill(T t, String fileName)
			throws RemoteException {
		// TODO Auto-generated method stub
		return bd.approveBill(t, fileName);
	}

}
