package presentation.checkui;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import vo.infoVO;
import businesslogic.checkbl.checkcontroller;
import businesslogicservice.checkblservice.checkblservice;

public class checksituationpanel extends JPanel{
	JPanel panel=this;
	JLabel l1=new JLabel("起始时间");
	JLabel l2=new JLabel("结束时间");
	JButton button1=new JButton("确认");
	JButton button2=new JButton("退出");
	JComboBox c1,c2,c3,c4,c5,c6;
	String[] year;
	String[] month=new String[]{"1","2","3","4","5","6","7","8","9","10","11","12"};
	String[] date=new String[31];
	String[] str={"收入","折让","支出","利润"};
	String[][] str1=new String[20][4];
	
	JTable table;
	JScrollPane scroll;
	
	checkblservice cs=new checkcontroller();
	
	public checksituationpanel(){
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
		
		button1.setBounds(270, 450, 80, 30);button1.setVisible(true);
		button2.setBounds(650, 450, 80, 30);button2.setVisible(true);
		button1.addActionListener(new button1listener());
		button2.addActionListener(new button2listener());
		l1.setBounds(270, 50, 100, 50);
		c1.setBounds(140, 120, 80, 30);
		c2.setBounds(260, 120, 80, 30);
		c3.setBounds(380, 120,80, 30);
		l2.setBounds(650, 50, 100, 50);
		c4.setBounds(520, 120, 80, 30);
		c5.setBounds(640, 120, 80, 30);
		c6.setBounds(760, 120, 80, 30);
		
		panel.add(button1);panel.add(button2);panel.add(l1);panel.add(l2);
		panel.add(c1);panel.add(c2);panel.add(c3);panel.add(c4);
		panel.add(c5);panel.add(c6);
		
		
		table=new JTable(str1,str);
		scroll=new JScrollPane(table);
		panel.add(scroll);
		scroll.setBounds(100, 200, 800, 230);
		
		panel.setLayout(null);
		panel.setVisible(true);
	}
	class button1listener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			String s1=null;String s2=null;
			if(!((String)c1.getSelectedItem()).equals("无")){
			     s1=(String)c1.getSelectedItem()+"-"+(String)c2.getSelectedItem()+"-"+(String)c3.getSelectedItem();
			}
			if(!((String)c4.getSelectedItem()).equals("无")){
			     s2=(String)c4.getSelectedItem()+"-"+(String)c5.getSelectedItem()+"-"+(String)c6.getSelectedItem();
			}
			infoVO v=new infoVO(s1,s2,null,null,null,null,null);
			ArrayList<String> s=new ArrayList<String>();
			s=cs.checksituation(v);
			String[][] str2=new String[20][4];
			for(int i=0;i<s.size();i++){
				str2[0][i]=s.get(i);
			}
			
			panel.remove(scroll);
			table=new JTable(str2,str);
			scroll=new JScrollPane(table);
			panel.add(scroll);
			scroll.setBounds(100, 200, 800, 230);
		}
		
	}
	class button2listener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.exit(0);
			
		}
		
	}

}
