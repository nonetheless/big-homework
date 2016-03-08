package po;

import java.io.Serializable;

public class Ex_StockPo implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
int outNum;
double outMoney;
int inNum;
double inMoney;
public Ex_StockPo(int outNum,double outMoney,int inNum,double inMoney){
	this.outNum=outNum;
	this.outMoney=outMoney;
	this.inNum=inNum;
	this.inMoney=inMoney;
}
public int get_outNum(){
	return outNum;
}
public double get_outMoney(){
	return outMoney;
}
public int get_inNum(){
	return inNum;
}
public double get_inMoney(){
	return inMoney;
}

}
