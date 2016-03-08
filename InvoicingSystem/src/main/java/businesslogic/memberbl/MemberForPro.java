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

public class MemberForPro {
	public ArrayList<MemberVO> findByLevel(int level){
		MemberDataService da;
		ArrayList<MemberVO> m = new ArrayList<MemberVO>();
		try {
			da = (MemberDataService)Naming.lookup("rmi://"+IPAddress.ip+":8888/MemberData");
			ArrayList<MemberPO> m1 = da.levelFind(level);
			for(int i=0;i<m1.size();i++){
				m.add(back(m1.get(i)));
			}
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NotBoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		return m;
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

}