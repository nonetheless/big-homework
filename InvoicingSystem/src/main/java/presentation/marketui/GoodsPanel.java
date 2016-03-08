package presentation.marketui;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import uidialog.DialogMaker;

/**
 * 
 * @author xinlin
 *显示购物车中的所有商品
 */
public class GoodsPanel extends JPanel{
	public enum Label{
		 GoodID(1),GoodKind(2),GoodPrice(3),GoodNum(4);
		 private final int value;
	     public int getValue() {
	           return value;
	     }
	     Label(int value) {
	           this.value = value;
	     }
	}
	JButton button;
	JScrollPane scroll;
	MarketCtrl ctrl;
	JPanel panel;
	public GoodsPanel(MarketCtrl c) {
		ctrl = c;
		panel = new JPanel();
		JLabel n = new JLabel("商品库");
		n.setFont(new Font(Font.MONOSPACED,Font.CENTER_BASELINE, 20));
		addThings(panel);
		JPanel labelName= new JPanel();
		labelName.setLayout(new BoxLayout(labelName,BoxLayout.X_AXIS));
		String[] arg = {"    分类或名称","商品id","商品分类","商品价格","商品数量"};
		for(int i = 0;i<5;i++){
			JLabel temp = new JLabel(arg[i]);
			labelName.add(temp);
			if(i!=4){
			labelName.add(new JLabel("                "));
			}
		}
		/*
		 * 向panel添加
		 */
		scroll =new JScrollPane(panel);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.add(n);
		this.add(labelName);
		this.add(scroll);
		button = new JButton("返回");
		button.addActionListener(new Back());
		this.add(button);
	}
	private void addThings(JPanel panel) {
		// 将vo转换为按钮
		ArrayList<String> kind = ctrl.getGoodsK();
		ArrayList<String> goods = ctrl.getGoods();
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		for(int i=0;i<goods.size();i++){
			panel.add(createGood(goods.get(i)));
		}
		for(int i=0;i<kind.size();i++){
			panel.add(createKind(kind.get(i)));
		}
		
	}
	private Component createGood(String string) {
		//创建按钮
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.X_AXIS));
		JButton s = new JButton(string);
		s.addActionListener(new Good(s));
		panel.add(s);
		createLabel(panel,string);
		return panel;
	}
	
	private void createLabel(JPanel panel2, String string) {
		// 在panel后加入其余信息
		int i = ctrl.FindGood(string);
		JLabel id = new JLabel(ctrl.getGoodsId(i));
		JLabel kind = new JLabel(ctrl.getGoodsKind(i));
		JLabel price = new JLabel(ctrl.getGoodsPrice(i));
		JLabel num = new JLabel(ctrl.getGoodsNum(i));
		panel2.add(new JLabel("                   "));
		panel2.add(id);
		panel2.add(new JLabel("                   "));
		panel2.add(kind);
		panel2.add(new JLabel("                   "));
		panel2.add(price);
		panel2.add(new JLabel("                   "));
		panel2.add(num);
	}
	private Component createKind(String string) {
		//创建按钮
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.X_AXIS));
		JButton s = new JButton(string);
		s.addActionListener(new Kind(s));
		panel.add(s);
		createKindLabel(panel,string);
		return panel;
	}
	
	private void createKindLabel(JPanel panel2, String string) {
		// 只是为了保持好看
		panel2.add(new JLabel("                   "));
		panel2.add(new JLabel("        "));
		panel2.add(new JLabel("                   "));
		panel2.add(new JLabel("        "));
		panel2.add(new JLabel("                   "));
		panel2.add(new JLabel("        "));
		panel2.add(new JLabel("                   "));
		panel2.add(new JLabel("        "));
	}

	class Back implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// 返回上层
			updpanel(ctrl.getBack());
			
		}
		
	}
	class Good implements ActionListener{

		JButton m;
		public Good(JButton s) {
			
			m  = s;
		}

		public void actionPerformed(ActionEvent e) {
			// 选择了商品的操作
			ctrl.setNow(m.getText());
			String[] arg = {"id","商品名","商品分类","商品价格","商品数量"};
			String[] aim = ctrl.getBuyingInfo();
			String [][] list = {aim};
			AddFrame add = new AddFrame(ctrl,arg,list);
			
		}
		
	}
	
	class Kind implements ActionListener{
		JButton b;

		public Kind(JButton s) {
			
			b= s;
		}

		public void actionPerformed(ActionEvent e) {
			//选择了kind的操作
			updpanel(b.getText());
			
		}
		
	}

	public void updpanel(String string) {
		//更新购物车
		ctrl.setNow(string);
		this.remove(scroll);
		this.remove(button);
		panel = new JPanel();
		addThings(panel);
		scroll = new JScrollPane(panel);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		this.add(scroll);
		this.add(button);
		revalidate();
		this.repaint();
	}

}
