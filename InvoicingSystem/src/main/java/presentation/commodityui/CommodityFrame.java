package presentation.commodityui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import presentation.kindui.KindUI;
import presentation.loginui.LoginUI;
import businesslogic.commoditybl.CommodityController;
import businesslogic.commoditybl.SearchType;
import businesslogicservice.commodityblservice.CommodityBlService;
import uiTable.TableFactory;
import uiField.IntField;
import vo.CommodityVo;
import vo.Ex_StockVo;
import vo.StockBillsVo;

/*CommodityFrame是库存管理的主界面，也是功能最多的界面
 * 
 */

public class CommodityFrame {

   private JFrame frame;	
   private JPanel searchPanel;
   private JTable table;
   private JComboBox<String> searchCombo;
   private JTextField searchField;
   private JButton searchButton;
   private JScrollPane tablePane;
   private JPanel ensureButtonPanel;
   private JButton ensureButton;
   private DefaultTableModel tableModel;
   private String state=null;
   private JPanel exStock_Panel;
   private JTextField beginYear;
   private JTextField beginMonth;
   private JTextField beginDay;
   private JTextField endYear;
   private JTextField endMonth;
   private JTextField endDay;

   private int width=1400;
   private int height=800;
	  
    public CommodityFrame() {
		frame=new JFrame();
		
		Toolkit tool=Toolkit.getDefaultToolkit();
		Dimension dm=tool.getScreenSize();
		width=(dm.width*4)/5;
		height=(dm.height*4)/5;
		
		frame.setBounds(dm.width/2-width/2,dm.height/2-height/2 , width, height);//使屏幕居中
	    
        frame.setLayout(null);
		Container contentPane=frame.getContentPane();
		
	    JMenuBar menuBar=new JMenuBar();
		menuBar.setBounds(0, 0, width, height/15);
	
		JMenu menu01=new JMenu("商品操作");
	    JMenuItem addItem=new JMenuItem("增加商品");
	    addItem.addActionListener(new AddButtonListener());
	    JMenuItem delItem=new JMenuItem("删除商品");
	    delItem.addActionListener(new DelItemListener());
	    JMenuItem changeItem=new JMenuItem("修改商品信息");
	    changeItem.addActionListener(new ChangeItemListener());
	    JMenuItem findItem=new JMenuItem("查找商品");
	    findItem.addActionListener(new SearchItemListener());
	    
	    menu01.add(addItem);
	    menu01.add(delItem);
	    menu01.add(changeItem);
	    menu01.add(findItem);
	    
	    JMenu menu02=new JMenu("库存操作");
	    JMenuItem stock_ex_item=new JMenuItem("库存查看");
	    stock_ex_item.addActionListener(new StockExListener());
	    JMenuItem stock_check_item=new JMenuItem("库存盘点");
	    stock_check_item.addActionListener(new StockCheckListener());
	    JMenuItem stock_bill_item=new JMenuItem("库存单据提交");
	    stock_bill_item.addActionListener(new BillListener());
	    
	    
	    JMenuItem excelItem=new JMenuItem("库存快照导出excel文件");
	    excelItem.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				CommodityBlService bl=new CommodityController();
				tableModel=TableFactory.getComdTable();
				table=new JTable(tableModel);
				int result=bl.exportAsXls(table);
				if(result==1)
				JOptionPane.showMessageDialog(frame, "导出excel成功");
				}
	      });
	    
	    menu02.add(stock_ex_item);
	    menu02.add(stock_check_item);
	    menu02.add(stock_bill_item);
	    menu02.add(excelItem);
	    
	    JMenu menu03=new JMenu("系统操作");
	    JMenuItem backItem=new JMenuItem("返回登录界面");
	    backItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
					frame.dispose();
			    	new LoginUI();
			}
	     });
	    
	    JMenuItem toKind=new JMenuItem("进行分类管理");
	    toKind.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new KindUI();
			}
	    });
	    
	    JMenuItem initItem=new JMenuItem("清空数据库");
	    initItem.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent arg0){
			   
            	int result=JOptionPane.showConfirmDialog(frame, "该操作将清空所有库存数据，您确定要这样做么？");
			    if(result==0)
			    {
				CommodityBlService bl=new CommodityController();
				bl.initAllData();
				}
			}
	    });
	    
	    menu03.add(backItem);
	    menu03.add(toKind);
	    menu03.add(initItem);
	    
	    menuBar.add(menu01);
		menuBar.add(menu02);
		menuBar.add(menu03);
		
        int search_Y=30;
		
		int search_Wid=100;
		int search_Het=35;
		
		searchPanel=new JPanel();
		searchPanel.setLayout(null);
		searchPanel.setBounds(0, height/15, width, 2*search_Het+20);
		
		String [] option={"商品名称","商品类别名称","商品编号"};
		searchCombo=new JComboBox<String>(option);
	   	searchCombo.setBounds(240, search_Y, search_Wid, search_Het);
	   	
	   	searchField=new JTextField();
	   	searchField.setBounds(380, search_Y, 2*search_Wid, search_Het);
	   	
	   	searchButton=new JButton("确认");
	   	searchButton.addActionListener(new SearchEnsureButtonListener());
	   	searchButton.setBounds(600,search_Y,search_Wid,search_Het);
	   	
	   	
	    searchPanel.add(searchCombo);
	    searchPanel.add(searchField);
		searchPanel.add(searchButton);
		searchPanel.setVisible(false);
		
		tablePane=new JScrollPane();
	    tablePane.setBounds(0,140,width,height*2/3);
		tablePane.setVisible(false);
		
		JLabel beginLabel=new JLabel("起始时间:");
		JLabel endLabel=new JLabel("截至时间:");
		JLabel year1=new JLabel("年");
		year1.setHorizontalAlignment(SwingConstants.CENTER);
		beginYear=new IntField();
		JLabel month1=new JLabel("月");
		month1.setHorizontalAlignment(SwingConstants.CENTER);
		beginMonth=new IntField();
		JLabel day1=new JLabel("日");
		day1.setHorizontalAlignment(SwingConstants.CENTER);
		beginDay=new IntField();
		JLabel year2=new JLabel("年");
		year2.setHorizontalAlignment(SwingConstants.CENTER);
		endYear=new IntField();
		JLabel month2=new JLabel("月");
		month2.setHorizontalAlignment(SwingConstants.CENTER);
		endMonth=new IntField();
		JLabel day2=new JLabel("日");
		day2.setHorizontalAlignment(SwingConstants.CENTER);
		endDay=new IntField();
		
		
		exStock_Panel=new JPanel();
		exStock_Panel.setLayout(new GridLayout(2,7));
		exStock_Panel.add(beginLabel);
		exStock_Panel.add(year1);
		exStock_Panel.add(beginYear);
		exStock_Panel.add(month1);
		exStock_Panel.add(beginMonth);
		exStock_Panel.add(day1);
		exStock_Panel.add(beginDay);
		
		exStock_Panel.add(endLabel);
		exStock_Panel.add(year2);
		exStock_Panel.add(endYear);
		exStock_Panel.add(month2);
		exStock_Panel.add(endMonth);
		exStock_Panel.add(day2);
		exStock_Panel.add(endDay);
		
		exStock_Panel.setBounds(20, 140, 800, 120);
		exStock_Panel.setVisible(false);
		
		ensureButton=new JButton("确认");
		ensureButton.setPreferredSize(new Dimension(100,40));
		ensureButton.addActionListener(new EnsureButtonListener());
		
	    ensureButtonPanel=new JPanel();
		ensureButtonPanel.setLayout(new FlowLayout());
		ensureButtonPanel.add(ensureButton);
		ensureButtonPanel.setBounds(0, height*9/10, width, height/10);
		ensureButtonPanel.setVisible(false);
		
		contentPane.add(menuBar);
		contentPane.add(searchPanel);
	    contentPane.add(tablePane);
	    contentPane.add(exStock_Panel);
	    contentPane.add(ensureButtonPanel);
	 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setResizable(false);
		frame.setVisible(true);
		checkAlarm();
	 
}

    private void checkAlarm(){
		CommodityBlService cbl=new CommodityController();
		ArrayList<StockBillsVo> alarmList=cbl.checkAlarm();
		
		if(alarmList!=null){
			JTable table=new JTable(TableFactory.getAlarmBillTable(alarmList));
			new AlarmFrame(table);
		}
	}
	
    private double makeValidTime(String year,String month,String day){
	       boolean b1=year.equals("");
	       boolean b2=month.equals("");
	       boolean b3=day.equals("");
	       
	       if(b1||b2||b3)
	    	 return -1;
	       
	       int yyear=Integer.parseInt(year);
	       b1=(yyear>=2000)&&(yyear<=2050);
	       int mmonth=Integer.parseInt(month);
	       b2=(mmonth>=1)&&(mmonth<=12);
	       int dday=Integer.parseInt(day);
	       b3=(dday>=1)&&(dday<=31);
	       
	       if(!(b1&&b2&&b3))
	    	   return -1;
	       String str1=null;
	       String str2=null;
	       if(mmonth<10)
	    	  str1="0"+mmonth;
	       else
	    	  str1=String.valueOf(mmonth);
	       if(dday<10)
	    	str2="0"+dday;
	       else
	    	str2=String.valueOf(dday);
	       
	       String tempResult=String.valueOf(yyear)+String.valueOf(str1)+String.valueOf(str2);
	      
	      return Integer.parseInt(tempResult);
	  }
   
    private void showTablePane(boolean edible){
		
		tableModel=TableFactory.getComdTable();
		tableModel.fireTableDataChanged();
	    table=new JTable(tableModel);
	    table.setEnabled(edible);
	    tablePane=new JScrollPane(table);
	    
	    tablePane.setBounds(0,140,width,height*19/40);
	    frame.getContentPane().add(tablePane);
	  
       tablePane.setVisible(true);
	}
   
    private void closePanel(){
		searchPanel.setVisible(false);
		tablePane.setVisible(false);
		exStock_Panel.setVisible(false);
		ensureButtonPanel.setVisible(false);
		
	}
	
    class EnsureButtonListener implements ActionListener,TableInfo{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			if(state.equals("Del")){
			int row=table.getSelectedRow();
				
			if(row>=0){
			int confirm=JOptionPane.showConfirmDialog(frame, "您确定要删除该商品项目么？");	
			if(confirm==0){
			CommodityBlService cbl=new CommodityController();
			String comdName=(String)table.getValueAt(row, 3);
			cbl.delCommodity(comdName);
			tableModel.removeRow(row);
		    
			}
			}
			else{
				JOptionPane.showMessageDialog(frame, "请选择要删除的项目");
				}
			
			}
			else if(state.equals("stock_Ex")){
				String year1=beginYear.getText();
				String month1=beginMonth.getText();
				String day1=beginDay.getText();
				
				String year2=endYear.getText();
				String month2=endMonth.getText();
				String day2=endDay.getText();
				
				double beginTime=makeValidTime(year1,month1,day1);
				double endTime=makeValidTime(year2,month2,day2);
			
				if((beginTime>0&&endTime>0)&&(beginTime<endTime)){
					CommodityBlService comdBl=new CommodityController();
					Ex_StockVo exVo=comdBl.examineStock(beginTime, endTime);
					JOptionPane.showMessageDialog(frame, exVo.toString());
				}
				else{
					JOptionPane.showMessageDialog(frame, "您输入的时间不合理");
				}
			}
			else if(state.equals("bill"))
			{
				 int row=table.getSelectedRow();
				   
				 if(row>=0)
				 {
					String temp=JOptionPane.showInputDialog(frame,"请输入实际数量"); 
					boolean valid=false;
					int factNum=0;
					
					if((temp!=null)&&(!temp.equals("")))
					{
					   try
					   {
				          factNum=Integer.parseInt(temp);
				          valid=true;
					   }
					   catch(Exception e1){
						JOptionPane.showMessageDialog(frame, "请输入正整数");
					   }
					
					   if(valid)
					   {
				          CommodityBlService cbl=new CommodityController();
				          int result=cbl.subStockBills(row, factNum);
				          
				          if(result==-1)
				            JOptionPane.showMessageDialog(frame, "库存数量与实际数量相同，单据无效");
				          else
				          {
				            JOptionPane.showMessageDialog(frame, "单据提交成功");
				            table.setValueAt(new Integer(factNum), row, 5);
				          }
					    }
				      }
				    }
				 else
					 JOptionPane.showMessageDialog(frame,"请选择要报单的商品项目");
		     }
			
			
			else if(state.equals("change"))
			{
				
				int row=table.getSelectedRow();
				
				CommodityBlService cbl=new CommodityController();
			    CommodityVo temp=cbl.getOneCommodity(row);
				ChangeFrame frame=new ChangeFrame(temp,row,this);
				
			}
	}
		public void set_TableInfo(int row,CommodityVo vo){
			table.setValueAt(vo.get_nameOfCommodity(), row, 3);
			table.setValueAt(vo.get_modelNum(), row, 4);
			table.setValueAt(new Integer(vo.get_numOfStock()), row, 5);
			table.setValueAt(new Double(vo.get_avg_price()), row, 6);
			table.setValueAt(new Double(vo.get_inprice()), row, 7);
			table.setValueAt(new Double(vo.get_outPrice()), row, 8);
			table.setValueAt(new Double(vo.get_latestInPrice()), row, 9);
			table.setValueAt(new Double(vo.get_latestOutPrice()), row, 10);
			table.setValueAt(vo.get_batch(), row, 11);
			table.setValueAt(vo.get_batch_Num(), row, 12);
			table.setValueAt(vo.get_ex_date(), row, 13);
			table.setValueAt(vo.get_storeHouse(), row, 14);
			table.setValueAt(new Integer(vo.get_alarmNum()), row, 15);
		}
	}
		
	class SearchEnsureButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e){
			// TODO Auto-generated method stub
			closePanel();
			searchPanel.setVisible(true);
			if((state!=null)&&(state.equals("Del")))
			ensureButtonPanel.setVisible(true);
			
		    if((state!=null)&&(state.equals("change")))
		    ensureButtonPanel.setVisible(true);
			
			String type=(String)searchCombo.getSelectedItem();
			String info=searchField.getText();
			
			CommodityBlService cmdBl=new CommodityController();
			ArrayList<CommodityVo> resultList=null;
			
			if(info.equals(""))
			   showTablePane(true);
		
		    else
			{
			  if(type.equals("商品名称"))
				resultList=cmdBl.search(SearchType.ComdName, info);
			    
				else if(type.equals("商品类别名称"))
				resultList=cmdBl.search(SearchType.ComdKindName, info);
			    
				else if(type.equals("商品编号"))
				resultList=cmdBl.search(SearchType.ComdKindNum, info);
			
			    if(resultList.size()!=0)
			    {
			      
			      tableModel=TableFactory.getComdTable(resultList);
		          table=new JTable(tableModel);
		          tablePane=new JScrollPane(table);
		    
		          if(state.equals("search"))
		          
		          table.setEnabled(false);
		          tablePane.setBounds(0,140,width,380);
		          frame.getContentPane().add(tablePane);
		          tablePane.repaint();
			      tablePane.setVisible(true);
			     }
			else
				JOptionPane.showMessageDialog(frame, "抱歉，没有匹配的项目");
		   }
	    }
	}
	
	class AddButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			state="Add";
			closePanel();
			tablePane.setVisible(false);
			AddFrame addFrame=new AddFrame();
	    }
	}
	
	class DelItemListener implements ActionListener{
        public void actionPerformed(ActionEvent arg0) {
        	closePanel();
        	state="Del";
            ensureButtonPanel.setVisible(true);
            searchPanel.setVisible(true);
            
            tableModel=TableFactory.getComdTable();
            table=new JTable(tableModel);
    	    table.setEnabled(true);
    	    tablePane=new JScrollPane(table);
    	    tablePane.setBounds(0,140,width,height*19/40);
    	    frame.getContentPane().add(tablePane);
			tablePane.setVisible(true);
			}
    }
	
	class StockCheckListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			state="stockCheck";
			closePanel();
		    ensureButtonPanel.setVisible(false);
			showTablePane(false);
         }
    }
	
	class StockExListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
        	closePanel();
        	ensureButtonPanel.setVisible(true);
        	exStock_Panel.setVisible(true);
        	state="stock_Ex";
       	}
		}
	
	class BillListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
	        closePanel();
	        ensureButtonPanel.setVisible(true);
	        showTablePane(true);
	        JOptionPane.showMessageDialog(frame, "请在表格中选择要报单的商品项目");
	        state="bill";
	       		
		}
		
	}
		
	class SearchItemListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			closePanel();
			state="search";
			searchPanel.setVisible(true);
			tablePane.setVisible(true);
			
		}
		
	}
	
	class ChangeItemListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			closePanel();
		    ensureButtonPanel.setVisible(true);
			searchPanel.setVisible(true);
	        showTablePane(true);
	        state="change";
	        JOptionPane.showMessageDialog(frame, "请在表格中选择要修改的商品项目");
			}
	}
}
