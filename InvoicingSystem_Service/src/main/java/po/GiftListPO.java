package po;

import java.io.Serializable;

public class GiftListPO extends MarketListPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GiftListPO(GoodsListPO po,String id,String memberId,String other
			,double price,String user,String member,String house,String saler){
		super(po, id, member, other, price, user, memberId, "KCZSD",house,saler);
		kind = 1;
	}
}