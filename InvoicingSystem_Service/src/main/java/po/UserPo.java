package po;

import java.io.Serializable;

public class UserPo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String status;
	private String name;
	private String id;
	private String password;
	private int level;


	public UserPo(String st,String name,String id,String pass,int level){
		this.status=st;
		this.name=name;
		this.id=id;
		this.password=pass;
		this.level=level;
		
	}


	public String getStatus(){
		return status;
	}
	public String getName(){
		return name;
	}
	public String getId(){
		return id;
	}
	public String getPassWord(){
		return password;
	}
	public int getLevel(){
		return level;
	}
}
