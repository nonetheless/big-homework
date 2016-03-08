package businesslogic.promotionbl;

import java.util.ArrayList;

import vo.TotalGiftVO;
import businesslogicservice.promotionblservice.TotalGiftPromotionBLService;

public class TotalGiftPromotionController implements TotalGiftPromotionBLService{
	
	TotalGiftPromotion tgp;
	
	public TotalGiftPromotionController(){
		tgp=new TotalGiftPromotion();
	}

	public ArrayList<TotalGiftVO> getTotalGift(double totalMoney) {
		// TODO Auto-generated method stub
		return tgp.getTotalGift(totalMoney);
	}

	public String addTotalGift(TotalGiftVO vo) {
		// TODO Auto-generated method stub
		return tgp.addTotalGift(vo);
	}

	public String editTotalGift(TotalGiftVO vo) {
		// TODO Auto-generated method stub
		return tgp.editTotalGift(vo);
	}

	public String delTotalGift(TotalGiftVO vo) {
		// TODO Auto-generated method stub
		return tgp.delTotalGift(vo);
	}

	public String delTotalGiftByMoney(double totalMoney) {
		// TODO Auto-generated method stub
		return tgp.delTotalGiftByMoney(totalMoney);
	}
	
	

}
