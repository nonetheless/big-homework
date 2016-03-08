package businesslogic.marketbl;

import java.util.ArrayList;

import po.GiftListPO;
import po.GoodsListPO;
import vo.InformationVO;
import vo.MemberVO;
import vo.SpVO;

public class MarketForPro {

	public String sendGift(SpVO sp){
		GoodsList get = new GoodsList(sp.getGiftList());
		ArrayList<MemberVO> mem = sp.getMemberList();
		for(int i = 0;i<mem.size();i++){
			MemberVO m = mem.get(i);
			get.reduCommodity(0);//减去商品
			InformationVO in = new InformationVO(m.getName(),m.getId(),"default","default","",1,"default");
			Sale te = new Sale(in);
			GoodsListPO ere = get.createPO();
			GiftListPO z= te.storeG(ere);
			String test = te.sendGift(z, sp.getPaper(), sp.getNum(), sp.getPaperDeadine());
			System.out.println(i+" 个赠送单"+test);
		}
		return "success";
	}
}
