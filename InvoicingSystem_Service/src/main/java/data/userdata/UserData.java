package data.userdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import po.UserPo;
import data.commoditydata.PoReader;
import data.commoditydata.PoWriter;
import dataservice.userdataservice.UserDataService;

public class UserData extends UnicastRemoteObject implements UserDataService {

	String userFile="file/user.ser";
	PoWriter<ArrayList<UserPo>> userWriter=new PoWriter<ArrayList<UserPo>>(userFile);
	PoReader<ArrayList<UserPo>> userReader=new PoReader<ArrayList<UserPo>>(userFile);

	ArrayList<UserPo> userList=null;
	public UserData() throws RemoteException {
		super();
		userList=userReader.read();
		
		// TODO Auto-generated constructor stub
	}

    public int addUser(UserPo po) throws RemoteException {
		// TODO Auto-generated method stub
    	int result=-1;
    	int length=userList.size();
    	for(int i=0;i<length;i++){
    		UserPo temp=userList.get(i);
    		
    		if(temp.getId().equals(po.getId())){
    			result=i;
    			
    			break;
    		}
    }
    	if(result==-1){
    		userList.add(po);
    	    result=1;
    	}
    	else
    		result=-1;
    	
    	
    	userWriter.write(userList);
		return result;
	}

	public int delUser(int loc) throws RemoteException {
		// TODO Auto-generated method stub
		userList.remove(loc);
		userWriter.write(userList);
		return 1;
	}

	public int changeUser(UserPo vo, int loc) throws RemoteException {
		// TODO Auto-generated method stub
		userList.set(loc, vo);
		return 1;
	}

	public ArrayList<UserPo> getAllUsers() throws RemoteException {
		// TODO Auto-generated method stub
		return userList;
	}
	

}
