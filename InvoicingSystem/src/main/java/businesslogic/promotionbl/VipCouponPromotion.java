package businesslogic.promotionbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import main.IPAddress;
import po.VipCouponPO;
import dataservice.promotiondataservice.VipCouponPromotionDataService;
import vo.VipCouponVO;

public class VipCouponPromotion {
	
	VipCouponPromotionDataService vcd;
	
	public VipCouponPromotion(){
		try {
			vcd=(VipCouponPromotionDataService)Naming.lookup("rmi://"+IPAddress.ip+":8808/VipCouponData");
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
	
	public VipCouponVO getVipCoupon(int level) {
		// TODO Auto-generated method stub
		VipCouponPO vp = null;
		try {
			vp = vcd.getVipCoupon(level);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		VipCouponVO vc=null;
		if(vp!=null){
			vc=new VipCouponVO(vp.getVipLevel(),vp.getPrice(),	
				vp.getNum(),vp.getSendTime(),vp.getEndDate());}
		return vc;
	}
	
	public ArrayList<VipCouponVO> getVipCouponList() {
		// TODO Auto-generated method stub
		ArrayList<VipCouponPO> a = null;
		try {
			a = vcd.getVipCouponList();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<VipCouponVO> vipCouponList=new ArrayList<VipCouponVO>();
		for(int i=0;i<a.size();i++){
			VipCouponPO vp=a.get(i);
			VipCouponVO vc=new VipCouponVO(vp.getVipLevel(),vp.getPrice(),
					vp.getNum(),vp.getSendTime(),vp.getEndDate());
			vipCouponList.add(vc);
		}
		return vipCouponList;
	}
	
	public String addVipCoupon(VipCouponVO vo) {
		// TODO Auto-generated method stub
		VipCouponPO vp=transfer(vo);
		String str = null;
		try {
			str = vcd.addVipCoupon(vo.getVipLevel(), vp);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}

	public String editVipCoupon(VipCouponVO vo) {
		// TODO Auto-generated method stub
		VipCouponPO vp=transfer(vo);
		String str = null;
		try {
			str = vcd.updateVipCoupon(vo.getVipLevel(), vp);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}

	public String delVipCoupon(int level) {
		// TODO Auto-generated method stub
		String str = null;
		try {
			str = vcd.delVipCoupon(level);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
	
	public VipCouponPO transfer(VipCouponVO vo){
		VipCouponPO vp=new VipCouponPO(vo.getVipLevel(),vo.getPrice(),
				vo.getNum(),vo.getSendTime(),vo.getEndDate());
		return vp;
	}
}
