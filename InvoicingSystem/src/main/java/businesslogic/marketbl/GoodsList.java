package businesslogic.marketbl;

import java.util.ArrayList;

import po.GoodLinePO;
import po.GoodsListPO;
import vo.BuyingVO;
import vo.ListVO;
import vo.MarketCommodityVO;
import vo.ProinfoVO;

public class GoodsList {
	ArrayList<GoodLine> list;
	public GoodsList(){
		list = new ArrayList<GoodLine>();
	}

	public GoodsList(ArrayList<BuyingVO> x) {
		//根据赠品单创建单据
		this();
		if(x!=null){
		for(int i=0;i<x.size();i++){
			GoodLine te =  new GoodLine(x.get(i));
			list.add(te);
		}
		}
	}

	public GoodsList(GoodsListPO list2) {
		// 根据PO创建单子，用与减少或者增加商品
		this();
		ArrayList<GoodLinePO> tem = list2.getList();
		for(int i=0;i<tem.size();i++){
			GoodLine te =  new GoodLine(tem.get(i));
			list.add(te);
		}
	}

	public String listadd(String commodity, double value, int number) {
		//添加一项iteam
		int b = search(commodity);
		if(b==-1){
			GoodLine temp = new GoodLine(commodity, value,number);
			list.add(temp);
			return "success";
		}
		return "false";
	}

	private int search(String commodity) {
		//查看是否有该商品，没有返回-1，有返回下标
		for(int i=0;i<list.size();i++){
			GoodLine temp = list.get(i);
			System.out.println(temp.commodity+"ddd");
			if(temp.commodity.equals(commodity)){
				return i;
			}
		}
		return -1;
	}

	public String listdel(String commodity, double value, int number) {
		// 删除一项iteam
		int b = search(commodity);
		System.out.println(commodity+"x");
		if(b==-1){
			return "false";
		}
		list.remove(b);
		return "success";
	}

	public String upd(String commodity, double value, int number) {
		// 更新一项iteam
		int b = search(commodity);

		if(b==-1){
			return "false";
		}
		GoodLine x =list.get(b);
		x.change(value,number);
		return "success";
	}

	public ListVO show(){
		// 返回list
		double all = cal();
		ArrayList<BuyingVO> te = new ArrayList<BuyingVO>();
		for(int i=0;i<list.size();i++){
			GoodLine tem = list.get(i);
			te.add(tem.show());
		}
		ListVO l = new ListVO(te,all);
		
		return l;
	}

	public double cal() {
		// 返回总价
		double all = 0;
		for(int i=0;i<list.size();i++){
			all = all+list.get(i).getNum() * list.get(i).getPrice();
		}
		return all;
	}

	public GoodsListPO createPO() {
		// 生成PO
		ArrayList<GoodLinePO> x = new ArrayList<GoodLinePO>();
		double price = 0;
		for(int i=0;i<list.size();i++){
			GoodLine temp = list.get(i);
			price = price + temp.getPrice() * temp.getNum();
			x.add(temp.createPO());
		}
		GoodsListPO ne = new GoodsListPO(x,price);
		return ne;
	}

	public String reduCommodity(int k) {
		// 减少商品
		String back = "false";
		System.out.println("reduceCommodity");
		for(int i=0;i<list.size();i++){
			GoodLine te = list.get(i);
			back = te.reduCommodity(k);
		}
		return back;
	}

	public String addCommodity(int k) {
		// 增加商品项
		String back = "false";
		for(int i=0;i<list.size();i++){
			GoodLine te = list.get(i);
			back = te.addCommodity(k);
		}
		return back;
	}

	public ArrayList<MarketCommodityVO> createCommodityVo() {
		// 得到商品vo返回
		ArrayList<MarketCommodityVO>  m = new ArrayList<MarketCommodityVO>();
		for(int i=0;i<list.size();i++){
			GoodLine se = list.get(i);
			m.add(se.createCommodityVo(0));
		}
		return m;
	}
	


}
