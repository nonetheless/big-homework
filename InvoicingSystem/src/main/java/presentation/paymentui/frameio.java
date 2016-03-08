package presentation.paymentui;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import presentation.accountui.accountFrame;
import presentation.accountui.accountFrame.aclistener;
import presentation.accountui.accountFrame.backlistener;
import presentation.accountui.accountFrame.cglistener;
import presentation.accountui.accountFrame.cplistener;
import presentation.accountui.accountFrame.cslistener;
import presentation.accountui.accountFrame.pclistener;
import presentation.accountui.accountFrame.piolistener;
import presentation.checkui.checkprocessframe;
import presentation.checkui.checksaleframe;
import presentation.checkui.checksituationframe;
import presentation.loginui.LoginUI;




public class frameio {
	JFrame ioframe=new JFrame("收款付款");
	payin_payout_panel mpanel;
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
	public frameio(String s,String iden){
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
		ioframe.setIconImage(bg_icon);
		ioframe.setBounds((screenWidth-1000)/2, (screenHeight-600)/4, 1000, 600);
		mpanel=new payin_payout_panel(operator);
		ioframe.setContentPane(mpanel);
		ioframe.add(a);
		mpanel.setVisible(true);
		ioframe.setVisible(true);
		ioframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ioframe.repaint();
	}
	public class aclistener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			accountFrame f=new accountFrame(operator,operatorid);
			ioframe.dispose();
		}
		
	}
	public class piolistener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			frameio f=new frameio(operator,operatorid);
			ioframe.dispose();
		}
		
	}
	public class pclistener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			framecash f=new framecash(operator,operatorid);
			ioframe.dispose();
		}
		
	}
	public class cglistener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			checksaleframe f=new checksaleframe(operator,operatorid);
			ioframe.dispose();
		}
		
	}
	public class cslistener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			checksituationframe f=new checksituationframe(operator,operatorid);
			ioframe.dispose();
		}
		
	}
	public class cplistener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			checkprocessframe f=new checkprocessframe(operator,operatorid);
			ioframe.dispose();
		}
		
	}
	public class backlistener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			LoginUI f=new LoginUI();
			ioframe.dispose();
		}
		
	}
	
	public static void main(String args[]){
		frameio f=new frameio("liuzhijia","财务人员");
		
	}

}
