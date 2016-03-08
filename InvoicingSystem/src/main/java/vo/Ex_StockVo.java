package vo;

public class Ex_StockVo {
int outNum;
double outMoney;
int inNum;
double inMoney;
public Ex_StockVo(int outNum,double outMoney,int inNum,double inMoney){
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
public String toString(){
return	"出库数量:"+outNum+" "+"出库金额合计:"+outMoney+" "+"入库数量"+inNum+" "+"入库金额合计："+inMoney;
}


}
