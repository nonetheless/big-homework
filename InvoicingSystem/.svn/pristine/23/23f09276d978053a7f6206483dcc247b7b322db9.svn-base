package businesslogicservice.commodityblservice;

import java.util.ArrayList;

import javax.swing.JTable;

import businesslogic.commoditybl.Search;
import businesslogic.commoditybl.SearchType;
import vo.CommodityVo;
import vo.Ex_StockVo;
import vo.StockBillsVo;
import vo.infoVO;

public interface CommodityBlService {

public int addCommodity(CommodityVo comdVo);
public int delCommodity(String name);

public int changeCommodity(CommodityVo comdVo);

//public int findCommodity(String name,String kindNum,String modelNum);
public ArrayList<StockBillsVo> checkAlarm();
public Ex_StockVo examineStock(double beginTime,double endTime);//用于库存查看
public ArrayList<CommodityVo> getAllCommoditys();//用于库存盘点

public int subStockBills(StockBillsVo vo);
public int subStockBills(int loc,int factNum);

public int  exportAsXls(JTable table);

public ArrayList<CommodityVo> search(SearchType type, String info);

public void initAllData();

public CommodityVo getOneCommodity(int loc);

}
