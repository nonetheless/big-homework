package businesslogicservice.memberblservice;
import java.util.ArrayList;
import vo.MemberVO;

public interface MemberBLService {
	public String addmember(MemberVO member);
	public String delmember(String name,String id);
	public  String updmember(MemberVO member);
	public ArrayList<MemberVO> findmember(String name,String id);
	public String find(String text);
}
