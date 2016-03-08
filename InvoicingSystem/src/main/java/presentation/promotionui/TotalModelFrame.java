package presentation.promotionui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import vo.TotalCouponVO;
import vo.TotalGiftVO;
import vo.TotalPromotionVO;
import businesslogic.promotionbl.TotalCouponPromotionController;
import businesslogic.promotionbl.TotalGiftPromotionController;
import businesslogic.promotionbl.TotalPromotionMethodController;

public class TotalModelFrame extends PromotionUI{
	
	double totalMoney;
	
	TotalPromotionMethodController tpm;
	TotalCouponPromotionController tcp;
	TotalGiftPromotionController tgp;
	
	String[][] couponData;
	String[][] giftData;
	
	
	JTable couponTable;
	JScrollPane couponStockPanel;
	
	JTable giftTable;
	JScrollPane giftStockPanel;
	
	JLabel disLabel;
	JTextField disTxt;
	
	JButton addCoupon;
	JButton delCoupon;
	JButton editCoupon;
	
	JButton addGift;
	JButton delGift;
	JButton editGift;
	
	JButton addDis;
	JButton delDis;
	JButton editDis;
	
	public TotalModelFrame(String UserName, int view,double totalMoney) {
		super(UserName, view);
		// TODO Auto-generated constructor stub
		this.totalMoney=totalMoney;
		
		backButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new PromotionFrame(user,2);
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
		
		showCoupon();
		showGift();
	}
	
	////////////////////////Coupon-Start//////////////////////////////////////
	public void showCoupon(){
		
		addCoupon=new JButton("增加代金券");
		addCoupon.setBounds(590,60,125,20);
		InfoPanel.add(addCoupon);
		//addCoupon.addMouseListener(new addCouponLis());
		
		delCoupon=new JButton("删除代金券");
		delCoupon.setBounds(590,90,125,20);
		InfoPanel.add(delCoupon);
		//delCoupon.addMouseListener(new delCouponLis());
		
		editCoupon=new JButton("编辑代金券");
		editCoupon.setBounds(590,120,125,20);
		InfoPanel.add(editCoupon);
		//editCoupon.addMouseListener(new editCouponLis());
		
		tpm=new TotalPromotionMethodController();
		System.out.println("tm: "+totalMoney);
		ArrayList<TotalPromotionVO> list=tpm.getTotalMethod();
		for(int i=0;i<list.size();i++){
			System.out.println("i: "+i);
			System.out.println(list.get(i).getTotalPrice()+" "+
					list.get(i).getIsCoupon()+" "+list.get(i).getIsGift());
		}
		TotalPromotionVO mvo=tpm.getTotalMethod(totalMoney);
		
		String[] titleData={"总价额","代金券金额","数量","使用期限"};
		couponData=new String[1][4];
		
		if(mvo.getIsCoupon()){
			tcp=new TotalCouponPromotionController();
			TotalCouponVO cvo=tcp.getTotalCoupon(totalMoney);
			ArrayList<TotalCouponVO> clist=tcp.getTotalCouponList();
			
			for(int i=0;i<clist.size();i++){
				System.out.println(clist.get(i).getTotalMoney()+" "+
						clist.get(i).getNum()+" "+clist.get(i).getPrice()+" "+clist.get(i).getEndDate());
			}
			System.out.println();
			
			if(cvo!=null){
				couponData[0][0]=String.valueOf(cvo.getTotalMoney());
				couponData[0][1]=String.valueOf(cvo.getPrice());
				couponData[0][2]=String.valueOf(cvo.getNum());
				couponData[0][3]=String.valueOf(cvo.getEndDate());
				
				addCoupon.setEnabled(false);
				delCoupon.setEnabled(true);
				delCoupon.addMouseListener(new delCouponLis());
				editCoupon.setEnabled(true);
				editCoupon.addMouseListener(new editCouponLis());
			}
			else{
				couponData[0][0]=String.valueOf(totalMoney);
				for(int i=1;i<4;i++){
					couponData[0][i]="无";
				}
				addCoupon.setEnabled(true);
				addCoupon.addMouseListener(new addCouponLis());
				delCoupon.setEnabled(false);
				editCoupon.setEnabled(false);
			}	
		}
		else{
			couponData[0][0]=String.valueOf(totalMoney);
			for(int i=1;i<4;i++){
				couponData[0][i]="无";
			}
			addCoupon.setEnabled(false);
			delCoupon.setEnabled(false);
			editCoupon.setEnabled(false);
		}
		couponTable=new JTable(couponData,titleData);
		couponTable.setRowHeight(25);
		couponTable.repaint();
		couponStockPanel = new JScrollPane(couponTable);
		couponStockPanel.setViewportView(couponTable);
		couponStockPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		couponStockPanel.setBounds(50,75,500,60);
		couponStockPanel.repaint();
		InfoPanel.add(couponStockPanel);
		
		InfoPanel.repaint();
	}
	
	public class addCouponLis implements MouseListener{

		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			tcp=new TotalCouponPromotionController();
			DialogForChoice dfc=new DialogForChoice();
			String temp=dfc.threeGet("请输入代金券信息", "代金券金额", "代金券数量",
					 "使用期限", "", "", "");
			if(!temp.equals("no")){
				String []res=temp.split(" ");
				TotalCouponVO tcv=new TotalCouponVO(Double.parseDouble((String)couponTable.getValueAt(0, 0)),
					Integer.parseInt(res[0]),Integer.parseInt(res[1]),res[2]);
				String result=tcp.addTotalCoupon(tcv);
				JOptionPane.showMessageDialog(null,result);
				
				InfoPanel.removeAll();
				InfoPanel.setLayout(null);
				showCoupon();
				showGift();
			}
		}

		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub	
		}
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
		}
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub	
		}
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub	
		}
	}
	
	public class delCouponLis implements MouseListener{

		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			tcp=new TotalCouponPromotionController();
			String result=tcp.delTotalCoupon(totalMoney);
			JOptionPane.showMessageDialog(null,result);
			
			InfoPanel.removeAll();
			InfoPanel.setLayout(null);
			showCoupon();
			showGift();
		}

		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
		}
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
		}
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
		}
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub	
		}
	}
	
	public class editCouponLis implements MouseListener{

		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			tcp=new TotalCouponPromotionController();
			DialogForChoice dfc=new DialogForChoice();
			String temp=dfc.threeGet("请输入代金券信息", "代金券金额", "代金券数量",
					 "使用期限", (String)couponTable.getValueAt(0, 1),(String)couponTable.getValueAt(0, 2),
					(String)couponTable.getValueAt(0, 3));
			if(!temp.equals("no")){
				String []res=temp.split(" ");
				TotalCouponVO vcv=new TotalCouponVO(Double.parseDouble((String)couponTable.getValueAt(0, 0)),
					Integer.parseInt(res[0]),Integer.parseInt(res[1]),res[2]);
				String result=tcp.editTotalCoupon(vcv);
				JOptionPane.showMessageDialog(null,result);
				
				InfoPanel.removeAll();
				InfoPanel.setLayout(null);
				showCoupon();
				showGift();
			}
		}

		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub	
		}
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub	
		}
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub	
		}
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub	
		}
	}
	////////////////////////Counpon_End///////////////////////////////////////
	
	
	////////////////////////Gift-Start////////////////////////////////////////
	public void showGift(){
		
		addGift=new JButton("增加赠品");
		addGift.setBounds(170,430,125,30);
		InfoPanel.add(addGift);
		//addGift.addMouseListener(new addGiftLis());
		
		delGift=new JButton("删除赠品");
		delGift.setBounds(320,430,125,30);
		InfoPanel.add(delGift);
		//delGift.addMouseListener(new delGiftLis());
		
		editGift=new JButton("编辑赠品");
		editGift.setBounds(470,430,125,30);
		InfoPanel.add(editGift);
		//editGift.addMouseListener(new editGiftLis());
		
		tpm=new TotalPromotionMethodController();
		TotalPromotionVO mvo=tpm.getTotalMethod(totalMoney);
		
		String[] titleData={"总价额", "商品编号", "商品名", "种类", "价格", "数量"};
		giftData=new String[100][6];
		
		if(mvo.getIsGift()){
			tgp=new TotalGiftPromotionController();
			ArrayList<TotalGiftVO> glist=tgp.getTotalGift(totalMoney);
			
			for(int i=0;i<glist.size();i++){
				System.out.println(glist.get(i).getTotalMoney()+" "+glist.get(i).getName()+" "+
						glist.get(i).getNum()+" "+glist.get(i).getPrice());
			}
			System.out.println();
			
			if(glist.size()>0){
				for(int i=0;i<glist.size();i++){
					giftData[i][0]=String.valueOf(glist.get(i).getTotalMoney());
					giftData[i][1]=glist.get(i).getId();
					giftData[i][2]=glist.get(i).getName();
					giftData[i][3]=glist.get(i).getKind();
					giftData[i][4]=String.valueOf(glist.get(i).getPrice());
					giftData[i][5]=String.valueOf(glist.get(i).getNum());
				}
				
				addGift.setEnabled(true);
				addGift.addMouseListener(new addGiftLis());
				delGift.setEnabled(true);
				delGift.addMouseListener(new delGiftLis());
				editGift.setEnabled(true);
				editGift.addMouseListener(new editGiftLis());
			}
			else{
				addGift.setEnabled(true);
				addGift.addMouseListener(new addGiftLis());
				delGift.setEnabled(false);
				editGift.setEnabled(false);
			}
		}
		else{
			addGift.setEnabled(false);
			delGift.setEnabled(false);
			editGift.setEnabled(false);
		}
		giftTable=new JTable(giftData,titleData);
		giftTable.setRowHeight(25);
		giftTable.repaint();
		giftStockPanel = new JScrollPane(giftTable);
		giftStockPanel.setViewportView(giftTable);
		giftStockPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		giftStockPanel.setBounds(50,200,680,200);
		giftStockPanel.repaint();
		InfoPanel.add(giftStockPanel);
		
		InfoPanel.repaint();
	}
	
	public class addGiftLis implements MouseListener{
		
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			DialogForChoice dfc=new DialogForChoice();
			String temp=dfc.chooseCommodityforTotal("请选择赠品");
			if(!temp.equals("no")){
			String []str=temp.split(" ");
			TotalGiftVO gvo=new TotalGiftVO(totalMoney,str[0],str[1],str[2],
					Double.parseDouble(str[3]),Integer.parseInt(str[4]));
			tgp=new TotalGiftPromotionController();
			String result=tgp.addTotalGift(gvo);
			JOptionPane.showMessageDialog(null,result);
			
			InfoPanel.removeAll();
			showCoupon();
			showGift();
			}
		}

		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
		}
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
		}
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub	
		}
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
		}
	}
	
	public class delGiftLis implements MouseListener{
		
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			int row=giftTable.getSelectedRow();
			if(row>=0&&giftTable.getValueAt(row, 0)!=null){
				tgp=new TotalGiftPromotionController();
				String money=(String)giftTable.getValueAt(row, 0);
				String id=(String)giftTable.getValueAt(row, 1);
				String name=(String)giftTable.getValueAt(row, 2);
				String kind=(String)giftTable.getValueAt(row, 3);
				String price=(String)giftTable.getValueAt(row, 4);
				String num=(String)giftTable.getValueAt(row, 5);
				TotalGiftVO vo=new TotalGiftVO(Double.parseDouble(money),id,name,kind,Double.parseDouble(price),
						Integer.parseInt(num));
				String result=tgp.delTotalGift(vo);
				JOptionPane.showMessageDialog(null,result);
				
				InfoPanel.removeAll();
				showGift();
				showCoupon();
			}
			else{
				JOptionPane.showMessageDialog(null,"请选中您所希望删除的赠品");
			}
		}
		
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
		}
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
		}
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
		}
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub	
		}
	}
	
	public class editGiftLis implements MouseListener{
		
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			int row=giftTable.getSelectedRow();
			if(row>=0&&giftTable.getValueAt(row, 0)!=null){
				tgp=new TotalGiftPromotionController();
				
				String money=(String)giftTable.getValueAt(row, 0);
				String id=(String)giftTable.getValueAt(row, 1);
				String name=(String)giftTable.getValueAt(row, 2);
				String kind=(String)giftTable.getValueAt(row, 3);
				String price=(String)giftTable.getValueAt(row, 4);
				String num=(String)giftTable.getValueAt(row, 5);
				
				DialogForChoice dfc=new DialogForChoice();
				String t=dfc.oneGet("请编辑信息", "int","数量" ,num);
				System.out.println("t: "+t);
				
				if(!t.equals("no")){
				TotalGiftVO vo=new TotalGiftVO(Double.parseDouble(money),id,name,kind,Double.parseDouble(price),
						Integer.parseInt(t));
				String result=tgp.editTotalGift(vo);
				JOptionPane.showMessageDialog(null,result);
				
				InfoPanel.removeAll();
				showGift();
				showCoupon();
				}
			}
			else{
				JOptionPane.showMessageDialog(null,"请选中您所希望编辑的赠品");
			}
		}

		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
		}
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
		}
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
		}
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
		}
	}
	////////////////////////Gift-End//////////////////////////////////////////
}
