package businesslogic.marketbl;
/*
 * @ggg
 * Market端的委托中心
 */

import java.util.ArrayList;

import vo.BuyingsVO;
import vo.InformationVO;
import vo.ListVO;
import vo.PromotionListVO;
import vo.PromotionVO;
import vo.ShowListVO;
import businesslogicservice.marketblservice.MarketBLService;

public class MarketControl implements MarketBLService{

	Check ch;
	Market ma;
	public MarketControl(){
		ma = new Market();
		ch = new Check();
	}
	public String inputinf(InformationVO info) {
		//从ui获取输入信息
		
		return ma.inputinf(info);
	}

	public String listadd(String commodity, double value, int number) {
		// 加入购物车
		return ma.listadd(commodity, value, number);
	}

	public String listdel(String commodity, double value, int number) {
		// reduce购物车
		return ma.listdel(commodity, value, number);
	}

	public String listupd(String commodity, double value, int number) {
		// 更新购物车
		return ma.listupd(commodity, value, number);
	}

	public ListVO listshow() {
		//查看购物车
		return ma.listshow();
	}

	public BuyingsVO listenter(String commodity) {
		// 通过点击查看商品子目录

		return ma.listenter(commodity);
	}


	public String reduce(double price) {
		//销售人员折扣
		return ma.reduce(price);
	}

	public String sure(){
		// 确认清单单据
		return ma.sure();
	}

	public PromotionListVO showFree() {
		//查看赠品
		return ma.showFree();
	}
	
	public String usePaper(int paper,int num){
		return ma.usePaper(paper,num);
	}
	public PromotionListVO getpro() {
		//得到促销
		return ma.getpro();
	}
	public String unsalediscount(boolean m) {
		// 是否退折扣
		return ma.unsalediscount(m);
	}
	public ArrayList<ShowListVO> showList(int i) {
		// 查看通过的单据或者未通过的单据
		return ch.show(i);
	}
	public int[] check() {
		// 查看有没有单据通过,0是通过的，1是没通过的
		return ch.check();
	}
	public String kindBack(String string) {
		// 返回kind
		return ma.kindBack(string);
	}

}
