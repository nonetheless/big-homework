package presentation.marketui;

import java.util.ArrayList;

import javax.swing.JFrame;

import uidialog.GggFrame;
import vo.BuyingVO;
import vo.BuyingsVO;
import vo.InformationVO;
import vo.ListVO;
import vo.PromotionListVO;
import vo.ShowListVO;
import businesslogic.marketbl.MarketControl;
import businesslogic.memberbl.MemberControl;
import businesslogicservice.marketblservice.MarketBLService;
import businesslogicservice.memberblservice.MemberBLService;

/**
 * 
 * @author xinlin
 *market的跳转逻辑,包括购物车
 */
public class MarketCtrl {
	int y;//通过单据的数量
	int n;//未通过单据的数量
	String memberName;
	String memberId;
	String house;
	String user;
	String other;
	int kind;
	String saler;
	MarketBLService mar;
	MemberBLService mem;
	String now;
	String now2;
	BuyingsVO buying;
	ListPanel mylist;
	ArrayList<String[]> goodList;
	double all;
	double pro;
	double gift;
	int paper;
	APanel ap;
	double pro1;
	JFrame listFrame;
	public MarketCtrl(String saler) {
		//初始化CTRL
		now = "灯具";
		mar = new MarketControl();
		mem = new MemberControl();
		this.saler = saler;
		memberName = "";
		memberId = "";
		house = "";
		user = saler;
		kind = 1;// 四种销售模式
		int e[] = mar.check();
		y = e[0];
		n = e[1];
		goodList = new ArrayList<String[]>();
		all = 0;
		pro = 0;
		gift = 0;
		paper = 0;
	}
	
	public String getName(){
		return memberName;
	}
	
	public String getId(){
		return memberId;
	}
	
	public String getSaler(){
		return saler;
	}
	
	public String getUser(){
		return user;
	}
	
	public String getOther(){
		return other;
	}
	
	public String getHouse(){
		return house;
	}
	
	public int getKind(){
		return kind;
	}
	
	public void setName(String a){
		memberName = a;
	}
	
	public void setId(String a){
		memberId = a;
	}
	
	public void setHouse(String a){
		house = a;
	}
	
	public void setSaler(String a){
		saler = a;
	}
	
	public void setOther(String a){
		other = a;
	}
	
	public void setKind(int a){
		kind = a;
	}

	public String getM(String text) {
		//获得Memberid
		return mem.find(text);
	}

	public String send(int t) {
		// 发送单据给bl
		kind = t;
		InformationVO vo = new InformationVO(memberName,memberId,house,user,other,t,saler);
		return mar.inputinf(vo);
	}

	public int[] getPass() {
		// 查看通过单据的数量
		
		int []d = mar.check();
		return d;
	}
	
	public String[][] showPass(){
		ArrayList<ShowListVO> v = mar.showList(0);
		ArrayList<ShowListVO> v1 = mar.showList(1);
		String back[][] = new String[v1.size()+v.size()][5];
		for(int i=0;i<v.size();i++){
			myAdd(back,i,"不通过",v.get(i));
		}
		for(int i=0;i<v1.size();i++){
			myAdd(back,i+v.size(),"通过",v1.get(i));
		}
		return back;
	}

	private void myAdd(String[][] back, int i, String string,ShowListVO v) {
		// 变为显示数组
		back[i][0] = string;
		back[i][1] = v.getId();
		back[i][2] = v.getMId();
		back[i][3] = v.getMname();
		back[i][4] = Double.toString(v.getPrice());
		
	}

	public String sendToManager() {
		// 确认订单传给总经理
		return mar.sure();
		
		
	}

	public ArrayList<String> getGoodsK() {
		// 返回类型
		upd(now);
		ArrayList<String> str = new ArrayList<String>();
		str = buying.getFile();
		return str;
	}

	private void upd(String now) {
		// 更新商品表
		buying = mar.listenter(now);
	}

	public ArrayList<String> getGoods() {
		// 返回商品名字
		upd(now);
		ArrayList<String> str = new ArrayList<String>();
		ArrayList<BuyingVO> good = buying.getCommodity();
		for(int i=0;i<good.size();i++){
			BuyingVO m = good.get(i);
			str.add(m.getName());
		}
		return str;
	}
	
	public void setNow(String s){
		//更新了CTRL保存 的商品状态
		now = s;
	}

	public String[] getBuyingInfo() {
		//将buying分解
		try{
		BuyingVO m = findBuying(now);
		String[] end = new String[5];
		end[0] = m.getId();
		end[1] = m.getName();
		end[2] = m.getKind();
		end[3] = Double.toString(m.getPrice());
		end[4] = Integer.toString(m.getNumber());
		return end;
		}
		catch (NullPointerException e){
			e.printStackTrace();
		}
		return null;
	}

	private BuyingVO findBuying(String now2) {
		// 查找Buying
		ArrayList<BuyingVO> m = buying.getCommodity();
		for(int i = 0;i<m.size();i++){
			BuyingVO m1 = m.get(i);
			if(now2.equals(m1.getName())){
				return m1;
			}
		}
		return null;
	}

	public String getGoodsId(int num) {
		// 查找id
		ArrayList<BuyingVO> m = buying.getCommodity();
		BuyingVO m1 = m.get(num);
		return m1.getId();
	}
	
	public String getGoodsKind(int num) {
		// 查找kind
		ArrayList<BuyingVO> m = buying.getCommodity();
		BuyingVO m1 = m.get(num);
		return m1.getKind();
	}
	
	public String getGoodsPrice(int num) {
		// 查找price
		ArrayList<BuyingVO> m = buying.getCommodity();
		BuyingVO m1 = m.get(num);
		return Double.toString(m1.getPrice());
	}
	
	public String getGoodsNum(int num) {
		// 查找price
		ArrayList<BuyingVO> m = buying.getCommodity();
		BuyingVO m1 = m.get(num);
		return Integer.toString(m1.getNumber());
	}
	
	public int FindGood(String id){
		ArrayList<BuyingVO> m = buying.getCommodity();
		for(int i=0;i<m.size();i++){
			BuyingVO m1 = m.get(i);
			if(m1.getName().equals(id)){
				return i;
			}
		}
		return -1;
	}

	public void add(ListPanel listPanel) {
		//添加list
		this.mylist= listPanel;
	}

	public String addGood(String[] end,int nn) {
		//添加购物车的方法
		for(int i = 0;i<goodList.size();i++){
			if(end[0].equals(goodList.get(i)[0])){
				return "false";
			}
		}
		if(nn<Integer.parseInt(end[4].trim())&&((kind==1)||(kind==4))){
			return "库存不足";
		}
		goodList.add(end);// 保存于桌面
		String[][] list = mylist.getList();
		if(list!=null){
		String[][] list1 = new String[list.length+1][6];
		for(int i=0;i<list.length;i++){
			list1[i] = list[i];
		}
		list1[list.length] = end;
		mylist.updList(list1);
		}
		else{
			String [][]then = {end};
			mylist.updList(then);
		}
		all = all +Double.parseDouble(end[3].trim())*Integer.parseInt(end[4].trim());
		return mar.listadd(end[0], Double.parseDouble(end[3].trim()), Integer.parseInt(end[4].trim()));
	}

	public String delList(String id,String price,String num) {
		//删除商品列表
		int leng= goodList.size();
		String a = mar.listdel(id, 0, 0);
		if(a.equals("false")){
			return a;
		}
		for(int i = 0;i<leng;i++){
			if(id.equals(goodList.get(i)[0])){
				goodList.remove(i);
				String [][] m = new String[leng-1][6];
				for(int j=0;j<leng-1;j++){
					m[j] = goodList.get(j);
				}
				mylist.updList(m);
				all = all -Double.parseDouble(price.trim())*Integer.parseInt(num.trim());
				return "success";
			}
		}
	    return "false1";
		
		
	}

	public String updList(String id, int goodnum, double goodprice) {
		// 更新商品列表
		//判断库存是否充足
		int leng= goodList.size();
		String a = mar.listupd(id, goodprice, goodnum);
		if(a.equals("false")){
			return a;
		}
		for(int i = 0;i<leng;i++){
			if(id.equals(goodList.get(i)[0])){
				double rr = goodprice*goodnum - Double.parseDouble(goodList.get(i)[5]);
				goodList.get(i)[3] = Double.toString(goodprice);
				goodList.get(i)[4] = Integer.toString(goodnum);
				goodList.get(i)[5] = Double.toString(goodprice*goodnum);
				String [][] m = new String[leng][6];
				for(int j=0;j<leng;j++){
					m[j] = goodList.get(j);
				}
				mylist.updList(m);
				all = all+rr;
				return "success";
			}
		}
		return "false1";
	}

	public String getBack() {
		// 得到向上菜单
		now = mar.kindBack(now);
		buying = mar.listenter(now);
		return now;
	}

	public PromotionListVO getPro() {
		// 获取赠品单
		return mar.getpro();
	}

	public void endList(int paper2, double gift2, double pro2,double pro) {
		////折扣金额，礼物折扣，策略折扣，销售员折扣
		paper = paper2;
		gift = gift2;
		this.pro = pro2;
		this.pro1 = pro;
		if(kind==1){
		mar.reduce(pro);
		mar.usePaper(paper, 1);
		}
		//改变marketframe
		ap.endList();
		listFrame.dispose();
	}

	public void addAPanel(APanel aPanel) {
		//得到market的对象
		ap = aPanel;
	}

	public void addFrame(GggFrame frame) {
		listFrame  = frame; 
		
	}

	public String[][] getFree(ListVO li) {
		//显示赠品单
		if(li!=null){
			return getView(li);
		}
		PromotionListVO m = mar.showFree();
		return getView(m.getList());
	}
	
	private String[][] getView(ListVO li) {
		// 获取List的显示
		ArrayList<BuyingVO> m = li.getCommodity();
		String [][] end  = new String[m.size()+1][6];
		for(int i = 0;i<m.size();i++){
			end[i] = getSingle(m.get(i));
		}
		end[m.size()][0] = "合计";
		end[m.size()][5] = Double.toString(li.getall());
		return end;
	}

	private String[] getSingle(BuyingVO b) {
		// 改变单行
		String [] back = {b.getId(),b.getName(),b.getKind(),Integer.toString(b.getNumber()),Double.toString(b.getPrice()),Double.toString(b.getPrice()*b.getNumber())};
		return back;
	}

	public String[][] getList() {
		// 显示商品单
		ListVO a = mar.listshow();
		return getView(a);
	}
	
	public String reRedu(double d){
		return mar.reduce(d);
	}

}
