package businesslogic.promotionbl;

import java.util.ArrayList;
import vo.VipPromotionVO;
import businesslogicservice.promotionblservice.VipPromotionMethodBLService;

public class VipPromotionMethodController implements VipPromotionMethodBLService{
	
	VipPromotionMethod vpm;
	
	public VipPromotionMethodController(){
		vpm=new VipPromotionMethod();
	}

	public ArrayList<VipPromotionVO> getVipMethod() {
		// TODO Auto-generated method stub
		return vpm.getVipMethod();
	}
	
	public VipPromotionVO getVipMethod(int vipLevel) {
		// TODO Auto-generated method stub
		return vpm.getVipMethod(vipLevel);
	}

	public String updateVipMethod(int level, VipPromotionVO vo) {
		// TODO Auto-generated method stub
		return vpm.updateVipMethod(level, vo);
	}
	
}
