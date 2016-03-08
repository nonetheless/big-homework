package businesslogic.promotionbl;

import java.util.ArrayList;

import vo.DiscountVO;
import businesslogicservice.promotionblservice.VipDiscountPromotionBLService;

public class VipDiscountPromotionController implements VipDiscountPromotionBLService{
	
	VipDiscountPromotion vdp;
	
	public VipDiscountPromotionController(){
		vdp=new VipDiscountPromotion();
	}

	public ArrayList<DiscountVO> getDiscount() {
		// TODO Auto-generated method stub
		return vdp.getDiscount();
	}
	
	public DiscountVO getDiscount(int vipLevel){
		return vdp.getDiscount(vipLevel);
	}

	public String addDiscount(DiscountVO vo) {
		// TODO Auto-generated method stub
		return vdp.addDiscount(vo);
	}

	public String editDiscount(DiscountVO vo) {
		// TODO Auto-generated method stub
		return vdp.editDiscount(vo);
	}

	public String delDiscount(int level) {
		// TODO Auto-generated method stub
		return vdp.delDiscount(level);
	}
	

}
