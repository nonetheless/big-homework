package presentation.promotionui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;

import vo.BuyingVO;
import vo.SpVO;
import businesslogic.promotionbl.VipPromotion;

public class SendGiftFrame extends PromotionUI{
	
	int level;
	
	JLabel levelLabel;
	JLabel clabel;
	JLabel gLabel;
	
	String[][] couponData;
	String[][] giftData;
	
	JTable couponTable;
	JScrollPane couponStockPanel;
	
	JTable giftTable;
	JScrollPane giftStockPanel;

	public SendGiftFrame(String UserName, int view, int viplevel) {
		super(UserName, view);
		// TODO Auto-generated constructor stub
		level=viplevel;
		setTitle("查看赠品");
		
		backButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new PromotionFrame(user,4);
				dispose();
			}
		});
		
		vipButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new PromotionFrame(user,1);
				dispose();
			}
			
		});
		
		totalButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new PromotionFrame(user,2);
				dispose();
			}
			
		});
		
		pkgButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new PromotionFrame(user,3);
				dispose();
			}
			
		});
		
		giftButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new PromotionFrame(user,4);
				dispose();
			}
			
		});
		
		String str="VIP等级："+level;
		levelLabel=new JLabel(str);
		levelLabel.setBounds(50, 10, 150, 50);
		levelLabel.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 20));
		InfoPanel.add(levelLabel);
		
		showAll();
	}
	
	public void getData(int level){
		
		VipPromotion vp=new VipPromotion();
		ArrayList<SpVO> list=vp.getGift();
		
		SpVO svo=null;
		for(int i=0;i<list.size();i++){
			svo=list.get(i);
			int vlevel=svo.getMemberList().get(0).getLevel();
			if(vlevel==level){
				break;
			}
		}
		
		couponData=new String[1][3];
		couponData[0][0]=String.valueOf(svo.getPaper());
		couponData[0][1]=String.valueOf(svo.getNum());
		couponData[0][2]=svo.getPaperDeadine();
		
		ArrayList<BuyingVO> glist=svo.getGiftList();
		giftData=new String[100][5];
		for(int i=0;i<glist.size();i++){
			giftData[i][0]=glist.get(i).getId();
			giftData[i][1]=glist.get(i).getName();
			giftData[i][2]=glist.get(i).getKind();
			giftData[i][3]=String.valueOf(glist.get(i).getPrice());
			giftData[i][4]=String.valueOf(glist.get(i).getNumber());
		}
	}
	

	public void showCoupon(){
		
		String[] titleData={"代金券金额","数量","使用期限"};
		
		clabel=new JLabel("代金券");
		clabel.setBounds(50, 100, 150, 50);
		clabel.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 20));
		InfoPanel.add(clabel);
		
		couponTable=new JTable(couponData,titleData);
		couponTable.setRowHeight(25);
		couponTable.repaint();
		couponStockPanel = new JScrollPane(couponTable);
		couponStockPanel.setViewportView(couponTable);
		couponStockPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		couponStockPanel.setBounds(180,100,500,60);
		couponStockPanel.repaint();
		InfoPanel.add(couponStockPanel);
		
		InfoPanel.repaint();
	}
	

	public void showGift(){
		
		String[] titleData={ "赠品编号", "赠品名", "种类", "价格", "数量"};
		
		gLabel=new JLabel("赠品列表");
		gLabel.setBounds(50, 190, 150, 50);
		gLabel.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 20));
		InfoPanel.add(gLabel);
		
		giftTable=new JTable(giftData,titleData);
		giftTable.setRowHeight(25);
		giftTable.repaint();
		giftStockPanel = new JScrollPane(giftTable);
		giftStockPanel.setViewportView(giftTable);
		giftStockPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		giftStockPanel.setBounds(50,250,680,200);
		giftStockPanel.repaint();
		InfoPanel.add(giftStockPanel);
		
		InfoPanel.repaint();
	}
	
	public void showAll(){
		getData(level);
		showCoupon();
		showGift();
	}
	
}
