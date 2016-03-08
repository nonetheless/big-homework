package po;

public class StackListPO extends MarketListPO{
	/**
	 * 作为子类继承
	 */
	private static final long serialVersionUID = 1L;
	public StackListPO(GoodsListPO po,String id,String memberId,String saler,String house,String other
			,double price,String user,String member){
		super(po,id,member,other
			,price,user,memberId,"JHD",house,saler);
		this.house = house;
		this.saler = saler;
		kind = 3;
		
	}
	

	
	
}
