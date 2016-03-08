package data.memberdata;
/*MemberData的数据模型，
 *在开始时读取数据，在关闭时存储数据
 *
 * */
 
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import po.MemberPO;

public class MemberData{
	String src;
	ArrayList<MemberPO> list;
	public MemberData(String x){
		src = x;	
		list = readFile();
		if(list== null){
			list = new ArrayList<MemberPO>();
		}
	}
	public MemberData(){
		src = "file/member.txt";
		list = readFile();
		if(list== null){
			list = new ArrayList<MemberPO>();
		}
		//test();
	}
	
	public void test(){
		
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).toString());
		}
		
	}

	public ArrayList<MemberPO> get(String id, String name) {
		// 查找客户
		ArrayList<MemberPO> e = new ArrayList<MemberPO>();
		ArrayList<Integer> b = search(id,name);
		for(int i = 0;i<b.size();i++){
			MemberPO x = mcopy(list.get(b.get(i)));
			e.add(x);
		}
		//test();
		return e;
	}

	public String del(String id, String name) {
		//删除一个
		ArrayList<Integer> x = search(id,name);
		if(x.size()==0){
			return "false";
		}
		if(x.size()!=1){
			return "false InputWrong";
		}
		int m = x.get(0);
		list.remove(m);
		return "success";
	}

	public String insert(MemberPO member) {
		//新增用户
		boolean m = compare(member.getName());
		//System.out.println(member.toString());
		if(!m){
			return "false";
		}
		list.add(mcopy(member));
		//test();
		return "success";
	}

	private boolean compare(String name) {
		// 比较是否相等
		int k = 0;
		boolean back = true;
		for(int i= 0;i<list.size();i++){
			MemberPO temp = list.get(i);
			if((temp.getName().equals(name))){
				
				return false;
			}
		}
		return back;
	}
	public String upd(MemberPO member) {
		//更新用户
		boolean m = compare(member.getName());
		if(m){
			return "false";
		}
		ArrayList<Integer> b = search(member.getId(),"");
		MemberPO temp = list.get(b.get(0));
		temp.setAd(member.getAd());
		temp.setE(member.getE());
		temp.setLevel(member.getLevel());
		temp.setSaler(member.getSaler());
		temp.setTel(member.getTel());
		temp.setYB(member.getYB());
		temp.setName(member.getName());
		return "success";
	}

	public String payMoney(String id, double b1) {
		//更新应付
		String x = "";
		ArrayList<Integer> b  = search(id,x);
		if(b.size()!=1){
			return "false";
		}
		MemberPO temp = list.get(b.get(0));
		temp.setPay(temp.getPay()+b1);
		return "success";
	}

	public String getMoney(String id, double b1) {
		//更新应收
		String x = "";
		ArrayList<Integer> b = search(id,x);
		if(b.size()!=1){
			return "false";
		}
		MemberPO temp = list.get(b.get(0));
		temp.setGet(temp.getGet()+b1);
		System.out.println(id+"dekehuyingfu"+b1);
		return "success";
	}

	private ArrayList<MemberPO> readFile(){
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(src));
			ArrayList<MemberPO> x = (ArrayList<MemberPO>)ois.readObject();
			ois.close();
			return x;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	private String writeFile(ArrayList<MemberPO> x){
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(src));
			oos.writeObject(x);
			oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "false";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "false";
		}
		return "success";
		
	}
	
	private MemberPO mcopy(MemberPO temp) {
		// 将MemberPO复制一个相同的
		MemberPO back = new MemberPO(temp.getId(),temp.getLevel(),temp.getKind(),temp.getName(),temp.getTel(),temp.getAd(),temp.getYB(),temp.getE(),temp.getSaler(),temp.getPay(),temp.getGet(),temp.getLimit());
		return back;
	}
	
	private ArrayList<Integer> search(String id,String name){
		//按照id与名称查找客户
		ArrayList<Integer> back = new ArrayList<Integer>();
		for(int i= 0;i<list.size();i++){
			MemberPO temp = list.get(i);
			if(temp.getId().contains(id)&&temp.getName().contains(name)){
				back.add(i);
			}
		}
		return back;
	}
	
	public String endMember(){
		return writeFile(list);
	}
	
	public ArrayList<MemberPO> levelFind(int level) {
		// 根据等级查看
		ArrayList<MemberPO> m = new ArrayList<MemberPO>();
		for(int i=0;i<list.size();i++){
			MemberPO temp = list.get(i);
			if(temp.getLevel()==level){
				m.add(temp);
			}
		}
		return m;
	}
	

}
