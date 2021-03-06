package businesslogic.marketbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.marketdataservice.MarketDataService;
import po.BillPO;
import po.GoodPO;
import po.GoodsListPO;
import po.MarketListPO;
import po.SaleListPO;
import po.StackListPO;
import vo.InformationVO;

public class Stack extends Unity{

	public Stack(InformationVO info) {
		super(info);
		kind = "JHD";
		
	}

	@Override
	protected BillPO getPO(GoodsListPO x) {
		//根据Goodslist生成销售单的PO
		String id = getId(kind);
		StackListPO bill= new StackListPO(x,id,memberId,saler,house,other
				,x.getAllPrice(),user,memberName);
		return bill;
	}

	@Override
	protected String store(MarketListPO x,int ok) {
		//存入数据层
		MarketDataService m;
		try {
			m = (MarketDataService)Naming.lookup("rmi://"+ip+":8888/MarketData");
			StackListPO xx = (StackListPO)x;
			return m.insertStack(xx,ok) ;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "false";
	}

	@Override
	public ArrayList<StackListPO> find(String start, String end, String thingid,
			String memberid2, String salerid, String house2) {
		ArrayList<StackListPO> m = new ArrayList<StackListPO>();
		MarketDataService ms;
		try {
			ms = (MarketDataService)Naming.lookup("rmi://"+ip+":8888/MarketData");
			ArrayList<StackListPO> nn = ms.findStack(start, end, thingid, memberid2, salerid, house2);
			for(int i=0;i<nn.size();i++){
				m.add(nn.get(i));
			}
			return m;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
