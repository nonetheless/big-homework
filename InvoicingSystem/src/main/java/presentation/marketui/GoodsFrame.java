package presentation.marketui;

import uidialog.GggFrame;

public class GoodsFrame{
	GggFrame frame;
	int height;
	int width;
	MarketCtrl ctrl;
	public GoodsFrame(MarketCtrl c){
		ctrl = c;
		frame = new GggFrame();
		ctrl.addFrame(frame);
		width = frame.getWidth();
		height = frame.getHeight();
		/*
		 * 购物车的panel
		 */
		GoodsPanel goods = new GoodsPanel(ctrl);
		goods.setBounds(width/8, height/8, width/3*2, height/3);
		/*
		 * 商品清单的panel
		 */
		ListPanel list = new ListPanel(ctrl);
		list.setBounds(width/8,height/8+height/3+height/20,width/3*2,height/3);
		/*
		 * 获取优惠和销售人员折扣和使用代金卷的panel
		 */
		OtherPanel other = new OtherPanel(ctrl);
		other.setBounds(width/8, height/8*7, width/3*2, height/12);
		frame.add(goods);
		frame.add(list);
		frame.add(other);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.repaint();
	}
}
