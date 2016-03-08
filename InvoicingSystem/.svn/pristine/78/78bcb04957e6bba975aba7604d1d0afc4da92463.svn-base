package vo;

import java.util.ArrayList;

public class SpVO {
	
	ArrayList<BuyingVO> blist;
	ArrayList<MemberVO> mlist;
	int paperPrice;
	int paperNum;
	String paperDeadline;   //代金券的使用期限，过期无效
	
	public SpVO(ArrayList<BuyingVO> blist,ArrayList<MemberVO> mlist,
			int paperPrice,int paperNum,String paperDeadline){
		this.blist = blist;
		this.mlist=mlist;
		this.paperNum = paperNum;
		this.paperPrice = paperPrice;
		this.paperDeadline=paperDeadline;
	}

	public ArrayList<BuyingVO> getGiftList(){
		return blist;
	}
	
	public ArrayList<MemberVO> getMemberList(){
		return mlist;
	}
	
	public int getPaper(){
		return paperPrice;
	}
	
	public int getNum(){
		return paperNum;
	}
	
	public String getPaperDeadine(){
		return paperDeadline;
	}

}
