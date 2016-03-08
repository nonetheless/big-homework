package presentation.billmanagementui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

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
import uiField.DoubleField;
import uiField.IntField;
import businesslogic.billmanagementbl.BillManageController;

public class BillDialog {
	
	BillManageController bmc;
	JDialog chooseDialog;
	
	JDialog getDialog;
	DoubleField double_txt1;
	String get_res="no";
	
	public void showBill(String type,String id){
		if(type.equals("SKD")){
			showSKD(id);
		}
		else if(type.equals("FKD")){
			showFKD(id);
		}
		else if(type.equals("XJFKD")){
			showXJFKD(id);
		}
		else if(type.equals("over")||type.equals("loss")||type.equals("alarm")){
			showStock(type,id);
		}
		else if(type.equals("XSD")){
			showXSD(id);
		}
		else if(type.equals("XSTHD")){
			showXSTHD(id);
		}
		else if(type.equals("JHD")){
			showJHD(id);
		}
		else if(type.equals("THD")){
			showTHD(id);
		}
		else if(type.equals("KCZSD")){
			showKCZSD(id);
		}
	}
	
	public void showSKD(String id){
		bmc=new BillManageController();
		ArrayList<PayinPO> list=bmc.getBillList("file/SKD.ser");
		PayinPO po=null;
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				po=list.get(i);
				if(po.getIdentifier().equals(id)){
					break;
				}
			}
			
			String [][]data1=new String[1][6];
			String []title1={"单据类型","单据编号","操作员","时间","应收总额","客户"};
			
			data1[0][0]=po.getType();
			data1[0][1]=po.getIdentifier();
			data1[0][2]=po.getOperator();
			data1[0][3]=po.gettime();
			data1[0][4]=String.valueOf(po.gettotal());
			data1[0][5]=po.getcustomer();
			
			
			ArrayList<accountlineitempo> acclist=po.getlist();
			
			String [][]data2=new String[100][3];
			String []title2={"帐户名","金额","备注"};
			
			if(acclist.size()>0){
				for(int i=0;i<acclist.size();i++){
					accountlineitempo accpo=acclist.get(i);
					data2[i][0]=accpo.getname();
					data2[i][1]=String.valueOf(accpo.getmoney());
					data2[i][2]=accpo.getremark();
				}
			}
			showDoubleTable(data1,title1,data2,title2,"查看收款单","转账列表");
		}
		
	}
	
	public void showXJFKD(String id){
		bmc=new BillManageController();
		ArrayList<PaycashPO> list=bmc.getBillList("file/XJFKD.ser");
		PaycashPO po=null;
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				po=list.get(i);
				if(po.getIdentifier().equals(id)){
					break;
				}
			}
			
			String [][]data1=new String[1][6];
			String []title1={"单据类型","单据编号","操作员","时间","应付总额","账户"};
			
			data1[0][0]=po.getType();
			data1[0][1]=po.getIdentifier();
			data1[0][2]=po.getOperator();
			data1[0][3]=po.gettime();
			data1[0][4]=String.valueOf(po.gettotal());
			data1[0][5]=po.getaccount();
			
			ArrayList<cashlineitempo> cashlist=po.getlist();
			String [][]data2=new String[1][3];
			String []title2={"条目名","金额","备注"};
			
			if(cashlist.size()>0){
				for(int i=0;i<cashlist.size();i++){
					cashlineitempo cpo=cashlist.get(i);
					data2[i][0]=cpo.getname();
					data2[i][1]=String.valueOf(cpo.getmoney());
					data2[i][2]=cpo.getremark();
				}
			}
			
			showDoubleTable(data1,title1,data2,title2,"查看现金付款单","条目列表");
		}
	}
	
	public void showFKD(String id){
		bmc=new BillManageController();
		ArrayList<PayoutPO> list=bmc.getBillList("file/FKD.ser");
		PayoutPO po=null;
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				po=list.get(i);
				if(po.getIdentifier().equals(id)){
					break;
				}
			}
			
			String [][]data1=new String[1][6];
			String []title1={"单据类型","单据编号","操作员","时间","应收总额","客户"};
			
			data1[0][0]=po.getType();
			data1[0][1]=po.getIdentifier();
			data1[0][2]=po.getOperator();
			data1[0][3]=po.gettime();
			data1[0][4]=String.valueOf(po.gettotal());
			data1[0][5]=po.getcustomer();
			
			
			ArrayList<accountlineitempo> acclist=po.getlist();
			
			String [][]data2=new String[100][3];
			String []title2={"帐户名","金额","备注"};
			
			if(acclist.size()>0){
				for(int i=0;i<acclist.size();i++){
					accountlineitempo accpo=acclist.get(i);
					data2[i][0]=accpo.getname();
					data2[i][1]=String.valueOf(accpo.getmoney());
					data2[i][2]=accpo.getremark();
				}
			}
			showDoubleTable(data1,title1,data2,title2,"查看付款单","转账列表");
		}
	} 
	
	public void showStock(String type,String id){
		bmc=new BillManageController();
		String file="file/"+type+".ser";
		ArrayList<StockBillsPo> list=bmc.getBillList(file);
		StockBillsPo po=null;
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				po=list.get(i);
				if(po.getIdentifier().equals(id)){
					break;
				}
			}
			
			String [][]data=new String[1][8];
			String []title={"单据类型","单据编号","操作员","商品名","商品型号","商品数量","仓库","日期"};
			
			data[0][0]=po.getType();
			data[0][1]=po.getIdentifier();
			data[0][2]=po.getOperator();
			data[0][3]=po.getCommodityName();
			data[0][4]=po.get_ModelNum();
			data[0][5]=String.valueOf(po.getFactualNum());
			data[0][6]=po.get_storeHouse();
			data[0][7]=po.get_date();
			
			String str=null;
			if(type.equals("over")){
				str="查看库存报警单";
			}
			else if(type.equals("loss")){
				str="查看库存报损单";
			}
			else{
				str="查看库存警报单";
			}
			showTable(data,title,str);
		}
	}
	
	public void showXSD(String id){
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
			
			String [][]data1=new String[1][9];
			String []title1={"单据类型","单据编号","操作员","客户ID","客户名","代金券","折扣","优惠前总价","优惠后总价"};
			
			String [][]data2=new String[100][5];
			String []title2={"商品ID","商品名","商品种类","商品价格","商品数量"};
			
			data1[0][0]=po.getType();
			data1[0][1]=po.getIdentifier();
			data1[0][2]=po.getOperator();
			data1[0][3]=po.getMemberId();
			data1[0][4]=po.getMemberName();
			data1[0][5]=String.valueOf(po.getpaper());
			data1[0][6]=String.valueOf(po.getdiscount());
			data1[0][7]=String.valueOf(po.getbefore());
			data1[0][8]=String.valueOf(po.getafter());
			
			GoodsListPO gpo=po.getList();
			ArrayList<GoodLinePO> goodslist=gpo.getList();
			for(int i=0;i<goodslist.size();i++){
				GoodLinePO glpo=goodslist.get(i);
				data2[i][0]=glpo.getId();
				data2[i][1]=glpo.getName();
				data2[i][2]=glpo.getKind();
				data2[i][3]=String.valueOf(glpo.getPrice());
				data2[i][4]=String.valueOf(glpo.getNumber());
			}
			
			showDoubleTable(data1,title1,data2,title2,"查看销售单","商品列表");
			
		}
	}
	
	public void showXSTHD(String id){
		bmc=new BillManageController();
		ArrayList<UnsaleListPO> list=bmc.getBillList("file/XSTHD.ser");
		UnsaleListPO po=null;
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				po=list.get(i);
				if(po.getIdentifier().equals(id)){
					break;
				}
			}
			
			String [][]data1=new String[1][6];
			String []title1={"单据类型","单据编号","操作员","客户ID","客户名","总价额"};
			
			String [][]data2=new String[100][5];
			String []title2={"商品ID","商品名","商品种类","商品价格","商品数量"};
			
			data1[0][0]=po.getType();
			data1[0][1]=po.getIdentifier();
			data1[0][2]=po.getOperator();
			data1[0][3]=po.getMemberId();
			data1[0][4]=po.getMemberName();
			data1[0][5]=String.valueOf(po.getPrice());
			
			GoodsListPO gpo=po.getList();
			ArrayList<GoodLinePO> goodslist=gpo.getList();
			for(int i=0;i<goodslist.size();i++){
				GoodLinePO glpo=goodslist.get(i);
				data2[i][0]=glpo.getId();
				data2[i][1]=glpo.getName();
				data2[i][2]=glpo.getKind();
				data2[i][3]=String.valueOf(glpo.getPrice());
				data2[i][4]=String.valueOf(glpo.getNumber());
			}
			
			showDoubleTable(data1,title1,data2,title2,"查看销售退货单","商品列表");
			
		}
	}
	
	public void showJHD(String id){
		
		bmc=new BillManageController();
		ArrayList<StackListPO> list=bmc.getBillList("file/JHD.ser");
		StackListPO po=null;
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				po=list.get(i);
				if(po.getIdentifier().equals(id)){
					break;
				}
			}
			
			String [][]data1=new String[1][7];
			String []title1={"单据类型","单据编号","操作员","客户ID","客户名","总价","仓库"};
			
			String [][]data2=new String[100][5];
			String []title2={"商品ID","商品名","商品种类","商品价格","商品数量"};
			
			data1[0][0]=po.getType();
			data1[0][1]=po.getIdentifier();
			data1[0][2]=po.getOperator();
			data1[0][3]=po.getMemberId();
			data1[0][4]=po.getMemberName();
			data1[0][5]=String.valueOf(po.getPrice());
			data1[0][6]=po.getHouse();
			
			GoodsListPO gpo=po.getList();
			ArrayList<GoodLinePO> goodslist=gpo.getList();
			for(int i=0;i<goodslist.size();i++){
				GoodLinePO glpo=goodslist.get(i);
				data2[i][0]=glpo.getId();
				data2[i][1]=glpo.getName();
				data2[i][2]=glpo.getKind();
				data2[i][3]=String.valueOf(glpo.getPrice());
				data2[i][4]=String.valueOf(glpo.getNumber());
			}
			
			showDoubleTable(data1,title1,data2,title2,"查看进货单","货物列表");
			
		}
	}
	
	public void showTHD(String id){
		
		bmc=new BillManageController();
		ArrayList<UnstackListPO> list=bmc.getBillList("file/THD.ser");
		UnstackListPO po=null;
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				po=list.get(i);
				if(po.getIdentifier().equals(id)){
					break;
				}
			}
			
			String [][]data1=new String[1][7];
			String []title1={"单据类型","单据编号","操作员","客户ID","客户名","总价","仓库"};
			
			String [][]data2=new String[100][5];
			String []title2={"商品ID","商品名","商品种类","商品价格","商品数量"};
			
			data1[0][0]=po.getType();
			data1[0][1]=po.getIdentifier();
			data1[0][2]=po.getOperator();
			data1[0][3]=po.getMemberId();
			data1[0][4]=po.getMemberName();
			data1[0][5]=String.valueOf(po.getPrice());
			data1[0][6]=po.getHouse();
			
			GoodsListPO gpo=po.getList();
			ArrayList<GoodLinePO> goodslist=gpo.getList();
			for(int i=0;i<goodslist.size();i++){
				GoodLinePO glpo=goodslist.get(i);
				data2[i][0]=glpo.getId();
				data2[i][1]=glpo.getName();
				data2[i][2]=glpo.getKind();
				data2[i][3]=String.valueOf(glpo.getPrice());
				data2[i][4]=String.valueOf(glpo.getNumber());
			}
			
			showDoubleTable(data1,title1,data2,title2,"查看退货单","货物列表");
			
		}
	}
	
	public void showKCZSD(String id){
		
		bmc=new BillManageController();
		ArrayList<GiftListPO> list=bmc.getBillList("file/KCZSD.ser");
		GiftListPO po=null;
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				po=list.get(i);
				if(po.getIdentifier().equals(id)){
					break;
				}
			}
			
			String [][]data1=new String[1][7];
			String []title1={"单据类型","单据编号","操作员","客户ID","客户名","总价","仓库"};
			
			String [][]data2=new String[100][5];
			String []title2={"赠品ID","赠品名","赠品种类","赠品价格","赠品数量"};
			
			data1[0][0]=po.getType();
			data1[0][1]=po.getIdentifier();
			data1[0][2]=po.getOperator();
			data1[0][3]=po.getMemberId();
			data1[0][4]=po.getMemberName();
			data1[0][5]=String.valueOf(po.getPrice());
			data1[0][6]=po.getHouse();
			
			GoodsListPO gpo=po.getList();
			ArrayList<GoodLinePO> goodslist=gpo.getList();
			for(int i=0;i<goodslist.size();i++){
				GoodLinePO glpo=goodslist.get(i);
				data2[i][0]=glpo.getId();
				data2[i][1]=glpo.getName();
				data2[i][2]=glpo.getKind();
				data2[i][3]=String.valueOf(glpo.getPrice());
				data2[i][4]=String.valueOf(glpo.getNumber());
			}
			
			showDoubleTable(data1,title1,data2,title2,"查看库存赠送单","赠品列表");
			
		}
	}
	
	public void showTable(String [][]data,String []title,String dialogName){
		
		JTable table=new JTable(data,title);
		table.setRowHeight(50);
		table.repaint();
		JScrollPane StockPanel = new JScrollPane(table);
		StockPanel.setViewportView(table);
		StockPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		StockPanel.setBounds(50,25,900,85);
		StockPanel.repaint();
		
		JButton enter=new JButton("确认");
		enter.setBounds(400, 130, 200, 50);
		enter.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				chooseDialog.dispose();
			}
			
		});
		
		JOptionPane dialogPanel = new JOptionPane();
		dialogPanel.setLayout(null);
		dialogPanel.add(StockPanel);
		dialogPanel.add(enter);
		dialogPanel.setPreferredSize(new Dimension(1000,200));
		
		chooseDialog = dialogPanel.createDialog(dialogPanel,dialogName);
		chooseDialog.setVisible(true);
	}
	
	public void showDoubleTable(String [][]data1,String []title1,
			String [][]data2,String []title2,String dialogName,String label){
		
		JTable table1=new JTable(data1,title1);
		table1.setRowHeight(50);
		table1.repaint();
		JScrollPane StockPanel = new JScrollPane(table1);
		StockPanel.setViewportView(table1);
		StockPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		StockPanel.setBounds(50,25,900,85);
		StockPanel.repaint();
		
		JTable table2=new JTable(data2,title2);
		table2.setRowHeight(50);
		table2.repaint();
		JScrollPane StockPanel2 = new JScrollPane(table2);
		StockPanel2.setViewportView(table2);
		StockPanel2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		StockPanel2.setBounds(50,160,900,200);
		StockPanel2.repaint();
		
		JButton enter=new JButton("确认");
		enter.setBounds(400, 380, 200, 50);
		enter.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				chooseDialog.dispose();
			}
			
		});
		
		JLabel clabel=new JLabel(label);
		clabel.setBounds(50, 120, 150, 30);
		
		JOptionPane dialogPanel = new JOptionPane();
		dialogPanel.setLayout(null);
		dialogPanel.add(StockPanel);
		dialogPanel.add(StockPanel2);
		dialogPanel.add(enter);
		dialogPanel.add(clabel);
		dialogPanel.setPreferredSize(new Dimension(1000,450));
		
		chooseDialog = dialogPanel.createDialog(dialogPanel,dialogName);
		chooseDialog.setVisible(true);
		
	}
	
	public String oneGet(String dialogName,String l1,String t1){
		JLabel line1=new JLabel(l1);
		line1.setBounds(150, 50, 150, 50);
		
		double_txt1=new DoubleField(t1);
		double_txt1.setBounds(350, 50, 100, 50);
		
		
		JButton enter=new JButton("确认");
		enter.setBounds(100, 150, 150, 50);
		enter.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(double_txt1!=null){
					if(double_txt1.getText().equals("")){
						JOptionPane.showMessageDialog(null, "输入不能为空");
					}
					else{
					get_res=double_txt1.getText();}
				}
				getDialog.dispose(); 
			}
			
		});
		
		JButton quit=new JButton("取消");
		quit.setBounds(350, 150, 150, 50);
		quit.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				get_res="no";
				getDialog.dispose();
			}
			
		});
		
		JOptionPane dialogPanel = new JOptionPane();
		dialogPanel.setLayout(null);
		
		dialogPanel.add(line1);	
		dialogPanel.add(double_txt1);
		
		dialogPanel.add(enter);
		dialogPanel.add(quit);
		
		dialogPanel.setPreferredSize(new Dimension(600,250));
		getDialog = dialogPanel.createDialog(dialogPanel,dialogName);
		getDialog.setVisible(true);
		
		return get_res;
	}
	
}
