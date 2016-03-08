package presentation.marketui;
import javax.swing.JFrame;

/**
 * @author xinlin
 * market的主页面
 * 可跳转至购物车
 */
import uidialog.GggFrame;

public class MarketFrame {
	GggFrame frame;
	int width;
	int height;
	MarketCtrl ctrl;
	String saler;
	public MarketFrame(String saler){
		this.saler = saler;
		frame = new GggFrame();
		frame.setUser(saler);
		ctrl = new MarketCtrl(saler);
		width = frame.getWidth();
		height = frame.getHeight();
		APanel a = new APanel(ctrl,saler,this);
		a.setBounds(0, height/15, width, height);
		frame.add(a);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.repaint();
	}
	
	public static void main(String[] args){
		MarketFrame m = new MarketFrame("ggg");
	}

	public void reflash() {
		// 更新为新的Frame
		frame = new GggFrame();
		frame.setUser(saler);
		ctrl = new MarketCtrl(saler);
		width = frame.getWidth();
		height = frame.getHeight();
		APanel a = new APanel(ctrl,saler,this);
		a.setBounds(0, height/15, width, height);
		frame.add(a);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.repaint();
		
	}

}
