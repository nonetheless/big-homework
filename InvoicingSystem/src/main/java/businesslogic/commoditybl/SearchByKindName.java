package businesslogic.commoditybl;

import java.util.ArrayList;

import vo.CommodityVo;

public class SearchByKindName implements Search {
String info=null;
public SearchByKindName(String info){
	this.info=info;
}
	public ArrayList<CommodityVo> searchBySomeWay(ArrayList<CommodityVo> list) {
		// TODO Auto-generated method stub
		ArrayList<CommodityVo> resultList=new ArrayList<CommodityVo>();
		int length=list.size();
		for(int i=0;i<length;i++){
			CommodityVo temp=list.get(i);
			if(temp.get_kindName().equals(info)){
				resultList.add(temp);
			}
		}
		
		return resultList;
	}

}
