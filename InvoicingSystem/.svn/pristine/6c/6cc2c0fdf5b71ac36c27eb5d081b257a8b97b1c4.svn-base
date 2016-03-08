package presentation.checkui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import po.BillPO;
import po.GiftListPO;
import po.GoodLinePO;
import po.GoodsListPO;
import po.PaycashPO;
import po.PayinPO;
import po.PayoutPO;
import po.SaleListPO;
import po.StackListPO;
import po.StockBillsPo;
import po.UnsaleListPO;
import po.UnstackListPO;
import po.accountlineitempo;
import po.cashlineitempo;
import presentation.paymentui.dialogmaker.buttonlistener1;
import presentation.paymentui.dialogmaker.buttonlistener2;
import presentation.paymentui.dialogmaker.buttonlistener3;

public class dialogmaker2 {
	JDialog dialog;
	JButton button=new JButton("查看详情");
	JButton button2=new JButton("红冲");
	JTable table;
	JScrollPane scroll;
	JOptionPane optionpane=new JOptionPane();
	String type;
	String operatorid;
	
	ArrayList<PayinPO> payinpo=new ArrayList<PayinPO>();
	ArrayList<PayoutPO> payoutpo=new ArrayList<PayoutPO>();
	ArrayList<PaycashPO> paycashpo=new ArrayList<PaycashPO>();
	ArrayList<SaleListPO> salelistpo=new ArrayList<SaleListPO>();
	ArrayList<UnsaleListPO> unsalelistpo=new ArrayList<UnsaleListPO>();
	ArrayList<StackListPO> stacklistpo=new ArrayList<StackListPO>();
	ArrayList<UnstackListPO> unstacklistpo=new ArrayList<UnstackListPO>();
	ArrayList<StockBillsPo> stockbillspo=new ArrayList<StockBillsPo>();
	ArrayList<GiftListPO> giftlistpo=new ArrayList<GiftListPO>();
	
	String[] str1={"类型","编号","操作员","时间","客户","转账列表","总额"};
	String[] str2={"类型","编号","操作员","时间","账户","条目列表","总额"};
	String[] str3={"类型","编号","操作员","客户名","客户ID","商品列表","仓库","总价","折让后总价","折让","代金券"};
	String[] str4={"类型","编号","操作员","客户名","客户ID","商品列表","仓库","总价"};
	String[] str5={"类型","编号","操作员","客户名","客户ID","赠品列表","仓库","总价"};
	String[] str6={"类型","编号","操作员","时间","商品","型号","实际数量"};
	String[][] ss;
	public dialogmaker2(String s,ArrayList<BillPO> bp,String iden){
		 type=s;operatorid=iden;
		 optionpane.setSize(1000, 600);
		 if(type.equals("in")){ 
			 for(int i=0;i<bp.size();i++){
				 payinpo.add((PayinPO)bp.get(i));
			 }
			 ss=new String[payinpo.size()][7];
			 for(int i=0;i<payinpo.size();i++){
				 ss[i][0]=payinpo.get(i).getType();
				 ss[i][1]=payinpo.get(i).getIdentifier();
				 ss[i][2]=payinpo.get(i).getOperator();
				 ss[i][3]=payinpo.get(i).gettime();
				 ss[i][4]=payinpo.get(i).getcustomer();
				 ss[i][5]="转账列表";
				 ss[i][6]=Double.toString(payinpo.get(i).gettotal());
			 }
			 table=new JTable(ss,str1);
			 scroll=new JScrollPane(table);
			 optionpane.add(scroll);
			 optionpane.add(button);
			 if(operatorid.equals("财务人员")){
				 optionpane.add(button2);
				 button.setBounds(150, 330, 150, 30);
			 }
			 else if(operatorid.equals("总经理")){
				 button.setBounds(260, 330, 150, 30);
			 }
			 
			 optionpane.setPreferredSize(new Dimension(700,400));
			 optionpane.setLayout(null);
			 
			 button2.setBounds(370, 330, 150, 30);
			 button.addActionListener(new buttonlistener1());
			 button2.addActionListener(new button2listener1());
			 scroll.setBounds(50, 50, 600, 250);scroll.setVisible(true);
			 dialog=optionpane.createDialog(optionpane, "收款单");
			 dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			 dialog.setVisible(true);
			 
		 }
		 else if(type.equals("out")){
			 for(int i=0;i<bp.size();i++){
				 payoutpo.add((PayoutPO)bp.get(i));
			 }
			 
			 ss=new String[payoutpo.size()][7];
			 for(int i=0;i<payoutpo.size();i++){
				 ss[i][0]=payoutpo.get(i).getType();
				 ss[i][1]=payoutpo.get(i).getIdentifier();
				 ss[i][2]=payoutpo.get(i).getOperator();
				 ss[i][3]=payoutpo.get(i).gettime();
				 ss[i][4]=payoutpo.get(i).getcustomer();
				 ss[i][5]="转账列表";
				 ss[i][6]=Double.toString(payoutpo.get(i).gettotal());
			 }
			 table=new JTable(ss,str1);
			 scroll=new JScrollPane(table);
			 optionpane.add(scroll);
			 optionpane.add(button);
			 if(operatorid.equals("财务人员")){
				 optionpane.add(button2);
				 button.setBounds(150, 330, 150, 30);
			 }
			 else if(operatorid.equals("总经理")){
				 button.setBounds(260, 330, 150, 30);
			 }
			 
			 
			 optionpane.setPreferredSize(new Dimension(700,400));
			 optionpane.setLayout(null);
			
			 button2.setBounds(370, 330, 150, 30);
			 button.addActionListener(new buttonlistener2());
			 button2.addActionListener(new button2listener2());
			 scroll.setBounds(50, 50, 600, 250);scroll.setVisible(true);
			 dialog=optionpane.createDialog(optionpane, "付款单");
			 dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			 dialog.setVisible(true);
		 }
		 else if(type.equals("cash")){
			 for(int i=0;i<bp.size();i++){
				 paycashpo.add((PaycashPO)bp.get(i));
			 }
			 ss=new String[paycashpo.size()][7];
			 for(int i=0;i<paycashpo.size();i++){
				 ss[i][0]=paycashpo.get(i).getType();
				 ss[i][1]=paycashpo.get(i).getIdentifier();
				 ss[i][2]=paycashpo.get(i).getOperator();
				 ss[i][3]=paycashpo.get(i).gettime();
				 ss[i][4]=paycashpo.get(i).getaccount();
				 ss[i][5]="转账列表";
				 ss[i][6]=Double.toString(paycashpo.get(i).gettotal());
			 }
			 table=new JTable(ss,str2);
			 scroll=new JScrollPane(table);
			 optionpane.add(scroll);
			 optionpane.add(button);
			 if(operatorid.equals("财务人员")){
				 optionpane.add(button2);
				 button.setBounds(150, 330, 150, 30);
			 }
			 else if(operatorid.equals("总经理")){
				 button.setBounds(260, 330, 150, 30);
			 }
			 optionpane.setPreferredSize(new Dimension(700,400));
			 optionpane.setLayout(null);
			 
			 button2.setBounds(370, 330, 150, 30);
			 button.addActionListener(new buttonlistener3());
			 button2.addActionListener(new button2listener3());
			 scroll.setBounds(50, 50, 600, 250);scroll.setVisible(true);
			 dialog=optionpane.createDialog(optionpane, "现金付款单");
			 dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			 dialog.setVisible(true);
		 }
		 else if(type.equals("sale")){
			 for(int i=0;i<bp.size();i++){
				 salelistpo.add((SaleListPO)bp.get(i));
			 }
			 ss=new String[salelistpo.size()][11];
			 for(int i=0;i<salelistpo.size();i++){
				 ss[i][0]=salelistpo.get(i).getType();
				 ss[i][1]=salelistpo.get(i).getIdentifier();
				 ss[i][2]=salelistpo.get(i).getOperator();
				 ss[i][3]=salelistpo.get(i).getMemberName();
				 ss[i][4]=salelistpo.get(i).getMemberId();
				 
				 ss[i][5]="商品列表";
				 ss[i][6]=salelistpo.get(i).getHouse();
				 ss[i][7]=Double.toString(salelistpo.get(i).getbefore());
				 ss[i][8]=Double.toString(salelistpo.get(i).getafter());
				 ss[i][9]=Double.toString(salelistpo.get(i).getdiscount());
				 ss[i][10]=Double.toString(salelistpo.get(i).getpaper());
			 }
			 table=new JTable(ss,str3);
			 scroll=new JScrollPane(table);
			 optionpane.add(scroll);
			 optionpane.add(button);
			 if(operatorid.equals("财务人员")){
				 optionpane.add(button2);
				 button.setBounds(150, 330, 150, 30);
			 }
			 else if(operatorid.equals("总经理")){
				 button.setBounds(260, 330, 150, 30);
			 }
			 optionpane.setPreferredSize(new Dimension(700,400));
			 optionpane.setLayout(null);
			 
			 button2.setBounds(370, 330, 150, 30);
			 button.addActionListener(new buttonlistener4());
			 button2.addActionListener(new button2listener4());
			 scroll.setBounds(50, 50, 600, 250);scroll.setVisible(true);
			 dialog=optionpane.createDialog(optionpane, "销售单");
			 dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			 dialog.setVisible(true);
		 }
		 else if(type.equals("unsale")){
			 for(int i=0;i<bp.size();i++){
				 unsalelistpo.add((UnsaleListPO)bp.get(i));
			 }
			 ss=new String[unsalelistpo.size()][8];
			 for(int i=0;i<unsalelistpo.size();i++){
				 ss[i][0]=unsalelistpo.get(i).getType();
				 ss[i][1]=unsalelistpo.get(i).getIdentifier();
				 ss[i][2]=unsalelistpo.get(i).getOperator();
				 ss[i][3]=unsalelistpo.get(i).getMemberName();
				 ss[i][4]=unsalelistpo.get(i).getMemberId();
				 
				 ss[i][5]="商品列表";
				 ss[i][6]=unsalelistpo.get(i).getHouse();
				 ss[i][7]=Double.toString(unsalelistpo.get(i).getPrice());
				 
			 }
			 table=new JTable(ss,str4);
			 scroll=new JScrollPane(table);
			 optionpane.add(scroll);
			 optionpane.add(button);
			 if(operatorid.equals("财务人员")){
				 optionpane.add(button2);
				 button.setBounds(150, 330, 150, 30);
			 }
			 else if(operatorid.equals("总经理")){
				 button.setBounds(260, 330, 150, 30);
			 }
			 optionpane.setPreferredSize(new Dimension(700,400));
			 optionpane.setLayout(null);
			
			 button2.setBounds(370, 330, 150, 30);
			 button.addActionListener(new buttonlistener5());
			 button2.addActionListener(new button2listener5());
			 scroll.setBounds(50, 50, 600, 250);scroll.setVisible(true);
			 dialog=optionpane.createDialog(optionpane, "销售退货单");
			 dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			 dialog.setVisible(true);
		 }
		 else if(type.equals("stack")){
			 for(int i=0;i<bp.size();i++){
				 stacklistpo.add((StackListPO)bp.get(i));
			 }
			 ss=new String[stacklistpo.size()][8];
			 for(int i=0;i<stacklistpo.size();i++){
				 ss[i][0]=stacklistpo.get(i).getType();
				 ss[i][1]=stacklistpo.get(i).getIdentifier();
				 ss[i][2]=stacklistpo.get(i).getOperator();
				 ss[i][3]=stacklistpo.get(i).getMemberName();
				 ss[i][4]=stacklistpo.get(i).getMemberId();
				 
				 ss[i][5]="商品列表";
				 ss[i][6]=stacklistpo.get(i).getHouse();
				 ss[i][7]=Double.toString(stacklistpo.get(i).getPrice());
				 
			 }
			 table=new JTable(ss,str4);
			 scroll=new JScrollPane(table);
			 optionpane.add(scroll);
			 optionpane.add(button);
			 if(operatorid.equals("财务人员")){
				 optionpane.add(button2);
				 button.setBounds(150, 330, 150, 30);
			 }
			 else if(operatorid.equals("总经理")){
				 button.setBounds(260, 330, 150, 30);
			 }
			 optionpane.setPreferredSize(new Dimension(700,400));
			 optionpane.setLayout(null);
			 
			 button2.setBounds(370, 330, 150, 30);
			 button.addActionListener(new buttonlistener6());
			 button2.addActionListener(new button2listener6());
			 scroll.setBounds(50, 50, 600, 250);scroll.setVisible(true);
			 dialog=optionpane.createDialog(optionpane, "进货单");
			 dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			 dialog.setVisible(true);
		 }
		 else if(type.equals("unstack")){
			 for(int i=0;i<bp.size();i++){
				 unstacklistpo.add((UnstackListPO)bp.get(i));
			 }
			 ss=new String[unstacklistpo.size()][8];
			 for(int i=0;i<unstacklistpo.size();i++){
				 ss[i][0]=unstacklistpo.get(i).getType();
				 ss[i][1]=unstacklistpo.get(i).getIdentifier();
				 ss[i][2]=unstacklistpo.get(i).getOperator();
				 ss[i][3]=unstacklistpo.get(i).getMemberName();
				 ss[i][4]=unstacklistpo.get(i).getMemberId();
				 
				 ss[i][5]="商品列表";
				
				 ss[i][6]=unstacklistpo.get(i).getHouse();
				 
				 ss[i][7]=Double.toString(unstacklistpo.get(i).getPrice());
				 
			 }
			 table=new JTable(ss,str4);
			 scroll=new JScrollPane(table);
			 optionpane.add(scroll);
			 optionpane.add(button);
			 if(operatorid.equals("财务人员")){
				 optionpane.add(button2);
				 button.setBounds(150, 330, 150, 30);
			 }
			 else if(operatorid.equals("总经理")){
				 button.setBounds(260, 330, 150, 30);
			 }
			 optionpane.setPreferredSize(new Dimension(700,400));
			 optionpane.setLayout(null);
			 
			 button2.setBounds(370, 330, 150, 30);
			 button.addActionListener(new buttonlistener7());
			 button2.addActionListener(new button2listener7());
			 scroll.setBounds(50, 50, 600, 250);scroll.setVisible(true);
			 dialog=optionpane.createDialog(optionpane, "退货单");
			 dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			 dialog.setVisible(true);
		 }
		 else if(type.equals("gift")){
			 for(int i=0;i<bp.size();i++){
				 giftlistpo.add((GiftListPO)bp.get(i));
			 }
			 ss=new String[giftlistpo.size()][8];
			 for(int i=0;i<giftlistpo.size();i++){
				 ss[i][0]=giftlistpo.get(i).getType();
				 ss[i][1]=giftlistpo.get(i).getIdentifier();
				 ss[i][2]=giftlistpo.get(i).getOperator();
				 ss[i][3]=giftlistpo.get(i).getMemberName();
				 ss[i][4]=giftlistpo.get(i).getMemberId();
				 
				 ss[i][5]="赠品列表";
				 ss[i][6]=giftlistpo.get(i).getHouse();
				 ss[i][7]=Double.toString(giftlistpo.get(i).getPrice());
				 
			 }
			 table=new JTable(ss,str5);
			 scroll=new JScrollPane(table);
			 optionpane.add(scroll);
			 optionpane.add(button);
			 if(operatorid.equals("财务人员")){
				 optionpane.add(button2);
				 button.setBounds(150, 330, 150, 30);
			 }
			 else if(operatorid.equals("总经理")){
				 button.setBounds(260, 330, 150, 30);
			 }
			 optionpane.setPreferredSize(new Dimension(700,400));
			 optionpane.setLayout(null);
			 
			 button2.setBounds(370, 330, 150, 30);
			 button.addActionListener(new buttonlistener8());
			 button2.addActionListener(new button2listener8());
			 scroll.setBounds(50, 50, 600, 250);scroll.setVisible(true);
			 dialog=optionpane.createDialog(optionpane, "赠品单");
			 dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			 dialog.setVisible(true);
		 }
		 else if(type.equals("stockloss")){
			 for(int i=0;i<bp.size();i++){
				 stockbillspo.add((StockBillsPo)bp.get(i));
			 }
			 ss=new String[stockbillspo.size()][7];
			 for(int i=0;i<stockbillspo.size();i++){
				 ss[i][0]=stockbillspo.get(i).getType();
				 ss[i][1]=stockbillspo.get(i).getIdentifier();
				 ss[i][2]=stockbillspo.get(i).getOperator();
				 ss[i][3]=stockbillspo.get(i).get_date();
				 ss[i][4]=stockbillspo.get(i).getCommodityName();
				 ss[i][5]=stockbillspo.get(i).get_ModelNum();
				 
				 ss[i][6]=Double.toString(stockbillspo.get(i).getFactualNum());
				
				 
			 }
			 table=new JTable(ss,str6);
			 scroll=new JScrollPane(table);
			 optionpane.add(scroll);
			 //optionpane.add(button);
			 //optionpane.add(button2);
			 optionpane.setPreferredSize(new Dimension(700,400));
			 optionpane.setLayout(null);
			 //button.setBounds(150, 330, 150, 30);
			 //button2.setBounds(370, 330, 150, 30);
			 //button.addActionListener(new buttonlistener5());
			 scroll.setBounds(50, 50, 600, 250);scroll.setVisible(true);
			 dialog=optionpane.createDialog(optionpane, "报损单");
			 dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			 dialog.setVisible(true);
		 }
         else if(type.equals("stockover")){
        	 for(int i=0;i<bp.size();i++){
				 stockbillspo.add((StockBillsPo)bp.get(i));
			 }
			 ss=new String[stockbillspo.size()][7];
			 for(int i=0;i<stockbillspo.size();i++){
				 ss[i][0]=stockbillspo.get(i).getType();
				 ss[i][1]=stockbillspo.get(i).getIdentifier();
				 ss[i][2]=stockbillspo.get(i).getOperator();
				 ss[i][3]=stockbillspo.get(i).get_date();
				 ss[i][4]=stockbillspo.get(i).getCommodityName();
				 ss[i][5]=stockbillspo.get(i).get_ModelNum();
				 
				 ss[i][6]=Double.toString(stockbillspo.get(i).getFactualNum());
				
				 
			 }
			 table=new JTable(ss,str6);
			 scroll=new JScrollPane(table);
			 optionpane.add(scroll);
			 //optionpane.add(button);
			 //optionpane.add(button2);
			 optionpane.setPreferredSize(new Dimension(700,400));
			 optionpane.setLayout(null);
			 //button.setBounds(150, 330, 150, 30);
			 //button2.setBounds(370, 330, 150, 30);
			 //button.addActionListener(new buttonlistener5());
			 scroll.setBounds(50, 50, 600, 250);scroll.setVisible(true);
			 dialog=optionpane.createDialog(optionpane, "报溢单");
			 dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			 dialog.setVisible(true);
		 }
		 
	}
	public class buttonlistener1 implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int selectrow=table.getSelectedRow();
			if(selectrow!=-1){
				PayinPO ipo=payinpo.get(selectrow);
				ArrayList<accountlineitempo> aclp=ipo.getlist();
				String[][] sos=new String[aclp.size()][3];
				for(int i=0;i<aclp.size();i++){
					sos[i][0]=aclp.get(i).getname();
					sos[i][1]=Double.toString(aclp.get(i).getmoney());
					sos[i][2]=aclp.get(i).getremark();
				}
				String[] sps={"账户名","金额","备注"};
				JTable table01=new JTable(sos,sps);
				
				JScrollPane scroll01=new JScrollPane(table01);
				JOptionPane pane=new JOptionPane();
				pane.add(scroll01);
				
				pane.setPreferredSize(new Dimension(700,400));
				pane.setLayout(null);
				 
				scroll01.setBounds(50, 50, 600, 250);scroll01.setVisible(true);
				JDialog dialog01=pane.createDialog(pane, "列表详情");
				dialog01.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog01.setVisible(true);
			}
		}
		
	}
	public class buttonlistener2 implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int selectrow=table.getSelectedRow();
			if(selectrow!=-1){
				PayoutPO ipo=payoutpo.get(selectrow);
				ArrayList<accountlineitempo> aclp=ipo.getlist();
				String[][] sos=new String[aclp.size()][3];
				for(int i=0;i<aclp.size();i++){
					sos[i][0]=aclp.get(i).getname();
					sos[i][1]=Double.toString(aclp.get(i).getmoney());
					sos[i][2]=aclp.get(i).getremark();
				}
				String[] sps={"账户名","金额","备注"};
				JTable table01=new JTable(sos,sps);
				
				JScrollPane scroll01=new JScrollPane(table01);
				JOptionPane pane=new JOptionPane();
				pane.add(scroll01);
				
				pane.setPreferredSize(new Dimension(700,400));
				pane.setLayout(null);
				 
				scroll01.setBounds(50, 50, 600, 250);scroll01.setVisible(true);
				JDialog dialog01=pane.createDialog(pane, "列表详情");
				dialog01.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog01.setVisible(true);
			}
		}
		
	}
	public class buttonlistener3 implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int selectrow=table.getSelectedRow();
			if(selectrow!=-1){
				PaycashPO ipo=paycashpo.get(selectrow);
				ArrayList<cashlineitempo> aclp=ipo.getlist();
				String[][] sos=new String[aclp.size()][3];
				for(int i=0;i<aclp.size();i++){
					sos[i][0]=aclp.get(i).getname();
					sos[i][1]=Double.toString(aclp.get(i).getmoney());
					sos[i][2]=aclp.get(i).getremark();
				}
				String[] sps={"条目名","金额","备注"};
				JTable table01=new JTable(sos,sps);
				
				JScrollPane scroll01=new JScrollPane(table01);
				JOptionPane pane=new JOptionPane();
				pane.add(scroll01);
				
				pane.setPreferredSize(new Dimension(700,400));
				pane.setLayout(null);
				 
				scroll01.setBounds(50, 50, 600, 250);scroll01.setVisible(true);
				JDialog dialog01=pane.createDialog(pane, "列表详情");
				dialog01.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog01.setVisible(true);
			}
		}
		
	}
	public class buttonlistener4 implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			int selectrow=table.getSelectedRow();
			if(selectrow!=-1){
				SaleListPO ipo=salelistpo.get(selectrow);
				GoodsListPO glp=ipo.getList();
				ArrayList<GoodLinePO> aclp=glp.getList();
				String[][] sos=new String[aclp.size()][5];
				for(int i=0;i<aclp.size();i++){
					sos[i][0]=aclp.get(i).getId();
					sos[i][1]=aclp.get(i).getName();
					sos[i][2]=aclp.get(i).getKind();
					sos[i][3]=Double.toString(aclp.get(i).getPrice());
					sos[i][4]=Integer.toString(aclp.get(i).getNumber());
				}
				String[] sps={"商品ID","名称","类型","单价","数量"};
				JTable table01=new JTable(sos,sps);
				
				JScrollPane scroll01=new JScrollPane(table01);
				JOptionPane pane=new JOptionPane();
				pane.add(scroll01);
				
				pane.setPreferredSize(new Dimension(700,400));
				pane.setLayout(null);
				 
				scroll01.setBounds(50, 50, 600, 250);scroll01.setVisible(true);
				JDialog dialog01=pane.createDialog(pane, "列表详情");
				dialog01.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog01.setVisible(true);
		}
		}
		
	}
	public class buttonlistener5 implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int selectrow=table.getSelectedRow();
			if(selectrow!=-1){
				UnsaleListPO ipo=unsalelistpo.get(selectrow);
				GoodsListPO glp=ipo.getList();
				ArrayList<GoodLinePO> aclp=glp.getList();
				String[][] sos=new String[aclp.size()][5];
				for(int i=0;i<aclp.size();i++){
					sos[i][0]=aclp.get(i).getId();
					sos[i][1]=aclp.get(i).getName();
					sos[i][2]=aclp.get(i).getKind();
					sos[i][3]=Double.toString(aclp.get(i).getPrice());
					sos[i][4]=Integer.toString(aclp.get(i).getNumber());
				}
				String[] sps={"商品ID","名称","类型","单价","数量"};
				JTable table01=new JTable(sos,sps);
				
				JScrollPane scroll01=new JScrollPane(table01);
				JOptionPane pane=new JOptionPane();
				pane.add(scroll01);
				
				pane.setPreferredSize(new Dimension(700,400));
				pane.setLayout(null);
				 
				scroll01.setBounds(50, 50, 600, 250);scroll01.setVisible(true);
				JDialog dialog01=pane.createDialog(pane, "列表详情");
				dialog01.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog01.setVisible(true);
		}
		}
		
	}
	public class buttonlistener6 implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int selectrow=table.getSelectedRow();
			if(selectrow!=-1){
				StackListPO ipo=stacklistpo.get(selectrow);
				GoodsListPO glp=ipo.getList();
				ArrayList<GoodLinePO> aclp=glp.getList();
				String[][] sos=new String[aclp.size()][5];
				for(int i=0;i<aclp.size();i++){
					sos[i][0]=aclp.get(i).getId();
					sos[i][1]=aclp.get(i).getName();
					sos[i][2]=aclp.get(i).getKind();
					sos[i][3]=Double.toString(aclp.get(i).getPrice());
					sos[i][4]=Integer.toString(aclp.get(i).getNumber());
				}
				String[] sps={"商品ID","名称","类型","单价","数量"};
				JTable table01=new JTable(sos,sps);
				
				JScrollPane scroll01=new JScrollPane(table01);
				JOptionPane pane=new JOptionPane();
				pane.add(scroll01);
				
				pane.setPreferredSize(new Dimension(700,400));
				pane.setLayout(null);
				 
				scroll01.setBounds(50, 50, 600, 250);scroll01.setVisible(true);
				JDialog dialog01=pane.createDialog(pane, "列表详情");
				dialog01.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog01.setVisible(true);
		}
		
	}
	}
	public class buttonlistener7 implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int selectrow=table.getSelectedRow();
			if(selectrow!=-1){
				UnstackListPO ipo=unstacklistpo.get(selectrow);
				GoodsListPO glp=ipo.getList();
				ArrayList<GoodLinePO> aclp=glp.getList();
				String[][] sos=new String[aclp.size()][5];
				for(int i=0;i<aclp.size();i++){
					sos[i][0]=aclp.get(i).getId();
					sos[i][1]=aclp.get(i).getName();
					sos[i][2]=aclp.get(i).getKind();
					sos[i][3]=Double.toString(aclp.get(i).getPrice());
					sos[i][4]=Integer.toString(aclp.get(i).getNumber());
				}
				String[] sps={"商品ID","名称","类型","单价","数量"};
				JTable table01=new JTable(sos,sps);
				
				JScrollPane scroll01=new JScrollPane(table01);
				JOptionPane pane=new JOptionPane();
				pane.add(scroll01);
				
				pane.setPreferredSize(new Dimension(700,400));
				pane.setLayout(null);
				 
				scroll01.setBounds(50, 50, 600, 250);scroll01.setVisible(true);
				JDialog dialog01=pane.createDialog(pane, "列表详情");
				dialog01.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog01.setVisible(true);
		}
		
	}
	}
	public class buttonlistener8 implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int selectrow=table.getSelectedRow();
			if(selectrow!=-1){
				GiftListPO ipo=giftlistpo.get(selectrow);
				GoodsListPO glp=ipo.getList();
				ArrayList<GoodLinePO> aclp=glp.getList();
				String[][] sos=new String[aclp.size()][5];
				for(int i=0;i<aclp.size();i++){
					sos[i][0]=aclp.get(i).getId();
					sos[i][1]=aclp.get(i).getName();
					sos[i][2]=aclp.get(i).getKind();
					sos[i][3]=Double.toString(aclp.get(i).getPrice());
					sos[i][4]=Integer.toString(aclp.get(i).getNumber());
				}
				String[] sps={"商品ID","名称","类型","单价","数量"};
				JTable table01=new JTable(sos,sps);
				
				JScrollPane scroll01=new JScrollPane(table01);
				JOptionPane pane=new JOptionPane();
				pane.add(scroll01);
				
				pane.setPreferredSize(new Dimension(700,400));
				pane.setLayout(null);
				 
				scroll01.setBounds(50, 50, 600, 250);scroll01.setVisible(true);
				JDialog dialog01=pane.createDialog(pane, "列表详情");
				dialog01.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog01.setVisible(true);
		}
		
		}
	
	}	
	
	public class button2listener1 implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			int selectrow=table.getSelectedRow();
			if(selectrow!=-1){
				PayinPO ipo=payinpo.get(selectrow);
				ArrayList<accountlineitempo> p=ipo.getlist();
				ArrayList<accountlineitempo> ps=new ArrayList<accountlineitempo>();
				for(int i=0;i<p.size();i++){
					accountlineitempo ap=new accountlineitempo(p.get(i).getname(),(0-p.get(i).getmoney()),p.get(i).getremark());
					ps.add(ap);
				}
				PayinPO ips=new PayinPO(ipo.getcustomer(),ipo.getOperator(),ps);
				dialogmaker3 k=new dialogmaker3("in",ips);
			}
		}
		
	}
	public class button2listener2 implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			int selectrow=table.getSelectedRow();
			if(selectrow!=-1){
				PayoutPO ipo=payoutpo.get(selectrow);
				ArrayList<accountlineitempo> p=ipo.getlist();
				ArrayList<accountlineitempo> ps=new ArrayList<accountlineitempo>();
				for(int i=0;i<p.size();i++){
					accountlineitempo ap=new accountlineitempo(p.get(i).getname(),(0-p.get(i).getmoney()),p.get(i).getremark());
					ps.add(ap);
				}
				PayoutPO ips=new PayoutPO(ipo.getcustomer(),ipo.getOperator(),ps);
				dialogmaker3 k=new dialogmaker3("out",ips);
		}
		
	}
	}
	public class button2listener3 implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			int selectrow=table.getSelectedRow();
			if(selectrow!=-1){
				PaycashPO ipo=paycashpo.get(selectrow);
				ArrayList<cashlineitempo> p=ipo.getlist();
				ArrayList<cashlineitempo> ps=new ArrayList<cashlineitempo>();
				for(int i=0;i<p.size();i++){
					cashlineitempo ap=new cashlineitempo(p.get(i).getname(),(0-p.get(i).getmoney()),p.get(i).getremark());
					ps.add(ap);
				}
				PaycashPO ips=new PaycashPO(ipo.getOperator(),ps,ipo.getaccount());
				dialogmaker3 k=new dialogmaker3("cash",ips);
		}
		}
		
	}
	public class button2listener4 implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			int selectrow=table.getSelectedRow();
			if(selectrow!=-1){
				SaleListPO ipo=salelistpo.get(selectrow);
				GoodsListPO gp=ipo.getList();
				ArrayList<GoodLinePO> lp=gp.getList();
				ArrayList<GoodLinePO> lps=new ArrayList<GoodLinePO>();
				for(int i=0;i<lp.size();i++){
					GoodLinePO pes=lp.get(i);
					GoodLinePO pas=new GoodLinePO(pes.getId(),pes.getName(),pes.getKind(),(0-pes.getPrice()),pes.getNumber());
					lps.add(pas);
				}
				GoodsListPO gps=new GoodsListPO(lps,(0-gp.getAllPrice()));
				SaleListPO ipos=new SaleListPO(gps,ipo.getIdentifier(),ipo.getMemberId(),ipo.getSaler(),ipo.getHouse(),ipo.getOther(),(0-ipo.getbefore()),(0-ipo.getafter()),(0-ipo.getpaper()),(0-ipo.getdiscount()),ipo.getOperator(),ipo.getMemberName());
				dialogmaker3 k=new dialogmaker3("sale",ipos);
		}
		
	}
	}
	public class button2listener5 implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			int selectrow=table.getSelectedRow();
			if(selectrow!=-1){
				UnsaleListPO ipo=unsalelistpo.get(selectrow);
				GoodsListPO gp=ipo.getList();
				ArrayList<GoodLinePO> lp=gp.getList();
				ArrayList<GoodLinePO> lps=new ArrayList<GoodLinePO>();
				for(int i=0;i<lp.size();i++){
					GoodLinePO pes=lp.get(i);
					GoodLinePO pas=new GoodLinePO(pes.getId(),pes.getName(),pes.getKind(),(0-pes.getPrice()),pes.getNumber());
					lps.add(pas);
				}
				GoodsListPO gps=new GoodsListPO(lps,(0-gp.getAllPrice()));
				UnsaleListPO ipos=new UnsaleListPO(gps,ipo.getIdentifier(),ipo.getMemberId(),ipo.getSaler(),ipo.getHouse(),ipo.getOther(),(0-ipo.getPrice()),ipo.getOperator(),ipo.getMemberName());
				dialogmaker3 k=new dialogmaker3("unsale",ipos);
		}
		}
		
	}
	public class button2listener6 implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			int selectrow=table.getSelectedRow();
			if(selectrow!=-1){
				StackListPO ipo=stacklistpo.get(selectrow);
				GoodsListPO gp=ipo.getList();
				ArrayList<GoodLinePO> lp=gp.getList();
				ArrayList<GoodLinePO> lps=new ArrayList<GoodLinePO>();
				for(int i=0;i<lp.size();i++){
					GoodLinePO pes=lp.get(i);
					GoodLinePO pas=new GoodLinePO(pes.getId(),pes.getName(),pes.getKind(),(0-pes.getPrice()),pes.getNumber());
					lps.add(pas);
				}
				GoodsListPO gps=new GoodsListPO(lps,(0-gp.getAllPrice()));
				StackListPO ipos=new StackListPO(gps,ipo.getIdentifier(),ipo.getMemberId(),ipo.getSaler(),ipo.getHouse(),ipo.getOther(),(0-ipo.getPrice()),ipo.getOperator(),ipo.getMemberName());
				dialogmaker3 k=new dialogmaker3("stack",ipos);
		}
		}
		
	}
	public class button2listener7 implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			int selectrow=table.getSelectedRow();
			if(selectrow!=-1){
				UnstackListPO ipo=unstacklistpo.get(selectrow);
				GoodsListPO gp=ipo.getList();
				ArrayList<GoodLinePO> lp=gp.getList();
				ArrayList<GoodLinePO> lps=new ArrayList<GoodLinePO>();
				for(int i=0;i<lp.size();i++){
					GoodLinePO pes=lp.get(i);
					GoodLinePO pas=new GoodLinePO(pes.getId(),pes.getName(),pes.getKind(),(0-pes.getPrice()),pes.getNumber());
					lps.add(pas);
				}
				GoodsListPO gps=new GoodsListPO(lps,(0-gp.getAllPrice()));
				UnstackListPO ipos=new UnstackListPO(gps,ipo.getIdentifier(),ipo.getMemberId(),ipo.getSaler(),ipo.getHouse(),ipo.getOther(),(0-ipo.getPrice()),ipo.getOperator(),ipo.getMemberName());
				dialogmaker3 k=new dialogmaker3("unstack",ipos);
		}
		}
		
	}
	public class button2listener8 implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			int selectrow=table.getSelectedRow();
			if(selectrow!=-1){
				GiftListPO ipo=giftlistpo.get(selectrow);
				GoodsListPO gp=ipo.getList();
				ArrayList<GoodLinePO> lp=gp.getList();
				ArrayList<GoodLinePO> lps=new ArrayList<GoodLinePO>();
				for(int i=0;i<lp.size();i++){
					GoodLinePO pes=lp.get(i);
					GoodLinePO pas=new GoodLinePO(pes.getId(),pes.getName(),pes.getKind(),(0-pes.getPrice()),pes.getNumber());
					lps.add(pas);
				}
				GoodsListPO gps=new GoodsListPO(lps,(0-gp.getAllPrice()));
				GiftListPO ipos=new GiftListPO(gps,ipo.getIdentifier(),ipo.getMemberId(),ipo.getOther(),(0-ipo.getPrice()),ipo.getOperator(),ipo.getMemberName(),ipo.getHouse(),ipo.getSaler());
				dialogmaker3 k=new dialogmaker3("gift",ipos);
		}
		}
		
	}
	public static void main(String args[]){
		ArrayList<BillPO> p=new ArrayList<BillPO>();
		dialogmaker2 k=new dialogmaker2("in",p,"财务人员");
	}

}
