package businesslogic.marketbl;

import java.util.ArrayList;
import vo.MarketCommodityVO;

public class MockCommodity {
	double price1,price2;
	String id,name,kind;
	int num;
	public MockCommodity(double p,String i){
		price1 = p;
		id = i;
		
	}
	public MockCommodity(){
		price1 =100;
		price2 = 200;
		id = "0001";
		kind = "dd";
		name = "dds";
		num = 100;
	}
	
	public String changeStack(String id,int number,double pricein,double priceout){
		return "success";
	}
	
    public MarketCommodityVO marketFind(String id){
    	return new MarketCommodityVO(id, id, id, num, price1, price1);
    }
    
	public String sendGift(ArrayList<MarketCommodityVO> out, String name2, String id2, int paper, int num2,String ddl) {
		//送礼物
		return "success";
		
	}

}
