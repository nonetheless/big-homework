package presentation.marketui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import uidialog.DialogMaker;

/**
 * 
 * @author xinlin
 *Market负责输入信息的ui部分
 */

public class APanel extends JPanel{
	MarketCtrl ctrl;
	JRadioButton sale;
	JRadioButton unsale;
	JRadioButton stack;
	JRadioButton unstack;
	JTextField namef;
	JTextField idf;
	JTextField housef;
	JTextField otherf;
	JTextField salerf;
	int width;
	int height;
	JLabel yl;
	JLabel nl;
	JLabel bPrice;
	JLabel rPrice;
	JLabel discont;
	JLabel gift;
	JLabel paper;
	JLabel pro;
	JButton checkList;
	JButton checkGift;
	JButton checkDiscount;
	JButton send;
	JButton enter;
	JButton isend;
	MarketFrame frame;
	public APanel(MarketCtrl ctrl, String saler,MarketFrame frame) {
		this.frame = frame;
		this.ctrl = ctrl;
		width = 600;
		height = 1000;
		JLabel salei = new JLabel("销售任务");
		JLabel unsalei = new JLabel("销售退货任务");
		JLabel stacki = new JLabel("进货任务");
		JLabel unstacki = new JLabel("退货任务");
		ButtonGroup use = new ButtonGroup();
		sale = new JRadioButton();
		sale.setSelected(true);
		unsale = new JRadioButton();
		stack = new JRadioButton();
		unstack = new JRadioButton();
		use.add(sale);
		use.add(unsale);
		use.add(stack);
		use.add(unstack);
		sale.addActionListener(new Saleu());
		unsale.addActionListener(new Unsaleu());
		stack.addActionListener(new Stacku());
		unstack.addActionListener(new Unstacku());		
		JLabel namel = new JLabel("客户姓名") ;
		JLabel idl = new JLabel("客户id");
		JLabel salerl = new JLabel("销售人员");
		JLabel housel = new JLabel("仓库");
		JLabel otherl = new JLabel("备注");
		namef = new JTextField(ctrl.getName());
		namef.addFocusListener(new Focus(namef));
		idf = new JTextField(ctrl.getId());
		idf.addFocusListener(new Focus(idf));
		housef = new JTextField(ctrl.getHouse());
		housef.addFocusListener(new Focus(housef));
		otherf = new JTextField(ctrl.getOther());
		otherf.addFocusListener(new Focus(otherf));
		salerf = new JTextField(ctrl.getSaler());
		salerf.addFocusListener(new Focus(salerf));
		isend = new JButton("确定");
		isend.addActionListener(new Info());
		JLabel ylist = new JLabel("通过审批的单据：");
		JLabel nlist = new JLabel("未通过审批的单据：");
		JButton fresh = new JButton("刷新");
		JButton che = new JButton("查看");
		fresh.addActionListener(new Fresh());
		che.addActionListener(new CheList());
		int m[] = ctrl.getPass();
		yl = new JLabel(Integer.toString(m[0]));
		nl= new JLabel(Integer.toString(m[1]));
		JLabel bPricel = new JLabel("折扣前商品价格");
		JLabel rPricel = new JLabel("商品总价格");
		JLabel discontl = new JLabel("销售人员折扣");
		JLabel prol = new JLabel("销售策略折扣");
		JLabel giftl = new JLabel("礼品价格");
		JLabel paperl = new JLabel("使用代金券");
	    checkList = new JButton("查看商品列表");
		checkGift = new JButton("查看赠品列表");
		checkDiscount = new JButton("更改销售人员折扣");
		checkList.addActionListener(new List(checkList));
		checkGift.addActionListener(new Gift(checkGift));
		checkDiscount.addActionListener(new Discount(checkDiscount));
		send = new JButton("确认订单");
		enter = new JButton("进入购物车");
		send.addActionListener(new Send(send));
		enter.addActionListener(new Enter(enter));
		priceFirst();
		firstSet();
		/*
		 * 与MPanel里一部分重复耦合
		 */
		JPanel text1 = new JPanel();
	    ArrayList<JComponent> a = new ArrayList<JComponent>();
	    a.add(salei);
	    a.add(new JLabel("    "));
	    a.add(unsalei);
	    a.add(new JLabel("    "));
	    a.add(stacki);
	    a.add(new JLabel("    "));
	    a.add(unstacki);
	    setBox(a,width/20,height/30,width/6,height/4,text1);
	    JPanel redio  =new JPanel();
	    a = new ArrayList<JComponent>();
	    a.add(sale);
	    a.add(unsale);
	    a.add(new JLabel("    "));
	    a.add(stack);
	    a.add(unstack);
	    setBox(a,width/20+width/6,height/30,width/12,height/4,redio);
	    JPanel text2 = new JPanel();
	    a = new ArrayList<JComponent>();
	    a.add(idl);
	    a.add(new JLabel("    "));
	    a.add(namel);
	    a.add(new JLabel("    "));
	    a.add(otherl);
	    a.add(new JLabel("    "));
	    a.add(salerl);
	    a.add(new JLabel("    "));
	    a.add(housel);
	    setBox(a,width/20+width/6+width/12,height/30,width/8,height/4,text2);
	    JPanel fied = new JPanel();
	    a = new ArrayList<JComponent>();
	    a.add(idf);
	    a.add(namef);
	    a.add(otherf);
	    a.add(salerf);
	    a.add(housef);
	    setBox(a,width/20+width/6+width/12+width/8,height/30,width/4,height/13*2,fied);
	    JPanel buttoni = new JPanel();
	    a = new ArrayList<JComponent>();
	    a.add(new JLabel("  "));
	    a.add(new JLabel("  "));
	    a.add(new JLabel("  "));
	    a.add(new JLabel("  "));
	    a.add(new JLabel("  "));
	    a.add(new JLabel("  "));
	    a.add(new JLabel("  "));
	    a.add(new JLabel("  "));
	    a.add(isend);
	    setBox(a,width/20+width/6+width/12+width/8+width/4+width/8,height/35,width/12,height/4,buttoni);
	    JPanel listCheck = new JPanel();
	    a = new ArrayList<JComponent>();
	    a.add(ylist);
	    a.add(new JLabel("  "));
	    a.add(new JLabel("  "));
	    a.add(nlist);
	    a.add(new JLabel("  "));
	    a.add(new JLabel("  "));
	    a.add(new JLabel("  "));
	    a.add(new JLabel("  "));
	    a.add(fresh);
	    setBox(a,width/20+width/6+width/12+width/8+width/2+width/5,height/30,width/4,height/4,listCheck);
	    JPanel listCheck1 = new JPanel();
	    a = new ArrayList<JComponent>();
	    a.add(yl);
	    a.add(new JLabel("  "));
	    a.add(new JLabel("  "));
	    a.add(nl);
	    a.add(new JLabel("  "));
	    a.add(new JLabel("  "));
	    a.add(new JLabel("  "));
	    a.add(new JLabel("  "));
	    a.add(che);
	    setBox(a,width/20+width/6+width/12+width/8+width/4+width/2+width/4,height/30,width/6,height/4,listCheck1);
	    JPanel goodsl = new JPanel();
	    a = new ArrayList<JComponent>();
	    a.add(bPricel);
	    a.add(new JLabel("   "));
	    a.add(giftl);
	    a.add(new JLabel("  "));
	    a.add(paperl);
	    a.add(new JLabel("  "));
	    a.add(discontl);
	    a.add(new JLabel("  "));
	    a.add(prol);
	    a.add(new JLabel("  "));
	    a.add(rPricel);
	    setBox(a,width/20,height/30+height/4,width/6,height/4,goodsl);
	    JPanel goods = new JPanel();
	    a = new ArrayList<JComponent>();
	    a.add(bPrice);
	    a.add(new JLabel("   "));
	    a.add(gift);
	    a.add(new JLabel("  "));
	    a.add(paper);
	    a.add(new JLabel("  "));
	    a.add(discont);
	    a.add(new JLabel("  "));
	    a.add(pro);
	    a.add(new JLabel("  "));
	    a.add(rPrice);
	    setBox(a,width/20+width/3,height/30+height/4,width/6,height/4,goods);
	    JPanel priceButton = new JPanel();
	    a = new ArrayList<JComponent>();
	    a.add(checkList);
	    a.add(new JLabel("   "));
	    a.add(checkGift);
	    a.add(new JLabel("  "));
	    a.add(checkDiscount);
	    setBox(a,width/20+width/3*2,height/30+height/4,width/4,height/4,priceButton);
	    JPanel enterp = new JPanel();
	    a = new ArrayList<JComponent>();
	    a.add(new JLabel("   "));
	    a.add(new JLabel("  "));
	    a.add(new JLabel("   "));
	    a.add(new JLabel("  "));
	    a.add(new JLabel("   "));
	    a.add(new JLabel("  "));
	    a.add(new JLabel("   "));
	    a.add(new JLabel("  "));
	    a.add(new JLabel("   "));
	    a.add(new JLabel("  "));
	    a.add(new JLabel("   "));
	    a.add(new JLabel("  "));
	    a.add(enter);
	    setBox(a,width/20+width/3*2+width/3,height/30+height/4,width/4,height/4,enterp);
	    JPanel sendp = new JPanel();
	    a = new ArrayList<JComponent>();
	    a.add(new JLabel("   "));
	    a.add(new JLabel("  "));
	    a.add(new JLabel("   "));
	    a.add(new JLabel("  "));
	    a.add(new JLabel("   "));
	    a.add(new JLabel("  "));
	    a.add(new JLabel("   "));
	    a.add(new JLabel("  "));
	    a.add(new JLabel("   "));
	    a.add(new JLabel("  "));
	    a.add(new JLabel("   "));
	    a.add(new JLabel("  "));
	    a.add(send);
	    setBox(a,width/20+width/3*2+width/3+width/4,height/30+height/4,width/4,height/4,sendp);
	    /*
	     * 添加组件
	     */
	    this.setLayout(null);
	    this.add(fied);
	    this.add(text2);
	    this.add(redio);
	    this.add(text1);
	    this.add(buttoni);
	    this.add(listCheck1);
	    this.add(listCheck);
	    this.add(goodsl);
	    this.add(goods);
	    this.add(priceButton);
	    this.add(enterp);
	    this.add(sendp);
	    ctrl.addAPanel(this);
	}
	
	class Send implements ActionListener{
		JButton s;

		public Send(JButton w) {
			s =w;
		}

		public void actionPerformed(ActionEvent e) {
			// 确认订单
			String m = "false";
			if(s.isEnabled()){
				m = ctrl.sendToManager();
				s.setEnabled(false);
			}
			DialogMaker.getDialog(m);
			frame.reflash();
		}
		
	}
	
	class Enter implements ActionListener{

		public Enter(JButton enter) {
			// TODO Auto-generated constructor stub
		}

		public void actionPerformed(ActionEvent e) {
			// 进入购物车
			GoodsFrame a = new GoodsFrame(ctrl);
		}
		
	}
	
	class List implements ActionListener{
		JButton m;

		public List(JButton check) {
			m = check;
		}
		
		public void actionPerformed(ActionEvent e) {
			// 查看商品清单
			if(m.isEnabled()){
				String[] aim = {"商品id","商品名","商品类型","商品数量","商品价格","总价格"};
				String[][] all = ctrl.getList();
				DialogMaker.getTable(aim, all);
			}
			
		}
		
	}
	
	class Gift implements ActionListener{

		JButton m;
		public Gift(JButton check) {
			m = check;
		}

		public void actionPerformed(ActionEvent e) {
			// 查看赠品清单
			String[] aim = {"商品id","商品名","商品类型","商品数量","商品价格","总价格"};
			String [][] all = ctrl.getFree(null);
			DialogMaker.getTable(aim, all);
			
		}
		
	}
	
	class Discount implements ActionListener{

		JButton m;
		public Discount(JButton check) {
			m = check;
		}

		public void actionPerformed(ActionEvent e) {
			//更改折扣
			double x = DialogMaker.getChoose("请输入折扣",ctrl.pro1);
			ctrl.pro1 = x;
			rPrice.setText(Double.toString(ctrl.all-ctrl.pro-ctrl.paper-ctrl.pro1));
		    discont.setText(Double.toString(ctrl.pro1));
			DialogMaker.getDialog(ctrl.reRedu(x));
		}
		
	}
	
	class CheList implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// 显示单据
			String list1[] = {"是否通过","单据编号","客户id","客户名","销售额"};
			String list2[][] = ctrl.showPass();
			DialogMaker.getTable(list1, list2);
			yl.setText("0");
			nl.setText("0");
		}
		
	}
	
	class Fresh implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// 推送已经审批的单据
			int[] n = ctrl.getPass();
			yl.setText(Integer.toString(n[0]));
			nl.setText(Integer.toString(n[1]));	
		}
		
	}
	
	class Info implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// 发送信息给bl层
			if(isend.isEnabled()){
			if(namef.getText().equals("")){
				DialogMaker.getDialog("请输入必须信息");
				return;
			}
			if(idf.getText().equals("")){
				DialogMaker.getDialog("请输入必须信息");
				return;
			}
			if(salerf.getText().equals("")){
				DialogMaker.getDialog("请输入必须信息");
				return;
			}
			if(housef.getText().equals("")){
				DialogMaker.getDialog("请输入必须信息");
				return;
			}
			if(namef.getText().equals("输入id错误")){
				DialogMaker.getDialog("输入id错误");
				return;
			}
			ctrl.setName(namef.getText());
			ctrl.setId(idf.getText());
			ctrl.setHouse(housef.getText());
			ctrl.setSaler(salerf.getText());
			ctrl.setOther(otherf.getText());
			int t = 0;
			if(sale.isSelected()){
				t=1;
			}
			if(unsale.isSelected()){
				t=2;
			}
			if(stack.isSelected()){
				t=3;
			}
			if(unstack.isSelected()){
				t=4;
			}
			if(t==0){
				DialogMaker.getDialog("请选择操作类型");
			}
			else{
			String m = ctrl.send(t);
			enter.setEnabled(true);
			isend.setEnabled(false);
			DialogMaker.getDialog(m);
			}
			}
		}
		
	}
	
	class Focus implements FocusListener{
		JTextField a;

		public Focus(JTextField f) {
			a = f;
		}

		public void focusGained(FocusEvent e) {
			// 选择时
			if(a!=namef){
			a.setText("");
			}		
		}

		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
			if(a==idf){
				namef.setText(ctrl.getM(idf.getText()));
			}
		}
		
	}

	private void setBox(ArrayList<JComponent> aim,int x,int y,int w,int h,JPanel p){
		//根据要添加的组件排成一行
		/*
		 * 与MTable的方法重复耦合
		 */
		p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
	    p.setBounds(x,y,w,h);
	    for(int i=0;i<aim.size();i++){
	    	p.add(aim.get(i));
	    }
	}
	
	public class Saleu implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			// 选择一种销售任务
			firstSet();
		}
		
	}
	
	public class Unsaleu implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			// 选择一种销售任务
			firstSet();
		}
		
	}
	
	public class Stacku implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// 选择一种销售任务
			firstSet();
		}
		
	}
	
	public class Unstacku implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// 选择一种销售任务
			firstSet();
		}
		
	}

	public void firstSet() {
		//设定输入的东西
		namef.setText("请输入姓名");
		idf.setText("请输入id");
		housef.setText("请输入仓库");
		salerf.setText(ctrl.getSaler());
		otherf.setText("请输入备注");
		// 将下方按钮设为不可点击
		checkList.setEnabled(false);
		checkGift.setEnabled(false);
		checkDiscount.setEnabled(false);
		send.setEnabled(false);
		enter.setEnabled(false);
		
	}
	
	private void priceFirst(){
		bPrice = new JLabel("0");
		rPrice = new JLabel("0");
		discont = new JLabel("0");
		gift = new JLabel("0");
		paper = new JLabel("0");
		pro = new JLabel("0");
	}

	public void endList() {
		// 完成了购物车部分
		if(sale.isSelected()){
		checkGift.setEnabled(true);
		checkDiscount.setEnabled(true);
		}
		checkList.setEnabled(true);
		enter.setEnabled(false);
		send.setEnabled(true);
		bPrice.setText(Double.toString(ctrl.all));
		rPrice.setText(Double.toString(ctrl.all-ctrl.pro-ctrl.paper-ctrl.pro1));
		paper.setText(Double.toString(ctrl.paper));
		pro.setText(Double.toString(ctrl.pro));
	    discont.setText(Double.toString(ctrl.pro1));
		gift.setText(Double.toString(ctrl.gift));
	}
	
}
