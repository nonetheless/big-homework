package data.marketdata;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import po.MarketUniPO;
/*生成id,比较复杂哟
 * 不想用继承，直接用if else，没有必要吧
 */

public class Unity {
	String time,type;
	int salenum;
	int stacknum;
	int unsalenum;
	int unstacknum;
	int giftnum;
	String filename;
	public Unity(){
		MarketUniPO tem = null;
		filename = "file/marketfile.txt";
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(new FileInputStream(filename));
			tem = (MarketUniPO)ois.readObject();
			time = tem.getTime();
			salenum = tem.getSale();
			stacknum = tem.getStack();
			unstacknum = tem.getUnstack();
			unsalenum = tem.getUnsale();
			giftnum = tem.getGift();
			ois.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	protected String getId(String n) {
		//自动生成id
		type = n;
		if(n.equals("JHD")){
			return getJH();
		}
		if(n.equals("THD")){
			return getTH();
		}
		if(n.equals("XSD")){
			return getXS();
		}
		if(n.equals("XSTHD")){
			return getXH();
		}
		if(n.equals("KCZSD")){
			return getZS();
		}
		return "false";
	}

	private String getZS() {
		// 获取赠品id
		String m  = getT()+"-"+Integer.toString(giftnum);
		String back = type+"-"+m;
		giftnum++;
		return back;
	}

	private String getT() {
		//得到时间的一部分
		Date tim = new Date(System.currentTimeMillis());
		String m[] = tim.toLocaleString().split(" ");
		String aim = m[0];
		if(!aim.equals(time)){
			time = aim;
			setZero();
		}
		return aim;
	}

	private void setZero() {
		// 新的一天，次数清0；
		salenum = 1;
		stacknum = 1;
		unsalenum = 1;
		unstacknum = 1;
		giftnum =1;
		
	}

	private String getXH() {
		// 获取销售退货单id
		String m  = getT()+"-"+Integer.toString(unsalenum);
		String back = type+"-"+m;
		unsalenum++;
		return back;
	}

	private String getXS() {
		// 获取销售id
		String m  = getT()+"-"+Integer.toString(salenum);
		String back = type+"-"+m;
		salenum++;
		return back;
	}

	private String getTH() {
		// 获取退货id
		String m  = getT()+"-"+Integer.toString(unstacknum);
		String back = type+"-"+m;
		unstacknum++;
		return back;
	}

	private String getJH() {
		// 获取进货id
		String m  = getT()+"-"+Integer.toString(stacknum);
		String back = type+"-"+m;
		stacknum++;
		return back;
	}
	
	public String store(){
		MarketUniPO x = new MarketUniPO(time, salenum,stacknum,unsalenum,unstacknum,giftnum);
		try{
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
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
	
	public String first(){
		Date tim = new Date(System.currentTimeMillis());
		String m[] = tim.toLocaleString().split(" ");
		String aim = m[0];
		MarketUniPO x = new MarketUniPO(aim,1,1,1,1,1);
		
		try{
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
			oos.writeObject(x);
			oos.close();
			}
			catch(IOException e){
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return "success";
	}


}
