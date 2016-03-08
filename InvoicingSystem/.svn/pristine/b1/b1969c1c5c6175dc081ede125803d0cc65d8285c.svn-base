package businesslogic.promotionbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import main.IPAddress;
import po.TotalPromotionPO;
import vo.TotalPromotionVO;
import dataservice.promotiondataservice.TotalPromotionMethodDataService;

public class TotalPromotionMethod {
	
	TotalPromotionMethodDataService tmd;
	
	public TotalPromotionMethod(){
		try {
			tmd=(TotalPromotionMethodDataService)Naming.lookup("rmi://"+IPAddress.ip+":8808/TotalMethodData");
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

	public ArrayList<TotalPromotionVO> getTotalMethod() {
		// TODO Auto-generated method stub
		ArrayList<TotalPromotionPO> array = null;
		try {
			array = tmd.getTotalMethod();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<TotalPromotionVO> list=new ArrayList<TotalPromotionVO>();
		if(array.size()>0){
			for(int i=0;i<array.size();i++){
				TotalPromotionPO po=array.get(i);
				TotalPromotionVO vo=new TotalPromotionVO(po.getTotalPrice(),po.getIsCoupon(),po.getIsGift());
				list.add(vo);
			}
		}
		return list;
	}

	public TotalPromotionVO getTotalMethod(double totalMoney) {
		// TODO Auto-generated method stub
		TotalPromotionPO po = null;
		try {
			po = tmd.getTotalMethod(totalMoney);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TotalPromotionVO vo=new TotalPromotionVO(po.getTotalPrice(),po.getIsCoupon(),po.getIsGift());
		return vo;
	}

	public String updateTotalMethod(double totalMoney, TotalPromotionVO vo) {
		// TODO Auto-generated method stub
		String str=null;
		TotalPromotionPO po=new TotalPromotionPO(vo.getTotalPrice(),vo.getIsCoupon(),vo.getIsGift());
		try {
			str=tmd.updateTotalMethod(totalMoney, po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}

	public String addTotalMethod(double totalMoney, TotalPromotionVO vo) {
		// TODO Auto-generated method stub
		String s=null;
		TotalPromotionPO po=new TotalPromotionPO(vo.getTotalPrice(),vo.getIsCoupon(),vo.getIsGift());
		try {
			s=tmd.addTotalMethod(totalMoney, po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}

	public String delTotalMethod(double totalMoney) {
		// TODO Auto-generated method stub
		String s=null;
		try {
			s=tmd.delTotalMethod(totalMoney);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
	
}
