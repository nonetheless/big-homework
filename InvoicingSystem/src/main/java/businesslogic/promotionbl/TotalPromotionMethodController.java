package businesslogic.promotionbl;

import java.util.ArrayList;

import vo.TotalPromotionVO;
import businesslogicservice.promotionblservice.TotalPromotionMethodBLService;

public class TotalPromotionMethodController implements TotalPromotionMethodBLService{
	
	TotalPromotionMethod tpm;
	
	public TotalPromotionMethodController(){
		tpm=new TotalPromotionMethod();
	}

	public ArrayList<TotalPromotionVO> getTotalMethod() {
		// TODO Auto-generated method stub
		return tpm.getTotalMethod();
	}

	public TotalPromotionVO getTotalMethod(double totalMoney) {
		// TODO Auto-generated method stub
		return tpm.getTotalMethod(totalMoney);
	}

	public String updateTotalMethod(double totalMoney, TotalPromotionVO vo) {
		// TODO Auto-generated method stub
		return tpm.updateTotalMethod(totalMoney, vo);
	}

	public String addTotalMethod(double totalMoney, TotalPromotionVO vo) {
		// TODO Auto-generated method stub
		return tpm.addTotalMethod(totalMoney, vo);
	}

	public String delTotalMethod(double totalMoney) {
		// TODO Auto-generated method stub
		return tpm.delTotalMethod(totalMoney);
	}

}
