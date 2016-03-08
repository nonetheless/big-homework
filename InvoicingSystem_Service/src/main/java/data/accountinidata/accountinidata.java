package data.accountinidata;

import dataservice.accountinidataservice.accountinidataservice;
import po.creatPO;

public class accountinidata implements accountinidataservice {
	public creatPO find(int number){
		creatPO p=new creatPO(null,null,null);
		return p;
	}
	public int store(creatPO creat){
		return 1;
	}

}
