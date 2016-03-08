package businesslogicservice.checkblservice;
import java.util.*;

import po.BillPO;
import po.GiftListPO;
import po.SaleListPO;
import po.StackListPO;
import po.StockBillsPo;
import po.UnsaleListPO;
import po.UnstackListPO;
import vo.infoVO;
public interface checkblservice {
	public ArrayList<SaleListPO> checksales(infoVO infoVO) ;
	public ArrayList<UnsaleListPO> checkunsales(infoVO infoVO);
	public ArrayList<StackListPO> checkstack(infoVO infoVO);
	public ArrayList<UnstackListPO> checkunstack(infoVO infoVO);
	public ArrayList<BillPO> checkstock(infoVO infoVO);
	public ArrayList<GiftListPO> checkgift(infoVO infoVO);
	public ArrayList<BillPO> checkpayment(infoVO infoVO);
	public ArrayList<String> checksituation(infoVO infoVO);
	public ArrayList<String> checkgoods(infoVO infoVO);

}
