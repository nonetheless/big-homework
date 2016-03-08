package vo;

import java.util.ArrayList;

import po.PkgItemVO;

public class PkgVO {
	
	String id;   //特价包id(编号)
	String name;    //特价包名称
	ArrayList <PkgItemVO> pkg;   //特价包内的商品列表
	double aftPrice;     //特价包优惠后总价
	
	public PkgVO(String id,String name,ArrayList<PkgItemVO> pkg,double aftPrice){
		this.id=id;
		this.name=name;
		this.pkg=pkg;
		this.aftPrice=aftPrice;
	}
	


	public String getId(){
		return this.id;
	}
	
	public String getName(){
		return this.name;
	}
	
	public ArrayList<PkgItemVO> getPkg(){
		return this.pkg;
	}
	
	public double getAftPrice(){
		return this.aftPrice;
	}
	
}
