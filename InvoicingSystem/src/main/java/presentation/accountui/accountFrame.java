package presentation.accountui;


import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import presentation.checkui.checkprocessframe;
import presentation.checkui.checksaleframe;
import presentation.checkui.checksituationframe;
import presentation.loginui.LoginUI;
import presentation.paymentui.framecash;
import presentation.paymentui.frameio;





public class accountFrame{
	JFrame accountframe=new JFrame("账户管理");
	
	mainpanel mpanel;
	int screenWidth,screenHeight,frameHeight,frameWidth;
	String operator;String operatorid;
	
	JMenuBar a = new JMenuBar();
	JMenu menu = new JMenu("菜单");
	JMenuItem ac=new JMenuItem("账户管理");
	JMenuItem pio=new JMenuItem("收款付款");
	JMenuItem pc=new JMenuItem("现金付款");
	JMenuItem cg=new JMenuItem("查看销售");
	JMenuItem cs=new JMenuItem("查看经营情况");
	JMenuItem cp=new JMenuItem("查看经营历程");
	
	JMenuItem back=new JMenuItem("登出");
	public accountFrame(String s,String iden){
		ac.addActionListener(new aclistener());
		pio.addActionListener(new piolistener());
		pc.addActionListener(new pclistener());
		cg.addActionListener(new cglistener());
		cs.addActionListener(new cslistener());
		cp.addActionListener(new cplistener());
		
		
		back.addActionListener(new backlistener());
		menu.add(ac);
		menu.add(pio);
		menu.add(pc);
		menu.add(cg);
		menu.add(cs);
		menu.add(cp);
		
		menu.add(back);
		a.add(menu);
		a.setBounds(0, 0, 1000, 600/15);a.setVisible(true);
		
		
		operator=s;operatorid=iden;
	    Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension screenSize=kit.getScreenSize();
		screenWidth=screenSize.width;
		screenHeight=screenSize.height;
		
		Image bg_icon=kit.getImage("Image//login_icon.jpg");
		accountframe.setIconImage(bg_icon);
		accountframe.setBounds((screenWidth-1000)/2, (screenHeight-600)/4, 1000, 600);
		mpanel=new mainpanel();
		accountframe.setContentPane(mpanel);
		accountframe.add(a);
		mpanel.setVisible(true);
	    accountframe.setVisible(true);
	    accountframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    accountframe.repaint();
	}
	public class aclistener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			
			// TODO Auto-generated method stub
			    accountFrame f=new accountFrame(operator,operatorid);
			    accountframe.dispose();
			
			
		}
		
	}
	public class piolistener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
				
			
			    frameio f=new frameio(operator,operatorid);
			    accountframe.dispose();
			
			
		}
		
	}
	public class pclistener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			   framecash f=new framecash(operator,operatorid);
			   accountframe.dispose();
			
			
			
		}
		
	}
	public class cglistener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			checksaleframe f=new checksaleframe(operator,operatorid);
			accountframe.dispose();
		}
		
	}
	public class cslistener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			checksituationframe f=new checksituationframe(operator,operatorid);
			accountframe.dispose();
		}
		
	}
	public class cplistener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			checkprocessframe f=new checkprocessframe(operator,operatorid);
			accountframe.dispose();
		}
		
	}
	
	public class backlistener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			LoginUI f=new LoginUI();
			accountframe.dispose();
		}
		
	}
	
	public static void main(String args[]){
		accountFrame f=new accountFrame("liuzhijia","总经理");
		
	}
	

}


