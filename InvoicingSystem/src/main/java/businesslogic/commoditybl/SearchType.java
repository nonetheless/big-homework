package businesslogic.commoditybl;

public enum SearchType {

ComdName("name"),ComdKindName("kindName"),ComdKindNum("kindNum");
private final String way;

SearchType(String way){
	this.way=way;
}
public String get_way(){
	return way;
}
}
