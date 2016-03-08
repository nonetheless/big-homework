package businesslogic.userbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import main.IPAddress;
import po.UserPo;
import dataservice.commoditydataservice.CommodityDataService;
import dataservice.userdataservice.UserDataService;
import vo.UserVo;

public class UserOperator {
	
	UserDataService userData=null;
	   public UserOperator(){
	    	try{
	    		userData=(UserDataService)Naming.lookup("rmi://"+IPAddress.ip+":4029/userData");
	    	
	    	}catch(MalformedURLException e){
				e.printStackTrace();
			} catch (RemoteException e) {
				e.printStackTrace();
			} catch (NotBoundException e){
				e.printStackTrace();
			}
	    	
	    }
	
	
	
	public int addUser(UserVo vo) {
		// TODO Auto-generated method stub
		UserPo po=new UserPo(vo.getStatus(),vo.getName(),vo.getId(),vo.getPassWord(),vo.getLevel());
		int result=-1;
		
		 try {
			result=userData.addUser(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return result;
	}

	public int delUser(int loc) {
		// TODO Auto-generated method stub
		int result=-1;
	  try {
		userData.delUser(loc);
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return result;
	}

	public int changeUser(UserVo vo,int loc) {
		// TODO Auto-generated method stub
		int result=-1;
		UserPo po=new UserPo(vo.getStatus(),vo.getName(),vo.getId(),vo.getPassWord(),vo.getLevel());
		  try {
			result=userData.changeUser(po, loc);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return result;
		
	}

	public ArrayList<UserVo> getAllUsers() {
		// TODO Auto-generated method stub
		ArrayList<UserPo> list=new ArrayList<UserPo>();
		ArrayList<UserVo> resultList=new ArrayList<UserVo>();
		try {
			list=userData.getAllUsers();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int length=list.size();
		for(int i=0;i<length;i++){
			UserPo temp=list.get(i);
			UserVo vo=new UserVo(temp.getStatus(),temp.getName(),temp.getId(),temp.getPassWord(),temp.getLevel());
		    resultList.add(vo);
		    
		}
		
		return resultList;
	}
	public String get_Name(String id){
		ArrayList<UserVo> list=getAllUsers();
		String name=null;
		for(int i=0;i<list.size();i++){
			boolean b=list.get(i).getId().equals(id);
			if(b)
			name=list.get(i).getName();	
			
		}
		return name;
	}
	
	
}
