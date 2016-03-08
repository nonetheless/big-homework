package presentation.marketui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

import uidialog.DialogMaker;

/**
 * 
 * @author xinlin
 *显示购物选中的商品
 */
public class ListPanel extends JPanel{
	MarketCtrl ctrl;
	JScrollPane scroll;
	JPanel panel;
	String [][] thing;
	public ListPanel(MarketCtrl c) {
		ctrl = c;
		ctrl.add(this);
		JLabel name = new JLabel("购物车");
		name.setFont(new Font(Font.MONOSPACED,Font.CENTER_BASELINE, 20));
		panel = new JPanel();
		thing = null;
		firstSet();
		JPanel labelName= new JPanel();
		labelName.setLayout(new BoxLayout(labelName,BoxLayout.X_AXIS));
		String[] arg = {"      商品id","商品名","商品分类","商品单价","商品数量","该商品总价格"};
		for(int i = 0;i<6;i++){
			JLabel temp = new JLabel(arg[i]);
			labelName.add(temp);
			if(i!=5){
			labelName.add(new JLabel("            "));
			}
		}
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.add(name);
		this.add(labelName);
		this.add(scroll);

	}
	private void firstSet() {
		// 初始化显示界面
		scroll = new JScrollPane(panel);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	}
	
	public void updList(String [][] a) {
		// 对外的更新商品清单
		thing = a;
		this.remove(scroll);
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		panel.setVisible(true);
		int leng = a.length;
		for(int i=0;i<leng;i++){
			panel.add(createGood(a[i]));
		}
		scroll = new JScrollPane(panel);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		revalidate();
		this.add(scroll);
		
	}
	private Component createGood(String[] string) {
		// 将String变为按钮
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.X_AXIS));
		panel.setVisible(true);
		JButton s = new JButton(string[0]);
		s.addActionListener(new Good(s));
		panel.add(s);
		createLabel(panel,string);
		return panel;
	}
	
	private void createLabel(JPanel panel2, String[] string) {
		//将String余下变为label
		JLabel id = new JLabel(string[1]);
		JLabel kind = new JLabel(string[2]);
		JLabel price = new JLabel(string[3]);
		JLabel num = new JLabel(string[4]);
		JLabel all = new JLabel(string[5]);
		panel2.add(new JLabel("               "));
		panel2.add(id);
		panel2.add(new JLabel("               "));
		panel2.add(kind);
		panel2.add(new JLabel("               "));
		panel2.add(price);
		panel2.add(new JLabel("               "));
		panel2.add(num);
		panel2.add(new JLabel("               "));
		panel2.add(all);
	}
	
	class Good implements ActionListener{
		String goodName;

		public Good(JButton s) {
			goodName = s.getText();
		}

		public void actionPerformed(ActionEvent e) {
			// 跳转进入
			for(int i = 0;i<thing.length;i++){
				if(goodName.equals(thing[i][0])){
					String[] arg = {"商品id","商品名","商品分类","商品单价","商品数量","该商品总价格"};
					String[][] aim = {thing[i]};
					CheckFrame che = new CheckFrame(ctrl, arg, aim);
					break;
				}
			}
			
		}
		
	}

	public String[][] getList() {
		// 返回list
		return thing;
	}
}
