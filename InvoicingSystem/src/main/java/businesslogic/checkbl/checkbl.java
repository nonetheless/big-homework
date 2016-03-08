package businesslogic.checkbl;
import java.util.ArrayList;

import po.BillPO;
import po.GiftListPO;
import po.GoodLinePO;
import po.SaleListPO;
import po.StackListPO;
import po.StockBillsPo;
import po.UnsaleListPO;
import po.UnstackListPO;
import vo.CommodityVo;
import vo.infoVO;
import businesslogic.commoditybl.CommodityOperator;
import businesslogic.marketbl.MarketForAccount;
import businesslogic.paymentbl.paymentcontroller;
import businesslogicservice.checkblservice.*;

public class checkbl {
	public ArrayList<SaleListPO> checksales(infoVO infoVO) {
		MarketForAccount m=new MarketForAccount();
		ArrayList<SaleListPO> p=m.findSale(infoVO);
		
		return p;
	}
	public ArrayList<UnsaleListPO> checkunsales(infoVO infoVO){
		MarketForAccount m=new MarketForAccount();
		ArrayList<UnsaleListPO> p=m.findUnsale(infoVO);
		
		return p;
		
	}
	public ArrayList<StackListPO> checkstack(infoVO infoVO){
		MarketForAccount m=new MarketForAccount();
		ArrayList<StackListPO> p=m.findStack(infoVO);
		
		return p;
		
	}
	public ArrayList<UnstackListPO> checkunstack(infoVO infoVO){
		MarketForAccount m=new MarketForAccount();
		ArrayList<UnstackListPO> p=m.findUnstack(infoVO);
		
		return p;
		
	}
	public ArrayList<BillPO> checkstock(infoVO infoVO){
		CommodityOperator c=new CommodityOperator();
		ArrayList<BillPO> p=c.getBills(infoVO);
		return p;
	}
	public ArrayList<GiftListPO> checkgift(infoVO infoVO){
		MarketForAccount m=new MarketForAccount();
		ArrayList<GiftListPO> p=m.findGift(infoVO);
		return p;
	}
	public ArrayList<BillPO> checkpayment(infoVO infoVO){
		paymentcontroller p=new paymentcontroller("in");
		ArrayList<BillPO> b=p.find(infoVO);
		return b;
	}
	public ArrayList<String> checksituation(infoVO infoVO){
		ArrayList<SaleListPO> p=this.checksales(infoVO);
		
		ArrayList<String> s=new ArrayList<String>();
		double in=0;
		double out=0;
		double profile=0;
		double discount=0;
		for(int i=0;i<p.size();i++){
			SaleListPO sp=p.get(i);
			double din=sp.getafter();
			double ddis=sp.getdiscount();
			in=in+din;
			discount=discount+ddis;
		}
		for(int i=0;i<p.size();i++){
			SaleListPO sp=p.get(i);
			
			ArrayList<GoodLinePO> lp=(sp.getList()).getList();
			for(int j=0;j<lp.size();j++){
				GoodLinePO gp=lp.get(j);
				String name=gp.getName();
				//System.out.println(name);
				int number=gp.getNumber();
				CommodityOperator com=new CommodityOperator();
				ArrayList<CommodityVo> c=com.getCommoditys(name);
				//System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+"-"+c.size());
				double d=c.get(0).get_inprice();
				double d1=number*d;
				out=out+d1;
		
			}
		}
		ArrayList<GiftListPO> g=this.checkgift(infoVO);
		for(int i=0;i<g.size();i++){
			out=out+g.get(i).getPrice();
		}
		profile=in-out;
		s.add(Double.toString(in));
		s.add(Double.toString(discount));
		s.add(Double.toString(out));
		s.add(Double.toString(profile));
		return s;
	}
	public ArrayList<String> checkgoods(infoVO infoVO){
		ArrayList<SaleListPO> p=this.checksales(infoVO);
		ArrayList<String> s=new ArrayList<String>();
		for(int i=0;i<p.size();i++){
			SaleListPO sp=p.get(i);
			String string=sp.getIdentifier();
			String[] result=string.split("-");
			String time=result[1]+"-"+result[2]+"-"+result[3];
			ArrayList<GoodLinePO> lp=(sp.getList()).getList();
			for(int j=0;j<lp.size();j++){
				GoodLinePO gp=lp.get(j);
				String name=gp.getName();
				String id=gp.getId();
				int number=gp.getNumber();
				double price=gp.getPrice();
				double whole=price*number;
				String line=time+";"+name+";"+id+";"+Integer.toString(number)+";"+Double.toString(price)+";"+Double.toString(whole);
				s.add(line);
			}
			
		}
		return s;
	}
	public static void main(String args[]){
		checkbl b=new checkbl();
		infoVO infoVO=new infoVO(null,null,null,null,null,null,"alarm");
		ArrayList<BillPO> p=b.checkstock(infoVO);
		System.out.println(p.size());
	}


}