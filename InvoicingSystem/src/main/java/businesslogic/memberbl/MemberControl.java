package businesslogic.memberbl;

import java.util.ArrayList;

import vo.MemberVO;
import businesslogicservice.memberblservice.MemberBLService;

public class MemberControl implements MemberBLService{

	Member a;
	public MemberControl(){
		a = new Member();
	}
	public String addmember(MemberVO member) {
		// TODO Auto-generated method stub
		
		return a.addmember(member);
	}

	public String delmember(String name, String id) {
		// TODO Auto-generated method stub
		return a.delmember(name, id);
	}

	public String updmember(MemberVO member) {
		// TODO Auto-generated method stub
		return a.updmember(member);
	}

	public ArrayList<MemberVO> findmember(String name, String id) {
		// TODO Auto-generated method stub
		return a.findmember(name, id);
	}
	public String find(String text) {
		
		return a.find(text);
	}

}
