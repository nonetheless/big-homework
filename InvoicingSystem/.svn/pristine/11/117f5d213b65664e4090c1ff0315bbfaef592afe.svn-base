package presentation.checkui;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import businesslogic.checkbl.checkcontroller;
import vo.infoVO;
import po.BillPO;
import po.GiftListPO;
import po.SaleListPO;
import po.StackListPO;
import po.StockBillsPo;
import po.UnsaleListPO;
import po.UnstackListPO;

public class processframe2 {
	JPanel panel=new JPanel();
	JFrame frame=new JFrame("单据种类");
	infoVO v;
	JButton button1,button2,button3,button4,button5,button6,button7,button8,button9,button10;
	checkcontroller cc=new checkcontroller();
	int screenWidth,screenHeight,frameHeight,frameWidth;
	String operatorid;
	public processframe2(infoVO iv,String iden){
		v=iv;
		operatorid=iden;
		System.out.println(v.getbilltype());
		System.out.println(v.getcustomer());
		System.out.println(v.getgoods());
		System.out.println(v.getoprator());
		System.out.println(v.getstorehouse());
		System.out.println(v.gettime1());
		System.out.println(v.gettime2());
		button1=new JButton("查看库存报损单");
		button2=new JButton("查看销售单");
		button3=new JButton("查看销售退货单");
		button4=new JButton("查看进货单");
		button5=new JButton("查看退货单");
		button6=new JButton("查看赠品单");
		button7=new JButton("查看收款单");
		button8=new JButton("查看付款单");
		button9=new JButton("查看现金付款单");
		button10=new JButton("查看库存报溢单");
		
		button1.setBounds(200, 60, 200, 50);button1.setVisible(true);
		button10.setBounds(600, 60, 200, 50);button2.setVisible(true);
		button2.setBounds(200, 160, 200, 50);button3.setVisible(true);
		button3.setBounds(600, 160, 200, 50);button4.setVisible(true);
		button4.setBounds(200, 260, 200, 50);button5.setVisible(true);
		button5.setBounds(600, 260, 200, 50);button6.setVisible(true);
		button6.setBounds(200, 360, 200, 50);button7.setVisible(true);
		button7.setBounds(600, 360, 200, 50);button8.setVisible(true);
		button8.setBounds(200, 460, 200, 50);button9.setVisible(true);
		button9.setBounds(600, 460, 200, 50);button10.setVisible(true);
		
		panel.setLayout(null);
		panel.add(button1);panel.add(button2);panel.add(button3);panel.add(button4);
		panel.add(button5);panel.add(button6);panel.add(button7);panel.add(button8);
		panel.add(button9);panel.add(button10);
		
		    Toolkit kit=Toolkit.getDefaultToolkit();
			Dimension screenSize=kit.getScreenSize();
			screenWidth=screenSize.width;
			screenHeight=screenSize.height;
			
			Image bg_icon=kit.getImage("Image//login_icon.jpg");
			frame.setIconImage(bg_icon);
			frame.setBounds((screenWidth-1000)/2, (screenHeight-600)/4, 1000, 600);
			
			frame.setContentPane(panel);
			panel.setVisible(true);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.repaint();
			
			
			button1.addActionListener(new button1listener());
			button2.addActionListener(new button2listener());
			button3.addActionListener(new button3listener());
			button4.addActionListener(new button4listener());
			button5.addActionListener(new button5listener());
			button6.addActionListener(new button6listener());
			button7.addActionListener(new button7listener());
			button8.addActionListener(new button8listener());
			button9.addActionListener(new button9listener());
			button10.addActionListener(new button10listener());
		
	}
	public class button1listener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			ArrayList<BillPO> p=cc.checkstock(v);
			ArrayList<BillPO> sp=new ArrayList<BillPO>();
			for(int i=0;i<p.size();i++){
				if(p.get(i).getType().equals("loss")){
					sp.add(p.get(i));
				}
			}
			dialogmaker2 k=new dialogmaker2("stockloss",sp,operatorid);
		}
		
	}
	public class button2listener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			ArrayList<SaleListPO> p=cc.checksales(v);
			ArrayList<BillPO> sp=new ArrayList<BillPO>();
			for(int i=0;i<p.size();i++){
				sp.add(p.get(i));
			}
			dialogmaker2 k=new dialogmaker2("sale",sp,operatorid);
		}
		
	}
	public class button3listener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			ArrayList<UnsaleListPO> p=cc.checkunsales(v);
			ArrayList<BillPO> sp=new ArrayList<BillPO>();
			for(int i=0;i<p.size();i++){
				sp.add(p.get(i));
			}
			dialogmaker2 k=new dialogmaker2("unsale",sp,operatorid);
		}
		
	}
	public class button4listener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			ArrayList<StackListPO> p=cc.checkstack(v);
			ArrayList<BillPO> sp=new ArrayList<BillPO>();
			for(int i=0;i<p.size();i++){
				sp.add(p.get(i));
			}
			dialogmaker2 k=new dialogmaker2("stack",sp,operatorid);
		}
		
	}
	public class button5listener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			ArrayList<UnstackListPO> p=cc.checkunstack(v);
			ArrayList<BillPO> sp=new ArrayList<BillPO>();
			for(int i=0;i<p.size();i++){
				sp.add(p.get(i));
			}
			dialogmaker2 k=new dialogmaker2("unstack",sp,operatorid);
		}
		
	}
	public class button6listener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			ArrayList<GiftListPO> p=cc.checkgift(v);
			ArrayList<BillPO> sp=new ArrayList<BillPO>();
			for(int i=0;i<p.size();i++){
				sp.add(p.get(i));
			}
			dialogmaker2 k=new dialogmaker2("gift",sp,operatorid);
		}
		
	}
	public class button7listener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			ArrayList<BillPO> p=cc.checkpayment(v);
			ArrayList<BillPO> sp=new ArrayList<BillPO>();
			for(int i=0;i<p.size();i++){
				if(p.get(i).getType().equals("SKD")){
					sp.add(p.get(i));
				}
				
			}
			dialogmaker2 k=new dialogmaker2("in",sp,operatorid);
		}
		
	}
	public class button8listener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			ArrayList<BillPO> p=cc.checkpayment(v);
			ArrayList<BillPO> sp=new ArrayList<BillPO>();
			for(int i=0;i<p.size();i++){
				if(p.get(i).getType().equals("FKD")){
					sp.add(p.get(i));
				}
				
			}
			dialogmaker2 k=new dialogmaker2("out",sp,operatorid);
		}
		
	}
	public class button9listener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			ArrayList<BillPO> p=cc.checkpayment(v);
			ArrayList<BillPO> sp=new ArrayList<BillPO>();
			for(int i=0;i<p.size();i++){
				if(p.get(i).getType().equals("XJFKD")){
					sp.add(p.get(i));
				}
				
			}
			dialogmaker2 k=new dialogmaker2("cash",sp,operatorid);
		}
		
	}
	public class button10listener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			ArrayList<BillPO> p=cc.checkstock(v);
			ArrayList<BillPO> sp=new ArrayList<BillPO>();
			for(int i=0;i<p.size();i++){
				if(p.get(i).getType().equals("over")){
					sp.add(p.get(i));
				}
				
			}
			dialogmaker2 k=new dialogmaker2("stockover",sp,operatorid);
		}
		
	}
	/*public static void main(String args[]){
		processframe2 f=new processframe2(null);
		
	}*/
	
	
	

}
