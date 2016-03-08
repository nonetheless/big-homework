/*
 * @cridtph
 */
package businesslogic.promotionbl;

import java.util.ArrayList;
import vo.VipCouponVO;
import businesslogicservice.promotionblservice.VipCouponPromotionBLService;

public class VipCouponPromotionController implements VipCouponPromotionBLService{
	
	VipCouponPromotion vcp;
	
	public VipCouponPromotionController(){     //构造方法
		vcp =new VipCouponPromotion();
	}
	
	public VipCouponVO getVipCoupon(int level){
		return vcp.getVipCoupon(level);
	}
	
	public ArrayList<VipCouponVO> getVipCouponList() {
		// TODO Auto-generated method stub
		return vcp.getVipCouponList();
	}

	public String addVipCoupon(VipCouponVO vo) {
		// TODO Auto-generated method stub
		return vcp.addVipCoupon(vo);
	}

	public String editVipCoupon(VipCouponVO vo) {
		// TODO Auto-generated method stub
		return vcp.editVipCoupon(vo);
	}

	public String delVipCoupon(int level) {
		// TODO Auto-generated method stub
		return vcp.delVipCoupon(level);
	}

}
