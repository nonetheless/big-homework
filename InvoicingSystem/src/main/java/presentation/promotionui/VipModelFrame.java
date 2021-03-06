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

import vo.DiscountVO;
import vo.VipCouponVO;
import vo.VipGiftVO;
import vo.VipPromotionVO;
import businesslogic.promotionbl.VipCouponPromotionController;
import businesslogic.promotionbl.VipDiscountPromotionController;
import businesslogic.promotionbl.VipGiftPromotionController;
import businesslogic.promotionbl.VipPromotionMethodController;

public class VipModelFrame extends PromotionUI{
	
	VipPromotionMethodController vmc;
	VipCouponPromotionController vcc;
	VipGiftPromotionController vgc;
	VipDiscountPromotionController vdc;
	
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
	
	int level;

	public VipModelFrame(String UserName, int view, int viplevel) {
		super(UserName, view);
		// TODO Auto-generated constructor stub
		level=viplevel;
		setTitle("制定Vip优惠政策");
		
		backButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new PromotionFrame(user,1);
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
		showDiscount();
	}
	
	////////////////////////Coupon-Start/////////////////////////////////
	public void showCoupon(){
		
		addCoupon=new JButton("增加代金券");
		addCoupon.setBounds(590,10,125,20);
		InfoPanel.add(addCoupon);
		//addCoupon.addMouseListener(new addCouponLis());
		
		delCoupon=new JButton("删除代金券");
		delCoupon.setBounds(590,40,125,20);
		InfoPanel.add(delCoupon);
		//delCoupon.addMouseListener(new delCouponLis());
		
		editCoupon=new JButton("编辑代金券");
		editCoupon.setBounds(590,70,125,20);
		InfoPanel.add(editCoupon);
		//editCoupon.addMouseListener(new editCouponLis());
		
		vmc=new VipPromotionMethodController();
		VipPromotionVO mvo=vmc.getVipMethod(level);
		
		String[] titleData={"vip等级","代金券金额","数量","赠送日期","使用期限"};
		couponData=new String[1][5];
		
		if(mvo.getIsCoupon()){
			vcc=new VipCouponPromotionController();
			VipCouponVO cvo=vcc.getVipCoupon(level);
			ArrayList<VipCouponVO> clist=vcc.getVipCouponList();
			
			for(int i=0;i<clist.size();i++){
				System.out.println(clist.get(i).getVipLevel()+" "+
						clist.get(i).getNum()+" "+clist.get(i).getPrice()+" "+
						clist.get(i).getSendTime()+" "+clist.get(i).getEndDate());
			}
			System.out.println();
			
			if(cvo!=null){
				couponData[0][0]=String.valueOf(cvo.getVipLevel());
				couponData[0][1]=String.valueOf(cvo.getPrice());
				couponData[0][2]=String.valueOf(cvo.getNum());
				couponData[0][3]=String.valueOf(cvo.getSendTime());
				couponData[0][4]=String.valueOf(cvo.getEndDate());
				
				addCoupon.setEnabled(false);
				delCoupon.setEnabled(true);
				delCoupon.addMouseListener(new delCouponLis());
				editCoupon.setEnabled(true);
				editCoupon.addMouseListener(new editCouponLis());
			}
			else{
				couponData[0][0]=String.valueOf(level);
				for(int i=1;i<5;i++){
					couponData[0][i]="无";
				}
				addCoupon.setEnabled(true);
				addCoupon.addMouseListener(new addCouponLis());
				delCoupon.setEnabled(false);
				editCoupon.setEnabled(false);
			}	
		}
		else{
			couponData[0][0]=String.valueOf(level);
			for(int i=1;i<5;i++){
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
		couponStockPanel.setBounds(50,25,500,60);
		couponStockPanel.repaint();
		InfoPanel.add(couponStockPanel);
		
		InfoPanel.repaint();
	}
	
	public class addCouponLis implements MouseListener{

		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			vcc=new VipCouponPromotionController();
			String temp=DialogCreatorForPromotion.fourGet("请输入代金券信息", "代金券金额", "代金券数量",
					"赠送日期", "使用期限", "", "", "", "");
			System.out.println("代金券信息：："+temp);
			if(!temp.equals("no")){
				String []res=temp.split(" ");
				VipCouponVO vcv=new VipCouponVO(Integer.parseInt((String)couponTable.getValueAt(0, 0)),
					Integer.parseInt(res[0]),Integer.parseInt(res[1]),res[2],res[3]);
				String result=vcc.addVipCoupon(vcv);
				JOptionPane.showMessageDialog(null,result);
				
				InfoPanel.removeAll();
				InfoPanel.setLayout(null);
				showCoupon();
				showGift();
				showDiscount();
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
			vcc=new VipCouponPromotionController();
			String result=vcc.delVipCoupon(level);
			JOptionPane.showMessageDialog(null,result);
			
			InfoPanel.removeAll();
			InfoPanel.setLayout(null);
			showCoupon();
			showGift();
			showDiscount();
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
			vcc=new VipCouponPromotionController();
			String temp=DialogCreatorForPromotion.fourGet("请输入代金券信息", "代金券金额", "代金券数量",
					"赠送日期", "使用期限", (String)couponTable.getValueAt(0, 1),(String)couponTable.getValueAt(0, 2),
					(String)couponTable.getValueAt(0, 3),(String)couponTable.getValueAt(0, 4));
			if(!temp.equals("no")){
				String []res=temp.split(" ");
				VipCouponVO vcv=new VipCouponVO(Integer.parseInt((String)couponTable.getValueAt(0, 0)),
					Integer.parseInt(res[0]),Integer.parseInt(res[1]),res[2],res[3]);
				String result=vcc.editVipCoupon(vcv);
				JOptionPane.showMessageDialog(null,result);
				
				InfoPanel.removeAll();
				InfoPanel.setLayout(null);
				showCoupon();
				showGift();
				showDiscount();
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
    ////////////////////////Coupon-End///////////////////////////////////
	
	
	////////////////////////Gift-Start/////////////////////////////////
	public void showGift(){
		
		addGift=new JButton("增加赠品");
		addGift.setBounds(170,310,125,30);
		InfoPanel.add(addGift);
		//addGift.addMouseListener(new addGiftLis());
		
		delGift=new JButton("删除赠品");
		delGift.setBounds(320,310,125,30);
		InfoPanel.add(delGift);
		//delGift.addMouseListener(new delGiftLis());
		
		editGift=new JButton("编辑赠品");
		editGift.setBounds(470,310,125,30);
		InfoPanel.add(editGift);
		//editGift.addMouseListener(new editGiftLis());
		
		vmc=new VipPromotionMethodController();
		VipPromotionVO mvo=vmc.getVipMethod(level);
		
		String[] titleData={"vip等级", "商品编号", "商品名", "种类", "价格", "数量", "赠送日期"};
		giftData=new String[100][7];
		
		if(mvo.getIsGift()){
			vgc=new VipGiftPromotionController();
			ArrayList<VipGiftVO> glist=vgc.getVipGift(level);
			
			for(int i=0;i<glist.size();i++){
				System.out.println(glist.get(i).getVipLevel()+" "+glist.get(i).getName()+" "+
						glist.get(i).getNum()+" "+glist.get(i).getPrice()+" "+
						glist.get(i).getSendTime());
			}
			System.out.println();
			
			if(glist.size()>0){
				for(int i=0;i<glist.size();i++){
					giftData[i][0]=String.valueOf(glist.get(i).getVipLevel());
					giftData[i][1]=glist.get(i).getId();
					giftData[i][2]=glist.get(i).getName();
					giftData[i][3]=glist.get(i).getKind();
					giftData[i][4]=String.valueOf(glist.get(i).getPrice());
					giftData[i][5]=String.valueOf(glist.get(i).getNum());
					giftData[i][6]=glist.get(i).getSendTime();
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
		giftStockPanel.setBounds(50,100,680,200);
		giftStockPanel.repaint();
		InfoPanel.add(giftStockPanel);
		
		InfoPanel.repaint();
	}
	
	public class addGiftLis implements MouseListener{
		
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			DialogForChoice dfc=new DialogForChoice();
			String temp=dfc.chooseCommodity("请选择赠品");
			if(!temp.equals("no")){
			String []str=temp.split(" ");
			VipGiftVO gvo=new VipGiftVO(level,str[0],str[1],str[2],
					Double.parseDouble(str[3]),Integer.parseInt(str[4]),str[5]);
			vgc=new VipGiftPromotionController();
			String result=vgc.addVipGift(gvo);
			JOptionPane.showMessageDialog(null,result);
			
			InfoPanel.removeAll();
			showCoupon();
			showGift();
			showDiscount();
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
				vgc=new VipGiftPromotionController();
				String vlevel=(String)giftTable.getValueAt(row, 0);
				String id=(String)giftTable.getValueAt(row, 1);
				String name=(String)giftTable.getValueAt(row, 2);
				String kind=(String)giftTable.getValueAt(row, 3);
				String price=(String)giftTable.getValueAt(row, 4);
				String num=(String)giftTable.getValueAt(row, 5);
				String sendDate=(String)giftTable.getValueAt(row,6);
				VipGiftVO vo=new VipGiftVO(Integer.parseInt(vlevel),id,name,kind,Double.parseDouble(price),
						Integer.parseInt(num),sendDate);
				String result=vgc.delVipGift(vo);
				JOptionPane.showMessageDialog(null,result);
				
				InfoPanel.removeAll();
				showGift();
				showCoupon();
				showDiscount();
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
				vgc=new VipGiftPromotionController();
				
				String vlevel=(String)giftTable.getValueAt(row, 0);
				String id=(String)giftTable.getValueAt(row, 1);
				String name=(String)giftTable.getValueAt(row, 2);
				String kind=(String)giftTable.getValueAt(row, 3);
				String price=(String)giftTable.getValueAt(row, 4);
				String num=(String)giftTable.getValueAt(row, 5);
				String sendDate=(String)giftTable.getValueAt(row, 6);
				
				DialogForChoice dfc=new DialogForChoice();
				String t=dfc.twoGet("请编辑信息", "数量", "赠送日期", num, sendDate);
				System.out.println("t: "+t);
				
				if(!t.equals("no")){
				String[] path=t.split(" ");
				VipGiftVO vo=new VipGiftVO(Integer.parseInt(vlevel),id,name,kind,Double.parseDouble(price),
						Integer.parseInt(path[0]),path[1]);
				String result=vgc.editVipGift(vo);
				JOptionPane.showMessageDialog(null,result);
				
				InfoPanel.removeAll();
				showGift();
				showCoupon();
				showDiscount();
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
	////////////////////////Gift-End///////////////////////////////////
	
	
	////////////////////////Discount-Start////////////////////////////////////
	public void showDiscount(){
		disLabel=new JLabel("打折额度");
		disLabel.setBounds(200, 360, 150, 50);
		
		disTxt=new JTextField();
		disTxt.setBounds(400, 360, 150, 50);
		disTxt.setEditable(false);
		
		addDis=new JButton("增加折扣");
		addDis.setBounds(120, 430, 150, 30);
		InfoPanel.add(addDis);
		
		delDis=new JButton("删除折扣");
		delDis.setBounds(300, 430, 150, 30);
		InfoPanel.add(delDis);
		
		editDis=new JButton("编辑折扣");
		editDis.setBounds(480, 430, 150, 30);
		InfoPanel.add(editDis);
		
		vmc=new VipPromotionMethodController();
		VipPromotionVO mvo=vmc.getVipMethod(level);
		
		if(mvo.getIsDiscount()){
			vdc=new VipDiscountPromotionController();
			DiscountVO vo=vdc.getDiscount(level);
			
			if(vo!=null){
				String dis=String.valueOf(vo.getDiscount());
				disTxt.setText(dis);
				addDis.setEnabled(false);
				delDis.setEnabled(true);
				delDis.addMouseListener(new delDiscountLis());;
				editDis.setEnabled(true);
				editDis.addMouseListener(new editDiscountLis());
			}
			else{
				disTxt.setText("无");
				addDis.setEnabled(true);
				addDis.addMouseListener(new addDiscountLis());
				delDis.setEnabled(false);
				editDis.setEnabled(false);
			}
		}
		else{
			disTxt.setText("无");
			addDis.setEnabled(false);
			delDis.setEnabled(false);
			editDis.setEnabled(false);
		}
		
		InfoPanel.add(disLabel);
		InfoPanel.add(disTxt);
		
		InfoPanel.repaint();
	}
	
	public class addDiscountLis implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			DialogForChoice dfc=new DialogForChoice();
			String s=dfc.oneGet("请输入折扣额度", "double","折扣额度", "");
			if(!s.equals("no")){
				if(Double.parseDouble(s)>=1){
					JOptionPane.showMessageDialog(null, "请输入小于1的折扣额度，例如0.85");
					return;
				}
				vdc=new VipDiscountPromotionController();
				DiscountVO vo=new DiscountVO(level,Double.parseDouble(s));
				String result=vdc.addDiscount(vo);
				JOptionPane.showMessageDialog(null,result);
				
				InfoPanel.removeAll();
				showCoupon();
				showGift();
				showDiscount();
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
	
	public class delDiscountLis implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			vdc=new VipDiscountPromotionController();
			String result=vdc.delDiscount(level);
			JOptionPane.showMessageDialog(null,result);
			
			InfoPanel.removeAll();
			showCoupon();
			showGift();
			showDiscount();
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
	
	public class editDiscountLis implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			DialogForChoice dfc=new DialogForChoice();
			String dis=disTxt.getText();
			String s=dfc.oneGet("请编辑折扣额度", "double","折扣额度", dis);
			if(!s.equals("no")){
				if(Double.parseDouble(s)>=1){
					JOptionPane.showMessageDialog(null, "请输入小于1的折扣额度，例如0.85");
					return;
				}
				vdc=new VipDiscountPromotionController();
				DiscountVO vo=new DiscountVO(level,Double.parseDouble(s));
				String result=vdc.editDiscount(vo);
				JOptionPane.showMessageDialog(null,result);
				
				InfoPanel.removeAll();
				showCoupon();
				showGift();
				showDiscount();
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
	////////////////////////Discount-End////////////////////////////////////
	
}
