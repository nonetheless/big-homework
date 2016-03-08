package businesslogicservice.promotionblservice;

import java.util.ArrayList;
import vo.VipCouponVO;

public interface VipCouponPromotionBLService {
	
	public ArrayList<VipCouponVO> getVipCouponList();
	public VipCouponVO getVipCoupon(int level);
	public String addVipCoupon(VipCouponVO vo);
	public String editVipCoupon(VipCouponVO vo);
	public String delVipCoupon(int level);

}
