package data.memberdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import po.MemberPO;
import dataservice.memberdataservice.MemberDataService;

public class MemberDataControl extends UnicastRemoteObject implements MemberDataService{

	MemberData memberdata;
	Unity x;
	public MemberDataControl() throws RemoteException{
		memberdata = new MemberData();
		x = new Unity();
	}
	public ArrayList<MemberPO> get(String id, String name) throws RemoteException{
		//查找客户
		
		return memberdata.get(id, name);
	}

	public String del(String id, String name) throws RemoteException{
		//删除客户
		return memberdata.del(id, name);
	}

	public String insert(MemberPO member) throws RemoteException{
		//新增客户
		return memberdata.insert(member);
	}

	public String upd(MemberPO member) throws RemoteException{
		//更新客户
		return memberdata.upd(member);
	}

	public String payMoney(String id, double b) throws RemoteException{
		//减少客户的应付
		return memberdata.payMoney(id, b);
	}

	public String getMoney(String id, double b) throws RemoteException{
		//减少客户的应收
		return memberdata.getMoney(id, b);
	}

	public String getid() throws RemoteException{
		//自动生成id
		return x.getId();
	}
	
	public void closeData(){
		//完成操作
	   memberdata.endMember();
	   x.store();
	}
	public ArrayList<MemberPO> levelFind(int level) throws RemoteException {
		// 
		return memberdata.levelFind(level);
	}
	
	public static void main(String[] args){
		try {
			MemberDataControl m = new MemberDataControl();
			m.x.First_Write();
			System.out.println("ok");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
