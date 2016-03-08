package businesslogic.marketbl;

import businesslogic.commoditybl.CommodityOperator;
import po.GoodLinePO;
import vo.BuyingVO;
import vo.CommodityVo;
import vo.MarketCommodityVO;

public class GoodLine {
	String commodity;
	double value;
	int number;
	String name,kind;
	MarketCommodityVO com;
	public GoodLine(String commodity, double value, int number) {
		// 新建一个商品项
		this.commodity = commodity;
		this.value = value;
		this.number = number;
		CommodityOperator x = new CommodityOperator();
		System.out.println(commodity+"dsfsdfsdf");
		com = x.MarketFind(commodity);
		if(com!=null){
		name = com.getName();
		kind = com.getKind();
		}
 	}
	public GoodLine(BuyingVO x) {
		// 得到goodline
		this(x.getId(),x.getPrice(),x.getNumber());
		name = x.getName();
		kind = x.getKind();
	}
	public GoodLine(GoodLinePO x) {
		// 得到goodLine
		this(x.getId(),x.getPrice(),x.getNumber());
		name = x.getName();
		kind = x.getKind();
	}
	public void change(double value2, int number2) {
		// 更新商品项的信息
		
		this.value=value2;
		this.number = number2;
	}
	public BuyingVO show() {
		// 变成buyingVO
		BuyingVO temp = new BuyingVO(commodity,name,kind,value,number);
		return temp;
	}
	public int getNum() {
		//返回数量
		return number;
	}
	public double getPrice() {
		// 返回价格
		return value;
	}
	public GoodLinePO createPO() {
		// 变成PO
		GoodLinePO po = new GoodLinePO(commodity,name,kind,value,number);
		return po;
	}
	public String reduCommodity(int k) {
		// 减少
		System.out.println("reduceCommodityLine");
		upd(k,-number);
		return "success";
	}
	public String addCommodity(int k) {
		// 增加商品项
		upd (k,number);
		return "success";
	}
	
	private String upd(int kind,int number){
	
		double v1 = 0;
		double v2 = 0;
		if(kind==1){
			v1 = 0;
			v2 = value;
		}
		if(kind==3){
			v1=value;
			v2=0;
		}
		CommodityOperator x = new CommodityOperator();
		System.out.println(commodity+"$$"+ number+"$$"+v1+"$$"+ v2);
		return x.changeStock(commodity, number, v1, v2);
	}
	public MarketCommodityVO createCommodityVo(int i) {
		// 返回CommodityVo
		double v1 = 0;
		double v2 = 0;
		if(i==1){
			v1 = 0;
			v2 = value;
		}
		else if(i==3){
			v1=value;
			v2=0;
		}
		MarketCommodityVO x = new MarketCommodityVO(commodity,name,kind,number,v1,v2);
		return x;
	}

}
