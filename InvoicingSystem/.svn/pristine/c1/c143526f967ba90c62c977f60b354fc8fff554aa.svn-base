package presentation.memberui;

import java.util.ArrayList;

import vo.MemberVO;
import businesslogic.memberbl.MemberControl;
import businesslogicservice.memberblservice.MemberBLService;

public class MemberFrameCtrl {
	String name;
	String tel;
	String saler;
	String kind;
	String YB;
	String Ad;
	String id;
	String level;
	String email;
	MemberBLService bl;
	ArrayList<MemberVO> m;
	public MemberFrameCtrl(String saler){
		m = new ArrayList<MemberVO>();
		bl = new MemberControl();
		name ="请输入客户信息";
		tel = "请输入客户电话";
		this.saler = saler;
		kind = "进货商";
		YB = "请输入客户邮编";
		Ad = "请输入客户地址";
		id = "查询删除请输入id";
		level = "1";
		email = "输入客户邮箱";
	}
	public String getName() {
		// 返回名字
		return name;
	}
	
	public String getEmail() {
		// 返回名字
		return email;
	}
	
	public String getId() {
		// 返回id
		return id;
	}
	
	public String getKind() {
		// 返回kind
		return kind;
	}
	
	public String getTel() {
		// 返回tel
		return tel;
	}
	
	public String getYB() {
		// 返回ybian
		return YB;
	}
	
	public String getAd() {
		// 返回地址
		return Ad;
	}
	
	public String getlevel() {
		// 返回level
		return level;
	}
	
	public String getSaler() {
		// 返回地址
		return saler;
	}
	
	public String getE() {
		// 返回地址
		return email;
	}
	
	public String find(String text) {
		//  根据id得到名字
		return bl.find(text);
	}
	
	public void setName(String text) {
		name = text;	
	}
	
	public void setId(String text) {
		id = text;	
	}
	
	public void setTel(String text) {
		tel = text;
		
	}
	
	public void setKind(String text) {
		kind = text;
		
	}

	public void setLevel(String text) {
		level = text;
		
	}
	
	public void setYB(String text) {
		YB = text;
		
	}
	
	public void setAd(String text) {
		Ad = text;
		
	}
	
	public void setSaler(String text) {
		saler = text;
		
	}
	public String addM() {
		//添加客户
		if(!check().equals("success")){
			return check();
		}
		MemberVO m1 = new MemberVO(kind,name,tel,Ad,YB,email,saler,Integer.parseInt(level));
		String back = bl.addmember(m1);
		return back;
	}
	
	
	private String check(){
		try{
			int x = Integer.parseInt(level);
		}
		catch (Exception e1){
			return "请正确输入等级";
		}
		try{
			long x = Long.parseLong(tel);
		}
		catch (Exception e1){
			return "请正确输入电话";
		}
		try{
			int x = Integer.parseInt(YB);
		}
		catch (Exception e1){
			return "请正确输入邮编";
		}
		if(name.equals("")){
			return "请正确输入姓名";
		}
		if(email.equals("")){
			return "请正确输入email";
		}
		if(Ad.equals("")){
			return "请正确输入地址";
		}
		if(saler.equals("")){
			return "请正确输入默认客服员";
		}
		return "success";
	}
	public String updM() {
		//更新客户
		if(!check().equals("success")){
			return check();
		}
		MemberVO m1 = new MemberVO(id,Integer.parseInt(level),kind,name,tel,Ad,YB,email,saler,0.0,0,0);
		String back = bl.updmember(m1);
		return back;
	}
	public String delM() {
		//删除
		return bl.delmember(name, id);
	}
	public String findM() {
		//查找
		m = new ArrayList<MemberVO>();
		m = bl.findmember(name, id);
		return "查找成功";
	}
	public String[][] getTable() {
		//自动生成表格
		String n[][] = new String[m.size()][12];
		for(int i=0;i<m.size();i++){
			setLine(i,n);
		}
		return n;
	}
	private void setLine(int i, String[][] n) {
		//单行更新
		MemberVO mem = m.get(i);
		n[i][0] = mem.getId();
		n[i][1] = mem.getName();
		n[i][2] = mem.getKind();
		n[i][3] = Integer.toString(mem.getLevel());
		n[i][4] = mem.getE();
		n[i][5] = mem.getAd();
		n[i][6] = mem.getTel();
		n[i][7] = mem.getYB();
		n[i][8] = mem.getSaler();
		n[i][9] = Double.toString(mem.getPay());
		n[i][10] = Double.toString(mem.getGet());
		n[i][11] = Double.toString(mem.getLimit());
	}
	public void setE(String text) {
		// email
		email = text;
		
	}
}
