package po;

import java.io.Serializable;

public class SaleNotePo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String kindNum;
	private int number;
	private double inPrice;
	private double outPrice;
	private String time;
	
	public SaleNotePo(String kindNum,int number,double inPrice,
			double outPrice,String time){
		
		this.kindNum=kindNum;
		this.number=number;
		this.inPrice=inPrice;
		this.outPrice=outPrice;
		this.time=time;
	}
	public String get_kindNum(){
		return kindNum;
	}
	
	public int get_number(){
		return number;
	}
	public double get_inPrice(){
		return inPrice;
	}
	public double get_outPrice(){
		return outPrice;
	}
	public String get_time(){
		return time;
	}
	
}
