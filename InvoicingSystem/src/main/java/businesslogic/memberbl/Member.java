package businesslogic.memberbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import main.IPAddress;
import dataservice.memberdataservice.MemberDataService;
import po.MemberPO;
import vo.MemberVO;

public class Member{
	//由于Member不参与其余类的交互，没有mock
	MemberDataService end;
	public Member(){
		try {
			end = (MemberDataService)Naming.lookup("rmi://"+ IPAddress.ip+":8888/MemberData");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		} 
	}

	public String addmember(MemberVO member) {
		//增加用户
		String id = null;
		String back = null;
		try {
			id = end.getid();
			MemberPO e = change(member,id);
			back = end.insert(e);
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return back;
	}

	public String delmember(String name, String id) {
		//删除用户
		String back = "false";
		try {
			back =  end.del(id, name);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return back;
	}

	public String updmember(MemberVO member) {
        MemberPO e = change(member,member.getId());
		String back = "false";
		try {
			back = end.upd(e);
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return back;
	}

	public ArrayList<MemberVO> findmember(String name, String id) {
		//查看用户
		ArrayList<MemberVO> list= new ArrayList<MemberVO>();
		ArrayList<MemberPO> list1;
		try {
			list1 = end.get(id, name);
			for(int i = 0;i<list1.size();i++){
				list.add(back(list1.get(i)));
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public String payMoney(String id,double b){
		//减少应付
		try {
			return end.payMoney(id, b);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "false";
	}
	public String getMoney(String id,double b){
		//减少应收
		try {
			return end.getMoney(id, b);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "false";
		
	}
	
	private MemberPO change(MemberVO member,String id){
		//自动生成id
		String id1 = id;
		int memberLevel =member.getLevel();
		String memberKind = member.getKind();
		String memberName = member.getName();
		String memberTel = member.getTel();
		String memberAd = member.getAd();
		String memberYB = member.getYB();
		String memberE = member.getE();
		String saler = member.getSaler();
		double pay = 0;
		double get = 0;
		double limit = 0;
		MemberPO e  = new MemberPO(id1,memberLevel,memberKind,memberName,memberTel,memberAd,memberYB,memberE,saler,pay,get,limit);
		return e;
	}
	
	private MemberVO back(MemberPO member){
		String id1 = member.getId();
		int memberLevel =member.getLevel();
		String memberKind = member.getKind();
		String memberName = member.getName();
		String memberTel = member.getTel();
		String memberAd = member.getAd();
		String memberYB = member.getYB();
		String memberE = member.getE();
		String saler = member.getSaler();
		double pay = member.getPay();
		double get = member.getGet();
		double limit = member.getLimit();
		MemberVO now = new MemberVO(id1,memberLevel,memberKind,memberName,memberTel,memberAd,memberYB,memberE,saler,pay,get,limit);
		return now;
	}
	
	public String find(String text) {
		//  根据id得到名字
		ArrayList<MemberVO> vo = new ArrayList<MemberVO>();
		vo = findmember("", text);
		if(vo.size()==0){
			return "输入id错误";
		}
		if(vo.size()>1){
			return "输入用户名";
		}
		return vo.get(0).getName();
	}

}
