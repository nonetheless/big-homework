package businesslogicservice.promotionblservice;

import java.util.ArrayList;
import vo.TotalCouponVO;

public interface TotalCouponPromotionBLService {
	
	public ArrayList<TotalCouponVO> getTotalCouponList();
	public TotalCouponVO getTotalCoupon(double totalMoney);
	public String addTotalCoupon(TotalCouponVO vo);
	public String editTotalCoupon(TotalCouponVO vo);
	public String delTotalCoupon(double totalMoney);

}
