package vo;

import po.CommodityPo;

public class CommodityVo {

	private String kindName;
	private String numOfKind;
	private String nameOfCommodity;
	private String modelNum;
	private int numOfStock;
	private double avg_price;
	private double inPrice;
	private double outPrice;
	private double latestInPrice;
	private double latestOutPrice;
	private String batch;
	private String batch_Num;
	private String ex_date;
	private String storeHouse;
	private int alarmNum=100;

	
	public CommodityVo(String kindName,String numOfKind,String nameOfCommodity,
			String modelNum,int numOfStock,double avg_price,double inPrice,double outPrice,
			double latestInPrice,double latestOutPrice,String batch,String batch_Num,String ex_date,String storeHouse,int alarmNum){
		
		this.kindName=kindName;
		this.numOfKind=numOfKind;
		this.nameOfCommodity=nameOfCommodity;
		this.modelNum=modelNum;
		this.numOfStock=numOfStock;
		this.avg_price=avg_price;
		this.inPrice=inPrice;
		this.outPrice=outPrice;
		this.latestInPrice=latestInPrice;
		this.latestOutPrice=latestOutPrice;
		this.batch=batch;
		this.batch_Num=batch_Num;
		this.ex_date=ex_date;
		this.storeHouse=storeHouse;
		this.alarmNum=alarmNum;
	  	}
	
    public CommodityVo(CommodityPo po){
    	new CommodityVo(po.get_kindName(),po.get_numOfKind(),po.get_nameOfCommodity(),
    	po.get_modelNum(), po.get_numOfStock(),po.get_avg_price(),po.get_inPrice(),
    	po.get_OutPrice(),po.get_latestinPrice(),po.get_latestoutPrice(),po.get_batch(),
    	po.get_batch_Num(),po.get_ex_date(),po.get_storeHouse(),po.get_alarmNum());
    }
	
	
	
	public String get_kindName(){
		return kindName;
	}
	public String get_numOfKind(){
		return numOfKind;
	}
	public String get_nameOfCommodity(){
		return nameOfCommodity;
	}
	public String get_modelNum(){
		return modelNum;
	}
	public int get_numOfStock(){
		return numOfStock;
	}
	public double get_avg_price(){
		return avg_price;
	}
	public double get_inprice(){
		return inPrice;
	}
	public double get_outPrice(){
		return outPrice;
	}
	public double get_latestInPrice(){
		return latestInPrice;
	}
	public double get_latestOutPrice(){
		return latestOutPrice;
	}
	public String get_batch(){
		return batch;
	}
	public String get_batch_Num(){
		return batch_Num;
	}
	public String get_ex_date(){
		return ex_date;
	}
	public String get_storeHouse(){
		return storeHouse;
	}
	
	public int get_alarmNum(){
		return alarmNum;
	}
	
	
	
	public void set_comdName(String name){
		nameOfCommodity=name;
	}
	public void set_modelame(String num){
		nameOfCommodity=num;
	}
	public void set_Num(int num){
		numOfStock=num;
	}
	public void set_inprice(double inPrice){
		this.inPrice=inPrice;
	}
	public void set_outprice(double outPrice){
		this.outPrice=outPrice;
	}
	public void set_avgPrice(double avg){
		this.avg_price=avg;
	}
	public void set_latestIn(double in){
		this.latestInPrice=in;
	}
	public void set_latestOut(double out){
		this.latestOutPrice=out;
	}
	public void set_batch(String batch){
		this.batch=batch;
	}
	public void set_batchNum(String batchNum){
		this.batch_Num=batchNum;
	}
	public void set_exDate(String newDate){
		this.ex_date=newDate;
	}
	public void set_storeHouse(String house){
		this.storeHouse=house;
	}
	public void set_alarmNum(int num){
		this.alarmNum=num;
	}

	public String toString(){
		return kindName+";"+numOfKind+";"+nameOfCommodity+";"+modelNum+";"+numOfStock+";"
	  +avg_price+";"+inPrice+";"+outPrice+";"+latestInPrice+";"+latestOutPrice;
	}
	
}
