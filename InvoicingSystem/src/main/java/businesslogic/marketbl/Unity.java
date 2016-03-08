package businesslogic.marketbl;
/*
 * @ggg
 * 4种销售模式的父类，具有一系列方法
 * 
 */

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import main.IPAddress;
import businesslogic.billmanagementbl.SendBillToManager;
import businesslogic.memberbl.Member;
import dataservice.marketdataservice.MarketDataService;
import po.BillPO;
import po.GoodsListPO;
import po.MarketListPO;
import vo.InformationVO;
import vo.PromotionListVO;

public abstract class Unity {
	final double L1 = 1000;
	final double L2 = 5000;
	protected String kind;
	protected String memberName;
	protected String memberId;
	protected String house;
	protected String user;
	protected String other;
	protected String saler;
	protected int Userlevel;
	protected String ip = IPAddress.ip;
	public Unity(InformationVO info){
		this();
		this.memberId = info.getId();
		this.memberName = info.getName();
		this.house = info.getHouse();
		this.other = info.getOther();
		this.user = info.getUser();
		this.saler = info.getSaler();
		MockUser x = new MockUser();
		Userlevel = x.getLevel(user);
	}
	
	public Unity(){
		kind = "unity";	
	}
	

	/*
	 * 将单据传给总经理
	 */
	public String sure(GoodsListPO x){
		SendBillToManager y = new SendBillToManager();
		BillPO bill = getPO(x);
		return y.sendBill(bill,kind);
	}
	
	
	protected abstract BillPO getPO(GoodsListPO x);
	
	protected abstract String store(MarketListPO x,int ok);
	
	protected String getId(String d){
		MarketDataService ma;
		try {
			ma = (MarketDataService)Naming.lookup("rmi://"+ip+":8888/MarketData");
			String id = ma.getId(d);
			return id;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "false";
	}

	public String reply(MarketListPO x,int key,int ok){
		//ok==1表示审批通过了
		String back = "false";
		if(ok==1){
		if(key==1){
			//客户付钱了
			back = payMoney(memberId,x.getPrice());
		}
		else{
			//客户应该收钱
			back = getMoney(memberId,x.getPrice());
		}
		}
		back = store(x,ok);
		
		return back;
	}
	
	protected String payMoney(String id,double money){
		Member x = new Member();
		return x.payMoney(id, money);
	}
	
	protected String getMoney(String id,double money){
		Member x = new Member();
		return x.getMoney(id, money);
	}

	public abstract <T extends BillPO> ArrayList<T> find(String start, String end, String thingid,
			String memberid2, String salerid, String house2);{

	}


}
