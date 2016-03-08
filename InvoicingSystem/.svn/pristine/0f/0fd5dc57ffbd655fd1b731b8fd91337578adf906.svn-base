package businesslogic.promotionbl;

import java.util.ArrayList;

import vo.CommodityVo;
import vo.VipGiftVO;
import businesslogicservice.promotionblservice.VipGiftPromotionBLService;

public class VipGiftPromotionController implements VipGiftPromotionBLService{
	
	VipGiftPromotion vgp;
	
	public VipGiftPromotionController(){
		vgp=new VipGiftPromotion();
	}

	public ArrayList<VipGiftVO> getVipGift(int level) {
		// TODO Auto-generated method stub
		return vgp.getVipGift(level);
	}

	public String addVipGift(VipGiftVO vo) {
		// TODO Auto-generated method stub
		return vgp.addVipGift(vo);
	}

	public String editVipGift(VipGiftVO vo) {
		// TODO Auto-generated method stub
		return vgp.editVipGift(vo);
	}

	public String delVipGift(VipGiftVO vo) {
		// TODO Auto-generated method stub
		return vgp.delVipGift(vo);
	}

	public String delVipGiftByLevel(int level) {
		// TODO Auto-generated method stub
		return vgp.delVipGiftByLevel(level);
	}

}
