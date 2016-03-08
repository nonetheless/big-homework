package businesslogic.kindbl;



import po.KindPo;

import businesslogic.commoditybl.ChangeFromKind;
import businesslogic.commoditybl.CommodityOperator;
import businesslogicservice.kindblservice.KindblService;

public class KindController implements KindblService {
KindOperator kindOperator;
public KindController(){
	kindOperator=new KindOperator();
}
	public int addKind(KindPo po) {
		// TODO Auto-generated method stub
		return kindOperator.addKind(po);
	}

	public int delKind(KindPo po) {
		// TODO Auto-generated method stub
		return kindOperator.delKind(po);
	}

	public int changeKind(KindPo po,String oldName) {
		// TODO Auto-generated method stub
		return kindOperator.changeKind(po,oldName);
		
	}
	public KindPo get_root() {
		// TODO Auto-generated method stub
		return kindOperator.getWholeTree();
	}

	/*public ArrayList<KindPo> getKinds(KindPo po) {
		// TODO Auto-generated method stub
		return null;
	}*/
    public void delCommodityByKindName(String kindName){
    ChangeFromKind kind=new CommodityOperator();
    kind.delCommodityByKindName(kindName);
    }
    public void delCommodityByName(String comdName){
    ChangeFromKind kind=new CommodityOperator();
    kind.delCommodityByName(comdName);
    }
	public void changeComdKindName(String oldName, String newName) {
		// TODO Auto-generated method stub
		ChangeFromKind kind=new CommodityOperator();
		kind.changeComdKindName(oldName, newName);
		
	}
	public void init() {
		// TODO Auto-generated method stub
		kindOperator.init();
		kindOperator.initCommodity();
	}
	
    
    
}
