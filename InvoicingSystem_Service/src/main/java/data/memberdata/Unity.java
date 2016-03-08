package data.memberdata;
/*@ggg
 * 用于得到id的类
 * 自动生成id并保证id不重复
 * 
 * */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import po.MemberUniPO;

public class Unity {
	String src;
	String before;//一些基本信息
	long id;
	public Unity(){
		MemberUniPO tem = null;
		before = "file/info.txt";
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(new FileInputStream(before));
			tem = (MemberUniPO)ois.readObject();
			id = tem.getId();
			ois.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getId(){
		String x = Long.toString(id);
		id++;
		return x;
	}
	
	public void First_Write(){
		MemberUniPO x = new MemberUniPO();
		x.setid(0);
		
		try{
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(before));
			oos.writeObject(x);
			}
			catch(IOException e){
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public String store(){
		MemberUniPO x = new MemberUniPO();
		x.setid(id);
		try{
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(before));
			oos.writeObject(x);
			oos.close();
			}
			catch(IOException e){
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "false";
			}
		return "success";
	}

}
