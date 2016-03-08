package po;

import java.io.Serializable;

public class GoodLinePO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String commodity;
	String name;String kind;double value;
	int number;

	public GoodLinePO(String commodity, String name, String kind, double value,
			int number) {
		this.commodity = commodity;
		this.name = name;
		this.kind = kind;
		this.value = value;
		this.number =number;
		
	}
	
	public String getId(){
		return commodity;
	}
	
	public int getNumber(){
		return number;
	}
	
	public String getName(){
		return name;
	}
	
	public String getKind(){
		return kind;
	}
	
	public double getPrice(){
		return value;
	}

}
