package presentation.billmanagementui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;

import businesslogic.billmanagementbl.BillManageController;
import businesslogic.billmanagementbl.MarketForBillSercice;
import businesslogic.billmanagementbl.paymentBill;
import businesslogic.marketbl.MarketForBill;
import businesslogic.paymentbl.paymentcontroller;
import po.BillPO;
import po.GiftListPO;
import po.PaycashPO;
import po.PayinPO;
import po.PayoutPO;
import po.SaleListPO;
import po.StackListPO;
import po.StockBillsPo;
import po.UnsaleListPO;
import po.UnstackListPO;
import presentation.promotionui.ManageFrame;
import presentation.promotionui.WelcomeFrame;

public class BillFrame extends ManageFrame{
	
	JLabel billLabel;
	
	JPanel billPanel;
	
	JTable billTable;
	JScrollPane billStockPanel;
	
	String [][]tableData;
	
	BillManageController bmc;
	
	ArrayList<PayinPO> skdlist;       //收款单
	ArrayList<PayoutPO> fkdlist;      //付款单
	ArrayList<PaycashPO> xjfkdlist;   //现金付款单
	
	ArrayList<StockBillsPo> overlist;    //库存报溢单
	ArrayList<StockBillsPo> losslist;    //库存报损单
	ArrayList<StockBillsPo> alarmlist;   //库存报警单
	
	ArrayList<SaleListPO> xsdlist;       //销售单
	ArrayList<UnsaleListPO> xsthdlist;   //销售退货单
	ArrayList<StackListPO> jhdlist;      //进货单
	ArrayList<UnstackListPO> thdlist;   //退货单
	ArrayList<GiftListPO> kczsdlist;      //库存赠送单
	
	JButton backButton;
	
	JButton checkBill;
	JButton approveBill;
	JButton editBill;
	
	JButton refreshBill;
	
	

	public BillFrame(String UserName) {
		super(UserName);
		// TODO Auto-generated constructor stub
		
		billPanel=new JPanel();
		billPanel.setBounds(0, 50, 1000, 550);
		rootPanel.add(billPanel);
		billPanel.setLayout(null);
		
		backButton =new JButton("返回");
		backButton.setBounds(850, 10, 100,30 );
		headPanel.add(backButton);
		backButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new WelcomeFrame(user);
				dispose();
			}
			
		});
		
		billLabel=new JLabel("未审批单据列表");
		billLabel.setBounds(20, 5, 150, 50);
		billPanel.add(billLabel);
		
		showBill();
	}
	
	public void getData(){
		
		tableData=new String[1000][3];
		
		int sign=0;
		bmc=new BillManageController();
		
		skdlist=bmc.getBillList("file/SKD.ser");
		fkdlist=bmc.getBillList("file/FKD.ser");
		xjfkdlist=bmc.getBillList("file/XJFKD.ser");
		if(skdlist.size()>0){//收款单
			for(int i=0;i<skdlist.size();i++){
				PayinPO po=skdlist.get(i);
				tableData[sign][0]=po.getType();
				tableData[sign][1]=po.getIdentifier();
				tableData[sign][2]=po.getOperator();
				
				sign++;
			}
		}
		if(fkdlist.size()>0){//付款单
			for(int i=0;i<fkdlist.size();i++){
				PayoutPO po=fkdlist.get(i);
				tableData[sign][0]=po.getType();
				tableData[sign][1]=po.getIdentifier();
				tableData[sign][2]=po.getOperator();
				
				sign++;
			}
		}
		if(xjfkdlist.size()>0){//现金付款单 
			for(int i=0;i<xjfkdlist.size();i++){
				PaycashPO po=xjfkdlist.get(i);
				tableData[sign][0]=po.getType();
				tableData[sign][1]=po.getIdentifier();
				tableData[sign][2]=po.getOperator();
				
				sign++;
			}
		}
		
		overlist=bmc.getBillList("file/over.ser");
		losslist=bmc.getBillList("file/loss.ser");
		alarmlist=bmc.getBillList("file/alarm.ser");
		if(overlist.size()>0){//库存报溢单 
			for(int i=0;i<overlist.size();i++){
				StockBillsPo po=overlist.get(i);
				tableData[sign][0]=po.getType();
				tableData[sign][1]=po.getIdentifier();
				tableData[sign][2]=po.getOperator();
				
				sign++;
			}
		}
		if(losslist.size()>0){//库存报损单 
			for(int i=0;i<losslist.size();i++){
				StockBillsPo po=losslist.get(i);
				tableData[sign][0]=po.getType();
				tableData[sign][1]=po.getIdentifier();
				tableData[sign][2]=po.getOperator();
				
				sign++;
			}
		}
		if(alarmlist.size()>0){//库存报警单 
			for(int i=0;i<alarmlist.size();i++){
				StockBillsPo po=alarmlist.get(i);
				tableData[sign][0]=po.getType();
				tableData[sign][1]=po.getIdentifier();
				tableData[sign][2]=po.getOperator();
				
				sign++;
			}
		}
		
		
		xsdlist=bmc.getBillList("file/XSD.ser");
		xsthdlist=bmc.getBillList("file/XSTHD.ser");
		jhdlist=bmc.getBillList("file/JHD.ser");
		thdlist=bmc.getBillList("file/THD.ser");
		kczsdlist=bmc.getBillList("file/KCZSD.ser");
		if(xsdlist.size()>0){//销售单 
			for(int i=0;i<xsdlist.size();i++){
				SaleListPO po=xsdlist.get(i);
				tableData[sign][0]=po.getType();
				tableData[sign][1]=po.getIdentifier();
				tableData[sign][2]=po.getOperator();
				
				sign++;
			}
		}
		if(xsthdlist.size()>0){//销售退货单 
			for(int i=0;i<xsthdlist.size();i++){
				UnsaleListPO po=xsthdlist.get(i);
				tableData[sign][0]=po.getType();
				tableData[sign][1]=po.getIdentifier();
				tableData[sign][2]=po.getOperator();
				
				sign++;
			}
		}
		if(jhdlist.size()>0){//进货单 
			for(int i=0;i<jhdlist.size();i++){
				StackListPO po=jhdlist.get(i);
				tableData[sign][0]=po.getType();
				tableData[sign][1]=po.getIdentifier();
				tableData[sign][2]=po.getOperator();
				
				sign++;
			}
		}
		if(thdlist.size()>0){//退货单 
			for(int i=0;i<thdlist.size();i++){
				UnstackListPO po=thdlist.get(i);
				tableData[sign][0]=po.getType();
				tableData[sign][1]=po.getIdentifier();
				tableData[sign][2]=po.getOperator();
				
				sign++;
			}
		}
		if(kczsdlist.size()>0){//库存赠送单 
			for(int i=0;i<kczsdlist.size();i++){
				GiftListPO po=kczsdlist.get(i);
				tableData[sign][0]=po.getType();
				tableData[sign][1]=po.getIdentifier();
				tableData[sign][2]=po.getOperator();
				
				sign++;
			}
		}
		
	}
	
	public void showBill(){
		
		String []title={"单据类型","编号","操作员"};
		
		getData();
		
		billTable=new JTable(tableData,title);
		billTable.setRowHeight(25);
		billTable.repaint();
		billStockPanel = new JScrollPane(billTable);
		billStockPanel.setViewportView(billTable);
		billStockPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		billStockPanel.setBounds(50,70,900,300);
		billStockPanel.repaint();
		billPanel.add(billStockPanel);
		
		checkBill=new JButton("查看单据");
		checkBill.setBounds(200, 400, 150, 50);
		checkBill.addMouseListener(new checkLis());
		billPanel.add(checkBill);
		
		approveBill=new JButton("通过单据");
		approveBill.setBounds(400, 400, 150, 50);
		approveBill.addMouseListener(new approveLis());;
		billPanel.add(approveBill);
		
		editBill=new JButton("编辑单据");
		editBill.setBounds(600, 400, 150, 50);
		editBill.addMouseListener(new editLis());
		billPanel.add(editBill);
		
		refreshBill=new JButton("刷新单据列表");
		refreshBill.setBounds(800, 10, 150, 50);
		refreshBill.addMouseListener(new refreshBillLis());
		billPanel.add(refreshBill);
	}
	
	public class checkLis implements MouseListener{

		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			int row=billTable.getSelectedRow();
			if(row!=-1&&billTable.getValueAt(row, 0)!=null){
				BillDialog bd=new BillDialog();
				String type=(String)billTable.getValueAt(row, 0);
				String id=(String)billTable.getValueAt(row, 1);
				bd.showBill(type, id);
			}
			else{
				JOptionPane.showMessageDialog(null, "请选中您所希望查看的单据");
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
	
	public class approveLis implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			int[] rows=billTable.getSelectedRows();
			if(rows.length==0){
				JOptionPane.showMessageDialog(null, "请选中您所希望审批的单据；+ctrl可选中多行进行批量审批");
			}
			else{
				bmc=new BillManageController();
				ArrayList<String> res=new ArrayList<String>();
				for(int i=0;i<rows.length;i++){
					if(billTable.getValueAt(rows[i], 0)!=null){
						String type=(String)billTable.getValueAt(rows[i], 0);
						String id=(String)billTable.getValueAt(rows[i], 1);
						System.out.println(getBill(type,id).getType());
						if(type.equals("XSD")||type.equals("XSTHD")||type.equals("JHD")
								||type.equals("THD")||type.equals("KCZSD")){
							MarketForBillSercice mfb=new MarketForBill();
							mfb.reply(getBill(type,id), 1);
						}
						else if(type.equals("SKD")){
							paymentBill pb=new paymentcontroller("in");
							pb.store(getBill(type,id), 1);
						}
						else if(type.equals("FKD")){
							paymentBill pb=new paymentcontroller("out");
							pb.store(getBill(type,id), 1);
						}
						else if(type.equals("XJFKD")){
							paymentBill pb=new paymentcontroller("cash");
							pb.store(getBill(type,id), 1);
						}
						res.add( bmc.approveBill(getBill(type,id), "file/"+type+".ser") );
					}
				}
				
				String result="Succeed";
				for(int i=0;i<res.size();i++){
					if(res.get(i).equals("Not Found")){
						result="Not Found Bill In Row "+rows[i];
					}
				}
				JOptionPane.showMessageDialog(null, result);
				billPanel.removeAll();
				showBill();
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
	
	public class editLis implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			int row=billTable.getSelectedRow();
			if(row==-1||billTable.getValueAt(row, 0)==null){
				JOptionPane.showMessageDialog(null, "请选中您所希望编辑的账单");
				return;
			}
			if( !((String)billTable.getValueAt(row, 0)).equals("XSD") ){
				JOptionPane.showMessageDialog(null, "只能编辑销售单，请选择销售单进行编辑");
				return;
			}
			
			String id=(String)billTable.getValueAt(row,1);
			bmc=new BillManageController();
			ArrayList<SaleListPO> list=bmc.getBillList("file/XSD.ser");
			SaleListPO po=null;
			if(list.size()>0){
				for(int i=0;i<list.size();i++){
					po=list.get(i);
					if(po.getIdentifier().equals(id)){
						break;
					}
				}
				BillDialog bd=new BillDialog();
				String res=bd.oneGet("请编辑折扣额",  "折扣额", String.valueOf(po.getdiscount()));
				
				if(!res.equals("no")){
					String type=(String)billTable.getValueAt(row, 0);
					SaleListPO spo=getBill(type,id);
					
					double d=Double.parseDouble(res);
					double pre_d=spo.getdiscount();
					double aft=spo.getafter()-(d-pre_d);
					
					SaleListPO sspo=new SaleListPO(spo.getList(), spo.getIdentifier(), spo.getMemberId(), spo.getSaler(), 
							spo.getHouse(), spo.getOther(), spo.getbefore(), aft, spo.getpaper(), d,
							spo.getOperator(), spo.getMemberName());
					
					bmc.updateBill(sspo, "file/XSD.ser");
					JOptionPane.showMessageDialog(null, "编辑成功");
					billPanel.removeAll();
					showBill();
				}
				
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
	
	public class refreshBillLis implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			billPanel.removeAll();
			showBill();
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
	
	public <T extends BillPO> T getBill(String type,String id){
		bmc=new BillManageController();
		ArrayList<T> list=bmc.getBillList("file/"+type+".ser");
		T t=null;
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				t=list.get(i);
				if(t.getIdentifier().equals(id)){
					break;
				}
			}
		}
		return t;
	}
	
}
