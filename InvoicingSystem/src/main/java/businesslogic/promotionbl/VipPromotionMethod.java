package businesslogic.promotionbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import main.IPAddress;
import po.VipPromotionPO;
import dataservice.promotiondataservice.VipPromotionMethodDataService;
import vo.VipPromotionVO;

public class VipPromotionMethod {
	
	VipPromotionMethodDataService vmd;
	
	public VipPromotionMethod(){
		try {
			vmd=(VipPromotionMethodDataService)Naming.lookup("rmi://"+IPAddress.ip+":8808/VipMethodData");
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
	
	
	public ArrayList<VipPromotionVO> getVipMethod() {
		// TODO Auto-generated method stub
		ArrayList<VipPromotionPO> array = null;
		try {
			array = vmd.getVipMethod();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<VipPromotionVO> v_array=new ArrayList<VipPromotionVO>();
		VipPromotionVO vo;
		
		if(array.size()>0){
			for(int i=0;i<array.size();i++){
				VipPromotionPO po=array.get(i);
				vo=new VipPromotionVO(po.getVipLevel(),po.getIsCoupon(),po.getIsGift(),po.getIsDiscount());
				v_array.add(vo);
			}
		}
		return v_array;
	}
	
	public VipPromotionVO getVipMethod(int level){
		VipPromotionPO po = null;
		try {
			po = vmd.getVipMethod(level);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		VipPromotionVO vo=new VipPromotionVO(po.getVipLevel(),po.getIsCoupon(),po.getIsGift(),po.getIsDiscount());
		return vo;
	}

	public String updateVipMethod(int level, VipPromotionVO vo) {
		// TODO Auto-generated method stub
		String str=null;
		VipPromotionPO po=new VipPromotionPO(vo.getVipLevel(),vo.getIsCoupon(),vo.getIsGift(),vo.getIsDiscount());
		try {
			str=vmd.updateVipMethod(level, po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}

}
