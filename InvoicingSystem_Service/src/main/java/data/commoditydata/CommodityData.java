package data.commoditydata;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import po.BillPO;
import po.CommodityPo;
import po.Ex_StockPo;
import po.PkgPO;
import po.SaleNotePo;
import po.StockBillsPo;
import po.infoPO;
import dataservice.commoditydataservice.CommodityDataService;

public class CommodityData extends UnicastRemoteObject  implements CommodityDataService{
   
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String comdSerFile="file/commoditys.ser";
    String pkgSerFile="file/pkg.ser";
    String saleNoteFile="file/saleNote.ser";
    String stockBillFile="file/stockBills.ser";
    String stockAlarmFile="file/alarmBill.ser";
    
    ArrayList<CommodityPo> comdList;
    ArrayList<PkgPO> pkgList;
    ArrayList<SaleNotePo>  salesList;
    ArrayList<StockBillsPo> stockBillList;
    ArrayList<StockBillsPo> alarmBillList;
    
    
    PoReader<ArrayList<CommodityPo>> comdReader=new PoReader<ArrayList<CommodityPo>>(comdSerFile);
    PoReader<ArrayList<PkgPO>> pkgReader=new PoReader<ArrayList<PkgPO>>(pkgSerFile);
    PoReader<ArrayList<StockBillsPo>> billReader=new PoReader<ArrayList<StockBillsPo>>(stockBillFile);
    PoReader<ArrayList<SaleNotePo>> noteReader=new PoReader<ArrayList<SaleNotePo>>(saleNoteFile);
    PoReader<ArrayList<StockBillsPo>> alarmReader=new PoReader<ArrayList<StockBillsPo>>(stockAlarmFile);
    
    
    PoWriter<ArrayList<CommodityPo>> comdWriter=new PoWriter<ArrayList<CommodityPo>>(comdSerFile);
    PoWriter<ArrayList<PkgPO>> pkgWriter=new PoWriter<ArrayList<PkgPO>>(pkgSerFile);
    PoWriter<ArrayList<StockBillsPo>> billWriter=new PoWriter<ArrayList<StockBillsPo>>(stockBillFile);
	PoWriter<ArrayList<SaleNotePo>> noteWriter=new PoWriter<ArrayList<SaleNotePo>>(saleNoteFile);
	PoWriter<ArrayList<StockBillsPo>> alarmWriter=new PoWriter<ArrayList<StockBillsPo>>(stockAlarmFile);
 	
	
	
	public CommodityData() throws RemoteException {
		super();
		//initSerFile();
		initSerLists();
		checkAlarm();
		
		// TODO Auto-generated constructor stub
	}

	
    
    
    
   
	public int addCommodity(CommodityPo po) throws RemoteException {
		// TODO Auto-generated method stub
		if(po!=null){
			
		comdList.add(po);
		comdWriter.write(comdList);
		System.out.println(po.get_nameOfCommodity()+";"+po.get_kindName());
		}
		return 1;
	}
	
	public int delCommodity(int loc)throws RemoteException {
		// TODO Auto-generated method stub
		comdList.remove(loc);
		comdWriter.write(comdList);
		
		return 1;
	}

	public int changeCommodity(CommodityPo comdPo,int loc) throws RemoteException {
	
		comdList.set(loc, comdPo);
		comdWriter.write(comdList);
		
		return 1;
	}
	
	
	
	
    public int findCommodity(String name) throws RemoteException {
	    
    	int length=comdList.size();
	    int loc=-1;
		
		for(int i=0;i<length;i++)
		  {
		   CommodityPo tempPo=comdList.get(i);
		   boolean b1=(tempPo.get_nameOfCommodity().equals(name));
		   System.out.println(tempPo.get_nameOfCommodity()+" "+name);
		   if(b1)
		   loc=i;
		   }
	
		return loc;
	}

	
	public Ex_StockPo examineStock(double beginTime, double endTime)throws RemoteException {
		// TODO Auto-generated method stub
		int length=salesList.size();
		int outNum=0;
		double outMoney=0;
		int inNum=0;
		double inMoney=0;
		for(int i=0;i<length;i++){
			SaleNotePo temp=salesList.get(i);
			double time=Double.valueOf(temp.get_time());
			if((time>=beginTime)&&(time<=endTime)){
				if(temp.get_number()>0){
					inNum=inNum+temp.get_number();
					inMoney=inMoney+temp.get_inPrice()*(temp.get_number());
				}
				else{
					outNum=outNum+(-temp.get_number());
					outMoney=outMoney+temp.get_outPrice()*(temp.get_number());
				}
			}
			
		}
		
		
		return new Ex_StockPo(outNum,outMoney,inNum,inMoney);
	}//库存查看

	
	
	
	public ArrayList<CommodityPo> getAllCommoditys() throws RemoteException {
		// TODO Auto-generated method stub
		
		return comdList;
	}

	public ArrayList<CommodityPo> getCommoditys(String name)throws RemoteException {
		// TODO Auto-generated method stub
		
		ArrayList<CommodityPo> tempList=new ArrayList<CommodityPo>();
		int length=comdList.size();
		for(int i=0;i<length;i++){
			CommodityPo tempPo=comdList.get(i);
			if(tempPo.get_nameOfCommodity().equals(name)){
				tempList.add(tempPo);
			}
		}
		
		
		return tempList;
	}

	
	
	public CommodityPo getCommodity(String kindNum) throws RemoteException {
		// TODO Auto-generated method stub
		int length=comdList.size();
		CommodityPo tempPo=null;
		for(int i=0;i<length;i++){
			tempPo=comdList.get(i);
			if(tempPo.get_numOfKind().equals(kindNum)){
				break;
			}
		}
		
		return tempPo;
	}
	public ArrayList<CommodityPo> getCommoditys_ByKindName(String KindName) throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<CommodityPo> tempList=new ArrayList<CommodityPo>();
		int length=comdList.size();
		for(int i=0;i<length;i++){
			CommodityPo tempPo=comdList.get(i);
			if(tempPo.get_kindName().equals(KindName))
				tempList.add(tempPo);
		}
		
		if(tempList.size()!=0)
		return tempList;
		else 
		return null;
	}
	

	public int addBill(StockBillsPo po) throws RemoteException {
		
		
		 resume_NumOfCommodity(po.getCommodityName(),po.get_ModelNum(),po.getFactualNum());    
         stockBillList.add(po);
	     billWriter.write(stockBillList);
	     return 1;
	}
	public void addAlarmBill(StockBillsPo po) {
		alarmBillList.add(po);
		alarmWriter.write(alarmBillList);
		}
	public ArrayList<StockBillsPo> getAlarm() throws RemoteException{
		     checkAlarm();
	       return alarmBillList;
	}
	
	public int resume_NumOfCommodity(String name,String modelNum,int fact_num){
		int result=-1;
	    int length=comdList.size();
	 
	    
	  for(int i=0;i<length;i++){
	    	CommodityPo temp=comdList.get(i);
	    	if((temp.get_nameOfCommodity().equals(name))&&(temp.get_modelNum().equals(modelNum))){
	    	temp.set_Num(fact_num);
	    
	    	comdList.set(i, temp);
	    	
	    	result=1;
	    	break;
	    	}
	      }
	    
	   updateCommodityFile();
	   
		
	    return result;
		
	}
	public void checkAlarm(){
		int length=comdList.size();
		 alarmBillList.clear();
		for(int i=0;i<length;i++){
			CommodityPo temp=comdList.get(i);
			if(temp.get_numOfStock()<temp.get_alarmNum()){
				String time=getTime();
				StockBillsPo po=new StockBillsPo("alarm",null,time,temp.get_nameOfCommodity(),
					temp.get_modelNum(),temp.get_numOfStock(),time,temp.get_storeHouse());
				alarmBillList.add(po);
			}
		}
	   
	    
	}

	public ArrayList<BillPO> getBills(infoPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
		System.out.println(po.getbilltype()+" "+po.gettime1()+" "+po.gettime2()+" "+po.getstorehouse()+" "+po.getoprator());
		
		int length=stockBillList.size();
		ArrayList<BillPO> resultList=new ArrayList<BillPO>();
		
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
		long time1=0;
		long time2=0;
		
		
		try {
			if((po.gettime1()!=null)&&(po.gettime2()!=null)){
			Date day1=sdf.parse(po.gettime1());
			Date day2=sdf.parse(po.gettime2());
			
			time1=day1.getTime();
			time2=day2.getTime();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		if(time1<=time2)
		{
		for(int i=0;i<length;i++){
			 StockBillsPo tempPo=stockBillList.get(i);
			 
			 System.out.println("单据是"+tempPo.toString());
			 long time=0;
			 try{
				Date day=sdf.parse(tempPo.get_date());
				time=day.getTime();
			 }
			 catch(Exception e){
			     
			 }
			 
			 
			 
			 if(po.gettime1()!=null)
			 {
				 if(time<time1)
			     continue;
				
			}
			if(po.gettime2()!=null)
			{
				if(time>time2)
		          continue;
		    }
			if(po.getbilltype()!=null){
				if(!(tempPo.getType().equals(po.getbilltype())))
					continue;
				
			}
			if(po.getoprator()!=null){
				if(!(tempPo.getOperator().equals(po.getoprator())))
					continue;
			}
			if(po.getstorehouse()!=null){
				if(!(tempPo.get_storeHouse().equals(po.getstorehouse())))
			            continue;
			}
			resultList.add(tempPo);	
			
          			
		}
		}
		
			return resultList;
		
		
	}

	

	
	/*
	 * changeStock方法,在逻辑层供销售模块调动，更改库存信息，每次调用都会留下记录，以便于库存盘点
	 * @see dataservice.commoditydataservice.CommodityDataService#changeStock(java.lang.String, int, double, double)
	 */
	public String changeStock(String num, int number, double inPrice,
			double outPrice) throws RemoteException {
		// TODO Auto-generated method stub
		int length=comdList.size();
		String result="failed";
	
		for(int i=0;i<length;i++){
			CommodityPo tempPO=comdList.get(i);
			if((tempPO.get_numOfKind().equals(num))){
				tempPO.set_Num(tempPO.get_numOfStock()+number);
			
				if(inPrice!=0){
				tempPO.set_latestIn(inPrice);
				tempPO.set_avgPrice((tempPO.get_inPrice()*tempPO.get_numOfStock()+inPrice*number)/(number+tempPO.get_numOfStock()));
				}
				if(outPrice!=0)
				tempPO.set_latestOut(outPrice);
				
				result="success";
				
				comdList.set(i, tempPO);
				updateCommodityFile();
			
				break;
			}
		}
		String time=getTime();
	
		
	    SaleNotePo saleNotePo=new SaleNotePo(num,number,inPrice,outPrice,time);
		salesList.add(saleNotePo);
		updateSaleFile();
		return result;
	}
	 
	
	

	public CommodityPo MarketFind(String numberOfkind) throws RemoteException {
		// TODO Auto-generated method stub
		
		int length=comdList.size();
		CommodityPo result=null;
		for(int i=0;i<length;i++){
			CommodityPo tempPO=comdList.get(i);
			if(tempPO.get_numOfKind().equals(numberOfkind)){
				result=tempPO;
				break;
			}		
		}
		return result;	
		
		
		
	}

	public int addPkg(PkgPO po) throws RemoteException {
		// TODO Auto-generated method stub
	//	int isExisted=findPkg(po);
		int result=1;
	//	if(isExisted<0){
		//	String id=getTime();
		  //  po.set_id(id);
			pkgList.add(po);
			pkgWriter.write(pkgList);
			result=1;
		//}
	   	return result;
	}

	public int delPkg(PkgPO po) throws RemoteException {
		// TODO Auto-generated method stub
	   int isExisted=matchPkg(po);
	   int result=-1;
	   if(isExisted>=0){
		   pkgList.remove(isExisted);
		   pkgWriter.write(pkgList);
		   result=1;
	   }
		   
		return result;
	}

	public int delPkg(int loc) throws RemoteException {
		// TODO Auto-generated method stub
		pkgList.remove(loc);
		updatePkgFile();
		return 1;
	}

	public int changePkg(int loc, PkgPO po) throws RemoteException {
		pkgList.set(loc, po);
		updatePkgFile();
		return 1;
	}

	public int changePkg(PkgPO po) throws RemoteException {
		// TODO Auto-generated method stub
		int loc=-1;
		 loc=matchPkg(po);
		if(loc>=0){
			pkgList.set(loc, po);
			pkgWriter.write(pkgList);
			loc=1;
		}
			
			
		return loc;
	}


	public int findPkg(PkgPO po) throws RemoteException{
			return 0;
		
	}
	
	public int matchPkg(PkgPO po) throws RemoteException{
		int length=pkgList.size();
		int find_result=-1;
		for(int i=0;i<length;i++){
			PkgPO tempPO=pkgList.get(i);
	        boolean b1=tempPO.getName().equals(po.getName());
			boolean b2=false;
			int len01=tempPO.getPkg().size();//len01是pkgList中的特价包的商品列表的长度
			int len02=po.getPkg().size();//len02是po中的特价包商品列表的长度
			
			if(len01==len02){//长度相同的情况下进行匹配，否则没有必要匹配
			for(int j=0;j<len01;j++){
			  b2=(tempPO.getPkg().get(j)).equals((po.getPkg().get(j)));
			  if(!b2)
			  break;
			 
			}
			}
			boolean result=b1||b2;
			if(result==true){
			 find_result=i;
			 break;
			}
		}
		return find_result;//返回了相同项目在list中的位置
	}
	
	
	public int findPkg_byId(String id) throws RemoteException{
		int length=pkgList.size();
		int loc=-1;
		for(int i=0;i<length;i++){
			PkgPO temPo=pkgList.get(i);
		    if(temPo.getId().equals(id)){
		    	loc=i;
		    	break;
		    }
		}
		return loc;
	}
	
	
	public PkgPO getPkg(String id) throws RemoteException {
		// TODO Auto-generated method stub
		int loc=findPkg_byId(id);
		if(loc>=0)
		return pkgList.get(loc);
		return null;
	}
	public ArrayList<PkgPO> getAllPkgs() throws RemoteException {
		// TODO Auto-generated method stub
		
		
		return pkgList;
	}

    public void initSerLists() throws RemoteException{
		comdList=comdReader.read();
		pkgList=pkgReader.read();
		stockBillList=billReader.read();
		salesList=noteReader.read();
		alarmBillList=alarmReader.read();
	}
	
	public void initSerFile() throws RemoteException{
		ArrayList<CommodityPo> poList01=new ArrayList<CommodityPo>();
		comdWriter.write(poList01);
		
		ArrayList<PkgPO> poList02=new ArrayList<PkgPO>();
		pkgWriter.write(poList02);
		
		ArrayList<StockBillsPo> poList03=new ArrayList<StockBillsPo>();
		billWriter.write(poList03);
		
		ArrayList<SaleNotePo> poList04=new ArrayList<SaleNotePo>();
		noteWriter.write(poList04);
		ArrayList<StockBillsPo> poList05=new ArrayList<StockBillsPo>();
		alarmWriter.write(poList05);
		
}
	
	public void updateCommodityFile(){
		comdWriter.write(comdList);
	}
    public void updateCommodityList(){
    	comdList=comdReader.read();
    }
    public void updatePkgList(){
    	pkgList=pkgReader.read();
    }
    public void updatePkgFile(){
    	pkgWriter.write(pkgList);
    }
    public void updateStockBillList(){
    	stockBillList=billReader.read();
    }
    public void updateStockBillFile(){
    	billWriter.write(stockBillList);
     }
	public void updateSaleFile(){
		noteWriter.write(salesList);
	}
	
	public int finish() throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
    private String getTime(){
    	Date d=new Date();
    	SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
    	String str=sdf.format(d);
    	return str;
    }

    public void updateCommodity_Kind(String oldName,String newName) throws RemoteException{
		// TODO Auto-generated method stub
    	
    	System.out.println("oldName="+oldName+" "+"newName="+newName);
    	
       int length=comdList.size();
       for(int i=0;i<length;i++)
       {
    	   CommodityPo temp=comdList.get(i);
    	   if(temp.get_kindName().equals(oldName))
    	   {
    			System.out.println("temp的kind="+temp.get_kindName()+" "+"newName="+newName);
    		   temp.set_KindName(newName);
    		   comdList.set(i, temp);
    		}
       }
	   updateCommodityFile();	
	}


	public CommodityPo getOneCommodity(int loc) throws RemoteException {
		// TODO Auto-generated method stub
		
		if(loc<comdList.size())
		return comdList.get(loc);
		return null;
	}


	public int delCommodityByName(String name) throws RemoteException {
		// TODO Auto-generated method stub
		int length=comdList.size();
		for(int i=0;i<length;i++){
			CommodityPo po=comdList.get(i);
			if(po.get_nameOfCommodity().equals(name)){
				comdList.remove(i);
				break;
			}
		}
		updateCommodityFile();
		return 1;
	}

    public int delCommodityByKindName(String kindName) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("要删除的分类是"+kindName);
		for(int i=0;i<comdList.size();i++){
			CommodityPo po=comdList.get(i);
			System.out.println(kindName+" "+po.get_kindName());
			if(po.get_kindName().equals(kindName))
				comdList.remove(i);
		}
		updateCommodityFile();
		
		return 1;
		
	}


	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		initSerFile();
		updateCommodityList();
	}






	






  	

}
