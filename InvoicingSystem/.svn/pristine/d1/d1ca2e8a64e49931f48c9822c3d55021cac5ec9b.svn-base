package uiTable;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import vo.CommodityVo;
import vo.StockBillsVo;
import vo.UserVo;
import businesslogic.commoditybl.CommodityController;
import businesslogicservice.commodityblservice.CommodityBlService;

public class TableFactory {
    
	private static CommodityBlService cbl;
	private static String[] cols={"行号","商品类别","商品编号","商品名","商品型号","库存数量","平均进价","进价"
			,"售价","最近进价","最近售价","批次","批号","出厂日期","仓库","报警数量"};
	

	public static DefaultTableModel getComdTable(){
		cbl=new CommodityController();
		ArrayList<CommodityVo> list=cbl.getAllCommoditys();
		int length=list.size();
		Object tableContent[][]=new Object[length][16];
		for(int i=0;i<length;i++){
			 CommodityVo temp=list.get(i);
			 Object[] objectArr={new Integer(i),temp.get_kindName(),temp.get_numOfKind(),temp.get_nameOfCommodity(),temp.get_modelNum(),
			 new Integer(temp.get_numOfStock()),new Double(temp.get_avg_price()),new Double(temp.get_inprice()),new Double(temp.get_outPrice()),
			 new Double(temp.get_latestInPrice()),new Double(temp.get_latestOutPrice()),temp.get_batch(),temp.get_batch_Num(),
			 temp.get_ex_date(),temp.get_storeHouse(),new Integer(temp.get_alarmNum())};
			 
			 tableContent[i]=objectArr;
        }
		return new DefaultTableModel(tableContent,cols);
	}
	
	public static DefaultTableModel getComdTable(ArrayList<CommodityVo> list){
	
		int length=list.size();
		Object tableContent[][]=new Object[length][16];
		for(int i=0;i<length;i++){
			 CommodityVo temp=list.get(i);
			 Object[] objectArr={new Integer(i),temp.get_kindName(),temp.get_numOfKind(),temp.get_nameOfCommodity(),temp.get_modelNum(),
			 new Integer(temp.get_numOfStock()),new Double(temp.get_avg_price()),new Double(temp.get_inprice()),new Double(temp.get_outPrice()),
			 new Double(temp.get_latestInPrice()),new Double(temp.get_latestOutPrice()),temp.get_batch(),temp.get_batch_Num(),
			 temp.get_ex_date(),temp.get_storeHouse(),new Integer(temp.get_alarmNum())};
			 
			 tableContent[i]=objectArr;
        }
		return new DefaultTableModel(tableContent,cols);
	}
	public static DefaultTableModel getAlarmBillTable(ArrayList<StockBillsVo> list){
		String col[]={"商品名称","商品型号","实际数量"};
		int length=list.size();
		int colNum=col.length;
		Object tableContent[][]=new Object[length][colNum];
		
		
		for(int i=0;i<length;i++){
			 StockBillsVo temp=list.get(i);
			 Object[] objectArr={temp.get_commodity(),temp.get_modelNum(),String.valueOf(temp.get_factualNum())};
             tableContent[i]=objectArr;
        }
		return new DefaultTableModel(tableContent,col);
	}
	
	public static DefaultTableModel getUserTable(ArrayList<UserVo> list){
		String col[]={"身份","姓名","ID","密码","等级"};
		int length=list.size();
		int colNum=col.length;
		Object tableContent[][]=new Object[length][colNum];
		for(int i=0;i<length;i++){
			 UserVo temp=list.get(i);
			 Object[] objectArr={temp.getStatus(),temp.getName(),temp.getId(),temp.getPassWord(),String.valueOf(temp.getLevel())};
             tableContent[i]=objectArr;
        }
		return new DefaultTableModel(tableContent,col);
		
	}
	
}
