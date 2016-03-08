package businesslogic.promotionbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import main.IPAddress;
import po.DiscountPO;
import dataservice.promotiondataservice.VipDiscountPromotionDataService;
import vo.DiscountVO;

public class VipDiscountPromotion {
	
	VipDiscountPromotionDataService vdd;
	
	public VipDiscountPromotion(){
		try {
			vdd=(VipDiscountPromotionDataService)Naming.lookup("rmi://"+IPAddress.ip+":8808/VipDiscountData");
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
	
	public ArrayList<DiscountVO> getDiscount() {
		// TODO Auto-generated method stub
		ArrayList<DiscountPO> dpl = null;
		try {
			dpl = vdd.getDiscount();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<DiscountVO> dvl=new ArrayList<DiscountVO>();
		if(dpl.size()>0){
			for(int i=0;i<dpl.size();i++){
				DiscountPO dp=dpl.get(i);
				DiscountVO dv=new DiscountVO(dp.getVipLevel(),dp.getDiscount());
				dvl.add(dv);
			}
		}
		return dvl;
	}
	
	public DiscountVO getDiscount(int vipLevel){
		DiscountPO po = null;
		try {
			po = vdd.getDiscount(vipLevel);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DiscountVO vo=null;
		if(po!=null){
			vo=new DiscountVO(po.getVipLevel(),po.getDiscount());
		}
		return vo;
	}

	public String addDiscount(DiscountVO vo) {
		// TODO Auto-generated method stub
		String str=null;
		try {
			str=vdd.addDiscount(transfer(vo));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}

	public String editDiscount(DiscountVO vo) {
		// TODO Auto-generated method stub
		String str=null;
		try {
			str=vdd.editDiscount(transfer(vo));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}

	public String delDiscount(int level) {
		// TODO Auto-generated method stub
		String str=null;
		try {
			str=vdd.delDiscount(level);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
	
	public DiscountPO transfer(DiscountVO vo){
		DiscountPO dp=new DiscountPO(vo.getVipLevel(),vo.getDiscount());
		return dp;
	}
}
