package presentation.promotionui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import uiField.DoubleField;
import uiField.IntField;
import vo.CommodityVo;
import businesslogic.promotionbl.GetCommodity;

public class DialogForChoice {
	
	GetCommodity gc=new GetCommodity();
	
	JTable cTable;
	JScrollPane cStockPanel;
	
	String [][]cdata;
	
	ArrayList<CommodityVo> list;
	String res="no";
	
	String get_res="no";
	
	JTextField txt1;
	JTextField txt2;
	
	IntField int_txt1;
	IntField int_txt2;
	
	DoubleField double_txt1;
	
	JDialog chooseDialog;
	
	JDialog getDialog;

	private JTextField txt3;
	
	public String chooseCommodity(String dialogName){
		
		cdata=new String[100][4];
		list=gc.getCommodity();
		for(int i=0;i<list.size();i++){
			cdata[i][0]=list.get(i).get_modelNum();   //id
			cdata[i][1]=list.get(i).get_nameOfCommodity();   //name
			cdata[i][2]=list.get(i).get_kindName();   //kind
			cdata[i][3]=String.valueOf(list.get(i).get_outPrice());   //price
		}
		
		String []ctitle={"商品编号","商品名","商品种类","商品售价"};
		
		cTable=new JTable(cdata,ctitle);
		cTable.setRowHeight(25);
		cTable.repaint();
		cStockPanel = new JScrollPane(cTable);
		cStockPanel.setViewportView(cTable);
		cStockPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		cStockPanel.setBounds(50,25,500,300);
		cStockPanel.repaint();
		
		JButton enter=new JButton("确认选择");
		enter.setBounds(100, 340, 150, 50);
		enter.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int s=cTable.getSelectedRow();
				if(s>=0){
					CommodityVo vo=list.get(s);
					String temp=twoGet("请输入详细信息","数量","赠送日期","","");
					if(!temp.equals("no")){
						String[] nd=temp.split(" ");
						res=vo.get_modelNum()+" "+vo.get_nameOfCommodity()+" "+vo.get_kindName()
								+" "+vo.get_outPrice()+" "+nd[0]+" "+nd[1];
						chooseDialog.dispose();		
					}
				}
				else{
					JOptionPane.showMessageDialog(null,"请选中您需要添加的商品");
				}
				
			}
			
		});
		
		JButton quit=new JButton("取消");
		quit.setBounds(350, 340, 150, 50);
		quit.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				res="no";
				chooseDialog.dispose();
			}
			
		});
		
		JOptionPane dialogPanel = new JOptionPane();
		dialogPanel.setLayout(null);
		dialogPanel.add(cStockPanel);
		dialogPanel.add(enter);
		dialogPanel.add(quit);
		dialogPanel.setPreferredSize(new Dimension(600,400));
		
		chooseDialog = dialogPanel.createDialog(dialogPanel,dialogName);
		chooseDialog.setVisible(true);
		
		return res;
	}
	
	public String chooseCommodityforTotal(String dialogName){
		
		cdata=new String[100][4];
		list=gc.getCommodity();
		for(int i=0;i<list.size();i++){
			cdata[i][0]=list.get(i).get_modelNum();   //id
			cdata[i][1]=list.get(i).get_nameOfCommodity();   //name
			cdata[i][2]=list.get(i).get_kindName();   //kind
			cdata[i][3]=String.valueOf(list.get(i).get_outPrice());   //price
		}
		
		String []ctitle={"商品编号","商品名","商品种类","商品售价"};
		
		cTable=new JTable(cdata,ctitle);
		cTable.setRowHeight(25);
		cTable.repaint();
		cStockPanel = new JScrollPane(cTable);
		cStockPanel.setViewportView(cTable);
		cStockPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		cStockPanel.setBounds(50,25,500,300);
		cStockPanel.repaint();
		
		JButton enter=new JButton("确认选择");
		enter.setBounds(100, 340, 150, 50);
		enter.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int s=cTable.getSelectedRow();
				if(s>=0){
					CommodityVo vo=list.get(s);
					String temp=oneGet("请输入详细信息","int","数量","");
					if(!temp.equals("no")){
						res=vo.get_modelNum()+" "+vo.get_nameOfCommodity()+" "+vo.get_kindName()
								+" "+vo.get_outPrice()+" "+temp;
						chooseDialog.dispose();		
					}
				}
				else{
					JOptionPane.showMessageDialog(null,"请选中您需要添加的商品");
				}
				
			}
			
		});
		
		JButton quit=new JButton("取消");
		quit.setBounds(350, 340, 150, 50);
		quit.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				res="no";
				chooseDialog.dispose();
			}
			
		});
		
		JOptionPane dialogPanel = new JOptionPane();
		dialogPanel.setLayout(null);
		dialogPanel.add(cStockPanel);
		dialogPanel.add(enter);
		dialogPanel.add(quit);
		dialogPanel.setPreferredSize(new Dimension(600,400));
		
		chooseDialog = dialogPanel.createDialog(dialogPanel,dialogName);
		chooseDialog.setVisible(true);
		
		return res;
	}
	
	public String oneGet(String dialogName,String type,String l1,String t1){
		JLabel line1=new JLabel(l1);
		line1.setBounds(150, 50, 150, 50);
		
		if(type.equals("str")){
			txt1=new JTextField(t1);
			txt1.setBounds(350, 50, 100, 50);
		}
		else if(type.equals("int")){
			int_txt1=new IntField(t1);
			int_txt1.setBounds(350, 50, 100, 50);
		}
		else if(type.equals("double")){
			double_txt1=new DoubleField(t1);
			double_txt1.setBounds(350, 50, 100, 50);
		}
		
		JButton enter=new JButton("确认");
		enter.setBounds(100, 150, 150, 50);
		enter.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(txt1!=null){
					if(txt1.getText().equals("")){
						JOptionPane.showMessageDialog(null, "输入不能为空");
					}
					else{
					get_res=txt1.getText();}
				}
				else if(int_txt1!=null){
					if(int_txt1.getText().equals("")){
						JOptionPane.showMessageDialog(null, "输入不能为空");
					}
					else{
					get_res=int_txt1.getText();}
				}
				else if(double_txt1!=null){
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
		if(type.equals("str")){
			dialogPanel.add(txt1);
		}
		else if(type.equals("int")){
			dialogPanel.add(int_txt1);
		}
		else if(type.equals("double")){
			dialogPanel.add(double_txt1);
		}
		
		dialogPanel.add(enter);
		dialogPanel.add(quit);
		
		dialogPanel.setPreferredSize(new Dimension(600,250));
		getDialog = dialogPanel.createDialog(dialogPanel,dialogName);
		getDialog.setVisible(true);
		
		return get_res;
	}
	
	public String twoGet(String dialogName,String l1,String l2,String t1,String t2){
		JLabel line1=new JLabel(l1);
		line1.setBounds(150, 30, 150, 50);
		
		int_txt1=new IntField(t1);
		int_txt1.setBounds(350, 30, 100, 50);
		
		JLabel line2=new JLabel(l2);
		line2.setBounds(150, 120, 150, 50);
		
		txt2=new JTextField(t2);
		txt2.setBounds(350, 120, 100, 50);
		
		JButton enter=new JButton("确认");
		enter.setBounds(100, 210, 150, 50);
		enter.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String str=txt2.getText();
				if(int_txt1.getText().equals("")||txt2.getText().equals("")){
					JOptionPane.showMessageDialog(null, "输入不能为空");
				}
				else if(checkDate(str)){
					get_res=int_txt1.getText()+" "+txt2.getText();
					getDialog.dispose(); 
				}
				else{
					JOptionPane.showMessageDialog(null, "日期格式错误，请按照yyyy-MM-dd的格式输入日期");
				}
			}
			
		});
		
		JButton quit=new JButton("取消");
		quit.setBounds(350, 210, 150, 50);
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
		dialogPanel.add(int_txt1);
		
		dialogPanel.add(line2);
		dialogPanel.add(txt2);
		
		dialogPanel.add(enter);
		dialogPanel.add(quit);
		
		dialogPanel.setPreferredSize(new Dimension(600,300));
		getDialog = dialogPanel.createDialog(dialogPanel,dialogName);
		getDialog.setVisible(true);
		
		return get_res;
	}
	
	public String threeGet(String dialogName,String l1,String l2,String l3,
			String t1,String t2,String t3){
		
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
		
		JButton enter=new JButton("确认");
		enter.setBounds(100, 250, 150, 50);
		enter.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String str=txt3.getText();
				if(int_txt1.getText().equals("")||int_txt2.getText().equals("")||txt3.getText().equals("")){
					JOptionPane.showMessageDialog(null, "输入不能为空");
				}
				else if(checkDate(str)){
					res=int_txt1.getText()+" "+int_txt2.getText()+" "+txt3.getText();
					getDialog.dispose();
				}
				else{
					JOptionPane.showMessageDialog(null, "日期格式错误，请按照yyyy-MM-dd的格式输入日期");
				}
			}
			
		});
		
		JButton quit=new JButton("取消");
		quit.setBounds(350, 250, 150, 50);
		quit.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				res="no";
				getDialog.dispose();
			}
			
		});
		
		JOptionPane dialogPanel = new JOptionPane();
		dialogPanel.setLayout(null);
		
		dialogPanel.add(line1);
		dialogPanel.add(line2);
		dialogPanel.add(line3);
		
		dialogPanel.add(int_txt1);
		dialogPanel.add(int_txt2);
		dialogPanel.add(txt3);
		
		dialogPanel.add(enter);
		dialogPanel.add(quit);
		
		dialogPanel.setPreferredSize(new Dimension(600,350));
		getDialog = dialogPanel.createDialog(dialogPanel,dialogName);
		getDialog.setVisible(true);
		
		return res;
	}
	
	public boolean checkDate(String str){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		// 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
		dateFormat.setLenient(false);
		boolean result=false;
		try{
			dateFormat.parse(str);
			if(Cal(str)>=0){
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
