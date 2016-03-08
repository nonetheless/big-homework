package businesslogic.promotionbl;

import java.util.ArrayList;

import vo.CommodityVo;
import businesslogic.commoditybl.CommodityOperator;
import businesslogic.commoditybl.CommodityProvider;

public class GetCommodity {
	
	CommodityProvider cp;
	
	public GetCommodity(){
		cp=new CommodityOperator();
	}
	
	public ArrayList<CommodityVo> getCommodity(){
		/*
		ArrayList<CommodityVo> comdList=new ArrayList<CommodityVo>();
		comdList.add(new CommodityVo("生活用品","234","热水袋","1312501897",56,65.2,54.2,50.88,65.7,87.8,"sdf","sadf","sad","sdag",88));
		comdList.add(new CommodityVo("零食","2324","话梅","1312501989",56,65.2,54.2,32.4,65.7,87.8,"sdf","sadf","s2ad","sdag",88));
		comdList.add(new CommodityVo("零食","2324","火腿肠","1367501989",56,65.2,54.2,31,65.7,87.8,"sdf","sadf","s2ad","sdag",88));
		comdList.add(new CommodityVo("零食","2324","饼干","1378901989",56,65.2,54.2,12,65.7,87.8,"sdf","sadf","s2ad","sdag",88));
		comdList.add(new CommodityVo("电子产品","2324","灯","1335566989",56,65.2,54.2,70,65.7,87.8,"sdf","sadf","s2ad","sdag",88));
		comdList.add(new CommodityVo("电子产品","2324","耳机","1317654289",56,65.2,54.2,50,65.7,87.8,"sdf","sadf","s2ad","sdag",88));
		return comdList;
		*/
		return cp.getAllCommoditys();
	}
}
