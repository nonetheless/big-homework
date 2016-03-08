package presentation.promotionui;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import uiField.DoubleField;
import uiField.IntField;


public class DialogCreatorForPromotion {
	
	static JDialog new_dialog = new JDialog();
	static JOptionPane dialogPanel;
	public static int return_value; 
	
	static JCheckBox line1;
	static JCheckBox line2;
	static JCheckBox line3;
	
	static JTextField txt3;
	static JTextField txt4;
	
	static IntField int_txt1;
	static IntField int_txt2;
	
	static DoubleField double_txt;
	
	static JTextField txt_t;
	
	static String res="no";
	
	public static String threeCheck(String dialogName,String l1,String l2,String l3){
		
		line1=new JCheckBox(l1);
		line2=new JCheckBox(l2);
		line3=new JCheckBox(l3);
		
		line1.setBounds(230,10,300,50);
		line2.setBounds(230,70,300,50);
		line3.setBounds(230,130,300,50);
		
		line1.setSelected(false);
		line2.setSelected(false);
		line3.setSelected(false);
		
		JButton button1=new JButton("确认");
		button1.setBounds(100, 200, 150, 50);
		button1.setVisible(true);
		button1.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				res=String.valueOf(line1.isSelected())+" "
				+line2.isSelected()+" "+line3.isSelected();
				new_dialog.dispose();
			}
			
		});
		
		JButton button2=new JButton("取消");
		button2.setBounds(350, 200, 150, 50);
		button2.setVisible(true);
		button2.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				res="no";
				new_dialog.dispose();
			}
		});
		
		dialogPanel = new JOptionPane();
		dialogPanel.setLayout(null);
		
		dialogPanel.add(line1);
		dialogPanel.add(line2);
		dialogPanel.add(line3);
		
		dialogPanel.add(button1);
		dialogPanel.add(button2);
		
		dialogPanel.setPreferredSize(new Dimension(600,300));
		
		new_dialog = dialogPanel.createDialog(dialogPanel,dialogName);
		new_dialog.setVisible(true);
		
		return res;
	}
	
	public static String fourGet(String dialogName,String l1,String l2,String l3,String l4,
			String t1,String t2,String t3,String t4){
		
		JLabel line1=new JLabel(l1);
		line1.setBounds(150, 30, 150, 50);
		
		int_txt1=new IntField(t1);
		int_txt1.setBounds(350, 30, 100, 50);
		
		JLabel line2=new JLabel(l2);
		line2.setBounds(150, 90, 150, 50);
		
		int_txt2=new IntField(t2);
		int_txt2.setBounds(350, 90, 100, 50);
		
		JLabel line3=new JLabel(l3);
		line3.setBounds(150, 150, 150, 50);
		
		txt3=new JTextField(t3);
		txt3.setBounds(350, 150, 100, 50);
		
		JLabel line4=new JLabel(l4);
		line4.setBounds(150, 210, 150, 50);
		
		txt4=new JTextField(t4);
		txt4.setBounds(350, 210, 100, 50);
		
		JButton enter=new JButton("确认");
		enter.setBounds(100, 300, 150, 50);
		enter.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String str_1=txt3.getText();
				String str_2=txt4.getText();
				System.out.println("str1: "+str_1);
				System.out.println("str2: "+str_2);
				System.out.println("check str1: "+checkDate(str_1));
				System.out.println("check str2: "+checkDate(str_2));
				if(int_txt1.getText().equals("")||int_txt2.getText().equals("")
						||txt3.getText().equals("")||txt4.getText().equals("")){
					JOptionPane.showMessageDialog(null, "输入不能为空");
				}
				else if(checkDate(str_1)&&checkDate(str_2)){
					res=int_txt1.getText()+" "+int_txt2.getText()+" "+txt3.getText()+" "+txt4.getText();
					new_dialog.dispose();
				}
				else{
					JOptionPane.showMessageDialog(null, "日期格式错误，请按照yyyy-MM-dd的格式输入日期");
				}
			}
			
		});
		
		JButton quit=new JButton("取消");
		quit.setBounds(350, 300, 150, 50);
		quit.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				res="no";
				new_dialog.dispose();
			}
			
		});
		
		dialogPanel = new JOptionPane();
		dialogPanel.setLayout(null);
		
		dialogPanel.add(line1);
		dialogPanel.add(line2);
		dialogPanel.add(line3);
		dialogPanel.add(line4);
		
		dialogPanel.add(int_txt1);
		dialogPanel.add(int_txt2);
		dialogPanel.add(txt3);
		dialogPanel.add(txt4);
		
		dialogPanel.add(enter);
		dialogPanel.add(quit);
		
		dialogPanel.setPreferredSize(new Dimension(600,400));
		new_dialog = dialogPanel.createDialog(dialogPanel,dialogName);
		new_dialog.setVisible(true);
		
		return res;
	}
	
	public static String twoCheck(String dialogName,String l1,String l2){
		line1=new JCheckBox(l1);
		line2=new JCheckBox(l2);
		
		line1.setBounds(230,10,300,50);
		line2.setBounds(230,70,300,50);
		
		line1.setSelected(false);
		line2.setSelected(false);
		
		JButton button1=new JButton("确认");
		button1.setBounds(100, 150, 150, 50);
		button1.setVisible(true);
		button1.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				res=String.valueOf(line1.isSelected())+" "
				+line2.isSelected();
				new_dialog.dispose();
			}
			
		});
		
		JButton button2=new JButton("取消");
		button2.setBounds(350, 150, 150, 50);
		button2.setVisible(true);
		button2.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				res="no";
				new_dialog.dispose();
			}
		});
		
		dialogPanel = new JOptionPane();
		dialogPanel.setLayout(null);
		
		dialogPanel.add(line1);
		dialogPanel.add(line2);
		
		dialogPanel.add(button1);
		dialogPanel.add(button2);
		
		dialogPanel.setPreferredSize(new Dimension(600,250));
		
		new_dialog = dialogPanel.createDialog(dialogPanel,dialogName);
		new_dialog.setVisible(true);
		
		return res;
	}
	
	public static String twoCheckOneGet(String dialogName,String l1,String l2,String str){
		line1=new JCheckBox(l1);
		line2=new JCheckBox(l2);
		
		line1.setBounds(230,10,300,50);
		line2.setBounds(230,70,300,50);
		
		JLabel tx=new JLabel(str);
		tx.setBounds(150, 130, 150, 50);
		
		double_txt=new DoubleField();
		double_txt.setBounds(270, 130, 150, 50);
		
		line1.setSelected(false);
		line2.setSelected(false);
		
		JButton button1=new JButton("确认");
		button1.setBounds(100, 200, 150, 50);
		button1.setVisible(true);
		button1.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(double_txt.getText().equals("")){
					JOptionPane.showMessageDialog(null, "输入不能为空");
				}
				else{
				res=String.valueOf(double_txt.getText()+" "+line1.isSelected())+" "
				+line2.isSelected();
				new_dialog.dispose();}
			}
			
		});
		
		JButton button2=new JButton("取消");
		button2.setBounds(350, 200, 150, 50);
		button2.setVisible(true);
		button2.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				res="no";
				new_dialog.dispose();
			}
		});
		
		dialogPanel = new JOptionPane();
		dialogPanel.setLayout(null);
		
		dialogPanel.add(line1);
		dialogPanel.add(line2);
		
		dialogPanel.add(button1);
		dialogPanel.add(button2);
		
		dialogPanel.add(tx);
		dialogPanel.add(double_txt);
		
		dialogPanel.setPreferredSize(new Dimension(600,300));
		
		new_dialog = dialogPanel.createDialog(dialogPanel,dialogName);
		new_dialog.setVisible(true);
		
		return res;
		
	}
	
	public static boolean checkDate(String str){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		// 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
		dateFormat.setLenient(false);
		boolean result=false;
		try{
			dateFormat.parse(str);
			String []s=str.split("-");
			if(Cal(str)>=0){
				System.out.println("edit s[0]: "+s[0]);
				result=true;   
			}
		}    
		catch (Exception e){    
			// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对    
			result=false;
		}
		return result;
	}
	
	public static long Cal(String str){
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
		//给定的时间
		Date d = null;
		try {
			d = format.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		  
		//当前时间处理
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		  
		  
		//给定时间处理		
		Calendar setCal = Calendar.getInstance();
		setCal.setTime(d);
		setCal.set(Calendar.HOUR_OF_DAY, 0);
		setCal.set(Calendar.MINUTE, 0);
		setCal.set(Calendar.SECOND, 0);
		setCal.set(Calendar.MILLISECOND, 0);
		
		long day =(setCal.getTimeInMillis()-cal.getTimeInMillis())/(1000*60*60*24);
		return day;
	}
	
}
