package dataservice.paymentdataservice;
import po.PayinPO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.*;

import po.infoPO;
public interface paymentindataservice extends Remote{
	public ArrayList<PayinPO> find(infoPO infoVo) throws RemoteException;
	public int store(PayinPO p,int i) throws RemoteException;
	public ArrayList<ArrayList<PayinPO>> refresh() throws RemoteException;
		
	

}
