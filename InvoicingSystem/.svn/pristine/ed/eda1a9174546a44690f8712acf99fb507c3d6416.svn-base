package businesslogic.promotionbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import main.IPAddress;

import po.TotalCouponPO;
import dataservice.promotiondataservice.TotalCouponPromotionDataService;
import vo.TotalCouponVO;

public class TotalCouponPromotion {
	
	TotalCouponPromotionDataService tcd;
	
	public TotalCouponPromotion(){
		try {
			tcd=(TotalCouponPromotionDataService)Naming.lookup("rmi://"+IPAddress.ip+":8808/TotalCouponData");
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
	
	public TotalCouponVO getTotalCoupon(double totalMoney) {
		// TODO Auto-generated method stub
		TotalCouponPO a = null;
		try {
			a = tcd.getTotalCoupon(totalMoney);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TotalCouponVO b=null;
		if(a!=null){
			b=new TotalCouponVO(a.getTotalMoney(),a.getPrice(),a.getNum(),a.getEndDate());
		}
		return b;
	}
	
	public ArrayList<TotalCouponVO> getTotalCouponList(){
		ArrayList<TotalCouponPO> a = null;
		try {
			a = tcd.getTotalCouponList();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<TotalCouponVO> b=new ArrayList<TotalCouponVO>();
		for(int i=0;i<a.size();i++){
			TotalCouponPO t=a.get(i);
			TotalCouponVO d=new TotalCouponVO(t.getTotalMoney(),t.getPrice(),t.getNum(),t.getEndDate());
			b.add(d);
		}
		return b;
	}

	public String addTotalCoupon(TotalCouponVO vo) {
		// TODO Auto-generated method stub
		TotalCouponPO tp=transfer(vo);
		String str = null;
		try {
			str = tcd.addTotalCoupon(tp.getTotalMoney(), tp);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}

	public String editTotalCoupon(TotalCouponVO vo) {
		// TODO Auto-generated method stub
		TotalCouponPO tp=transfer(vo);
		String str = null;
		try {
			str = tcd.updateTotalCoupon(tp.getTotalMoney(), tp);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}

	public String delTotalCoupon(double totalMoney) {
		// TODO Auto-generated method stub
		String str = null;
		try {
			str = tcd.delTotalCoupon(totalMoney);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
	
	public TotalCouponPO transfer(TotalCouponVO vo){
		TotalCouponPO vp=new TotalCouponPO(vo.getTotalMoney(),vo.getPrice(),
				vo.getNum(),vo.getEndDate());
		return vp;
	}

}
