package dataservice.commoditydataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.BillPO;
import po.CommodityPo;
import po.Ex_StockPo;
import po.PkgPO;
import po.StockBillsPo;
import po.infoPO;



public interface CommodityDataService extends Remote{
	
public int addCommodity(CommodityPo po) throws RemoteException;
public int delCommodity(int loc) throws RemoteException;
public int delCommodityByKindName(String kindName) throws RemoteException;
public int delCommodityByName(String name) throws RemoteException;
public int changeCommodity(CommodityPo comdPo,int loc) throws RemoteException;


public int findCommodity(String name) throws RemoteException;

public Ex_StockPo examineStock(double beginTime,double endTime) throws RemoteException;//为库存盘点提供信息
public ArrayList<CommodityPo> getAllCommoditys() throws RemoteException;//为库存查看提供信息
public ArrayList<CommodityPo> getCommoditys(String name) throws RemoteException;//用于总经理模块的某个调动
public CommodityPo getCommodity(String kindNum) throws RemoteException;//
public ArrayList<CommodityPo> getCommoditys_ByKindName(String KindName) throws RemoteException;//通过类别名称查找商品

public int addBill(StockBillsPo po) throws RemoteException;//用于提交报损单和报溢单
public ArrayList<StockBillsPo> getAlarm() throws RemoteException;//用于报警单
public  ArrayList<BillPO> getBills(infoPO vo) throws RemoteException;

//public int changeCommoditys(CommodityPo po) throws RemoteException;//用于UI层的修改商品信息
public String changeStock(String kindNum,int number,double inPrice,double outPrice) throws RemoteException;//用于Sale模块的修改库存信息，每次修改之后必须留有持久化记录用于库存查看

//public int get(CommodityPo po) throws RemoteException;

public CommodityPo MarketFind(String numberOfkind) throws RemoteException;//用于Sale模块找到商品

public int addPkg(PkgPO po) throws RemoteException;
public int delPkg(PkgPO po) throws RemoteException;
public int delPkg(int loc) throws  RemoteException;
public int changePkg(PkgPO po) throws RemoteException;
public int changePkg(int loc,PkgPO po) throws RemoteException;
public int findPkg(PkgPO po)   throws RemoteException;
public int findPkg_byId(String id) throws RemoteException;
public PkgPO getPkg(String id) throws RemoteException;
public ArrayList<PkgPO> getAllPkgs() throws RemoteException;

public CommodityPo getOneCommodity(int loc) throws RemoteException;



public void init() throws RemoteException;
public int finish() throws RemoteException;
public void updateCommodity_Kind(String oldName,String newName) throws RemoteException;
	// TODO Auto-generated method stub
	
	

}