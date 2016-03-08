package dataservice.paymentdataservice;
import po.PaycashPO;
import po.infoPO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.*;

import vo.infoVO;
public interface paymentcashdataservice extends Remote{
	public ArrayList<PaycashPO> find(infoPO info) throws RemoteException;
	public ArrayList<ArrayList<PaycashPO>> refresh() throws RemoteException;
	public int store(PaycashPO p,int i) throws RemoteException;

}
