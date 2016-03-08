package businesslogic.marketbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import main.IPAddress;
import dataservice.marketdataservice.MarketDataService;
import dataservice.memberdataservice.MemberDataService;
import businesslogic.billmanagementbl.SendBillToManager;
import businesslogic.commoditybl.CommodityOperator;
import businesslogic.memberbl.Member;
import businesslogic.promotionbl.SalesPromotion;
import po.BillPO;
import po.GiftListPO;
import po.GoodsListPO;
import po.MarketListPO;
import po.SaleListPO;
import vo.InformationVO;
import vo.MarketCommodityVO;
import vo.MemberVO;
import vo.ProinfoVO;
import vo.PromotionListVO;

public class Sale extends Unity{

	private double salerredu;
	private double proredu;
	private double usepaper;
	private int paperedu;
	private int papernum;
	private GoodsList free;
	private String ip = IPAddress.ip;
	public Sale(InformationVO info) {
		// TODO Auto-generated constructor stub
		super(info);
		kind = "XSD";
	}

	public String reduce(double price) {
		//销售人员折让:1代表低，2代表高
		if((Userlevel==1)&&(price<=L1)){
			salerredu = price;
			return "success";
		}
		if((Userlevel==2)&&(price<=L2)){
			salerredu = price;
			return "success";
		}
		return "false";
	}

	@Override
	protected BillPO getPO(GoodsListPO x) {
		//根据Goodslist生成销售单的PO
				double before = x.getAllPrice();
				double after = before - salerredu - usepaper - proredu;
				String id = getId(kind);
				SaleListPO  bill = new SaleListPO(x,id,memberId,saler,house
						,other,before,after,usepaper,salerredu+proredu,user,memberName);
				return bill;
	}
	
	private BillPO getGift(){
		String id = getId("KCZSD");
		GiftListPO gift = new GiftListPO(free.createPO(),id,memberId,other,free.cal(),user,memberName,house,saler);
		return gift;
	}
	
	public String sure(GoodsListPO x){
		//重写sure的方法
		SendBillToManager y = new SendBillToManager();
		BillPO bill = getPO(x);
		BillPO bill2 = getGift();
		String a = y.sendBill(bill, "XSD");
		String b = y.sendBill(bill2,"KCZSD");
		if(a.equals("Succeed")&&b.equals("Succeed")){
			return "success";
		}
		return "false";
		
		
		
	}

	private String setFreeList(double all, int mlevel) {
		//  得到赠送策略
		SalesPromotion m = new SalesPromotion();
		ProinfoVO x = m.getPromotion(all, mlevel);
		if(x==null){
			return "false";
		}
		proredu = x.getDiscount();
		paperedu = x.getPaper();
		papernum = x.getNum();
		free = new GoodsList(x.getList());
		return "success";
	}

	private int getMemberLevel(String memberId, String memberName) {
		//获取Member等级
		Member m = new Member();
		ArrayList<MemberVO> vo = m.findmember(memberName, memberId);
		if(vo.size()==1){
			MemberVO tem = vo.get(0);
			return tem.getLevel();
		}
		return -1;
	}

	public String usePaper(int paper, int num) {
		// 金额
		usepaper = paper*num;
		return "success";
	}

	public PromotionListVO getpro(double all) {
		//返回策略
		int mlevel = getMemberLevel(memberId,memberName);
		if(setFreeList(all,mlevel).equals("success")){
			
			PromotionListVO nw = new PromotionListVO(free.show(), proredu, paperedu, papernum);
			return nw;
		}
		return null;
	}

	public PromotionListVO showFree() {
		// 查看赠送信息，包含了销售人员折让
		PromotionListVO nw = new PromotionListVO(free.show(), proredu+salerredu, paperedu, papernum);
		return nw;
	}

	public String replyFree(MarketListPO m,int ok) {
		// 存入数据层
		MarketDataService x;
		try {
			x = (MarketDataService)Naming.lookup("rmi://"+ip+":8888/MarketData");
			GiftListPO xx = (GiftListPO)m;
			return x.insertGift(xx,ok);
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

	@Override
	protected String store(MarketListPO x,int ok) {
		//存入数据层
			MarketDataService m;
			try {
				m = (MarketDataService)Naming.lookup("rmi://"+ip+":8888/MarketData");
				SaleListPO xx = (SaleListPO)x;
				return m.insertSale(xx,ok) ;
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

	@Override
	public ArrayList<SaleListPO> find(String start, String end, String thingid,
			String memberid2, String salerid, String house2) {
		// 查单
		ArrayList<SaleListPO> m = new ArrayList<SaleListPO>();
		MarketDataService ms;
		try {
			ms = (MarketDataService)Naming.lookup("rmi://"+ip+":8888/MarketData");
			ArrayList<SaleListPO> nn = ms.findSale(start, end, thingid, memberid2, salerid, house2);
			for(int i=0;i<nn.size();i++){
				m.add(nn.get(i));
			}
			return m;
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
		return null;
	}

	public ArrayList<GiftListPO> findGift(String start, String end,
			String thingid, String memberid, String salerid, String house) {
		// 查看赠品单
		MarketDataService ms;
		try {
			ms = (MarketDataService)Naming.lookup("rmi://"+ip+":8888/MarketData");
			return ms.findGift(start, end, thingid, memberid, salerid, house);
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
		return null;	
		
	}

	public String sendGift(GiftListPO n,int paper,int num,String ddl) {
		//定时赠送单据
		CommodityOperator mm = new CommodityOperator();
		GoodsList s= new GoodsList(n.getList());
		String name = n.getMemberName();
		String id = n.getMemberId();
		ArrayList<MarketCommodityVO> out = s.createCommodityVo();
	   // mm.sendGift(out,name,id,paper,num);
	    return replyFree(n,1);
	}
	
	public GiftListPO storeG(GoodsListPO t){
		String id = getId("KCZSD");
		GiftListPO gift = new GiftListPO(t,id,memberId,other,t.getAllPrice(),user,memberName,house,saler);
		return gift;
	}

}