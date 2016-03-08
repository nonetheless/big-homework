package businesslogic.userbl;

import java.util.ArrayList;

import vo.UserVo;
import businesslogicservice.userblservice.UserblService;

public class UserController implements UserblService{
   UserOperator user=new UserOperator();
	public int addUser(UserVo vo) {
		// TODO Auto-generated method stub
		return  user.addUser(vo);
	}

	public int delUser(int loc) {
		// TODO Auto-generated method stub
		return user.delUser(loc);
	}

	public int changeUser(UserVo vo,int loc) {
		// TODO Auto-generated method stub
		return user.changeUser(vo,loc);
	}

	public ArrayList<UserVo> getAllUsers() {
		// TODO Auto-generated method stub
		return user.getAllUsers();
	}

}
