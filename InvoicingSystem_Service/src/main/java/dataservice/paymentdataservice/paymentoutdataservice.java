package dataservice.paymentdataservice;
import po.BillPO;
import po.PayinPO;
import po.PayoutPO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.*;

import po.infoPO;
public interface paymentoutdataservice extends Remote{
	public ArrayList<PayoutPO> find(infoPO infoVo) throws RemoteException;
	public int store(PayoutPO p,int i) throws RemoteException;
	public ArrayList<ArrayList<PayoutPO>> refresh() throws RemoteException;

}
