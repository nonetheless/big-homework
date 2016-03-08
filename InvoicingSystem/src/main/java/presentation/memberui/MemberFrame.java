package presentation.memberui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import presentation.loginui.LoginUI;
import uidialog.GggFrame;

public class MemberFrame{
	GggFrame frame;
	MemberFrameCtrl ctrl;
	int width;
	int height;
	public MemberFrame(String saler){
		ctrl = new MemberFrameCtrl(saler);
		frame = new GggFrame();
		frame.setUser(saler);
		width = 1000;
		height = 600;
		MPanel m = new MPanel(ctrl);
		m.setBounds(0, height/15, width, height/15*14);
		frame.add(m);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.repaint();
	}
	
	class Out implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// 退出的按钮
			System.exit(0);
		}
	} 
	
	class Sign implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// 登出的按钮
			LoginUI log = new LoginUI();
			log.setVisible(true);
			frame.dispose();
			
		}	
	} 
	
	public static void main(String[] args){
		MemberFrame frame = new MemberFrame("ggg");
	}

}
