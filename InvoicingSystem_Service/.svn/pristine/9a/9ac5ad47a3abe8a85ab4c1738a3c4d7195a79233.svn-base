package po;

import java.io.Serializable;
import java.util.ArrayList;

public class GoodsListPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<GoodLinePO> list;
	double price;
	public GoodsListPO(ArrayList<GoodLinePO> x, double price2) {
		//存储总价
		this.price = price2;
		list = x;
	}
	
	public double getAllPrice(){
		return price;
	}
	
	public ArrayList<GoodLinePO> getList(){
		return list;
	}

}
