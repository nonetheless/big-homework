package businesslogicservice.promotionblservice;

import java.util.ArrayList;
import vo.PkgVO;

public interface PkgPromotionBLService {
	
	public ArrayList<PkgVO> getPkgList();
	public PkgVO getPkgGoods(String id);
	public String addPkg(PkgVO vo);
	public String delPkg(String id);
	public String editPkg(PkgVO vo);
}
