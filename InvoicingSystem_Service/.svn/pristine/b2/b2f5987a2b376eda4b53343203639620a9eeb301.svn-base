package data.marketdata;
/*
 * @ggg
 * market的数据层，提供方法
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;

import po.GiftListPO;
import po.GoodLinePO;
import po.GoodsListPO;
import po.MarketListPO;
import po.MemberPO;
import po.SaleListPO;
import po.StackListPO;
import po.UnsaleListPO;
import po.UnstackListPO;


public class MarketData <T extends MarketListPO>{
	String sale,unsale,stack,gift,unstack,sale1,unsale1,stack1,gift1,unstack1,sale2,unsale2,stack2,gift2,unstack2;
	ArrayList<SaleListPO> list1,list1n,list1y;
	ArrayList<StackListPO> list2,list2n,list2y;
	ArrayList<UnsaleListPO> list3,list3n,list3y;
	ArrayList<UnstackListPO> list4,list4n,list4y;
	ArrayList<GiftListPO> list5,list5n,list5y;
	public MarketData(){
		sale = "file/sale.txt";
		unsale = "file/unsale.txt";
		stack = "file/stack.txt";
		unstack = "file/unstack.txt";
		gift = "file/gift.txt";
		sale1 = "file/sale1.txt";
		unsale1 = "file/unsale1.txt";
		stack1 = "file/stack1.txt";
		unstack1 = "file/unstack1.txt";
		gift1 = "file/gift1.txt";
		sale2 = "file/sale2.txt";
		unsale2 = "file/unsale2.txt";
		stack2= "file/stack2.txt";
		unstack2 = "file/unstack2.txt";
		gift2 = "file/gift2.txt";
		boolean m = true;
		list1 = read(sale,list1);
		list2 = read(stack,list2);
		list3 = read(unsale,list3);
		list4 = read(unstack,list4);
	    list5 = read(gift,list5);
	    list1n = read(sale1,list1n);
		list2n = read(stack1,list2n);
		list3n = read(unsale1,list3n);
		list4n = read(unstack1,list4n);
	    list5n = read(gift1,list5n);
	    list1y = read(sale2,list1y);
		list2y = read(stack2,list2y);
		list3y = read(unsale2,list3y);
		list4y = read(unstack2,list4y);
	    list5y = read(gift2,list5y);
	}
	private <T extends MarketListPO> ArrayList<T> read(String sale2,ArrayList<T> list) {
		// 读文件
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(new FileInputStream(sale2));
			list = (ArrayList<T>)ois.readObject();
			if(list==null){
				list = new ArrayList<T>();
			}
			ois.close();
			return list;
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			list = new ArrayList<T>();
			return list;
		}
		return null;
	}
	public ArrayList<SaleListPO> findSale(String start, String end,
			String thingid, String memberid, String salerid, String house) {	
		//销售单
		return find(list1, start, end, thingid, memberid, salerid, house);
	}

	public ArrayList<StackListPO> findStack(String start, String end,
			String thingid, String memberid, String salerid, String house) {
		// 进货单
		return find(list2, start, end, thingid, memberid, salerid, house);
	}

	public ArrayList<UnsaleListPO> findUnsale(String start, String end,
			String thingid, String memberid, String salerid, String house) {
		// 销售退货单
		return find(list3, start, end, thingid, memberid, salerid, house);
	}

	public ArrayList<UnstackListPO> findUnstack(String start, String end,
			String thingid, String memberid, String salerid, String house) {
		// 退货单
		return find(list4, start, end, thingid, memberid, salerid, house);
	}

	public ArrayList<GiftListPO> findGift(String start, String end,
			String thingid, String memberid, String salerid, String house) {
		//赠品单
		return find(list5, start, end, thingid, memberid, salerid, house);
	}

	public String insertSale(SaleListPO po,int ok) {
		// 插入销售
		if(ok==1){
		return insert(list1y,po);
		}
		return insert(list1n,po);
	}

	public String insertGift(GiftListPO po,int ok) {
		// 插入赠品
		if(ok==1){
			return insert(list5y,po);
			}
			return insert(list5n,po);
	}

	public String insertStack(StackListPO po,int ok) {
		// 插入进货
		if(ok==1){
			return insert(list2y,po);
			}
			return insert(list2n,po);
	}

	public String insertUnsale(UnsaleListPO po,int ok) {
		// 插入销售退货
		if(ok==1){
			return insert(list3y,po);
			}
			return insert(list3n,po);
	}

	public String insertUnstack(UnstackListPO po,int ok) {
		//插入退货
		if(ok==1){
			return insert(list4y,po);
			}
			return insert(list4n,po);
	}
	
	private <T extends MarketListPO> ArrayList<T> find(ArrayList<T> list,String start, String end,
			String thingid, String memberid, String salerid, String house){
		//通过泛型来实现
		ArrayList<T> tem = new ArrayList<T>();
		if(!start.equals("no")){
		tem = timeGet(list,tem,start,end);
		}
		if(!memberid.equals("no")){
		tem = memberGet(list,tem,memberid);

		}
		if(!salerid.equals("no")){
		tem = salerGet(list,tem,memberid);

		}
		if(!house.equals("no")){
			tem = houseGet(list,tem,memberid);	

		}
		if(!thingid.equals("no")){
			tem = thingGet(list,tem,memberid);	
		}
		if((start.equals("no"))&&(memberid.equals("no"))&&(salerid.equals("no"))&&(house.equals("no"))&&(thingid.equals("no"))){
			for(int i=0;i<list.size();i++){
				tem.add(list.get(i));
			}
		}
		return tem;
	}
	
	private <T extends MarketListPO> ArrayList<T> salerGet(ArrayList<T> list,ArrayList<T> aim,String member){
	//客户
		for(int i=0;i<list.size();i++){
			T mm = list.get(i);
			String saler = mm.getSaler();
			if(saler.equals(member)){
				aim.add(mm);
			}
		}
		return aim;
	}
	
	private <T extends MarketListPO> ArrayList<T> houseGet(ArrayList<T> list,ArrayList<T> aim,String house1){
		//仓库
		for(int i=0;i<list.size();i++){
			T mm = list.get(i);
			String house = mm.getHouse();
			if(house.equals(house1)){
				aim.add(mm);
			}
		}
		return aim;
	
	}
	
	private <T extends MarketListPO> ArrayList<T> thingGet(ArrayList<T> list,ArrayList<T> aim,String thing){
		//商品
		for(int i=0 ;i<list.size();i++){
			T mm = list.get(i);
			GoodsListPO temp= mm.getList();
			if(goodCheck(temp,thing)){
				aim.add(mm);
			}
			
		}
		return aim;
	}
	
	private boolean goodCheck(GoodsListPO temp,String id) {
		// 判断商品id 是否包含在内
		ArrayList<GoodLinePO> t = temp.getList();
		for(int i = 0;i<t.size();i++){
			GoodLinePO tt = t.get(i);
			if(tt.getId().equals(id)){
				return true;
			}
		}
		return false;
	}
	private <T extends MarketListPO> ArrayList<T> memberGet(ArrayList<T> list,ArrayList<T> aim,String member){
		//根据客户查找
		for(int i=0;i<list.size();i++){
			T mm = list.get(i);
			String id = mm.getMemberId();
			if(id.equals(member)){
				aim.add(mm);
			}
		}
		return aim;
	}
	
	private <T extends MarketListPO> ArrayList<T> timeGet(ArrayList<T> list,ArrayList<T> aim,String start, String end){
		//根据时间查找
		for(int i = 0;i<list.size();i++){
			T x = list.get(i);
			String[] m = x.getIdentifier().split("-");
			String a = m[1]+"-"+m[2]+"-"+m[3];
			if(timeOk(a,start,end)){
				aim.add(x);
			}
		}
		return aim;
		
	}
	
	
	
	private boolean timeOk(String a, String start, String end) {
		// 判断时间是否符合
		try{
		long m = createTime(a);
		long m1 = createTime(start);
		long m3 = createTime(end);
		if((m<m3)&&(m>m1)){
			return true;
		}
		else{
			return false;
		}
		}
		catch(NullPointerException e){
			e.printStackTrace();
		}
		return false;
	}
	private long createTime(String a) throws NullPointerException{
		//把String变成date
		String k[] = a.split("-");
		if(k.length!=3){
			throw new NullPointerException();
		}
		int w1 = Integer.parseInt(k[0])-1900;
		int w2 = Integer.parseInt(k[1])-1;
		int w3 = Integer.parseInt(k[2]);
		Date over =  new Date(w1,w2,w3);
		return over.getTime();
	}
	private <T extends MarketListPO> String insert(ArrayList<T> list,T m){
		list.add(m);
		return "success";
	}
	
	public String store(){
		boolean test = true;
		test = test&write(list1,sale);
		test = test&write(list2,stack);
		test = test&write(list3,unsale);
		test = test&write(list4,unstack);
		test = test&write(list5,gift);
		test = test&write(list1n,sale1);
		test = test&write(list2n,stack1);
		test = test&write(list3n,unsale1);
		test = test&write(list4n,unstack1);
		test = test&write(list5n,gift1);
		test = test&write(list1y,sale2);
		test = test&write(list2y,stack2);
		test = test&write(list3y,unsale2);
		test = test&write(list4y,unstack2);
		test = test&write(list5y,gift2);
		if(test){
			return "success";
		}
		return "false";
	}
	
	private <T extends MarketListPO>boolean write(ArrayList<T> list,String name){
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(name));
			oos.writeObject(list);
			oos.close();
			return true;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	public void firstWrite(){
		ArrayList<SaleListPO> o = new ArrayList<SaleListPO>();
		ArrayList<StackListPO> o1 = new ArrayList<StackListPO>();
		ArrayList<UnsaleListPO> o2= new ArrayList<UnsaleListPO>();
		ArrayList<UnstackListPO> o3 = new ArrayList<UnstackListPO>();
		ArrayList<GiftListPO> o4 = new ArrayList<GiftListPO>();
		write(o,sale);
		write(o1,stack);
		write(o2,unsale);
		write(o3,unstack);
		write(o4,gift);
		write(o,sale1);
		write(o1,stack1);
		write(o2,unsale1);
		write(o3,unstack1);
		write(o4,gift1);
		write(o,sale2);
		write(o1,stack2);
		write(o2,unsale2);
		write(o3,unstack2);
		write(o4,gift2);
		
	}
	public int[] check() {
		// 查看有没有审批的单据
		int[] z = new int[2];
		z[0] = 0;
		z[1] = 0;
		z[0] = list1y.size()+list2y.size()+list3y.size()+list4y.size()+list5y.size();
		z[1] = list1n.size()+list2n.size()+list3n.size()+list4n.size()+list5n.size();
		return z;
	}
	public ArrayList<MarketListPO> showList(int i) {
		// 展示单据
		System.out.println(i);
		System.out.println(list5.size()+"PPPPe");
		System.out.println(list5y.size()+"PPPPe");
		System.out.println(list5n.size()+"PPPPe");
		ArrayList<MarketListPO> back = new ArrayList<MarketListPO>();
		if(i==0){
			addBack(back,list1n);
			addBack(back,list2n);
			addBack(back,list3n);
			addBack(back,list4n);
			addBack(back,list5n);
		}
		if(i==1){
			setToNull(list1,list1y);
			setToNull(list2,list2y);
			setToNull(list3,list3y);
			setToNull(list4,list4y);
			setToNull(list5,list5y);
			addBack(back,list1y);
			addBack(back,list2y);
			addBack(back,list3y);
			addBack(back,list4y);
			addBack(back,list5y);
		}
		return back;
	}
	private <T extends MarketListPO>void setToNull(ArrayList<T> list,ArrayList<T> listo) {
		//将通过的单据存入清单中
		for(int i=0;i<listo.size();i++){
			list.add(listo.get(i));
		}
	}
	private <T extends MarketListPO>void addBack(ArrayList<MarketListPO> back,
			ArrayList<T> list1n2) {
		// 添加单据
		for(int i=0;i<list1n2.size();i++){
			back.add(list1n2.get(i));
		}
		while (list1n2.size()!=0){
			list1n2.remove(0);
		}
	}
}
