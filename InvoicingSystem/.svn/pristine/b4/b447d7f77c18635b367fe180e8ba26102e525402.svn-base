package businesslogic.paymentbl;

import java.util.ArrayList;

import vo.accountlineitemVO;

public class accountlist2 {
	ArrayList<accountlineitem2> list=new ArrayList<accountlineitem2>();
	public int add(accountlineitemVO v){
		accountlineitem2 aci=new accountlineitem2(v.getname(),v.getmoney(),v.getremark());
		list.add(aci);
		return 1;
		
	}
	public int del(accountlineitemVO v){
		accountlineitem2 aci=new accountlineitem2(v.getname(),v.getmoney(),v.getremark());
		for(int i=0;i<list.size();i++){
			if(list.get(i).name.equals(aci.name)&&list.get(i).remark.equals(aci.remark)&&list.get(i).money==aci.money){
				list.remove(i);
				break;
			}
		}
		return 1;
	}

}
