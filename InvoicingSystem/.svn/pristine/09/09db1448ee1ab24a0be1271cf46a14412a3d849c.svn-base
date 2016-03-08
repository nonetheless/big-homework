package uidialog;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

import uiField.DoubleField;

public class DialogMaker{
	static JDialog new_dialog;
	static int clicked = 0;
	static int Dialog_WIDTH = 300;
	static int Dialog_HEIGHT = 200;
	static int Dialog_WIDTH1 = 500;
	static int Dialog_HEIGHT1 = 400;

	public static void getDialog(String a){
		clicked = 0;
		JOptionPane dialogPane = new JOptionPane(null);
		dialogPane.setLayout(null);
		JLabel b = new JLabel();
		b.setText(a);
		b.setBounds(Dialog_WIDTH/5,Dialog_HEIGHT/3,Dialog_WIDTH/5*3,Dialog_HEIGHT/3*2);
		b.setVisible(true);
		JPanel r = new JPanel();
		r.setBounds(0, 0,Dialog_WIDTH,Dialog_HEIGHT);
		r.add(b);
		dialogPane.add(r);
		new_dialog =dialogPane.createDialog(null);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screen = kit.getScreenSize();
		new_dialog.setBounds(screen.width/2-Dialog_WIDTH/2, screen.height/2-Dialog_HEIGHT/2, Dialog_WIDTH, Dialog_HEIGHT);
		new_dialog.setVisible(true);
		Object selectedValue = dialogPane.getValue();
	    if(selectedValue == null){
	    	clicked=1;
	    }
	}
	
	public static void getTable(String []a,String[][] list){
		clicked = 0;
		JOptionPane dialogPane = new JOptionPane(null);
		dialogPane.setLayout(null);
		JPanel r = new JPanel();
		r.setBounds(0, 0,Dialog_WIDTH1,Dialog_HEIGHT1);
		JTable table = new JTable(list,a);
		JScrollPane scroller = new JScrollPane(table);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		/*
		 * 添加组件
		 */
		r.add(scroller);
		dialogPane.add(r);
		new_dialog =dialogPane.createDialog(null);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screen = kit.getScreenSize();
		new_dialog.setBounds(screen.width/2-Dialog_WIDTH1/2, screen.height/2-Dialog_HEIGHT1/2, Dialog_WIDTH1, Dialog_HEIGHT1);
		new_dialog.setVisible(true);
		Object selectedValue = dialogPane.getValue();
	    if(selectedValue == null){
	    	clicked=1;
	    }
	}
	
	public static double getChoose(String a,double c){
		clicked = 0;
		JOptionPane dialogPane = new JOptionPane(null);
		dialogPane.setLayout(null);
		JLabel b = new JLabel();
		b.setText(a);
		b.setBounds(Dialog_WIDTH/5,Dialog_HEIGHT/3,Dialog_WIDTH/5*3,Dialog_HEIGHT/4);
		b.setVisible(true);
		DoubleField m = new DoubleField();
		m.setText(Double.toString(c));
		m.setBounds(Dialog_WIDTH/5,Dialog_HEIGHT/4*2,Dialog_WIDTH/5*3,Dialog_HEIGHT/4);
		JButton re = new JButton("确认");
		re.setBounds(Dialog_WIDTH/5,Dialog_HEIGHT/4*3,Dialog_WIDTH/5*3,Dialog_HEIGHT/4);
		re.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new_dialog.dispose();
			}
			
		});
		JPanel r = new JPanel();
		r.setBounds(0, 0,Dialog_WIDTH,Dialog_HEIGHT);
		r.add(b);
		r.add(m);
		r.add(re);
		dialogPane.add(r);
		new_dialog =dialogPane.createDialog(null);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screen = kit.getScreenSize();
		new_dialog.setBounds(screen.width/2-Dialog_WIDTH/2, screen.height/2-Dialog_HEIGHT/2, Dialog_WIDTH, Dialog_HEIGHT);
		new_dialog.setVisible(true);
		Object selectedValue = dialogPane.getValue();
	    if(selectedValue == null){
	    	clicked=0;
	    }
	    if(m.getText().equals("")){
	    	return 0;
	    }
	    else{
	    	return Double.parseDouble(m.getText());
	    }
	}


}
