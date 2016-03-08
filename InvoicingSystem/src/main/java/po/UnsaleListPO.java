package po;

import java.io.Serializable;
import java.util.ArrayList;

public class UnsaleListPO extends MarketListPO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UnsaleListPO(GoodsListPO po,String id,String memberId,String saler,String house,String other
			,double price,String user,String member){
		super(po,id,member,other
			,price,user,memberId,"XSTHD",house,saler);
		this.house = house;
		this.saler = saler;
		kind = 2;
	}
}
