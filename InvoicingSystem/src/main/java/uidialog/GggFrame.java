package uidialog;
/**@author xinlin
 * Market和Member的模版，包含了菜单栏
 * 
 */

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import presentation.loginui.LoginUI;
import presentation.marketui.MarketFrame;
import presentation.memberui.MemberFrame;


public class GggFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int width;
	int height;
	String user;
	public GggFrame(){
		super();
		Toolkit tool= Toolkit.getDefaultToolkit();
		Dimension scr = tool.getScreenSize();
		width = 1000;
		height = 600;
		this.setBounds(scr.width/2-width/2,scr.height/2-height/2 , width, height);
		JMenuBar a = new JMenuBar();
		JMenu menu = new JMenu("menu");
		JMenuItem out = new JMenuItem("退出");
		JMenuItem signout = new JMenuItem("登出");
		JMenuItem sale = new JMenuItem("销售任务");
		JMenuItem mem = new JMenuItem("客户管理");
		sale.addActionListener(new Sa(this));
		mem.addActionListener(new Me(this));
		out.addActionListener (new Out());
		signout.addActionListener(new Sign(this));
		menu.add(out);
		menu.add(signout);
		menu.add(mem);
		menu.add(sale);
		a.add(menu);
		this.add(a);
		this.setLayout(null);
		a.setBounds(0, 0, width, height/15);
		this.setVisible(true);
		this.setResizable(false);
		this.repaint();
	}
	
	class Me implements ActionListener{

		JFrame a;
		public Me(JFrame ggg) {
			a = ggg;
		}

		public void actionPerformed(ActionEvent e) {
			// 换界面
			MemberFrame b = new MemberFrame(user);
			a.dispose();
		}
		
	}
	
	class Sa implements ActionListener{

		JFrame a;
		public Sa(JFrame ggg) {
			// TODO Auto-generated constructor stub
			a = ggg;
		}

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			MarketFrame b = new MarketFrame(user);
			a.dispose();
		}
		
	}
	
	class Out implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// 退出的按钮
			System.exit(0);
		}
	} 
	
	class Sign implements ActionListener{
		JFrame a;
		public Sign(JFrame frame){
			a = frame;
		}

		public void actionPerformed(ActionEvent e) {
			// 登出的按钮
			LoginUI log = new LoginUI();
			log.setVisible(true);
			a.dispose();
			
		}	
	}

	public void setUser(String saler) {
		// TODO Auto-generated method stub
		user = saler;
	} 

}
