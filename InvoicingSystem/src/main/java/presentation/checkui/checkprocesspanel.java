package presentation.checkui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;

import vo.infoVO;

public class checkprocesspanel extends JPanel{
	JPanel panel=this;
	JLabel l1=new JLabel("起始时间");
	JLabel l2=new JLabel("结束时间");
	JLabel l3=new JLabel("单据类型");
	JLabel l4=new JLabel("业务员");
	JLabel l5=new JLabel("客户");
	JLabel l6=new JLabel("仓库");
	JButton button1=new JButton("确认");
	JButton button2=new JButton("退出");
	JComboBox f1;//单据类型
	JTextField f2=new JTextField();//业务员
	JTextField f3=new JTextField();//客户
	JTextField f4=new JTextField();//仓库
	JComboBox c1,c2,c3,c4,c5,c6;
	String operatorid;
	String[] year;
	String[] month=new String[]{"1","2","3","4","5","6","7","8","9","10","11","12"};
	String[] date=new String[31];
	public checkprocesspanel(String iden){
		operatorid=iden;
		panel.setSize(1000, 600);
		SimpleDateFormat df=new SimpleDateFormat("yyyy");
		String time=df.format(new Date());
		int i=Integer.parseInt(time);
		year=new String[i-2000+2];
		year[0]="无";
		for(int j=2000;j<=i;j++){
			year[j-1999]=Integer.toString(j);
		}
		for(int j=1;j<=31;j++){
			date[j-1]=Integer.toString(j);
		}
		c1=new JComboBox(year);
		c2=new JComboBox(month);
		c3=new JComboBox(date);
		c4=new JComboBox(year);
		c5=new JComboBox(month);
		c6=new JComboBox(date);
		String[] type={"无","销售单","销售退货单","进货单","退货单","赠品单","报损单","报溢单","收款单","付款单","现金付款单"};
		f1=new JComboBox(type);
		panel.setLayout(null);
		
		button1.setBounds(270, 450, 80, 30);button1.setVisible(true);
		button2.setBounds(650, 450, 80, 30);button2.setVisible(true);
		l1.setBounds(270, 50, 100, 50);
		c1.setBounds(140, 120, 80, 30);
		c2.setBounds(260, 120, 80, 30);
		c3.setBounds(380, 120,80, 30);
		l2.setBounds(650, 50, 100, 50);
		c4.setBounds(520, 120, 80, 30);
		c5.setBounds(640, 120, 80, 30);
		c6.setBounds(760, 120, 80, 30);
		
		l3.setBounds(270, 170, 100, 50);
		f1.setBounds(200, 240, 200, 30);
		l4.setBounds(650, 170, 100,50);
		f2.setBounds(580, 240, 200, 30);
		
		l5.setBounds(280, 280, 100, 50);
		f3.setBounds(200, 350, 200,30);
		l6.setBounds(660, 280, 100,50);
		f4.setBounds(580, 350, 200, 30);
		
		panel.add(button1);panel.add(button2);panel.add(l1);panel.add(l2);
		panel.add(c1);panel.add(c2);panel.add(c3);panel.add(c4);
		panel.add(c5);panel.add(c6);panel.add(l3);panel.add(l4);
		panel.add(f1);panel.add(f2);panel.add(f3);panel.add(f4);
		panel.add(l5);panel.add(l6);
		button1.addActionListener(new button1listener());
		button2.addActionListener(new button2listener());
		
	}
	public class button1listener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			String s1=null;String s2=null;String s3=null;String s4=null;String s5=null;String s6=null;
			if(!((String)c1.getSelectedItem()).equals("无")){
			     s1=(String)c1.getSelectedItem()+"-"+(String)c2.getSelectedItem()+"-"+(String)c3.getSelectedItem();
			}
			if(!((String)c4.getSelectedItem()).equals("无")){
			     s2=(String)c4.getSelectedItem()+"-"+(String)c5.getSelectedItem()+"-"+(String)c6.getSelectedItem();
			}
			if(!((String)f1.getSelectedItem()).equals("无")){
				String ss=(String)f1.getSelectedItem();
				if(ss.equals("销售单")){
					s3="XSD";
				}
				if(ss.equals("销售退货单")){
					s3="XSTHD";
				}
				if(ss.equals("进货单")){
					s3="JHD";
				}
				if(ss.equals("退货单")){
					s3="THD";
				}
				if(ss.equals("赠品单")){
					s3="KCZSD";
				}
				if(ss.equals("报损单")){
					s3="loss";
				}
				if(ss.equals("报溢单")){
					s3="over";
				}
				if(ss.equals("收款单")){
					s3="SKD";
				}
				if(ss.equals("付款单")){
					s3="FKD";
				}
				if(ss.equals("现金付款单")){
					s3="XJFKD";
				}
			}
			if(f2.getText().trim().length()!=0){
				s4=f2.getText().trim();
			}
			if(f3.getText().trim().length()!=0){
				s5=f3.getText().trim();
			}
			if(f4.getText().trim().length()!=0){
				s6=f4.getText().trim();
			}
			
			infoVO v=new infoVO(s1,s2,null,s5,s4,s6,s3);
			processframe2 frame2=new processframe2(v,operatorid);
			f2.setText("");f3.setText("");f4.setText("");
		}
		
	}
	public class button2listener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			System.exit(0);
			
		}
		
	}
	
	

}
