/**
 * 供审批单据与制定促销策略作继承的根界面
 */
package presentation.promotionui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

public class ManageFrame extends JFrame{
	
	public JPanel rootPanel;
	
	protected JPanel headPanel;
	
	JLabel header;
	JLabel date;
	
	public String user;
	
	public ManageFrame(String UserName){
		
		user=UserName;
		
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension screenSize=kit.getScreenSize();
		int screenWidth=screenSize.width;
		int screenHeight=screenSize.height;
		setBounds((int)(0.5*(screenWidth-1000)), (int)(0.5*(screenHeight-600)), 1000, 600);
		setResizable(false);
		
		rootPanel=new JPanel();
		rootPanel.setBounds(0,0,1000,600);
		rootPanel.setLayout(null);
		setContentPane(rootPanel);
		
		headPanel=new JPanel();
		headPanel.setBounds(0,0,1000,50);
		headPanel.setBorder(new MatteBorder(0,0,3,0,(Color)new Color(0,0,0)));
		headPanel.setLayout(null);
		rootPanel.add(headPanel);
		
		Image bg_icon=kit.getImage("Image//login_icon.jpg");
		setIconImage(bg_icon);
		
		header=new JLabel("Welcome  "+user);
		header.setBounds(30, 0, 200, 50);
		headPanel.add(header);
		
		this.setVisible(true);
	}
}
