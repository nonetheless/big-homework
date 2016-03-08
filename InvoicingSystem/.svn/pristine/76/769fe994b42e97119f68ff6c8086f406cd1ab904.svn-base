package businesslogic.promotionbl;

import java.util.ArrayList;

import businesslogic.commoditybl.CommodityOperator;
import businesslogic.commoditybl.CommodityProvider;
import vo.PkgVO;

public class PkgPromotion{
	
	CommodityProvider cp;
	
	public PkgPromotion(){
		cp=new CommodityOperator();
	}

	public ArrayList<PkgVO> getPkgList() {
		// TODO Auto-generated method stub
		return cp.getAllPkgs();
	}

	public PkgVO getPkgGoods(String id) {
		// TODO Auto-generated method stub
		return cp.get_Pkg(id);
	}

	public String addPkg(PkgVO vo) {
		// TODO Auto-generated method stub
		int i=cp.addPkg(vo);
		String str=null;
		if(i==1){
			str="Succeed";
		}
		else if(i==-1){
			str="Fail";
		}
		return str;
	}

	public String delPkg(String id) {
		// TODO Auto-generated method stub
		int i=cp.delPkg(id);
		String str=null;
		if(i==1){
			str="Succeed";
		}
		else if(i==-1){
			str="Fail";
		}
		return str;
		
	}

	public String editPkg(PkgVO vo) {
		// TODO Auto-generated method stub
		int i=cp.changePkg(vo);
		System.out.println("i "+i);
		String str=null;
		if(i==1){
			str="Succeed";
		}
		else if(i==-1){
			str="Fail";
		}
		return str;
	}
}
