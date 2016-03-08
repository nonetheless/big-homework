package dataservice.memberdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.MemberPO;

public interface MemberDataService extends Remote{
	public ArrayList<MemberPO>get(String id,String name) throws RemoteException;
	public String del(String id,String name) throws RemoteException;
	public String insert(MemberPO member) throws RemoteException;
	public String upd(MemberPO member) throws RemoteException;
	public String payMoney(String id,double b) throws RemoteException;
	public String getMoney(String id,double b) throws RemoteException;
	public String getid() throws RemoteException;
	public ArrayList<MemberPO> levelFind(int level) throws RemoteException;
}
