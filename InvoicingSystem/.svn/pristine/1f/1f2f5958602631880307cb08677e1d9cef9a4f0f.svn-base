package businesslogic.loginbl;

import vo.UserVo;
import businesslogic.userbl.UserOperator;
import businesslogicservice.loginblservice.LoginBlService;

public class LoginController implements LoginBlService {
Login login=new Login();

public UserVo login(UserVo vo) {
	// TODO Auto-generated method stub
	return login.login(vo);
}

public String getUserName(String id) {
	// TODO Auto-generated method stub
	UserOperator uot=new UserOperator();
	return uot.get_Name(id);
	
}

	
}
