package presentation.promotionui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.MatteBorder;

import businesslogic.promotionbl.VipPromotion;
import presentation.billmanagementui.BillData;
import presentation.billmanagementui.BillFrame;
import presentation.checkui.checkprocessframe;
import presentation.checkui.checksaleframe;
import presentation.checkui.checksituationframe;
import presentation.loginui.LoginUI;
import vo.SpVO;

public class WelcomeFrame extends ManageFrame{
	
	JPanel menuPanel;
	JPanel InfoPanel;
	
	JButton proButton;
	JButton billButton;
	JButton mxButton;       //查看销售明细
	JButton lcButton;       //查看经营历程
	JButton qkButton;       //查看经营情况
	
	JButton backButton;
	
	JLabel billInfo;
	JButton goBill;
	
	JLabel giftInfo;
	JButton goGift;
	
	
	public WelcomeFrame(String UserName) {
		super(UserName);
		// TODO Auto-generated constructor stub
		
		BillData bd=new BillData();
		int num=bd.getBillData();
		String str="今天您有"+num+"个单据需要审批";
		
		VipPromotion vp=new VipPromotion();
		ArrayList<SpVO> list=vp.getGift();
		String sstr="今天您有"+list.size()+"个vip等级对应的客户有礼品要赠送";

		String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
		try{	
			UIManager.setLookAndFeel(lookAndFeel);			
		}catch (UnsupportedLookAndFeelException ex1) {			       
			System.err.println("Unsupported LookAndFeel: ");
		}catch (ClassNotFoundException ex2){
			System.err.println("LookAndFeel class not found: ");	   
		}catch (InstantiationException ex3){
			System.err.println("Could not load LookAndFeel: ");
		}catch (IllegalAccessException ex4){
			System.err.println("Cannot use LookAndFeel: ");
		}
		
		setTitle("欢迎总经理使用！");
		
		menuPanel=new JPanel();
		menuPanel.setBounds(0, 50, 200, 550);
		menuPanel.setBorder(new MatteBorder(0,0,0,3,(Color) new Color(0, 0, 0)));
		menuPanel.setLayout(null);
		rootPanel.add(menuPanel);
		
		InfoPanel=new JPanel();
		InfoPanel.setBounds(200, 50, 800, 550);
		InfoPanel.setLayout(null);
		rootPanel.add(InfoPanel);
		
		proButton=new JButton("制定促销策略");
		proButton.setBounds(20, 70, 150, 50);
		proButton.setFont(new Font(Font.DIALOG,Font.BOLD,15));
		proButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new PromotionFrame(user,1);
				dispose();
			}
			
		});
		menuPanel.add(proButton);
		
		billButton=new JButton("审批单据");
		billButton.setBounds(20, 140, 150, 50);
		billButton.setFont(new Font(Font.DIALOG,Font.BOLD,15));
		billButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new BillFrame(user);
				dispose();
			}
			
		});
		menuPanel.add(billButton);
		
		mxButton=new JButton("查看销售明细");
		mxButton.setBounds(20, 210, 150, 50);
		mxButton.setFont(new Font(Font.DIALOG,Font.BOLD,15));
		mxButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new checksaleframe(user,"总经理");
				dispose();
			}
			
		});
		menuPanel.add(mxButton);
		
		lcButton=new JButton("查看经营历程");
		lcButton.setBounds(20, 280, 150, 50);
		lcButton.setFont(new Font(Font.DIALOG,Font.BOLD,15));
		lcButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new checkprocessframe(user,"总经理");
				dispose();
			}
			
		});
		menuPanel.add(lcButton);
		
		qkButton=new JButton("查看经营情况");
		qkButton.setBounds(20, 350, 150, 50);
		qkButton.setFont(new Font(Font.DIALOG,Font.BOLD,15));
		qkButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new checksituationframe(user,"总经理");
				dispose();
			}
			
		});
		menuPanel.add(qkButton);
		
		menuPanel.repaint();
	
		billInfo=new JLabel(str);
		billInfo.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 30));
		billInfo.setBounds(100, 100, 600, 50);
		InfoPanel.add(billInfo);
		
		goBill=new JButton("去审批");
		goBill.setBounds(450, 170, 150, 50);
		goBill.setFont(new Font(Font.DIALOG,Font.BOLD,15));
		InfoPanel.add(goBill);
		goBill.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new BillFrame(user);
				dispose();
			}
			
		});
		
		
		giftInfo=new JLabel(sstr);
		giftInfo.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 30));
		giftInfo.setBounds(100, 250, 700, 50);
		InfoPanel.add(giftInfo);
		
		goGift=new JButton("去赠送");
		goGift.setBounds(450, 320, 150, 50);
		goGift.setFont(new Font(Font.DIALOG,Font.BOLD,15));
		InfoPanel.add(goGift);
		goGift.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new PromotionFrame(user, 4);
				dispose();
			}
			
		});
		
		backButton =new JButton("退出登录");
		backButton.setBounds(830, 10, 120,30 );
		headPanel.add(backButton);
		backButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new LoginUI();
				dispose();
			}
			
		});
		
		InfoPanel.repaint();
		headPanel.repaint();
	}
	
}