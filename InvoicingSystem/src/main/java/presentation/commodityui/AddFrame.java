package presentation.commodityui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;






import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import uiField.*;






import businesslogic.commoditybl.CommodityController;
import businesslogicservice.commodityblservice.CommodityBlService;
import vo.CommodityVo;


public class AddFrame {

JFrame frame;
JPanel panel;
int width;
int height;
 JTextField kindField;
 JTextField kindNumField;
 JTextField nameField;
JTextField modelField;
 JTextField numField;
 JTextField avgPriceField;
 JTextField inPriceField;
JTextField outPriceField;
 JTextField latestInPriceField;
 JTextField latestOutPriceField;
 JTextField batchField;
 JTextField batchNumField;
 JTextField ex_dateField;
 JTextField storeHouseField;
 JTextField alarmField;
JButton enSureButton;
JButton backButton;
	
int labelWidth=100;
int labelHeight=50;
int fieldWidth=100;
int fieldHeight=30;

CommodityBlService comdBl=new CommodityController();

public AddFrame(){
	frame=new JFrame();
	
	width=1000;
	height=600;
	Toolkit tool=Toolkit.getDefaultToolkit();
	Dimension dm=tool.getScreenSize();
   
	frame.setBounds(dm.width/2-width/2,dm.height/2-height/2 , width, height/2);//使frame居中显示
    frame.setTitle("新增商品");
    
    Container contentPane=frame.getContentPane();
    
    
	panel=new JPanel();
	panel.setBounds(30, 0, 1000, 300);
	panel.setLayout(new GridLayout(5,6));
	
	
	
    
	JLabel kindLabel=new JLabel("商品类别");
    kindField=new JTextField();
    kindField.setEditable(false);
    kindField.addMouseListener(new fieldActionListener(this));
    
    
    JLabel kindNumLabel=new JLabel("商品编号");
    kindNumField=new JTextField();
    kindNumField.setEditable(false);
    
    JLabel nameLabel=new JLabel("商品名称");
    nameField=new StringField();
    //nameField.addMouseListener(new FieldListener(nameField));
    
    JLabel modelLabel=new JLabel("商品型号");
	modelField=new StringField();
	//modelField.addMouseListener(new FieldListener(modelField));
	
	JLabel numLabel=new JLabel("库存数量");
	numField = new IntField();
	//numField.addMouseListener(new FieldListener(numField));
	
	JLabel avgLabel=new JLabel("平均进价");
	avgPriceField = new DoubleField();
	//avgPriceField.addMouseListener(new FieldListener(avgPriceField));
	
	JLabel inPriceLabel=new JLabel("进价");
	inPriceField = new DoubleField();
	//inPriceField.addMouseListener(new FieldListener(inPriceField));
	
	JLabel outPriceLabel=new JLabel("售价");
	outPriceField = new DoubleField();
	//outPriceField.addMouseListener(new FieldListener(outPriceField));
	
	JLabel latestInLabel=new JLabel("最近进价");
	latestInPriceField = new DoubleField();
	//latestInPriceField.addMouseListener(new FieldListener(latestInPriceField));
	
	JLabel latestOutLabel=new JLabel("最近售价");
	latestOutPriceField = new DoubleField();
	//latestOutPriceField.addMouseListener(new FieldListener(latestOutPriceField));
	
	JLabel batchLabel=new JLabel("批次");
	batchField = new StringField();
	//batchField.addMouseListener(new FieldListener(batchField));
	
	JLabel batchNumLabel=new JLabel("批号");
    batchNumField = new StringField();
	//batchNumField.addMouseListener(new FieldListener(batchNumField));
	
	JLabel dateLabel=new JLabel("出厂日期");
	ex_dateField = new StringField();
	//ex_dateField.addMouseListener(new FieldListener(ex_dateField));
	
	JLabel storeHouseLabel=new JLabel("仓库");
	storeHouseField =new StringField();
	//storeHouseField.addMouseListener(new FieldListener(storeHouseField));
	
	JLabel alarmLabel=new JLabel("报警数量");
	alarmField = new IntField();
	//alarmField.addMouseListener(new FieldListener(alarmField));
	
	
	panel.add(kindLabel);
    panel.add(kindField);
    
    panel.add(kindNumLabel);
	panel.add(kindNumField);
	
	panel.add(nameLabel);
	panel.add(nameField);
	
	panel.add(modelLabel);
	panel.add(modelField);
	
	panel.add(numLabel);
	panel.add(numField);
	
	panel.add(avgLabel);
	panel.add(avgPriceField);
	
	panel.add(inPriceLabel);
	panel.add(inPriceField);
	
	panel.add(outPriceLabel);
	panel.add(outPriceField);
	
	panel.add(latestInLabel);
	panel.add(latestInPriceField);
	
	panel.add(latestOutLabel);
	panel.add(latestOutPriceField);
	
	panel.add(batchLabel);
	panel.add(batchField);
	
	panel.add(batchNumLabel);
	panel.add(batchNumField);
	
	panel.add(dateLabel);
	panel.add(ex_dateField);
	
	panel.add(storeHouseLabel);
	panel.add(storeHouseField);
	
	panel.add(alarmLabel);
	panel.add(alarmField);
	
	
	JPanel buttonPanel=new JPanel();
	
	enSureButton=new JButton("确认");
	enSureButton.addActionListener(new ensureListener());
	
	backButton=new JButton("返回主菜单");
	backButton.addActionListener(new BackListener());
	
	buttonPanel.add(enSureButton);
	buttonPanel.add(backButton);
	
	
	
	contentPane.add(panel,BorderLayout.CENTER);
	contentPane.add(buttonPanel,BorderLayout.SOUTH);
	frame.setResizable(false);
	frame.setSize(800,300);
	frame.setVisible(true);
	//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//frame.pack();
	frame.repaint();
	
}
 void set_KindText(String kindName){
	kindField.setText(kindName);
}
void set_KindNum(String num){
	kindNumField.setText(num);
}


class ensureListener implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		CommodityVo comdVo=makeVo();
		int result=-1;
		if(comdVo!=null){
		result=comdBl.addCommodity(comdVo);
		if(result==1)
		JOptionPane.showMessageDialog(null, "添加成功");
		else{
		JOptionPane.showMessageDialog(null, "该商品已经存在了！");
		}
		}
		else{
		JOptionPane.showMessageDialog(null, "信息不足！！！！");	
		}
	}

}


class fieldActionListener extends MouseAdapter{
     AddFrame frame;
	public fieldActionListener(AddFrame frame){
		this.frame=frame;
	}
	
public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("到这了");
	    new KindChooseFrame(frame);
		System.out.println("到这了");
	}
}



class BackListener implements ActionListener{
   public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	   frame.dispose();	
	}
	}
public CommodityVo makeVo(){
	String kindName=kindField.getText();
	boolean b1=kindName.equals("");
	
	String kindNum=kindNumField.getText();
	boolean b2=kindNum.equals("");
	
	String  comdName=nameField.getText();
	boolean b3=comdName.equals("");
	
	boolean b4=numField.getText().equals("");
	int numOfStock=-1;
	if(!b4)
	numOfStock=Integer.parseInt(numField.getText());
	
    boolean b5=avgPriceField.getText().equals("");
    double avgPrice=-1;
    if(!b5)
    avgPrice=Double.valueOf(avgPriceField.getText());
    
    boolean b6=inPriceField.getText().equals("");
    double inPrice=-1;
    if(!b6)
    inPrice=Double.valueOf(inPriceField.getText());
    
    boolean b7=latestInPriceField.getText().equals("");
    double latestInPrice=-1;
    if(!b7)
    latestInPrice=Double.valueOf(latestInPriceField.getText());
    
    boolean b8=latestOutPriceField.getText().equals("");
    double latestOutPrice=-1;
    if(!b8)
    latestOutPrice=Double.valueOf(latestOutPriceField.getText());
    
    
    String batch=batchField.getText();
    boolean b9=batch.equals("");
    
    String batchNum=batchNumField.getText();
    boolean b10=batchNum.equals("");
    
    String ex_date=ex_dateField.getText();
    boolean b11=ex_date.equals("");
    
    String storeHouse=storeHouseField.getText();
    boolean b12=storeHouse.equals("");
    
    String alarm=alarmField.getText();
    boolean b13=alarm.equals("");
    int alarmNum=-1;
    if(!b13)
    alarmNum=Integer.parseInt(alarm);
    
    String modelNum=modelField.getText();
    boolean b14=modelNum.equals("");
    
    String outPriceS=outPriceField.getText();
    boolean b15=outPriceS.equals("");
    double outPrice=-1;
    if(!b15)
    outPrice=Double.valueOf(outPriceS);
    
    if((b1||b2||b3||b4||b5||b6||b7||b8||b9||b10||b11||b12||b13||b14||b15)){
    System.out.println("你大爷的，信息不足");
    return null;
    }
    else
    return new CommodityVo(kindName,kindNum,comdName,modelNum,numOfStock,avgPrice,inPrice
    		,outPrice,latestInPrice,latestOutPrice,batch,batchNum,ex_date,storeHouse,alarmNum);
    
    
	
}



}
