package businesslogic.promotionbl;

import java.util.ArrayList;

import vo.TotalCouponVO;
import businesslogicservice.promotionblservice.TotalCouponPromotionBLService;

public class TotalCouponPromotionController implements TotalCouponPromotionBLService{
	
	TotalCouponPromotion tcp;
	
	public TotalCouponPromotionController(){
		tcp=new TotalCouponPromotion();
	}

	public TotalCouponVO getTotalCoupon(double totalMoney) {
		// TODO Auto-generated method stub
		return tcp.getTotalCoupon(totalMoney);
	}

	public ArrayList<TotalCouponVO> getTotalCouponList(){
		return tcp.getTotalCouponList();
	}
	
	public String addTotalCoupon(TotalCouponVO vo) {
		// TODO Auto-generated method stub
		return tcp.addTotalCoupon(vo);
	}

	public String editTotalCoupon(TotalCouponVO vo) {
		// TODO Auto-generated method stub
		return tcp.editTotalCoupon(vo);
	}

	public String delTotalCoupon(double totalMoney) {
		// TODO Auto-generated method stub
		return tcp.delTotalCoupon(totalMoney);
	}

	
	
}
