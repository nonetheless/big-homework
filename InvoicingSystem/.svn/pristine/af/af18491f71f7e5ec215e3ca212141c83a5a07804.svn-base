/*
 * @cristph
 * 存储具有相同vip等级的代金券
 */
package vo;

import java.util.ArrayList;

import vo.VipCouponVO;

public class VipCouponListVO {
	
	private ArrayList<VipCouponVO> vipCouponList=new ArrayList<VipCouponVO>();
	private int vipLevel;
	
	public int getListLength(){//获取list大小
		return vipCouponList.size();
	}
	
	public int getVipLevel(){//获取vip等级
		return vipLevel;
	}
	
	public VipCouponVO get(int pos){//获取对象
		if(pos<vipCouponList.size()){
			return vipCouponList.get(pos);
		}
		else return null;
	}
	
	public String add(VipCouponVO vo){
		boolean isExist=false;
		int pos=-1;
		for(int i=0;i<vipCouponList.size();i++){
			if(vipCouponList.get(i).getPrice()==vo.getPrice()
					&&vipLevel==vo.getVipLevel()){
				isExist=true;
				pos=i;
			}
		}
		if(isExist){//若已存在，合并同金额同vip等级代金券
			vipCouponList.get(pos).addNum(vo.getNum());
			return "Succeed";
		}
		else{
			vipCouponList.add(vo);
			return "Succeed";
		}
	}
	
	public String del(VipCouponVO vo){
		boolean isExist=false;
		int pos=-1;
		for(int i=0;i<vipCouponList.size();i++){
			if(vipCouponList.get(i).getPrice()==vo.getPrice()
					&&vipLevel==vo.getVipLevel()){
				isExist=true;
				pos=i;
			}
		}
		if(isExist){//若已存在，合并同金额同vip等级代金券
			vipCouponList.remove(pos);
			return "Succeed";
		}
		else{
			return "Fail";
		}
	}
	
	public void edit(){
		//edit one of the DiscountVOs
	}
	
	public void read(){
		//read data from txt
	}
	
	public void write(){
		//write data into txt
	}
}
