package presentation.marketui;

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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import uidialog.DialogMaker;

public class AddFrame extends JFrame {
	MarketCtrl ctrl;
	JTextField num;
	JTextField price;
	int goodnum;
	double goodprice;
	String end[];
	public AddFrame(MarketCtrl c,String []a,String [][] b){
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
		goodprice = Double.parseDouble(b[0][3]);
		goodnum = Integer.parseInt(b[0][4]);
		end = new String[b[0].length+1];
		for(int i = 0;i<b[0].length;i++){
			end[i] = b[0][i];
		}
		JLabel add = new JLabel("增加商品                                                                                     ");
		JPanel field = new JPanel();
		field.setLayout(new FlowLayout());
		JLabel numl = new JLabel("数量");
		JLabel pricel = new JLabel("价格");
		num = new JTextField("请输入数量");
		price = new JTextField("       ");
		price.setText(Double.toString(goodprice)+"    ");
		num.addFocusListener(new Enter(num));
		num.addKeyListener(new IntListener());
		price.addFocusListener(new Enter(price));
		price.addKeyListener(new DoubleListener(price));
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
		panel.add(add);
		panel.add(field);
		panel.add(sure);
		panel.add(scroll);
		this.setLayout(null);
		this.add(panel);
		this.setVisible(true);
		this.repaint();
		
	}
	
   
	class Sure implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			//确定后需要的是改变购物车
			end[3] = price.getText().trim();
			end[4] = num.getText().trim();
			if(end[3].equals("")||end[4].equals("")){
				DialogMaker.getDialog("请输入金额和数量");
			}
			else if(end[4].equals("0")){
				DialogMaker.getDialog("不能加入0个商品");
			}
			else{
				double all = Integer.parseInt(end[4])*Double.parseDouble(end[3]);
				end[5] = Double.toString(all);
			    String x = ctrl.addGood(end,goodnum);
			    DialogMaker.getDialog(x);
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
				m.setText("      ");
			}
			
		}

		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	

}
