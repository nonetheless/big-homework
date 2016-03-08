package businesslogicservice.loginblservice;

import vo.UserVo;

public interface LoginBlService {
public UserVo login(UserVo vo);
public String  getUserName(String id); 

}
