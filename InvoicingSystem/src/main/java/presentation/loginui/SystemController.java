package presentation.loginui;

import presentation.accountui.accountFrame;
import presentation.commodityui.CommodityFrame;
import presentation.marketui.MarketFrame;
import presentation.promotionui.WelcomeFrame;
import presentation.userui.UserUI;
import vo.UserVo;

public class SystemController {

	public void show(UserVo vo){
		String status=vo.getStatus();
		
		if(status.equals("库存管理员")){
			new CommodityFrame();
		}
		if(status.equals("销售人员")){
			new MarketFrame(vo.getId()+"-"+String.valueOf(vo.getLevel()));
		}
		if(status.equals("财务人员")){
			new accountFrame(vo.getName(),vo.getStatus());
		}
		if(status.equals("总经理")){
			new  WelcomeFrame(vo.getName());
		}
		if(status.equals("系统管理员")){
			new UserUI(vo.getName());
		}
		
	}
	
	
	
	
	

}