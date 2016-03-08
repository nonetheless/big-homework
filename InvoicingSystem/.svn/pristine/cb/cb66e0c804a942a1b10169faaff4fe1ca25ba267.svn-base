package presentation.promotionui;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;

import po.PkgItemVO;
import vo.BuyingVO;
import vo.PkgVO;
import vo.SpVO;
import vo.TotalPromotionVO;
import vo.VipGiftVO;
import vo.VipPromotionVO;
import businesslogic.marketbl.MarketForPro;
import businesslogic.promotionbl.PkgPromotionController;
import businesslogic.promotionbl.TotalCouponPromotionController;
import businesslogic.promotionbl.TotalGiftPromotionController;
import businesslogic.promotionbl.TotalPromotionMethodController;
import businesslogic.promotionbl.VipCouponPromotionController;
import businesslogic.promotionbl.VipDiscountPromotionController;
import businesslogic.promotionbl.VipGiftPromotionController;
import businesslogic.promotionbl.VipPromotion;
import businesslogic.promotionbl.VipPromotionMethodController;



public class PromotionFrame extends PromotionUI{
	
	VipPromotionMethodController vmc;
	TotalPromotionMethodController tpm;
	
	VipCouponPromotionController vcc;
	VipGiftPromotionController vgc;
	VipDiscountPromotionController vdc;
	
	TotalCouponPromotionController tcc;
	TotalGiftPromotionController tgc;
	
	PkgPromotionController ppc;
	
	ArrayList<VipPromotionVO> vlist;
	ArrayList<TotalPromotionVO> tlist;
	ArrayList<PkgVO> plist;
	
	JTable vipTable;
	JScrollPane vipStockPanel;
	String [][] vipData;
	
	JTable totalTable;
	JScrollPane totalStockPanel;
	String [][] totalData;
	
	JTable pkgTable;
	JScrollPane pkgStockPanel;
	String [][] pkgData;
	
	JTable giftTable;
	JScrollPane giftStockPanel;
	String [][] giftData;
	
	JButton editVip;
	JButton editVipModel;
	
	JButton editTotal;
	JButton editTotalModel;
	JButton delTotal;
	JButton addTotal;
	
	JButton addPkg;
	JButton delPkg;
	JButton editPkg;
	JButton editPkgModel;
	
	JButton enter;
	JButton check;
	
	//int now_view;

	public PromotionFrame(String UserName,int view) {
		
		super(UserName, view);
		
		setTitle("制定促销策略");
		
		backButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if(pkgTable!=null){
				boolean per=true;
				int i=0;
				while(pkgTable.getValueAt(i, 0)!=null){
					if(Integer.parseInt((String)pkgTable.getValueAt(i, 2))==0){
						per=false;
					}
					i++;
				}
				if(per){
					new WelcomeFrame(user);
					dispose();
				}
				else{
					JOptionPane.showMessageDialog(null, "您有未编辑完成的特价包");
				}
				}
				else{
					new WelcomeFrame(user);
					dispose();
				}
				
			}
			
		});
		
		vipButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				InfoPanel.removeAll();
				showView(1);
			}
			
		});
		
		totalButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				InfoPanel.removeAll();
				showView(2);
			}
			
		});
		
		pkgButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				InfoPanel.removeAll();
				showView(3);
			}
			
		});
		
		giftButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				InfoPanel.removeAll();
				showView(4);
			}
			
		});
		
		showView(view);
	}
	
	///vip//////////////////
	public void getVipData(){
		vmc=new VipPromotionMethodController();
		vlist=vmc.getVipMethod();
		vipData=new String[5][4];
		for(int i=0;i<5;i++){
			vipData[i][0]=String.valueOf( vlist.get(i).getVipLevel() );
			vipData[i][1]=String.valueOf( vlist.get(i).getIsCoupon() );
			vipData[i][2]=String.valueOf( vlist.get(i).getIsGift() );
			vipData[i][3]=String.valueOf( vlist.get(i).getIsDiscount() );
		}
	}
	
	public void showVip(){
		getVipData();
		String [] title={"Vip等级","采用代金券","采用赠品","采用打折"};
		
		vipTable=new JTable(vipData,title);
		vipTable.setRowHeight(50);
		vipTable.repaint();
		vipStockPanel = new JScrollPane(vipTable);
		vipStockPanel.setViewportView(vipTable);
		vipStockPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		vipStockPanel.setBounds(100,50,600,280);
		vipStockPanel.repaint();
		InfoPanel.add(vipStockPanel);
		InfoPanel.repaint();
		
		editVip=new JButton("编辑优惠模式");
		editVip.setBounds(200, 400, 150, 50);
		editVip.setVisible(true);
		InfoPanel.add(editVip);
		editVip.addMouseListener(new editVipLis());
		
		editVipModel=new JButton("编辑优惠政策");
		editVipModel.setBounds(400, 400, 150, 50);
		editVipModel.setVisible(true);
		InfoPanel.add(editVipModel);
		editVipModel.addMouseListener(new editVipModelLis());
	}
	
	public class editVipLis implements MouseListener{
		
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			if(vipTable.getSelectedRow()==-1){
				JOptionPane.showMessageDialog(null,"请选中您希望编辑的行");
				return;
			}
			
			int level=vipTable.getSelectedRow()+1;
			String temp=DialogCreatorForPromotion.threeCheck("请选择优惠政策", "采用代金券", "采用赠品", "采用折扣");
			
			if(!temp.equals("no")){
				String[] res=temp.split(" ");
				System.out.println("level: "+level);
				for(int i=0;i<3;i++){
					System.out.println(res[i]);
				}
				VipPromotionVO vo=new VipPromotionVO(level, Boolean.parseBoolean(res[0]),
						Boolean.parseBoolean(res[1]), Boolean.parseBoolean(res[2]));
				String t=vmc.updateVipMethod(level, vo);
				
				//更新具体优惠政策
				if(!vo.getIsCoupon()){
					vcc=new VipCouponPromotionController();
					vcc.delVipCoupon(level);
				}
				if(!vo.getIsGift()){
					vgc=new VipGiftPromotionController();
					vgc.delVipGiftByLevel(level);
				}
				if(!vo.getIsDiscount()){
					vdc=new VipDiscountPromotionController();
					vdc.delDiscount(level);
				}
				
				System.out.println("run: "+t);
				InfoPanel.removeAll();
				showVip();
				repaint();
			}
			else{
				System.out.println("no way to change");
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
	
	public class editVipModelLis implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if(vipTable.getSelectedRow()==-1){
				JOptionPane.showMessageDialog(null,"请选中您希望编辑的行");
				return;
			}
			
			int level=vipTable.getSelectedRow()+1;
			dispose();
			new VipModelFrame(user,1,level);
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
	///vip//////////////////
	
	
	///total////////////////
	public void getTotalData(){
		tpm=new TotalPromotionMethodController();
		tlist=tpm.getTotalMethod();
		totalData=new String[100][3];
		for(int i=0;i<tlist.size();i++){
			totalData[i][0]=String.valueOf( tlist.get(i).getTotalPrice() );
			totalData[i][1]=String.valueOf( tlist.get(i).getIsCoupon() );
			totalData[i][2]=String.valueOf( tlist.get(i).getIsGift() );
		}
	}
	
	public void showTotal(){
		getTotalData();
		String [] title={"总价额","采用代金券","采用赠品"};
		
		totalTable=new JTable(totalData,title);
		totalTable.setRowHeight(50);
		totalTable.repaint();
		totalStockPanel = new JScrollPane(totalTable);
		totalStockPanel.setViewportView(totalTable);
		totalStockPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		totalStockPanel.setBounds(100,50,600,280);
		totalStockPanel.repaint();
		InfoPanel.add(totalStockPanel);
		InfoPanel.repaint();
		
		editTotal=new JButton("编辑优惠模式");
		editTotal.setBounds(410, 400, 150, 50);
		InfoPanel.add(editTotal);
		editTotal.addMouseListener(new editTotalLis());
		
		editTotalModel=new JButton("编辑优惠内容");
		editTotalModel.setBounds(590, 400, 150, 50);
		InfoPanel.add(editTotalModel);
		editTotalModel.addMouseListener(new editTotalModelLis());
		
		addTotal=new JButton("增加优惠项");
		addTotal.setBounds(50, 400, 150, 50);
		InfoPanel.add(addTotal);
		addTotal.addMouseListener(new addTotalLis());
		
		delTotal=new JButton("删除优惠项");
		delTotal.setBounds(230, 400, 150, 50);
		InfoPanel.add(delTotal);
		delTotal.addMouseListener(new delTotalLis());
	}
	
	public class editTotalLis implements MouseListener{

		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
			int row=totalTable.getSelectedRow();
			if(totalTable.getSelectedRow()==-1||totalTable.getValueAt(row, 0)==null){
				JOptionPane.showMessageDialog(null,"请选中您希望编辑的行");
				return;
			}
			
			double totalMoney=Double.parseDouble( (String)totalTable.getValueAt(row, 0) );
			String temp=DialogCreatorForPromotion.twoCheck("请选择优惠政策", "采用代金券", "采用赠品");
			
			if(!temp.equals("no")){
				String[] res=temp.split(" ");
				System.out.println("money: "+totalMoney);
				for(int i=0;i<2;i++){
					System.out.println(res[i]);
				}
				TotalPromotionVO vo=new TotalPromotionVO(totalMoney, Boolean.parseBoolean(res[0]),
						Boolean.parseBoolean(res[1]));
				String t=tpm.updateTotalMethod(totalMoney, vo);
				
				//更新具体优惠政策
				if(!vo.getIsCoupon()){
					tcc=new TotalCouponPromotionController();
					tcc.delTotalCoupon(totalMoney);
				}
				if(!vo.getIsGift()){
					tgc=new TotalGiftPromotionController();
					tgc.delTotalGiftByMoney(totalMoney);
				}
				
				JOptionPane.showMessageDialog(null,t);
				InfoPanel.removeAll();
				showTotal();
				repaint();
			}
			else{
				System.out.println("no way to change");
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
	
	public class editTotalModelLis implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			int row=totalTable.getSelectedRow();
			if(totalTable.getSelectedRow()==-1||totalTable.getValueAt(row, 0)==null){
				JOptionPane.showMessageDialog(null,"请选中您希望编辑的行");
				return;
			}
			
			double totalMoney=Double.parseDouble( (String)totalTable.getValueAt(row, 0) );
			System.out.println("totalMoney: "+totalMoney);
			dispose();
			new TotalModelFrame(user,1,totalMoney);
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
	
	public class addTotalLis implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			String temp=DialogCreatorForPromotion.twoCheckOneGet("请输入详细信息", "采用代金券", "采用赠品", "总价额");
			if(!temp.equals("no")){
				String[] res=temp.split(" ");
				double money=Double.parseDouble(res[0]);
				boolean isCoupon=Boolean.parseBoolean(res[1]);
				boolean isGift=Boolean.parseBoolean(res[2]);
				TotalPromotionVO vo=new TotalPromotionVO(money,isCoupon,isGift);
				tpm=new TotalPromotionMethodController();
				String result=tpm.addTotalMethod(money, vo);
				
				JOptionPane.showMessageDialog(null,result);
				InfoPanel.removeAll();
				showTotal();
				repaint();
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
	
	public class delTotalLis implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			int row=totalTable.getSelectedRow();
			if(totalTable.getSelectedRow()==-1||totalTable.getValueAt(row, 0)==null){
				JOptionPane.showMessageDialog(null,"请选中您希望删除的行");
				return;
			}
			
			double totalMoney=Double.parseDouble( (String)totalTable.getValueAt(row, 0) );
			tpm=new TotalPromotionMethodController();
			String result=tpm.delTotalMethod(totalMoney);
			
			JOptionPane.showMessageDialog(null,result);
			InfoPanel.removeAll();
			showTotal();
			repaint();
			
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
	///total////////////////
	
	
	///pkg//////////////////
	public void getPkgData(){
		ppc=new PkgPromotionController();
		plist=ppc.getPkgList();
		pkgData=new String[100][4];
		for(int i=0;i<plist.size();i++){
			pkgData[i][0]=String.valueOf( plist.get(i).getId() );
			pkgData[i][1]=String.valueOf( plist.get(i).getName() );
			pkgData[i][2]=String.valueOf( plist.get(i).getPkg().size() );
			pkgData[i][3]=String.valueOf( plist.get(i).getAftPrice() );
		}
	}
	
	public void showPkg(){
		
		getPkgData();
		String [] title={"特价包编号","特价包名","包内商品种类数","优惠价"};
		
		pkgTable=new JTable(pkgData,title);
		pkgTable.setRowHeight(50);
		pkgTable.repaint();
		pkgStockPanel = new JScrollPane(pkgTable);
		pkgStockPanel.setViewportView(pkgTable);
		pkgStockPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		pkgStockPanel.setBounds(100,50,600,280);
		pkgStockPanel.repaint();
		InfoPanel.add(pkgStockPanel);
		InfoPanel.repaint();
		
		editPkg=new JButton("编辑特价包名");
		editPkg.setBounds(410, 400, 150, 50);
		InfoPanel.add(editPkg);
		editPkg.addMouseListener(new editPkgLis());
		
		editPkgModel=new JButton("编辑商品列表");
		editPkgModel.setBounds(590, 400, 150, 50);
		InfoPanel.add(editPkgModel);
		editPkgModel.addMouseListener(new editPkgModelLis());
		
		addPkg=new JButton("增加特价包");
		addPkg.setBounds(50, 400, 150, 50);
		InfoPanel.add(addPkg);
		addPkg.addMouseListener(new addPkgLis());
		
		delPkg=new JButton("删除特价包");
		delPkg.setBounds(230, 400, 150, 50);
		InfoPanel.add(delPkg);
		delPkg.addMouseListener(new delPkgLis());
	}
	
	public class addPkgLis implements MouseListener{

		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			DialogForChoice dfc=new DialogForChoice();
			String name=dfc.oneGet("请输入特价包名", "str","特价包名称", "");
			
			if(!name.equals("no")){
				Calendar cal = Calendar.getInstance();
				String id=String.valueOf(cal.getTimeInMillis());
				
				ArrayList<PkgItemVO> list=new ArrayList<PkgItemVO>();
				PkgVO vo=new PkgVO(id,name,list,0.0);
				ppc.addPkg(vo);
				
				InfoPanel.removeAll();
				showPkg();
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
	
	public class delPkgLis implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			int row=pkgTable.getSelectedRow();
			if(row==-1||pkgTable.getValueAt(row, 0)==null){
				JOptionPane.showMessageDialog(null,"请选中您希望删除的行");
				return;
			}
			
			String id=(String)pkgTable.getValueAt(row, 0);
			
			String result=ppc.delPkg(id);
			JOptionPane.showMessageDialog(null,result);
			
			InfoPanel.removeAll();
			showPkg();
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
	
	public class editPkgLis implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
			int row=pkgTable.getSelectedRow();
			if(row==-1||pkgTable.getValueAt(row, 0)==null){
				JOptionPane.showMessageDialog(null,"请选中您希望编辑的行");
				return;
			}
			
			DialogForChoice dfc=new DialogForChoice();
			String name=dfc.oneGet("请输入新的特价包名", "str","新名称", "");
			
			if(!name.equals("no")){
				String id=(String)pkgTable.getValueAt(row, 0);
				PkgVO orignVO=ppc.getPkgGoods(id);
				PkgVO posVO=new PkgVO(id,name,orignVO.getPkg(),orignVO.getAftPrice());
				
				String result=ppc.editPkg(posVO);
				JOptionPane.showMessageDialog(null,result);
				
				InfoPanel.removeAll();
				showPkg();
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
	
	public class editPkgModelLis implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
			int row=pkgTable.getSelectedRow();
			if(pkgTable.getSelectedRow()==-1||pkgTable.getValueAt(row, 0)==null){
				JOptionPane.showMessageDialog(null,"请选中您希望编辑的行");
				return;
			}
			
			String id=(String)pkgTable.getValueAt(row, 0);
			
			dispose();
			new PkgModelFrame(user,1,id);
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
	///pkg//////////////////
	
	
	public void getGiftData(){
		VipPromotion vp=new VipPromotion();
		ArrayList<SpVO> list=vp.getGift();
		
		giftData=new String[5][3];
		for(int i=0;i<list.size();i++){
			SpVO svo=list.get(i);
			int vlevel=svo.getMemberList().get(0).getLevel();
			giftData[i][0]=String.valueOf(vlevel);
			if(svo.getGiftList().size()>0){
				giftData[i][1]="有";
			}else{
				giftData[i][1]="无";
			}
			if(svo.getNum()!=0){
				giftData[i][2]="有";
			}else{
				giftData[i][2]="无";
			}
		}
		
	}
	
	public void showGift(){
		getGiftData();
		String [] title={"Vip等级","赠送赠品","赠送代金券"};
		
		giftTable=new JTable(giftData,title);
		giftTable.setRowHeight(50);
		giftTable.repaint();
		giftStockPanel = new JScrollPane(giftTable);
		giftStockPanel.setViewportView(giftTable);
		giftStockPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		giftStockPanel.setBounds(100,50,600,280);
		giftStockPanel.repaint();
		InfoPanel.add(giftStockPanel);
		InfoPanel.repaint();
		
		enter=new JButton("确认赠送");
		enter.setBounds(200, 400, 150, 50);
		enter.setVisible(true);
		InfoPanel.add(enter);
		enter.addMouseListener(new enterLis());
		
		check=new JButton("查看赠送内容");
		check.setBounds(400, 400, 150, 50);
		check.setVisible(true);
		InfoPanel.add(check);
		check.addMouseListener(new checkLis());
	}
	
	public class enterLis implements MouseListener{

		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			int row=giftTable.getSelectedRow();
			if(giftTable.getSelectedRow()==-1||giftTable.getValueAt(row, 0)==null){
				JOptionPane.showMessageDialog(null,"请选中您希望赠送的vip等级");
				return;
			}
			
			VipPromotion vp=new VipPromotion();
			ArrayList<SpVO> list=vp.getGift();
			
			int templevel=Integer.parseInt( (String)giftTable.getValueAt(row, 0) );
			
			SpVO svo=null;
			for(int i=0;i<list.size();i++){
				svo=list.get(i);
				int vlevel=svo.getMemberList().get(0).getLevel();
				if(vlevel==templevel){
					break;
				}
			}
			
			MarketForPro mfp=new MarketForPro();
			mfp.sendGift(svo);
			
			int v_level=svo.getMemberList().get(0).getLevel();
			
			//更新coupon
			VipCouponPromotionController vcc=new VipCouponPromotionController();
			vcc.delVipCoupon(v_level);
			
			//跟新gift
			VipGiftPromotionController vgc=new VipGiftPromotionController();
			ArrayList<BuyingVO> glist=svo.getGiftList();
			if(glist!=null){
				for(int i=0;i<glist.size();i++){
					BuyingVO bvo=glist.get(i);
					VipGiftVO vo=new VipGiftVO(v_level,bvo.getId(),bvo.getName(),bvo.getKind(),bvo.getPrice(),
							bvo.getNumber(),"");
					vgc.delVipGift(vo);
				}
			}
			//更新UI
			JOptionPane.showMessageDialog(null, "赠送单已发出");
			InfoPanel.removeAll();
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
	
	public class checkLis implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			int row=giftTable.getSelectedRow();
			if(giftTable.getSelectedRow()==-1||giftTable.getValueAt(row, 0)==null){
				JOptionPane.showMessageDialog(null,"请选中您希望编辑的行");
				return;
			}
			
			int level=Integer.parseInt( (String)giftTable.getValueAt(row, 0) );
			
			dispose();
			new SendGiftFrame(user,1,level);
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
	
	public void showView(int view){
		if(view==1){
			showVip();
		}
		else if(view==2){
			showTotal();
		}
		else if(view==3){
			showPkg();
		}
		else if(view==4){
			showGift();
		}
	}
	
	
}
