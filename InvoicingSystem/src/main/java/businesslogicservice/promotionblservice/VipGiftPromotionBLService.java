package businesslogicservice.promotionblservice;

import java.util.ArrayList;

import vo.VipGiftVO;

public interface VipGiftPromotionBLService {
	
	public ArrayList<VipGiftVO> getVipGift(int level);
	public String addVipGift(VipGiftVO vo);
	public String editVipGift(VipGiftVO vo);
	public String delVipGift(VipGiftVO vo);
	public String delVipGiftByLevel(int level);

}
