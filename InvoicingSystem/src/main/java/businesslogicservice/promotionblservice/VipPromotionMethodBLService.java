package businesslogicservice.promotionblservice;

import java.util.ArrayList;
import vo.VipPromotionVO;

public interface VipPromotionMethodBLService {
	
	public ArrayList<VipPromotionVO> getVipMethod();
	public VipPromotionVO getVipMethod(int vipLevel);
	public String updateVipMethod(int level,VipPromotionVO vo);
}
