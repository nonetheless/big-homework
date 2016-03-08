package businesslogicservice.billmanagementblservice;


import java.util.ArrayList;
import po.BillPO;


public interface BillManagementBLService {
	
	public <T extends BillPO> ArrayList<T> getBillList(String fileName);
	public <T extends BillPO> String storeBill(ArrayList<T> list,String fileName);
	public <T extends BillPO> String updateBill(T t,String fileName);
	public <T extends BillPO> String approveBill(T t,String fileName);
}
