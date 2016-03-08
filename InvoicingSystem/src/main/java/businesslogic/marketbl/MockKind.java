package businesslogic.marketbl;

import java.util.ArrayList;
import vo.KindInfoVO;

public class MockKind {
	public KindInfoVO find(String name){
		ArrayList<String> id = new ArrayList<String>();
		ArrayList<String> kind = new ArrayList<String>();
		id.add("0023");
		id.add("0024");
		id.add("0025");
		id.add("0026");
		id.add("0027");
		id.add("0028");
		kind.add("light");
		kind.add("light1");
		kind.add("light2");
		kind.add("light3");
		KindInfoVO x  = new KindInfoVO(kind,id);
		return x;
	}

}
