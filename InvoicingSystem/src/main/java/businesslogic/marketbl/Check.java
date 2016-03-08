package businesslogic.marketbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import main.IPAddress;
import po.MarketListPO;
import dataservice.marketdataservice.MarketDataService;
import vo.ShowListVO;

public class Check {
	private String ip = IPAddress.ip;

	public ArrayList<ShowListVO> show(int i) {
		// 查看单据的
		ArrayList<MarketListPO> po = new ArrayList<MarketListPO>();
		try {
			MarketDataService m = (MarketDataService)Naming.lookup("rmi://localhost:8888/MarketData");
			po = m.showList(i);
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
		ArrayList<ShowListVO> s = trans(po);
		return s;
	}

	private ArrayList<ShowListVO> trans(ArrayList<MarketListPO> po) {
		// 变为vo
		ArrayList<ShowListVO> m = new ArrayList<ShowListVO>();
		for(int i=0;i<po.size();i++){
			MarketListPO mo = po.get(i);
			ShowListVO tem = new ShowListVO(mo.getIdentifier(), mo.getMemberId(), mo.getMemberName(), mo.getPrice());
			m.add(tem);
		}
		return m;
	}

	public int[] check() {
		//查看单据数量
		int [] mm = new int[2];
		mm[0] = 0;
		mm[1] = 0;
		try {
			MarketDataService m = (MarketDataService)Naming.lookup("rmi://"+ip+":8888/MarketData");
			mm =  m.check();
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
		return mm;
	}

}