package po;

import java.io.Serializable;
import java.util.ArrayList;

public class KindPo implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String kindName=null;
private String numOfKind=null;;
private ArrayList<KindPo> childs=new ArrayList<KindPo>();
private KindPo father=null;
private int numOfChild=0;
private int numBase=0;
private boolean allowChild=false;

public void set_AllowChild(boolean b){
	allowChild=b;
}
public boolean isallowChild(){
	return allowChild;
}
public String get_Name(){
	return kindName;
}
public String get_Num(){
	return numOfKind;
}
public ArrayList<KindPo> getChilds(){
	return childs;
}
public KindPo get_Father(){
	return father;
}
public void add_Child(KindPo po){
	
	childs.add(numOfChild, po);
	numOfChild++;
	numBase++;
}
public void del_Child(int i){
	childs.remove(i);
	numOfChild--;
	
}
public int get_NumOfChild(){
	return numOfChild;
}

public void set_Num(String num){
	this.numOfKind=num;
}
public boolean is_father(){
	return this.numOfChild>0;
}
public int  get_NumBase(){
	return numBase;
}

public void set_kindName(String name){
	this.kindName=name;
}

public  KindPo(String name,KindPo father,String num){
	this.kindName=name;
	this.father=father;
	this.numOfKind=num;
}


}
