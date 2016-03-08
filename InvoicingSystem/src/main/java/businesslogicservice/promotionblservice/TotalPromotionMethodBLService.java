package businesslogicservice.promotionblservice;

import java.util.ArrayList;

import vo.TotalPromotionVO;

public interface TotalPromotionMethodBLService {
	
	public ArrayList<TotalPromotionVO> getTotalMethod();
	public TotalPromotionVO getTotalMethod(double totalMoney);
	public String updateTotalMethod(double totalMoney,TotalPromotionVO vo);
	public String addTotalMethod(double totalMoney,TotalPromotionVO vo);
	public String delTotalMethod(double totalMoney);

}
