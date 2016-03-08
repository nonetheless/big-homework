package presentation.memberui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import uidialog.DialogMaker;

public class MPanel extends JPanel {
	int width;
	int height;
	JPanel panel = this;
	JRadioButton add;
	JRadioButton del;
	JRadioButton find;
	JRadioButton upd;
	JTextField namef;
	JTextField idf;
	JComboBox kindf;
	JTextField telf;
	JTextField adf;
	JTextField salerf;
	JTextField ybf;
	JComboBox levelf;
	JTextField emf;
	MemberFrameCtrl ctrl;
	JScrollPane scroller;
	JTable table;
	String[] str = {"id","名字","类型","等级","邮箱","地址","电话","邮编","默认销售员","应付款","应收款","信用额度"};
	public MPanel(MemberFrameCtrl ctrl) {
		//新建一个客户管理panel
		this.ctrl = ctrl;
		height = 600;
		width = 1000;
		ButtonGroup user = new ButtonGroup();
		add = new JRadioButton();
		add.addActionListener(new Add());
		del= new JRadioButton();
		del.addActionListener(new Del());
	    find= new JRadioButton();
	    find.addActionListener(new Find());
	    upd = new JRadioButton();
	    upd.addActionListener(new Upd());
	    user.add(add);
	    user.add(del);
	    user.add(find);
	    user.add(upd);
	    JLabel ade = new JLabel("新增客户");
	    JLabel de = new JLabel("删除客户");
	    JLabel fi = new JLabel("查找客户");
	    JLabel up = new JLabel("更新客户");
	    JLabel name = new JLabel("客户名称");
	    JLabel id = new JLabel("客户id");
	    JLabel tel = new JLabel("客户电话");
	    JLabel adress = new JLabel("客户地址");
	    JLabel kind = new JLabel("客户类型");
	    JLabel yb = new JLabel("客户邮编");
	    JLabel level = new JLabel("客户等级");
	    JLabel saler = new JLabel("销售人员");
	    JLabel em = new JLabel("电子邮箱");
	    //添加button
	    JButton button = new JButton("确定");
	    button.addActionListener(new Send());
	    button.setVisible(true);
	    firstDo();
	    //操作panel了
	    /*
		 * 与MPanel里一部分重复耦合
		 */
	    JPanel text1 = new JPanel();
	    ArrayList<JComponent> a = new ArrayList<JComponent>();
	    a.add(ade);
	    a.add(new JLabel("    "));
	    a.add(de);
	    a.add(new JLabel("    "));
	    a.add(up);
	    a.add(new JLabel("    "));
	    a.add(fi);
	    setBox(a,width/20,height/30,width/6,height/4,text1);
	    JPanel redio  =new JPanel();
	    a = new ArrayList<JComponent>();
	    a.add(add);
	    a.add(del);
	    a.add(new JLabel("    "));
	    a.add(upd);
	    a.add(find);
	    setBox(a,width/20+width/6,height/30,width/12,height/4,redio);
	    JPanel text2 = new JPanel();
	    a = new ArrayList<JComponent>();
	    a.add(id);
	    a.add(new JLabel("    "));
	    a.add(tel);
	    a.add(new JLabel("    "));
	    a.add(level);
	    a.add(new JLabel("    "));
	    a.add(adress);
	    a.add(new JLabel("    "));
	    a.add(em);
	    setBox(a,width/20+width/6+width/12,height/30,width/12,height/4,text2);
	    JPanel fied = new JPanel();
	    a = new ArrayList<JComponent>();
	    a.add(idf);
	    a.add(telf);
	    a.add(levelf);
	    a.add(adf);
	    a.add(emf);
	    setBox(a,width/20+width/6+width/12+width/12,height/30,width/4,height/4,fied);
	    JPanel text3 = new JPanel();
	    a = new ArrayList<JComponent>();
	    a.add(name);
	    a.add(new JLabel("    "));
	    a.add(yb);
	    a.add(new JLabel("    "));
	    a.add(kind);
	    a.add(new JLabel("    "));
	    a.add(saler);
	    a.add(new JLabel("    "));
	    setBox(a,width/20+width/6+width/12+width/12+width/4,height/30,width/12,height/4,text3);
	    JPanel fied2 = new JPanel();
	    a = new ArrayList<JComponent>();
	    a.add(namef);
	    a.add(ybf);
	    a.add(kindf);
	    a.add(salerf);
	    a.add(button);
	    setBox(a,width/20+width/6+width/12+width/12+width/4+width/12,height/30,width/4,height/4,fied2);
	    this.setLayout(null);
	    this.add(text1);
	    this.add(text2);
	    this.add(text3);
	    this.add(redio);
	    this.add(fied);
	    this.add(fied2);
	    //添加表格
	    setTable1();
	}
	
	private void setTable1() {
		// 更新表格
		String [][] aim = null;
		aim = ctrl.getTable();
		if(scroller!=null){
			this.remove(scroller);
		}
		table = new JTable(aim,str);
		scroller = new JScrollPane(table);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		this.add(scroller);
		scroller.setBounds(width/20, height/30+height/4, width/8*7, height/15*8);
	}

	private void setBox(ArrayList<JComponent> aim,int x,int y,int w,int h,JPanel p){
		//根据要添加的组件排成一行
		/*
		 * 与ATable的方法重复耦合
		 */
		p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
	    p.setBounds(x,y,w,h);
	    for(int i=0;i<aim.size();i++){
	    	p.add(aim.get(i));
	    }
	}
	
	private void firstDo() {
		//初始化textfield
		    namef = new JTextField(ctrl.getName());
		    namef.addFocusListener(new Check(namef));
		    idf = new JTextField(ctrl.getId());
		    idf.addFocusListener(new Check(idf));
		    String t1[] = {"进货商","销售商"}; 
		    String t2[] = {"1","2","3","4","5"}; 
		    kindf = new JComboBox(t1);
		    kindf.addItemListener(new Change(kindf));
		    kindf.setEditable(false);
		    levelf = new JComboBox(t2);
		    levelf.addItemListener(new Change(levelf));
		    levelf.setEditable(false);
		    telf = new JTextField(ctrl.getTel());
		    telf.addFocusListener(new Check(telf));
		    telf.addKeyListener(new IntListener());
		    ybf = new JTextField(ctrl.getYB());
		    ybf.addFocusListener(new Check(ybf));
		    ybf.addKeyListener(new IntListener());
		    adf = new JTextField(ctrl.getAd());
		    adf.addFocusListener(new Check(adf));
		    salerf = new JTextField(ctrl.getSaler());
		    salerf.addFocusListener(new Check(salerf));
		    emf = new JTextField(ctrl.getE());
		    emf.addFocusListener(new Check(emf));
		
	}
	
	class Change implements ItemListener{

		JComboBox m;
		public Change(JComboBox m){
			this.m = m;
		}
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			if(e.getStateChange()==ItemEvent.SELECTED){
				String a = (String) m.getSelectedItem();
				if(m==kindf){
					ctrl.setKind(a);
				}
				if(m==levelf){
					ctrl.setLevel(a);
				}
			}
		}
		
	}

	class Add implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			//选择增加,将所有设为可选
			namef.setText("请输入姓名");
			idf.setText("请输入id");
			adf.setText("请输入地址");
			ybf.setText("请输入邮编");
			telf.setText("请输入电话");
			emf.setText("请输入email");
			setOk(namef);
			setNo(idf);
			setOk1(kindf);
			setOk1(levelf);
			setOk(adf);
			setOk(ybf);
			setOk(telf);
			setOk(salerf);
			setOk(emf);
		}
		
	}
	
	private void setOk(JTextField namef) {
		// 设为可选
		namef.setEnabled(true);
		
	}
	
	public void setOk1(JComboBox kindf2) {
		// 设为可选
		kindf2.setEnabled(true);
	}

	class Del implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			//选择删除
			namef.setText("可自动获得客户姓名只需填入id然后确定");

			idf.setText("请输入id");
			adf.setText("");
			ybf.setText("");
			telf.setText("");
			emf.setText("");
			setOk(namef);
			setOk(idf);
			setNo1(kindf);
			setNo1(levelf);
			setNo(adf);
			setNo(ybf);
			setNo(telf);
			setNo(salerf);
			setNo(emf);
		}
		
	}

	
	class Find implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			//选择查找
			namef.setText("可不填,可根据id自动填姓名");
			idf.setText("请输入id");
			adf.setText("");
			ybf.setText("");
			telf.setText("");
			emf.setText("");
			setOk(namef);
			setOk(idf);
			setNo1(kindf);
			setNo1(levelf);
			setNo(adf);
			setNo(ybf);
			setNo(telf);
			setNo(salerf);
			setNo(emf);
		}
		
	}
	
	class Upd implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			//选择更新
			namef.setText("请输入姓名");
			idf.setText("请输入id");
			adf.setText("请输入地址");
			ybf.setText("请输入邮编");
			telf.setText("请输入电话");
			emf.setText("请输入email");
			setNo(namef);
			setOk(idf);
			setOk1(kindf);
			setOk1(levelf);
			setOk(adf);
			setOk(ybf);
			setOk(telf);
			setOk(salerf);
			setOk(emf);
		}
	}
	
	class Check implements FocusListener{
		JTextField i;
		public Check(JTextField i){
			this.i = i;
		}

		public void focusGained(FocusEvent e) {
			//当点击时更新
			if(!((i==namef)&&(del.isSelected()||(find.isSelected())))){
				i.setText("");
			}
		}

		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
			if(i==idf){
				String m = ctrl.find(idf.getText());
				namef.setText(m);
			}
			if(i==telf){
				String i = telf.getText();
				try{
					long m = Long.parseLong(i);
				}
				catch(Exception e1){
					telf.setText("请输入数字");
				}
			}
		}
	}
	
	class Send implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// 发送单据
			if(add.isSelected()){
				ctrl.setName(namef.getText());
				ctrl.setYB(ybf.getText());
				ctrl.setAd(adf.getText());
				ctrl.setTel(telf.getText());
				ctrl.setSaler(salerf.getText());
				ctrl.setE(emf.getText());
				DialogMaker.getDialog(ctrl.addM());
			}
			if(upd.isSelected()){
				ctrl.setId(idf.getText());
				ctrl.setName(namef.getText());
				ctrl.setYB(ybf.getText());
				ctrl.setAd(adf.getText());
				ctrl.setTel(telf.getText());
				ctrl.setSaler(salerf.getText());
				ctrl.setE(emf.getText());
				DialogMaker.getDialog(ctrl.updM());
			}
			if(del.isSelected()){
				ctrl.setName(namef.getText());
				ctrl.setId(idf.getText());
				DialogMaker.getDialog(ctrl.delM());
			}
			if(find.isSelected()){
				ctrl.setName(namef.getText());
				ctrl.setId(idf.getText());
				ctrl.findM();
				setTable1();
				DialogMaker.getDialog(ctrl.findM());
			}
			
		}
		
	}

	public void setNo(JTextField kindf2) {
		// 不可修改
		kindf2.setEnabled(false);
		
	}

	public void setNo1(JComboBox kindf2) {
		// TODO Auto-generated method stub
		kindf2.setEnabled(false);
	}


}
