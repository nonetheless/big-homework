package businesslogic.promotionbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import main.IPAddress;
import po.TotalGiftPO;
import dataservice.promotiondataservice.TotalGiftPromotionDataService;
import vo.TotalGiftVO;

public class TotalGiftPromotion {
	
	TotalGiftPromotionDataService tgd;
	
	public TotalGiftPromotion(){
		try {
			tgd=(TotalGiftPromotionDataService)Naming.lookup("rmi://"+IPAddress.ip+":8808/TotalGiftData");
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
	}
	
	public ArrayList<TotalGiftVO> getTotalGift(double totalMoney) {
		// TODO Auto-generated method stub
		ArrayList<TotalGiftPO> tp = null;
		try {
			tp = tgd.getTotalGift(totalMoney);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<TotalGiftVO> tv=new ArrayList<TotalGiftVO>();
		if(tp.size()>0){
			for(int i=0;i<tp.size();i++){
				TotalGiftPO p=tp.get(i);
				TotalGiftVO v=new TotalGiftVO(p.getTotalMoney(),p.getId(),
						p.getName(),p.getKind(),p.getPrice(),p.getNum());
				tv.add(v);
			}
		}
		return tv;
	}

	public String addTotalGift(TotalGiftVO vo) {
		// TODO Auto-generated method stub
		String str=null;
		try {
			str=tgd.addTotalGift(vo.getTotalMoney(), transfer(vo));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}

	public String editTotalGift(TotalGiftVO vo) {
		// TODO Auto-generated method stub
		String str=null;
		try {
			str=tgd.updateTotalGift(vo.getTotalMoney(), transfer(vo));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}

	public String delTotalGift(TotalGiftVO vo) {
		// TODO Auto-generated method stub
		String str=null;
		try {
			str=tgd.delTotalGift(vo.getTotalMoney(), transfer(vo));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
	
	public String delTotalGiftByMoney(double totalMoney) {
		// TODO Auto-generated method stub
		String str=null;
		try {
			str=tgd.delTotalGiftByMoney(totalMoney);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
	
	public TotalGiftPO transfer(TotalGiftVO vo){
		TotalGiftPO t=new TotalGiftPO(vo.getTotalMoney(),vo.getId(),
				vo.getName(),vo.getKind(),vo.getPrice(),vo.getNum());
		return t;
	}

}
