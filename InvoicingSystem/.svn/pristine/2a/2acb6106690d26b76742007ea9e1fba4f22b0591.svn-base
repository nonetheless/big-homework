package businesslogic.commoditybl;

import java.util.ArrayList;

import vo.CommodityVo;

public class SearchByComdName implements Search {
String info=null;
public SearchByComdName(String info){
	this.info=info;
}

	public ArrayList<CommodityVo> searchBySomeWay(ArrayList<CommodityVo> list) {
		// TODO Auto-generated method stub
		int length=list.size();
		
		ArrayList<CommodityVo> resultList=new ArrayList<CommodityVo>();
		for(int i=0;i<length;i++){
			CommodityVo temp=list.get(i);
			if(temp.get_nameOfCommodity().equals(info)){
				resultList.add(temp);
			}
			
		}
      
		return resultList;
		
	}
    public void set_Name(String info){
    	this.info=info;
    }
	
	
}
