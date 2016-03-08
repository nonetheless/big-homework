/*
 * @cristph
 * for sales promotion
 */
package businesslogic.promotionbl;

import java.util.ArrayList;

import vo.BuyingVO;
import vo.DiscountVO;
import vo.ProinfoVO;
import vo.TotalCouponVO;
import vo.TotalGiftVO;
import vo.TotalPromotionVO;
import vo.VipPromotionVO;

public class SalesPromotion {
	
	TotalCouponPromotion tcp;
	TotalGiftPromotion tgp;
	TotalPromotionMethod tpm;
	VipDiscountPromotion vdp;
	VipPromotionMethod vpm;
	
	public SalesPromotion(){
		tcp=new TotalCouponPromotion();
		tgp=new TotalGiftPromotion();
		tpm=new TotalPromotionMethod();
		vdp=new VipDiscountPromotion();
		vpm=new VipPromotionMethod();
	}
	
	public ProinfoVO getPromotion(double totalMoney,int vipLevel){
		
		ArrayList<BuyingVO> list=new ArrayList<BuyingVO>();
		double discount=0;
		int paperPrice=0;
		int paperNum=0;
		String paperDeadline=null;   //代金券的使用期限，过期无效
		
		//TotalPromotionVO pvo=tpm.getTotalMethod(totalMoney);
		VipPromotionVO vvo=vpm.getVipMethod(vipLevel);
		
		ArrayList<TotalPromotionVO> tplist=tpm.getTotalMethod();
		ArrayList<TotalPromotionVO> reslist=new ArrayList<TotalPromotionVO>();
		
		//获取对应总价额应有的TotalPromotionVO对象
		int pos=-1;
		if(tplist.size()>0){
			
			for(int i=0;i<tplist.size();i++){
				TotalPromotionVO tpvo=tplist.get(i);
				if(tpvo.getTotalPrice()<=totalMoney){
					reslist.add(tpvo);
				}
			}
			
			if(reslist.size()>0){
				double tempPrice=reslist.get(0).getTotalPrice();
				pos=0;
				
				for(int i=0;i<reslist.size();i++){
					TotalPromotionVO ttpvo=tplist.get(i);
					if(ttpvo.getTotalPrice()>=tempPrice){
						tempPrice=ttpvo.getTotalPrice();
						pos=i;
					}
				}
			}
		}
		
		TotalPromotionVO pvo=null;
		if(pos>=0){
			pvo=reslist.get(pos);
		}
		
		if(pvo!=null){
			//获得代金券
			if(pvo.getIsCoupon()){
				TotalCouponVO cvo=tcp.getTotalCoupon(pvo.getTotalPrice());
				if(cvo!=null){//代金券存在
					paperPrice=cvo.getPrice();
					paperNum=cvo.getNum();
					paperDeadline=cvo.getEndDate();
				}else{
					paperPrice=0;
					paperNum=0;
					paperDeadline=null;
				}	
			}else{
					paperPrice=0;
					paperNum=0;
					paperDeadline=null;
				}
			
			//获得赠品
			if(pvo.getIsGift()){
				
				ArrayList<TotalGiftVO> array=tgp.getTotalGift(pvo.getTotalPrice());
				
				if(array.size()>0){//赠品列表不为空
					for(int i=0;i<array.size();i++){
						TotalGiftVO vo=array.get(i);
						BuyingVO bvo=new BuyingVO(vo.getId(),vo.getName(),vo.getKind(),
								vo.getPrice(),vo.getNum());
						list.add(bvo);
					}
				}else{
					list=null;
				}
			}else{
				list=null;
			}
		}else{
			paperPrice=0;
			paperNum=0;
			paperDeadline=null;
			list=null;
		}
		
		
		if(vvo!=null){
			//获得打折额
			System.out.println("vo in getDis");
			if(vvo.getIsDiscount()){
				System.out.println("in getDis");
				DiscountVO dvo=vdp.getDiscount(vipLevel);
				if(dvo!=null){
					discount=totalMoney*(1-dvo.getDiscount());
				}else{
					discount=0;
				}
			}else{
				discount=0;
			}
		}else{
			discount=0;
		}
		
		ProinfoVO pro=new ProinfoVO(list,discount,paperPrice,paperNum,paperDeadline);
		return pro;
	}

}
