package businesslogic.billmanagementbl;
/**
 * 解决bill与market的无环依赖
 */
import po.BillPO;

public interface MarketForBillSercice {

	public String reply(BillPO x,int ok);
	//审批单据
}
