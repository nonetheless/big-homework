package businesslogic.paymentbl;

import java.util.ArrayList;

import vo.cashlineitemVO;

public class cashlist {
	ArrayList<cashlineitem> list=new ArrayList<cashlineitem>();
	public int add(cashlineitemVO v){
		cashlineitem c=new cashlineitem(v.getitem(),v.getmoney(),v.getremark());
		list.add(c);
		return 1;
		
	}
	public int del(cashlineitemVO v){
		cashlineitem c=new cashlineitem(v.getitem(),v.getmoney(),v.getremark());
		for(int i=0;i<list.size();i++){
			if(list.get(i).item.equals(c.item)&&list.get(i).money==c.money&&list.get(i).remark.equals(c.remark)){
				list.remove(i);
				break;
			}
		}
		return 1;
	}

}
