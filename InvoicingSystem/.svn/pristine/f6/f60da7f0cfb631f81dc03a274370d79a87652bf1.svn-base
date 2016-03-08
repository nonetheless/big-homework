package businesslogic.commoditybl;


import java.util.ArrayList;

import po.BillPO;

import vo.CommodityVo;
import vo.MarketCommodityVO;
import vo.PkgVO;
import vo.infoVO;

public interface CommodityProvider {
public  ArrayList<BillPO> getBills(infoVO vo);
public ArrayList<CommodityVo> getCommoditys(String name);
public CommodityVo  getCommodity(String kindNum);
public ArrayList<CommodityVo> getCommoditys_ByKindName(String kindName);
public ArrayList<CommodityVo> getAllCommoditys();

public String changeStock(String kindNum,int number,double inPrice,double outPrice);
public MarketCommodityVO MarketFind(String numberOfkind);
public int addPkg(PkgVO vo);
public int delPkg(PkgVO vo);
public int delPkg(String id);
public int changePkg(PkgVO vo);
public PkgVO get_Pkg(String id);
public ArrayList<PkgVO> getAllPkgs();
public String sendGift(ArrayList<CommodityVo> arr,String customName,String customId,int money,int number); 

public int findPkg(PkgVO vo);
public int findPkg(String id);

//public void updateCommodity_Kind(String oldName,String newName);
	// TODO Auto-generated method stu

}
