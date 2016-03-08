package businesslogic.promotionbl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import vo.BuyingVO;
import vo.MemberVO;
import vo.SpVO;
import vo.VipCouponVO;
import vo.VipGiftVO;
import vo.VipPromotionVO;
import businesslogic.marketbl.MarketForPro;
import businesslogic.memberbl.MemberForPro;

public class VipPromotion {

	VipPromotionMethod vpm;
	VipGiftPromotion vgp;
	VipCouponPromotion vcp;
	
	ArrayList<VipGiftVO> tempGiftList;
	VipCouponVO cv;
	
	ArrayList<BuyingVO> giftList;
	int couponPrice;
	int couponNum;
	String couponEndDate;
	
	MemberForPro mfp;
	MarketForPro sg;
	
	ArrayList<SpVO> vipGiftList;
	
	public VipPromotion(){
		vpm=new VipPromotionMethod();
		mfp=new MemberForPro();
		sg=new MarketForPro();
		
		giftList=new ArrayList<BuyingVO>();
		couponPrice=0;
		couponNum=0;
		couponEndDate=null;
		
		vipGiftList=new ArrayList<SpVO>();
	}
	
	
	public boolean check(String str){
		boolean res=false;
		if(Cal(str)>=0&&Cal(str)<=7){
			res=true;
		}
		return res;
	}
	
	public long Cal(String str){
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
		//给定的时间
		Date d = null;
		try {
			d = format.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		  
		//当前时间处理
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		  
		  
		//给定时间处理		
		Calendar setCal = Calendar.getInstance();
		setCal.setTime(d);
		setCal.set(Calendar.HOUR_OF_DAY, 0);
		setCal.set(Calendar.MINUTE, 0);
		setCal.set(Calendar.SECOND, 0);
		setCal.set(Calendar.MILLISECOND, 0);
		
		long day =(setCal.getTimeInMillis()-cal.getTimeInMillis())/(1000*60*60*24);
		return day;
	}
	
	public ArrayList<SpVO> getGift(){
		
		ArrayList<VipPromotionVO> vplist=vpm.getVipMethod();
		
		for(int i=0;i<5;i++){//遍历5个VipPromotionVO
			
			VipPromotionVO vpvo=vplist.get(i);
			int vipLevel=vpvo.getVipLevel();
			
			ArrayList<MemberVO> memberlist=mfp.findByLevel(vipLevel);
			
			if(memberlist.size()>0){//1.确定是否有赠送对象
				
				if(vpvo.getIsGift()){
					
					vgp=new VipGiftPromotion();
					tempGiftList=vgp.getVipGift(vipLevel);
					
					if(tempGiftList.size()>0){//2.确定giftlist是否有赠品
						
						for(int j=0;j<tempGiftList.size();j++){
							
							VipGiftVO vgvo=tempGiftList.get(j);
							String date=vgvo.getSendTime();
							
							if(check(date)){//3.判断是否满足赠送日期条件
								BuyingVO bvo=new BuyingVO(vgvo.getId(),vgvo.getName(),vgvo.getKind(),
										vgvo.getPrice(),vgvo.getNum());
								giftList.add(bvo);//4.若满足条件则加入赠送列表
							}//end of 3
							else{
								giftList=new ArrayList<BuyingVO>();
							}
							
						}
						
					}//end of 2
					else{
						giftList=new ArrayList<BuyingVO>();
					}
					
				}//end of check isGift
				else{
					giftList=new ArrayList<BuyingVO>();
				}
				
				if(vpvo.getIsCoupon()){
					vcp=new VipCouponPromotion();
					VipCouponVO vcvo=vcp.getVipCoupon(vipLevel);
					
					if(vcvo!=null){
						String date=vcvo.getSendTime();
						
						if(check(date)){
							couponPrice=vcvo.getPrice();
							couponNum=vcvo.getNum();
							couponEndDate=vcvo.getEndDate();
						}else{
							couponPrice=0;
							couponNum=0;
							couponEndDate=null;
						}
						
					}else{
						couponPrice=0;
						couponNum=0;
						couponEndDate=null;
					}
					
				}else{
					couponPrice=0;
					couponNum=0;
					couponEndDate=null;
				}
				
				SpVO sp=new SpVO(giftList,memberlist,couponPrice,couponNum,couponEndDate);
				//sg.sendGift(sp);
				if( (couponNum!=0)||(giftList.size()>0) ){
					vipGiftList.add(sp);
				}
				
				System.out.println("//////////lavip"+vipLevel+"//////////////");
				System.out.println("coupon price:"+couponPrice+" coupon Num:"+couponNum+" couponEndDate:"+couponEndDate);
				for(int k=0;k<giftList.size();k++){
					System.out.println("giftName: "+giftList.get(k).getName()+" giftNum: "+giftList.get(k).getNumber());
				}
				for(int h=0;h<memberlist.size();h++){
					System.out.println("memberName: "+memberlist.get(h).getName()+" memberLevel: "+memberlist.get(h).getLevel());
				}
				System.out.println("//////////lavip"+vipLevel+"//////////////");
				System.out.println();
				
			}//end of 1
			
		}//end of 遍历
		
		return vipGiftList;
	}
}
