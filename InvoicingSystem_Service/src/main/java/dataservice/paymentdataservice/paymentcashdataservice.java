package dataservice.paymentdataservice;
import po.PaycashPO;
import po.PayinPO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.*;

import po.infoPO;
public interface paymentcashdataservice extends Remote{
	public ArrayList<PaycashPO> find(infoPO info) throws RemoteException;
	public int store(PaycashPO p,int i) throws RemoteException;
	public ArrayList<ArrayList<PaycashPO>> refresh() throws RemoteException;

}
