package presentation.paymentui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import po.BillPO;
import po.PaycashPO;
import po.PayinPO;
import po.PayoutPO;
import po.accountlineitempo;
import po.cashlineitempo;

public class dialogmaker {
	JDialog dialog;
	JButton button=new JButton("查看详情");
	JTable table;
	JScrollPane scroll;
	JOptionPane optionpane=new JOptionPane();
	String type;
	ArrayList<PayinPO> payinpo=new ArrayList<PayinPO>();
	ArrayList<PayoutPO> payoutpo=new ArrayList<PayoutPO>();
	ArrayList<PaycashPO> paycashpo=new ArrayList<PaycashPO>();
	String[] str1={"类型","编号","操作员","时间","客户","转账列表","总额"};
	String[] str2={"类型","编号","操作员","时间","账户","条目列表","总额"};
	String[][] ss;
	public dialogmaker(String s,ArrayList<PayinPO> ip,ArrayList<PayoutPO> op,ArrayList<PaycashPO> cp){
		 type=s;
		 optionpane.setSize(1000, 600);
		 if(s.equals("in")){ 
			 payinpo=ip;
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
			 optionpane.setPreferredSize(new Dimension(700,400));
			 optionpane.setLayout(null);
			 button.setBounds(270, 330, 150, 30);
			 button.addActionListener(new buttonlistener1());
			 scroll.setBounds(50, 50, 600, 250);scroll.setVisible(true);
			 dialog=optionpane.createDialog(optionpane, "收款单");
			 dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			 dialog.setVisible(true);
			 
		 }
		 else if(s.equals("out")){
			 payoutpo=op;
			 
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
			 optionpane.setPreferredSize(new Dimension(700,400));
			 optionpane.setLayout(null);
			 button.setBounds(270, 330, 150, 30);
			 button.addActionListener(new buttonlistener2());
			 scroll.setBounds(50, 50, 600, 250);scroll.setVisible(true);
			 dialog=optionpane.createDialog(optionpane, "付款单");
			 dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			 dialog.setVisible(true);
		 }
		 else if(s.equals("cash")){
			 paycashpo=cp;
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
			 optionpane.setPreferredSize(new Dimension(700,400));
			 optionpane.setLayout(null);
			 button.setBounds(270, 330, 150, 30);
			 button.addActionListener(new buttonlistener3());
			 scroll.setBounds(50, 50, 600, 250);scroll.setVisible(true);
			 dialog=optionpane.createDialog(optionpane, "现金付款单");
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
	public static void main(String args[]){
		ArrayList<PaycashPO> p=new ArrayList<PaycashPO>();
		ArrayList<cashlineitempo> list=new ArrayList<cashlineitempo>();
		cashlineitempo acp=new cashlineitempo("zhanghu2",100,"wu"); 
		cashlineitempo abp=new cashlineitempo("zhanghu3",234,"rt");
		list.add(acp);list.add(abp);
		PaycashPO pl=new PaycashPO("linxin",list,"liuzhijia");
		p.add(pl);
		dialogmaker k=new dialogmaker("cash",null,null,p);
	}
    

}
