package presentation.checkui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import vo.infoVO;
import businesslogic.checkbl.checkcontroller;
import businesslogicservice.checkblservice.checkblservice;



public class checksalepanel extends JPanel{
	JPanel panel=this;
	JLabel l1=new JLabel("起始时间");
	JLabel l2=new JLabel("结束时间");
	JLabel l3=new JLabel("商品名");
	JLabel l4=new JLabel("业务员");
	JLabel l5=new JLabel("客户");
	JLabel l6=new JLabel("仓库");
	JButton button1=new JButton("确认");
	JButton button2=new JButton("退出");
	JTextField f1=new JTextField();//商品
	JTextField f2=new JTextField();//业务员
	JTextField f3=new JTextField();//客户
	JTextField f4=new JTextField();//仓库
	JComboBox c1,c2,c3,c4,c5,c6;
	
	checkblservice cs=new checkcontroller();
	
	String[] year;
	String[] month=new String[]{"1","2","3","4","5","6","7","8","9","10","11","12"};
	String[] date=new String[31];
	String[] str={"时间","商品名","型号","数量","单价","总额"};
	String[][] str1=new String[20][6];
	JTable table;
	JScrollPane js;
	public checksalepanel(){
		
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
		table=new JTable(str1,str);
		js=new JScrollPane(table);
		
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
		
		l3.setBounds(120, 170, 100, 50);
		f1.setBounds(200, 180, 200, 30);
		l4.setBounds(500, 170, 100,50);
		f2.setBounds(580, 180, 200, 30);
		
		l5.setBounds(120, 230, 100, 50);
		f3.setBounds(200, 240, 200,30);
		l6.setBounds(500, 230, 100,50);
		f4.setBounds(580, 240, 200, 30);
		
		js.setBounds(100, 300, 800, 130);
		
		panel.add(button1);panel.add(button2);panel.add(l1);panel.add(l2);
		panel.add(c1);panel.add(c2);panel.add(c3);panel.add(c4);
		panel.add(c5);panel.add(c6);panel.add(l3);panel.add(l4);
		panel.add(f1);panel.add(f2);panel.add(f3);panel.add(f4);
		panel.add(l5);panel.add(l6);panel.add(js);
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
			if(f1.getText().trim().length()!=0){
				s3=f1.getText().trim();
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
			
			infoVO v=new infoVO(s1,s2,s3,s5,s4,s6,null);
			ArrayList<String> as=cs.checkgoods(v);
			str1=new String[as.size()][6];
			for(int i=0;i<as.size();i++){
				String[] result=as.get(i).split(";");
				str1[i][0]=result[0];
				str1[i][1]=result[1];
				str1[i][2]=result[2];
				str1[i][3]=result[3];
				str1[i][4]=result[4];
				str1[i][5]=result[5];
				
			}
			panel.remove(js);
			table=new JTable(str1,str);
			js=new JScrollPane(table);
			js.setBounds(100, 300, 800, 130);
			panel.add(js);
			
		}
		
	}
	public class button2listener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.exit(0);
			
		}
		
	}

}
