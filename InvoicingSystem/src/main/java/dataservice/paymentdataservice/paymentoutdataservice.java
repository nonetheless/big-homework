package dataservice.paymentdataservice;
import po.PayinPO;
import po.PayoutPO;
import po.infoPO;

import java.rmi.RemoteException;
import java.util.*;

import vo.infoVO;
public interface paymentoutdataservice {
    public ArrayList<PayoutPO> find(infoPO infoVo) throws RemoteException;
    public int store(PayoutPO p,int i) throws RemoteException;
	public ArrayList<ArrayList<PayoutPO>> refresh() throws RemoteException;

}
