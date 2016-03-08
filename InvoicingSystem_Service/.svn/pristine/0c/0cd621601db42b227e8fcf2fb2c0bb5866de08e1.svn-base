package data.loginData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import po.UserPo;
import data.commoditydata.PoReader;
import data.commoditydata.PoWriter;
import dataservice.loginDataService.LoginDataService;

public class LoginData extends UnicastRemoteObject implements LoginDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<UserPo> userArray=null;
	String userFile="file/user.ser";
	PoWriter<ArrayList<UserPo>> userWriter=new PoWriter<ArrayList<UserPo>>(userFile);
	PoReader<ArrayList<UserPo>> userReader=new PoReader<ArrayList<UserPo>>(userFile);
	public LoginData() throws RemoteException {
		super();
	//	initSerFile();
		initList();
		// TODO Auto-generated constructor stub
	}
	void initSerFile(){
		
		userArray=new ArrayList<UserPo>();
		
		
		UserPo administrator=new UserPo("系统管理员","隔壁老王","admin","admin",10);
		UserPo stockAd=new UserPo("库存管理员","韩淳","192","192",8);
		UserPo accountAd=new UserPo("财务人员","刘至家","193","193",8);
		UserPo saleAd1=new UserPo("销售人员","林鑫1","1901","1901",8);
		UserPo saleAd2=new UserPo("销售人员","林鑫2","1902","1902",8);
		UserPo manager=new UserPo("总经理","吴骁凯","191","191",8);
		userArray.add(saleAd1);
		userArray.add(saleAd2);
		userArray.add(manager);
		userArray.add(administrator);
		userArray.add(stockAd);
		userArray.add(accountAd);
		userWriter.write(userArray);
	}

	
	
	void initList(){
	
		userArray=userReader.read();
	}
	

	public UserPo login(UserPo po) throws RemoteException {
		// TODO Auto-generated method stub
		String id=po.getId();
		String passWord=po.getPassWord();
		
		int length=userArray.size();
		UserPo result=null;
		for(int i=0;i<length;i++){
			UserPo temp=userArray.get(i);
			boolean statusValid=temp.getStatus().equals(po.getStatus());
			boolean idValid=temp.getId().equals(id);
			boolean passwordValid=temp.getPassWord().equals(passWord);
			if(idValid&&passwordValid&&statusValid){
				result=temp;
				break;
			}
				
		}
		
		return result;
	}
	
	

}
