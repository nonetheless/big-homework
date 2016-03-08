package po;

public class MarketListPO extends BillPO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	GoodsListPO po;
	String memberId;
	String other;
	double price;
	String member;
	String house,saler;
	int kind;
	public MarketListPO(GoodsListPO po,String id,String member,String other
			,double price,String user,String memberId,String kind,String house,String saler){
		super.setType(kind);
		super.setOperator(user);
		super.setIdentifier(id);
		this.po = po;
		this.memberId = memberId;
		this.other = other;
        this.price = price;
		this.member = member;
		this.house = house;
		this.saler = saler;
	}
	
	public GoodsListPO getList(){
		return this.po;
	}
	
	public String getMemberId(){
		return this.memberId;
	}
	
	public String getMemberName(){
		return this.member;
	}
	
	public String getOther(){
		return this.other;
	}
	
	
	
	public double getPrice(){
		return this.price;
	}
	
	public int getKind(){
		return kind;
	}

	public String getSaler(){
		return this.saler;
	}
	
	public String getHouse(){
		return this.house;
	}


}
