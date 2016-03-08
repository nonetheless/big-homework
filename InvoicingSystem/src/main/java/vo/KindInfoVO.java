package vo;
/*
 * Kind传送给Market的商品分类信息
 */

import java.util.ArrayList;

public class KindInfoVO {
	ArrayList<String> kind;
	ArrayList<String> id;
	public KindInfoVO(ArrayList<String> kind,ArrayList<String> id){
		this.kind = kind;
		this.id = id;
	}
	
	public ArrayList<String> getKind(){
		return kind;
	}
	
	public ArrayList<String> getCommodityId(){
		return id;
	}


}
