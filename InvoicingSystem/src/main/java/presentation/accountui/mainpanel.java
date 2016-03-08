package presentation.accountui;

import java.awt.Color;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import businesslogic.accountbl.accountcontroller;
import businesslogicservice.accountblservice.accountblservice;


public class mainpanel extends JPanel{
	JPanel panel=this; 
	
	accountblservice ab=new accountcontroller();
	
	String s="add";
	
	JRadioButton addbutton=new JRadioButton("增加账户",true);
	JRadioButton delbutton=new JRadioButton("删除账户",false);
	JRadioButton changebutton=new JRadioButton("修改账户",false);
	JRadioButton findbutton=new JRadioButton("查找账户",false);
	ButtonGroup group=new ButtonGroup();
	
	JLabel l1=new JLabel("账户名称");
	JLabel l2=new JLabel("账户余额");
	JLabel l3=new JLabel("修改后账户名称");
	
	JTextField f1=new JTextField();
	JTextField f2=new JTextField();
	JTextField f3=new JTextField();
	
	String [] str={"账户名称","账户余额"};
	String str1[][] =new String[20][2];
	JTable table=new JTable(str1,str);
	
	JButton button1,button2;
	
	
	
	JScrollPane js;
	public mainpanel(){
		panel.setSize(1000, 600);
		
		js=new JScrollPane(table);
		
		group.add(addbutton);
		group.add(changebutton);
		group.add(delbutton);
		group.add(findbutton);
		
		
		button1=new JButton("确认");
		button2=new JButton("退出");
		//panel.setBackground(Color.BLACK);
		
		
		panel.add(button1);
		panel.add(button2);
		panel.add(changebutton);
		panel.add(delbutton);
		panel.add(f1);
		panel.add(f2);
		panel.add(f3);
		panel.add(findbutton);
		panel.add(l1);
		panel.add(l2);
		panel.add(l3);
		panel.add(js);
		panel.add(addbutton);
		panel.setLayout(null);
		
		
		addbutton.setBounds(50, 50, 100, 50);
		delbutton.setBounds(50, 110, 100, 50);
		changebutton.setBounds(150, 50, 100, 50);
		findbutton.setBounds(150, 110, 100, 50);
		//addbutton.setBackground(Color.BLACK);
		//delbutton.setBackground(Color.blue);
		delbutton.setVisible(true);
		addbutton.setVisible(true);
		changebutton.setVisible(true);
		findbutton.setVisible(true);
	    
		button1.setBounds(300, 470, 80,30);
		button2.setBounds(600, 470, 80, 30);
		button1.setVisible(true);
		button2.setVisible(true);
		
		l1.setBounds(300, 50, 100, 50);
		l2.setBounds(620, 50, 100,50);
		l3.setBounds(300, 110, 100, 50);
		f1.setBounds(400, 60, 200, 30);
		f2.setBounds(700,60 , 200, 30);
		f3.setBounds(400, 120, 200, 30);
		l1.setVisible(true);
		l2.setVisible(true);
		f1.setVisible(true);
		f2.setVisible(true);
		f3.setEnabled(false);
		
		
		js.setBounds(100, 200, 800, 230);
		
		addbutton.addItemListener(new addlistener());
		delbutton.addItemListener(new dellistener());
		changebutton.addItemListener(new changelistener());
		findbutton.addItemListener(new findlistener());
		
		f2.addKeyListener(new numberlistener());
		f1.addFocusListener(new f1listener());
		button1.addActionListener(new button1listener());
		button2.addActionListener(new button2listener());
		
	}
	public class addlistener implements ItemListener{
		public void itemStateChanged(ItemEvent e){
			if(e.getStateChange()==ItemEvent.SELECTED){
				s="add";
				f3.setEnabled(false);
				f1.setEnabled(true);
				f2.setEnabled(true);
			}
	}
	}
	public class dellistener implements ItemListener{
		public void itemStateChanged(ItemEvent e){
			if(e.getStateChange()==ItemEvent.SELECTED){
				s="del";
				f1.setEnabled(true);
				f2.setEnabled(false);
				f3.setEnabled(false);
			}
		}
	}
	public class changelistener implements ItemListener{
		public void itemStateChanged(ItemEvent e){
			if(e.getStateChange()==ItemEvent.SELECTED){
				s="change";
				f1.setEnabled(true);
				f2.setEnabled(false);
				f3.setEnabled(true);
			}
		}
	}
	public class findlistener implements ItemListener{
		public void itemStateChanged(ItemEvent e){
			if(e.getStateChange()==ItemEvent.SELECTED){
				s="find";
				f1.setEnabled(true);
				f2.setEnabled(false);
				f3.setEnabled(false);
			}
		}
	}
	public class button1listener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(s.equals("add")){
				if(f1.getText().trim().length()==0||f2.getText().trim().length()==0){
					JOptionPane.showMessageDialog(null,"名称或余额为空");
				}
				else {
				    int i=ab.add(f1.getText(),Double.parseDouble(f2.getText()) );
				    
				    if(i==0){
				    	JOptionPane.showMessageDialog(null, "账户已存在");
					
				    }
				    else if(i==1){
				    	JOptionPane.showMessageDialog(null, "账户添加成功");
					
				    }
				}
			}
			else if(s.equals("del")){
				if(f1.getText().trim().length()==0){
					
						JOptionPane.showMessageDialog(null,"账户名称为空");
					
				}
				else{
					int i=ab.del(f1.getText());
				
				    if(i==0){
				    	JOptionPane.showMessageDialog(null,"账户不存在");
					
				    }
				    else if(i==1){
				    	JOptionPane.showMessageDialog(null,"账户删除成功");
				 	
				    }
				}
			}
			else if(s.equals("change")){
				if(f1.getText().trim().length()==0||f3.getText().trim().length()==0){
					JOptionPane.showMessageDialog(null,"请确保两个名称不为空");
				}
				else {
					int i=ab.change(f1.getText(), f3.getText());
					if(i==0){
						JOptionPane.showMessageDialog(null,"账户不存在");
					}
					else if(i==1){
						JOptionPane.showMessageDialog(null,"账户名称修改成功");
					}
				}
				
			}
			else if(s.equals("find")){
				if(f1.getText().trim().length()==0){
					
					JOptionPane.showMessageDialog(null,"账户名称为空");
				
			    }
				else{
					String t=ab.find(f1.getText());
					
					String[] result=t.split(";") ;
					if(!(result[0].equals("不存在"))){
						
						String [][] st=new String[20][2];
						st[0][0]=result[0];st[0][1]=result[1];
						panel.remove(js);
						table=new JTable(st,str);
						js=new JScrollPane(table);
						panel.add(js);
						js.setBounds(100, 200, 800, 230);
						js.setVisible(true);
					}
					else{
						panel.remove(js);
						table=new JTable(str1,str);
						js=new JScrollPane(table);
						panel.add(js);
						js.setBounds(100, 200, 800, 230);
						js.setVisible(true);
					}
				}
			}
			f1.setText("");f2.setText("");f3.setText("");
		}
		
	}
	public class button2listener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.exit(0);
		}
		
	}
	public class numberlistener implements KeyListener{

		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}	
			

		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			int k=e.getKeyChar();
			if(!(k>=e.VK_0&&k<=e.VK_9)){
				e.consume();
			}
		}
		

		
		
	}
	public class f1listener implements FocusListener{

	

		public void focusGained(FocusEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void focusLost(FocusEvent arg0) {
			// TODO Auto-generated method stub
            if(s.equals("del")||s.equals("change")){
				String t=ab.find(f1.getText());
				
				String[] result=t.split(";") ;
				if(!(result[0].equals("不存在"))){
					
					String [][] st=new String[20][2];
					st[0][0]=result[0];st[0][1]=result[1];
					panel.remove(js);
					table=new JTable(st,str);
					js=new JScrollPane(table);
					panel.add(js);
					js.setBounds(100, 200, 800, 230);
					js.setVisible(true);
				}
				
			}
		}
		
	}

}
