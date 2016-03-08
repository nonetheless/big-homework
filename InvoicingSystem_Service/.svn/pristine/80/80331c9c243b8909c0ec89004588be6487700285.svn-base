package dataservice.accountdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.accountPO;

public interface accountdataservice extends Remote{
	public int add(accountPO ac) throws RemoteException;
	public int del(String name) throws RemoteException;
	public int change(String name1,String name2) throws RemoteException;
	public accountPO find(String name) throws RemoteException;
	public int change2(String name,double money) throws RemoteException;
	public int accountini() throws RemoteException;
	public ArrayList<accountPO> find2(String year) throws RemoteException;
}
