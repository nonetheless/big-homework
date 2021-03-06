package businesslogic.marketbl;

import businesslogic.billmanagementbl.MarketForBillSercice;
import po.BillPO;
import po.MarketListPO;
import vo.InformationVO;

public class MarketForBill implements MarketForBillSercice{
	final int SALE = 1;
	final int UNSALE =2;
	final int STACK =3;
	final int UNSTACK =4;
	
	public String reply(BillPO x,int ok){
		//保存单据，更改，有点麻烦
		String back = "false";
		MarketListPO m = (MarketListPO) x;
		InformationVO v = new InformationVO(m.getMemberName(),m.getMemberId(),m.getHouse(),m.getOperator(),m.getOther(),m.getKind(),m.getSaler());
		Unity uni = changeKind (v);
		GoodsList get = new GoodsList(m.getList());
		//无论是否通过审批，都要保存一下单据
		//ifelse 程序员杀手啊
		if(ok==1){
			if(m.getType().equals("KCZSD")){
				//赠品单减少商品库存
				back = get.reduCommodity(0);
			}
			else if((v.getKind()==1)||(v.getKind()==4)){
				//销售单，退货单，减少
				back = get.reduCommodity(v.getKind());
			}
			else{
				back = get.addCommodity(v.getKind());
			}
		}
		if((v.getKind()==1)||(v.getKind()==4)){
			if(!m.getType().equals("KCZSD")){
				back = uni.reply(m,1,ok);
			}
			else{
				Sale tee = (Sale)uni;
				back = tee.replyFree(m,ok);
			}
		}
		else{
			back = uni.reply(m,2,ok);
		}
		return back;
	}
	
	private Unity changeKind(InformationVO info) {
		// 通过输入建立不同的领域模型
		/*
		 * 控制耦合
		 * 1 sale
		 * 2 unsale
		 * 3 stack
		 * 4 unstack
		 */
		Unity te = null;
		switch(info.getKind()){
		case SALE:
			te = new Sale(info);
			break;
		case UNSALE:
			te = new Unsale(info);
			break;
		case STACK:
			te = new Stack(info);
			break;
		case UNSTACK:
			te = new Unstack(info);
			break;
			
		}
		return te;
	}

}
