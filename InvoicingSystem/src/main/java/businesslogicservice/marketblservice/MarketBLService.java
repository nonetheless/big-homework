package businesslogicservice.marketblservice;

import java.util.ArrayList;

import vo.BuyingsVO;
import vo.InformationVO;
import vo.ListVO;
import vo.PromotionListVO;
import vo.ShowListVO;

public interface MarketBLService {
	public String inputinf(InformationVO info);
	public String listadd(String commodity ,double value,int number);
	public String listdel(String commodity ,double value,int number);
	public String listupd(String commodity ,double value,int number);
	public ListVO listshow();
	public BuyingsVO listenter(String commodity);
	public String kindBack(String string);//返回上一个kind
	public String reduce(double price);//销售人员让价
	public String sure();
	public PromotionListVO showFree();//查看赠品单
	public String usePaper(int paper, int num);
	public PromotionListVO getpro();
	public String unsalediscount(boolean m);//是否退折扣
	public ArrayList<ShowListVO> showList(int i);
	public int[] check();//查看是否有单据通过或者未通过
}
