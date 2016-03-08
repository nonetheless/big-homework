package businesslogic.promotionbl;

import java.util.ArrayList;

import businesslogicservice.promotionblservice.PkgPromotionBLService;
import vo.PkgVO;

public class PkgPromotionController implements PkgPromotionBLService{
	
	PkgPromotion pp;
	
	public PkgPromotionController(){
		pp=new PkgPromotion();
	}
	
	//PkgPromotion
	public ArrayList<PkgVO> getPkgList(){
		return pp.getPkgList();
	}
	
	public PkgVO getPkgGoods(String id){
		return pp.getPkgGoods(id);
	}
	
	public String addPkg(PkgVO vo){
		return pp.addPkg(vo);
	}
	
	public String delPkg(String id){
		return pp.delPkg(id);
	}
	
	public String editPkg(PkgVO vo){
		return pp.editPkg(vo);
	}

}
