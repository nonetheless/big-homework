package businesslogic.billmanagementbl;

import java.util.ArrayList;

import po.BillPO;
import businesslogicservice.billmanagementblservice.BillManagementBLService;

public class BillManageController implements BillManagementBLService{
	
	BillManage bm;
	
	public BillManageController(){
		bm=new BillManage();
	}

	public <T extends BillPO> ArrayList<T> getBillList(String fileName) {
		// TODO Auto-generated method stub
		return bm.getBillList(fileName);
	}

	public <T extends BillPO> String storeBill(ArrayList<T> list,
			String fileName) {
		// TODO Auto-generated method stub
		return bm.storeBill(list, fileName);
	}

	public <T extends BillPO> String updateBill(T t, String fileName) {
		// TODO Auto-generated method stub
		return bm.updateBill(t, fileName);
	}

	public <T extends BillPO> String approveBill(T t, String fileName) {
		// TODO Auto-generated method stub
		return bm.approveBill(t, fileName);
	}

}
