package businesslogic.promotionbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import main.IPAddress;
import businesslogic.commoditybl.CommodityOperator;
import businesslogic.commoditybl.CommodityProvider;
import dataservice.promotiondataservice.VipGiftPromotionDataService;
import po.CommodityPo;
import po.VipGiftPO;
import vo.CommodityVo;
import vo.VipGiftVO;

public class VipGiftPromotion {
	
	VipGiftPromotionDataService vgd;
	
	public VipGiftPromotion(){
		try {
			vgd=(VipGiftPromotionDataService)Naming.lookup("rmi://"+IPAddress.ip+":8808/VipGiftData");
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
	
	public ArrayList<VipGiftVO> getVipGift(int level) {
		// TODO Auto-generated method stub
		ArrayList<VipGiftPO> vgp = null;
		try {
			vgp = vgd.getVipGift(level);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<VipGiftVO> v=new ArrayList<VipGiftVO>();
		if(vgp.size()>0){
			for(int i=0;i<vgp.size();i++){
				VipGiftPO vp=vgp.get(i);
				VipGiftVO vo=new VipGiftVO(vp.getVipLevel(),vp.getId(),vp.getName(),
						vp.getKind(),vp.getPrice(),vp.getNum(),vp.getSendTime());
				v.add(vo);
			}
		}
		return v;
	}

	public String addVipGift(VipGiftVO vo) {
		// TODO Auto-generated method stub
		String str=null;
		try {
			str=vgd.addVIPGift(vo.getVipLevel(), transfer(vo));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}

	public String editVipGift(VipGiftVO vo) {
		// TODO Auto-generated method stub
		String str=null;
		try {
			str=vgd.updateVipGift(vo.getVipLevel(), transfer(vo));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}

	public String delVipGift(VipGiftVO vo) {
		// TODO Auto-generated method stub
		String str=null;
		try {
			str=vgd.delVIPGift(vo.getVipLevel(), transfer(vo));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
	
	public String delVipGiftByLevel(int level) {
		// TODO Auto-generated method stub
		String str=null;
		try {
			str=vgd.delVipGiftByLevel(level);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
	
	public VipGiftPO transfer(VipGiftVO vo){
		VipGiftPO vgp=new VipGiftPO(vo.getVipLevel(),vo.getId(),vo.getName(),
				vo.getKind(),vo.getPrice(),vo.getNum(),vo.getSendTime());
		return vgp;
	}
}
