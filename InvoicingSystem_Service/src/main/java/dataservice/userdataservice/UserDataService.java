package dataservice.userdataservice;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.UserPo;


public interface UserDataService extends Remote{

     
	public int addUser(UserPo vo) throws RemoteException;
	public int delUser(int loc) throws RemoteException;
	public int changeUser(UserPo vo,int loc) throws RemoteException;
	public ArrayList<UserPo> getAllUsers() throws RemoteException;
}
