package businesslogic.kindbl;

public interface ChangeFromComd {

	public int addCommodityToKind(String fatherName,String kindNum,String comdName);
	public void delCommodityToKind(String name);
	public int changeCommodityName(String oldName,String newName);
	public void init();
}
