package presentation.commodityui;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddCommodityPanel extends JPanel {

	private JTextField kindField;
	private JTextField kindNumField;
	private JTextField nameField;
	private JTextField modelField;
	private JTextField numField;
	private JTextField avgPriceField;
	private JTextField inPriceField;
	private JTextField outPriceField;
	private JTextField latestInPriceField;
	private JTextField latestOutPriceField;
	private Component batchField;
	private JTextField batchNumField;
	private JTextField ex_dateField;
	private JTextField storeHouseField;
	private Component alarmField;

	private int width;
	private int height;
	
	public AddCommodityPanel(){
		/*Container container=getContPane();
		width=1000;
		height=600;*/
		//System.out.println(width);
		//System.out.println(height);
		setLayout(null);
		//setLayout(new GridLayout(5,6,10,10));
		ArrayList<Component> list=new ArrayList<Component>();
		
		JLabel label01=new JLabel("商品类别");
		label01.setBounds(0, 0, 50, 50);
		label01.setBounds(0, 0, width/6, height/10);
		list.add(label01);
		kindField=new JTextField("");
		kindField.setBounds(width/6, 0, width/6, height/10);
		list.add(kindField);
		
		JLabel label02=new JLabel("商品编号");//商品编号是自己动生成，不可编辑
		list.add(label02);
		kindNumField=new JTextField("");
		list.add(kindNumField);
		
		
		JLabel label03=new JLabel("商品名称");
		list.add(label03);
		nameField=new JTextField("");
		list.add(nameField);
	
		JLabel label04=new JLabel("商品型号");
		list.add(label04);
		modelField=new JTextField("");
		list.add(modelField);
		
		JLabel label05=new JLabel("库存数量");
		list.add(label05);
		numField = new JTextField("");
		list.add(numField);
		
		JLabel label06=new JLabel("平均进价");
		list.add(label06);
		avgPriceField = new JTextField("");
		list.add(avgPriceField);
		
		JLabel label07=new JLabel("进价");
		list.add(label07);
		inPriceField = new JTextField("");
		list.add(inPriceField);
		
		JLabel label08=new JLabel("售价");
		list.add(label08);
		outPriceField = new JTextField("");
		list.add(outPriceField);
		
		JLabel label09=new JLabel("最近进价");
		list.add(label09);
		latestInPriceField = new JTextField("");
		list.add(latestInPriceField);
		
		JLabel label10=new JLabel("最近售价");
		list.add(label10);
		latestOutPriceField = new JTextField("");
		list.add(latestOutPriceField);
		
		JLabel label11=new JLabel("批次");
		list.add(label11);
		batchField = new JTextField("");
		list.add(batchField);
		
		JLabel label12=new JLabel("批号");
		list.add(label12);
		
		batchNumField = new JTextField("");
		//batchNumField.setSize(100, 80);
		list.add(batchNumField);
		
		JLabel label13=new JLabel("出厂日期");
		list.add(label13);
		ex_dateField = new JTextField("");
		list.add(ex_dateField);
		
		JLabel label14=new JLabel("仓库");
		list.add(label14);
		storeHouseField = new JTextField("");
		list.add(storeHouseField);
		
		JLabel label15=new JLabel("报警数量");
		list.add(label15);
		alarmField = new JTextField("");
		list.add(alarmField);
		
	    for(int i=0;i<list.size();i++){
	  	    	add(list.get(i));
	     }
		
		
		
	     setVisible(true);
		
		
	}

	
	
	
}
