package presentation.marketui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import uidialog.DialogMaker;
import vo.BuyingVO;
import vo.ListVO;
import vo.PromotionListVO;

/**
 * 
 * @author xinlin
 * 确认订单的panel
 */
public class OtherPanel extends JPanel{
	MarketCtrl ctrl;
	JTextField disc;
	JTextField dis;
	JButton end;
	boolean m1;
	boolean m2;
	boolean m3;
	double gift;
	int paper;
	double pro;
	JButton p;
	public OtherPanel(MarketCtrl c) {
		super();
		gift = 0;
		paper = 0;
		pro = 0;
		ctrl = c;
		m1 = false;
		m2 = false;
		m3 = false;
		JLabel discl = new JLabel("销售人员折扣");
		disc = new JTextField("0");
		disc.addKeyListener(new DoubleListener(disc));
		disc.addFocusListener(new Check(disc));
		JLabel disl = new JLabel("代金卷使用");
		dis = new JTextField("0");
		dis.addKeyListener(new IntListener());
		dis.addFocusListener(new Check(dis));
		p = new JButton("获取优惠");
		p.addActionListener(new Pro());
		end = new JButton("结束购物");
		end.addActionListener(new End(end));
		end.setEnabled(false);
		this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
		this.add(discl);
		this.add(new JLabel("     "));
		this.add(disc);
		this.add(new JLabel("     "));
		this.add(disl);
		this.add(new JLabel("     "));
		this.add(dis);
		this.add(new JLabel("     "));
		this.add(p);
		this.add(new JLabel("     "));
		this.add(end);
		if(!ctrl.ap.sale.isSelected()){
			m1 = m2 = m3 = true;
			dis.setEnabled(false);
			dis.setEditable(false);
			disc.setEnabled(false);
			disc.setEditable(false);
			p.setEnabled(false);
			end.setEnabled(true);
		}
	}
	
	class Pro implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// 获取优惠策略
			if(p.isEnabled()){
			PromotionListVO m  = ctrl.getPro();
			ListVO li= m.getList();
			int x = m.getPaper();
			int y = m.getNum();
			pro = m.getMoney();
			gift = m.getList().getall();
			DialogMaker.getDialog("赠送"+x+"元代金券"+y+"张");
			String [] tatle = {"商品id","商品名","商品类型","商品数量","商品价格","总价格"};
			String [][] all = ctrl.getFree(li);
			DialogMaker.getTable(tatle, all);
			m2 = true;
			if(!dis.getText().equals("")){
				m1 = true;
			}
			if(!disc.getText().equals("")){
				m3 = true;
			}
			if(m1&&m2&&m3){
				end.setEnabled(true);
			}
		}
		}
		
	}
	
	class End implements ActionListener{

		JButton th;
		public End(JButton end) {
			//判断是否可使用
			th = end;
		}

		public void actionPerformed(ActionEvent e) {
			//结束后需要改变的东西有marketFrame
			if(th.isEnabled()){
				//更新逻辑层
				if(dis.getText().equals("")){
					paper = 0;
				}
				else{
				paper =Integer.parseInt(dis.getText());
				}
				if(disc.getText().equals("")){
					double pro1 = 0;
				}
				double pro1 = Double.parseDouble(disc.getText());
				//折扣金额，礼物折扣，策略折扣，销售员折扣
				ctrl.endList(paper,gift,pro,pro1);
				
			}
		}
		
	}
	
	class Check implements FocusListener{

		JTextField m;
		public Check(JTextField d) {
			// TODO Auto-generated constructor stub
			m = d;
		}

		public void focusGained(FocusEvent e) {

			
		}

		public void focusLost(FocusEvent e) {
			if(!dis.getText().equals("")){
				m1 = true;
			}
			else{
				dis.setText("");
			}
			if(!disc.getText().equals("")){
				m3 = true;
			}
			else{
				disc.setText("");
			}
			if(m1&&m2&&m3){
				end.setEnabled(true);
			}
			
		}
		
	}

}
