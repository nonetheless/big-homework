package businesslogic.commoditybl;

import java.util.ArrayList;

import javax.swing.JTable;

import dataservice.commoditydataservice.CommodityDataService;
import vo.CommodityVo;
import vo.Ex_StockVo;
import vo.StockBillsVo;
import vo.infoVO;
import businesslogicservice.commodityblservice.CommodityBlService;

public class CommodityController implements CommodityBlService {
     CommodityOperator cop;
     public CommodityController(){
    	 cop=new CommodityOperator();
     }
	
	public int addCommodity(CommodityVo comdVo){
	   return cop.addCommodity(comdVo);
    }

	public int delCommodity(String name) {
		return cop.delCommodity(name);
	}
	
	public int changeCommodity(CommodityVo comdVo) {
		return cop.changeCommodity(comdVo);
	}
	

    public Ex_StockVo  examineStock(double beginTime,double endTime) {
		return cop.examineStock(beginTime, endTime);
		
	}

	public ArrayList<CommodityVo> getAllCommoditys() {
		return cop.getAllCommoditys();
	}

	public int subStockBills(StockBillsVo vo) {
		// TODO Auto-generated method stub
		return cop.subStockBills(vo);
	}

	public int exportAsXls(JTable table){
		
		return cop.exportAsXls(table);
	}

	public ArrayList<CommodityVo> search(SearchType type, String info) {
        	
		return cop.search(type, info);
	}
    public CommodityVo getOneCommodity(int loc){
    	return cop.getOneCommodity(loc);
    }

	public int subStockBills(int loc,int factNum) {
		// TODO Auto-generated method stub
		return cop.subStockBills(loc, factNum);
		
	}

	public ArrayList<StockBillsVo> checkAlarm() {
		// TODO Auto-generated method stub
		return cop.checkAlarm();
	}

	public void initAllData() {
		// TODO Auto-generated method stub
		cop.init();
		cop.initKind();
	}

	





	





	

}
