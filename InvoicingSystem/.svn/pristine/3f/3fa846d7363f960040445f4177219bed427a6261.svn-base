package businesslogic.billmanagementbl;

import java.util.ArrayList;

import po.BillPO;

public class SendBillToManager {
	
	BillManage bm;
	
	public SendBillToManager(){
		bm=new BillManage();
	}
	
	/*
	 * 供销售，库存及财务人员使用
	 * 参数T为所需传入的BillPO的子类型
	 * 参数file为单据的类型，如收款单为“SKD”
	 * 要求单据的编号唯一
	 */
	public <T extends BillPO> String sendBill(T t,String file){
		ArrayList<T> list=new ArrayList<T>();
		if(t==null){
			System.out.println("bill list null pointer");
		}
		list.add(t);
		String res=bm.storeBill(list, file);
		return res;
	}

}
