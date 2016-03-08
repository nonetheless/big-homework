package presentation.paymentui;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;





import po.BillPO;
import po.PaycashPO;
import po.PayinPO;
import po.PayoutPO;
import presentation.paymentui.payin_payout_panel.button6listener.button01listener;
import presentation.paymentui.payin_payout_panel.button6listener.button02listener;
import presentation.paymentui.payin_payout_panel.button6listener.button03listener;
import vo.MemberVO;
import vo.accountlineitemVO;
import vo.cashlineitemVO;
import businesslogic.accountbl.accountcontroller;
import businesslogic.memberbl.Member;
import businesslogic.paymentbl.paymentcontroller;
import businesslogicservice.paymentblservice.paymentblservice;

public class pay_cash_panel extends JPanel{
    int is_a_account=0;
	
	JPanel panel=this;
	
	String operator;
	
	
	paymentblservice pv=new paymentcontroller("cash");
	
	
	
	
	JLabel l1=new JLabel("账户名称");
	JLabel l2=new JLabel("条目名称");
	JLabel l3=new JLabel("金额");
	JLabel l4=new JLabel("备注");
	JLabel l5=new JLabel("条目列表");
	
	JTextField f1=new JTextField();
	JTextField f2=new JTextField();
	JTextField f3=new JTextField();
	JTextField f4=new JTextField();
	
	JButton button1,button2,button3,button4,button5,button6;
	
	String [] str={"条目名称","金额","备注"};
	String str1[][] =new String[0][3];
	DefaultTableModel model=new DefaultTableModel(str1,str);
	
	JTable table=new JTable(model);
	JScrollPane js;
	
	public pay_cash_panel(String s){
        panel.setSize(1000, 600);
		
		js=new JScrollPane(table);
		
		operator=s;
		
		
		
		
		button1=new JButton("提交");
		button2=new JButton("退出");
		button3=new JButton("添加");
		button4=new JButton("添加");
		button5=new JButton("删除");
		button6=new JButton("刷新");
		
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(button5);
		panel.add(button6);
		panel.add(f1);panel.add(f2);panel.add(f3);panel.add(f4);
		
		panel.add(l1);panel.add(l2);panel.add(l3);panel.add(l4);panel.add(l5);
		panel.add(js);
		
		panel.setLayout(null);
		
		button1.setBounds(150, 470, 80, 30);button1.setVisible(true);
		button2.setBounds(550, 470, 80, 30);button2.setVisible(true);
		button3.setBounds(200, 150, 80, 30);button3.setVisible(true);
		button4.setBounds(710, 155, 80, 30);button4.setVisible(true);
		button5.setBounds(350, 470, 80, 30);button5.setVisible(true);
		button6.setBounds(750, 470, 80, 30);button6.setVisible(true);
		
		l1.setBounds(210, 50,100, 50);l1.setVisible(true);
		l2.setBounds(520, 110, 100, 50);l2.setVisible(true);
		l3.setBounds(730, 110, 100, 50);l3.setVisible(true);
		l4.setBounds(530, 170, 100, 50);l4.setVisible(true);
		l5.setBounds(630, 40, 100, 50);l5.setVisible(true);
		
		f1.setBounds(140, 100, 200,30);f1.setVisible(true);
		f2.setBounds(450, 85, 200,30);f2.setVisible(true);
		f3.setBounds(660, 85, 200,30);f3.setVisible(true);
		f4.setBounds(450, 155, 200,30);f4.setVisible(true);
		
		
		
		js.setBounds(100, 220, 800, 230);js.setVisible(true);
		
		f3.addKeyListener(new numberlistener());
		
		button1.addActionListener(new button1listener());
		button2.addActionListener(new button2listener());
		button3.addActionListener(new button3listener());
		button4.addActionListener(new button4listener());
		button5.addActionListener(new button5listener());
		button6.addActionListener(new button6listener());
	}
	public class button1listener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			int i=0;
			if(is_a_account==0){
				JOptionPane.showMessageDialog(null, "必须有一个账户");
			}
			else{
				
			    i=pv.submit(operator);
			}
			if(i==1){
				JOptionPane.showMessageDialog(null, "提交成功");
				is_a_account=0;pv=new paymentcontroller("cash");
				f1.setText("");
				panel.remove(js);
				model=new DefaultTableModel(str1,str);
			    table=new JTable(model);
			    js=new JScrollPane(table);
			    panel.add(js);
			    js.setBounds(100, 220, 800, 230);js.setVisible(true);
			}
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
			int keychar=e.getKeyChar();
			if(!(keychar>=e.VK_0&&keychar<=e.VK_9)){
				e.consume();
			}
		}
		
	}
    
    
    public class button3listener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(f1.getText().trim().length()==0){
				JOptionPane.showMessageDialog(null, "请输入账户名");
			}
			else{
				accountcontroller a=new accountcontroller();
				String ss=a.find(f1.getText());
				
				if(ss.equals("不存在;-1.0")){
					JOptionPane.showMessageDialog(null, "账户不存在");
					f1.setText("");
				}
				else{
					pv.addaccount(f1.getText());
					JOptionPane.showMessageDialog(null,"加入账户成功");
					is_a_account=1;
				}
			}
		}
    	
    }
    public class button4listener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			if(f2.getText().trim().length()==0||f3.getText().trim().length()==0){
				JOptionPane.showMessageDialog(null, "条目名或金额不能为空");
			}
			else{
				
					cashlineitemVO v=new cashlineitemVO(f2.getText(),Double.parseDouble(f3.getText()),f4.getText());
					int i=pv.addcashlist(v);
					if(i==1){
						JOptionPane.showMessageDialog(null, "添加成功");
						String [] rowValues = {f2.getText(),f3.getText(),f4.getText()};
		                model.addRow(rowValues);  //添加一行
		                panel.remove(js);
		                table=new JTable(model);
		                js=new JScrollPane(table);
		                panel.add(js);
		                js.setBounds(100, 220, 800, 230);js.setVisible(true);
                        
					}
				
				f2.setText("");f3.setText("");f4.setText("");
			}
		}
    	
    }
    public class button5listener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int selectrow=table.getSelectedRow();
			if(selectrow!=-1){
				String s1=(String)table.getValueAt(selectrow, 0);
				String s2=(String)table.getValueAt(selectrow, 2);
				String s3=(String)table.getValueAt(selectrow, 1);
				double d1=Double.parseDouble(s3);
				accountlineitemVO acvo=new accountlineitemVO(s1,d1,s2);
				pv.delaccountlist(acvo);
				model.removeRow(selectrow);
				panel.remove(js);
                table=new JTable(model);
                js=new JScrollPane(table);
                panel.add(js);
                js.setBounds(100, 220, 800, 230);js.setVisible(true);
			}
		}
    	
    }
    public class button6listener implements ActionListener{

    	
        int screenWidth,screenHeight,frameHeight,frameWidth;
        ArrayList<PayinPO> inp=new ArrayList<PayinPO>();
		ArrayList<PayoutPO> outp=new ArrayList<PayoutPO>();
		ArrayList<PaycashPO> cashp=new ArrayList<PaycashPO>();
		public void actionPerformed(ActionEvent e) {
			JButton button01=new JButton("查看收款单");
	        JButton button02=new JButton("查看付款单");
	        JButton button03=new JButton("查看现金付款单");
	        
	        JFrame frame0=new JFrame("查看") ;
	        JPanel panel0=new JPanel();
			// TODO Auto-generated method stub
			ArrayList<ArrayList<BillPO>> bp=pv.refresh();
			ArrayList<BillPO> bpy=bp.get(0);
			
			for(int i=0;i<bpy.size();i++){
				if(bpy.get(i).getType().equals("SKD")){
					inp.add((PayinPO)bpy.get(i));
				}
				else if(bpy.get(i).getType().equals("FKD")){
					outp.add((PayoutPO)bpy.get(i));
				}
				else if(bpy.get(i).getType().equals("XJFKD")){
					cashp.add((PaycashPO)bpy.get(i));
				}
			}
			Toolkit kit=Toolkit.getDefaultToolkit();
			Dimension screenSize=kit.getScreenSize();
			screenWidth=screenSize.width;
			screenHeight=screenSize.height;
			
			Image bg_icon=kit.getImage("Image//login_icon.jpg");
			frame0.setIconImage(bg_icon);
			frame0.setBounds((screenWidth-500)/2, (screenHeight-300)/4, 500, 300);
			button01.setBounds(100, 50, 300, 50);button01.setVisible(true);
			button02.setBounds(100, 110,300, 50);button02.setVisible(true);
			button03.setBounds(100, 170, 300, 50);button03.setVisible(true);
			
			panel0.setLayout(null);
			panel0.add(button01);
			panel0.add(button02);
			panel0.add(button03);
			button01.addActionListener(new button01listener());
			button02.addActionListener(new button02listener());
			button03.addActionListener(new button03listener());
			frame0.setContentPane(panel0);
			frame0.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			panel0.setVisible(true);
			frame0.setVisible(true);
			
			
		}
		public class button01listener implements ActionListener{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dialogmaker k=new dialogmaker("in",inp,null,null);
			}
			
		}
		public class button02listener implements ActionListener{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dialogmaker k=new dialogmaker("out",null,outp,null);
			}
			
		}
		public class button03listener implements ActionListener{

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dialogmaker k=new dialogmaker("cash",null,null,cashp);
			}
			
		}
    	
    }

}
