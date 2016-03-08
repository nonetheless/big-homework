package presentation.promotionui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

public class PromotionUI extends ManageFrame{
	
	JButton backButton;
	
	JPanel menuPanel;
	JPanel InfoPanel;
	
	JButton vipButton;
	JButton totalButton;
	JButton pkgButton;
	JButton giftButton;
	
	//JLabel giftInfo;
	//JButton goGift;
	
	int view;

	public PromotionUI(String UserName,int view) {
		super(UserName);
		// TODO Auto-generated constructor stub
		
		
		this.view=view;
		setTitle("制定促销策略");
		
		backButton =new JButton("返回");
		backButton.setBounds(850, 10, 100,30 );
		headPanel.add(backButton);
		backButton.setVisible(true);
		
		menuPanel=new JPanel();
		menuPanel.setBounds(0, 50, 200, 550);
		menuPanel.setBorder(new MatteBorder(0,0,0,3,(Color) new Color(0, 0, 0)));
		menuPanel.setLayout(null);
		rootPanel.add(menuPanel);
		
		InfoPanel=new JPanel();
		InfoPanel.setBounds(200, 50, 800, 550);
		InfoPanel.setLayout(null);
		rootPanel.add(InfoPanel);
		
		vipButton=new JButton("Vip优惠");
		vipButton.setBounds(20, 70, 150, 50);
		vipButton.setFont(new Font(Font.DIALOG,Font.BOLD,15));
		menuPanel.add(vipButton);
		
		totalButton=new JButton("总价额满优惠");
		totalButton.setBounds(20, 140, 150, 50);
		totalButton.setFont(new Font(Font.DIALOG,Font.BOLD,15));
		menuPanel.add(totalButton);
		
		pkgButton=new JButton("特价包优惠");
		pkgButton.setBounds(20, 210, 150, 50);
		pkgButton.setFont(new Font(Font.DIALOG,Font.BOLD,15));
		menuPanel.add(pkgButton);
		
		giftButton=new JButton("VIP赠送");
		giftButton.setBounds(20, 280, 150, 50);
		giftButton.setFont(new Font(Font.DIALOG,Font.BOLD,15));
		menuPanel.add(giftButton);
		
		/*
		giftInfo=new JLabel("今天您有XX个客户需要赠送礼品");
		giftInfo.setBounds(150, 250, 300, 50);
		InfoPanel.add(giftInfo);
		
		goGift=new JButton("去赠送");
		goGift.setBounds(250, 350, 150, 50);
		goGift.setFont(new Font(Font.DIALOG,Font.BOLD,15));
		InfoPanel.add(goGift);
		*/
		
	}
	
}
