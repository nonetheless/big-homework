package presentation.billmanagementui;

import java.util.ArrayList;

import po.GiftListPO;
import po.PaycashPO;
import po.PayinPO;
import po.PayoutPO;
import po.SaleListPO;
import po.StackListPO;
import po.StockBillsPo;
import po.UnsaleListPO;
import po.UnstackListPO;
import businesslogic.billmanagementbl.BillManageController;

public class BillData {
	BillManageController bmc;
	
	ArrayList<PayinPO> skdlist;       //收款单
	ArrayList<PayoutPO> fkdlist;      //付款单
	ArrayList<PaycashPO> xjfkdlist;   //现金付款单
	
	ArrayList<StockBillsPo> overlist;    //库存报溢单
	ArrayList<StockBillsPo> losslist;    //库存报损单
	ArrayList<StockBillsPo> alarmlist;   //库存报警单
	
	ArrayList<SaleListPO> xsdlist;       //销售单
	ArrayList<UnsaleListPO> xsthdlist;   //销售退货单
	ArrayList<StackListPO> jhdlist;      //进货单
	ArrayList<UnstackListPO> thdlist;   //退货单
	ArrayList<GiftListPO> kczsdlist;      //库存赠送单
	
	public int getBillData(){
		int sign=0;
		bmc=new BillManageController();
		
		skdlist=bmc.getBillList("file/SKD.ser");
		fkdlist=bmc.getBillList("file/FKD.ser");
		xjfkdlist=bmc.getBillList("file/XJFKD.ser");
		sign=sign+skdlist.size();
		sign=sign+fkdlist.size();
		sign=sign+xjfkdlist.size();
		
		overlist=bmc.getBillList("file/over.ser");
		losslist=bmc.getBillList("file/loss.ser");
		alarmlist=bmc.getBillList("file/alarm.ser");
		sign=sign+overlist.size();
		sign=sign+losslist.size();
		sign=sign+alarmlist.size();
		
		xsdlist=bmc.getBillList("file/XSD.ser");
		xsthdlist=bmc.getBillList("file/XSTHD.ser");
		jhdlist=bmc.getBillList("file/JHD.ser");
		thdlist=bmc.getBillList("file/THD.ser");
		kczsdlist=bmc.getBillList("file/KCZSD.ser");
		sign=sign+xsdlist.size();
		sign=sign+xsthdlist.size();
		sign=sign+jhdlist.size();
		sign=sign+thdlist.size();
		sign=sign+kczsdlist.size();
		
		return sign;
	}

}
