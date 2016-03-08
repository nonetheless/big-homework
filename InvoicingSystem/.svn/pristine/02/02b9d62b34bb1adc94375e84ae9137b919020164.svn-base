package presentation.checkui;

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

import presentation.accountui.accountFrame;
import presentation.accountui.accountFrame.aclistener;
import presentation.accountui.accountFrame.backlistener;
import presentation.accountui.accountFrame.cglistener;
import presentation.accountui.accountFrame.cplistener;
import presentation.accountui.accountFrame.cslistener;
import presentation.accountui.accountFrame.pclistener;
import presentation.accountui.accountFrame.piolistener;
import presentation.loginui.LoginUI;
import presentation.paymentui.framecash;
import presentation.paymentui.frameio;
import presentation.promotionui.WelcomeFrame;

public class checksituationframe {
	JFrame checksituationframe=new JFrame("查看经营情况");
	checksituationpanel mpanel;
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
	JMenuItem ma=new JMenuItem("总经理");
	JMenuItem back=new JMenuItem("登出");
	public checksituationframe(String s,String iden){
		ac.addActionListener(new aclistener());
		pio.addActionListener(new piolistener());
		pc.addActionListener(new pclistener());
		cg.addActionListener(new cglistener());
		cs.addActionListener(new cslistener());
		cp.addActionListener(new cplistener());
		ma.addActionListener(new malistener());
		back.addActionListener(new backlistener());
		menu.add(ac);
		menu.add(pio);
		menu.add(pc);
		menu.add(cg);
		menu.add(cs);
		menu.add(cp);
		menu.add(ma);
		menu.add(back);
		a.add(menu);
		a.setBounds(0, 0, 1000, 600/15);a.setVisible(true);
		operator=s;operatorid=iden;
	    Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension screenSize=kit.getScreenSize();
		screenWidth=screenSize.width;
		screenHeight=screenSize.height;
		
		Image bg_icon=kit.getImage("Image//login_icon.jpg");
		checksituationframe.setIconImage(bg_icon);
		checksituationframe.setBounds((screenWidth-1000)/2, (screenHeight-600)/4, 1000, 600);
		mpanel=new checksituationpanel();
		checksituationframe.setContentPane(mpanel);
		checksituationframe.add(a);
		mpanel.setVisible(true);
		checksituationframe.setVisible(true);
		checksituationframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		checksituationframe.repaint();
	}
	public class aclistener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			
			// TODO Auto-generated method stub
			if(operatorid.equals("财务人员")){
			    accountFrame f=new accountFrame(operator,operatorid);
			    checksituationframe.dispose();
			}
			else{
				JOptionPane.showMessageDialog(null, "你没有权限");
			}
		}
		
	}
	public class piolistener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(operatorid.equals("财务人员")){
			   frameio f=new frameio(operator,operatorid);
			   checksituationframe.dispose();
			}
			else{
				JOptionPane.showMessageDialog(null, "你没有权限");
			}
		}
		
	}
	public class pclistener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(operatorid.equals("财务人员")){
				framecash f=new framecash(operator,operatorid);
			    checksituationframe.dispose();
				
			}
			else{
				JOptionPane.showMessageDialog(null, "你没有权限");
			}
		}
		
	}
	public class cglistener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			checksaleframe f=new checksaleframe(operator,operatorid);
			checksituationframe.dispose();
		}
		
	}
	public class cslistener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			checksituationframe f=new checksituationframe(operator,operatorid);
			checksituationframe.dispose();
		}
		
	}
	public class cplistener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			checkprocessframe f=new checkprocessframe(operator,operatorid);
			checksituationframe.dispose();
		}
		
	}
	public class malistener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(operatorid.equals("总经理")){
				WelcomeFrame f=new WelcomeFrame(operator);
				checksituationframe.dispose();
			}
			else{
				JOptionPane.showMessageDialog(null, "你没有权限");
			}
		}
		
	}
	public class backlistener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			LoginUI f=new LoginUI();
			checksituationframe.dispose();
		}
		
	}
	public static void main(String args[]){
		checksituationframe f=new checksituationframe("liuzhijia","财务人员");
		
	}
}
