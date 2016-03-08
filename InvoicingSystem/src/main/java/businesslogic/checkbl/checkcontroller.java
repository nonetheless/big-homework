package businesslogic.checkbl;

import java.util.ArrayList;

import po.BillPO;
import po.GiftListPO;
import po.SaleListPO;
import po.StackListPO;
import po.StockBillsPo;
import po.UnsaleListPO;
import po.UnstackListPO;
import businesslogicservice.checkblservice.checkblservice;
import vo.infoVO;

public class checkcontroller implements checkblservice{
	checkbl ch=new checkbl();
	public ArrayList<SaleListPO> checksales(infoVO infoVO) {
		
		ArrayList<SaleListPO> p=ch.checksales(infoVO);
		return p;
	}
	public ArrayList<UnsaleListPO> checkunsales(infoVO infoVO){
		ArrayList<UnsaleListPO> p=ch.checkunsales(infoVO);
		return p;
	}
	public ArrayList<StackListPO> checkstack(infoVO infoVO){
		ArrayList<StackListPO> p=ch.checkstack(infoVO);
		return p;
	}
	public ArrayList<UnstackListPO> checkunstack(infoVO infoVO){
		ArrayList<UnstackListPO> p=ch.checkunstack(infoVO);
		return p;
	}
	public ArrayList<BillPO> checkstock(infoVO infoVO){
		ArrayList<BillPO> p=ch.checkstock(infoVO);
		return p;
	}
	public ArrayList<GiftListPO> checkgift(infoVO infoVO){
		ArrayList<GiftListPO> p=ch.checkgift(infoVO);
		return p;
	}
	public ArrayList<BillPO> checkpayment(infoVO infoVO){
		ArrayList<BillPO> p=ch.checkpayment(infoVO);
		return p;
	}
	public ArrayList<String> checksituation(infoVO infoVO){
		ArrayList<String> p=ch.checksituation(infoVO);
		return p;
	}
	public ArrayList<String> checkgoods(infoVO infoVO){
		
		ArrayList<String> p=ch.checkgoods(infoVO);
		return p;
	}

}
