package presentation.marketui;
/**
 * @author xinlin
 * 用来删除或者更新商品清单
 */
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
/**
 * @author xinlin
 * 购物车弹出窗口，选择数量价格
 */
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import uidialog.DialogMaker;

public class CheckFrame extends JFrame{
	MarketCtrl ctrl;
	JRadioButton del;
	JRadioButton upd;
	JTextField num;
	JTextField price;
	int goodnum;
	double goodprice;
	String id;
	String b1[];
	public CheckFrame(MarketCtrl c,String []a,String [][] b){
		super();
		Toolkit tool= Toolkit.getDefaultToolkit();
		Dimension scr = tool.getScreenSize();
		int width = 600;
		int height = 500;
		this.setBounds(scr.width/2-width/2,scr.height/2-height/2 , width, height);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, width, height);
		panel.setVisible(true);
		ctrl = c;
		b1 = b[0];
		id = b[0][0];
		goodprice = Double.parseDouble(b[0][3].trim());
		goodnum = Integer.parseInt(b[0][4].trim());
		ButtonGroup use = new ButtonGroup();
		del = new JRadioButton();
		upd = new JRadioButton();
		use.add(del);
		use.add(upd);
		del.setSelected(true);
		JLabel dell = new JLabel("删除商品");
		JLabel updl = new JLabel("更新商品");
		JPanel choose = new JPanel();
		choose.setLayout(new FlowLayout());
		choose.add(dell);
		choose.add(del);
		choose.add(new JLabel("                                     "));
		choose.add(updl);
		choose.add(upd);
		JPanel field = new JPanel();
		field.setLayout(new FlowLayout());
		JLabel numl = new JLabel("数量");
		JLabel pricel = new JLabel("价格");
		num = new JTextField("        ");
		num.addKeyListener(new IntListener());
		price = new JTextField("       ");
		price.addKeyListener(new DoubleListener(price));
		num.addFocusListener(new Enter(num));
		price.addFocusListener(new Enter(price));
		field.add(numl);
		field.add(num);
		field.add(new JLabel("                         "));
		field.add(pricel);
		field.add(price);
		JButton sure = new JButton("确定");
		sure.addActionListener(new Sure());
		JTable table  = new JTable(b,a);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		panel.add(choose);
		panel.add(field);
		panel.add(sure);
		panel.add(scroll);
		price.setText(b[0][3]+"     ");
		num.setText(b[0][4]+"     ");
		this.setLayout(null);
		this.add(panel);
		this.setVisible(true);
		this.repaint();
		
	}
	class Sure implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			if(del.isSelected()){
				String ss = ctrl.delList(id,b1[3].trim(),b1[4].trim());
				DialogMaker.getDialog(ss);
			}
			else{
				if(num.getText().trim().equals("")){
					DialogMaker.getDialog("false");
				}
				else if(price.getText().trim().equals("")){
					DialogMaker.getDialog("false");
				}
				else if(num.getText().trim().equals("0")){
					DialogMaker.getDialog("false");
				}
				else{
					int x = Integer.parseInt(num.getText().trim());
					double y = Double.parseDouble(price.getText().trim());
				    String ss = ctrl.updList(id,x,y);
				    DialogMaker.getDialog(ss);
				}
			}
			
		}
		
	}
	
	class Enter implements FocusListener{
		JTextField m;

		public Enter(JTextField price) {
			m = price;
		}

		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub
			if(m==num){
				m.setText("");
			}
			
		}

		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	

}
