package businesslogic.marketbl;
import java.util.ArrayList;

import po.GiftListPO;
import po.SaleListPO;
import po.StackListPO;
import po.UnsaleListPO;
import po.UnstackListPO;
import vo.InformationVO;
import vo.infoVO;

public class MarketForAccount {
	String start;
	String end ;
	String memberid ;
	String salerid ;
	String house;
	String thingid;
	public  ArrayList<SaleListPO> findSale(infoVO in){
		//查看销售单据
		check(in);
		ArrayList<SaleListPO> m = new ArrayList<SaleListPO>();
		Unity s = new Sale(new InformationVO("", "", "", "", "", 0, ""));
		m = s.find(start, end, thingid, memberid, salerid, house);
		return m;
	}
	
	public  ArrayList<UnsaleListPO> findUnsale(infoVO in){
		//查看销售单据
		check(in);
		ArrayList<UnsaleListPO> m = new ArrayList<UnsaleListPO>();
		Unity s = new Unsale(new InformationVO("", "", "", "", "", 0, ""));
		m = s.find(start, end, thingid, memberid, salerid, house);
		return m;
	}
	
	private void check(infoVO in) {
		// 初始化
		start = in.gettime1();
		end = in.gettime2();
		memberid = in.getcustomer();
		salerid = in.getoprator();
		house = in.getstorehouse();
		thingid = in.getgoods();
		if(start==null){
			start = "no";
		}
		if(end==null){
			end = "no";
		}
		if(memberid==null){
			memberid = "no";
		}
		if(salerid==null){
			salerid = "no";
		}
		if(house==null){
			house = "no";
		}
		if(thingid==null){
			thingid = "no";
		}
	}

	public  ArrayList<StackListPO> findStack(infoVO in){
		//查看进货单据
		check(in);
		ArrayList<StackListPO> m = new ArrayList<StackListPO>();
		Unity s = new Stack(new InformationVO("", "", "", "", "", 0, ""));
		m = s.find(start, end, thingid, memberid, salerid, house);
		return m;
	}
	
	public  ArrayList<UnstackListPO> findUnstack(infoVO in){
		//查看退货单据
		check(in);
		ArrayList<UnstackListPO> m = new ArrayList<UnstackListPO>();
		Unity s = new Unstack(new InformationVO("", "", "", "", "", 0, ""));
		m = s.find(start, end, thingid, memberid, salerid, house);
		return m;
	}
	
	public ArrayList<GiftListPO> findGift(infoVO in){
		//查看礼品单据
		check(in);
		ArrayList<GiftListPO> m = new ArrayList<GiftListPO>();
		Sale msn = new Sale(new InformationVO("", "", "", "", "", 0, ""));
		return msn.findGift(start, end, thingid, memberid, salerid, house);
	}

}
