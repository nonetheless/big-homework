package presentation.commodityui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JTree;

import presentation.kindui.KindUI;
/*添加新商品时，选择分类所用的界面
 * 继承了KindUI，只是按钮不一样
 */


public class KindChooseFrame extends KindUI {
	
	private JPanel buttonPanel;
	private JButton sureButton;
    private String currentKind;
    private AddFrame frame;//添加商品的frame，由构造方法作为参数传入，以便于分类信息的传回
	private JFrame fatherFrame;
	private JTree tree=super.tree;
	
	public KindChooseFrame(AddFrame frame){
	    super();
	    
	    this.frame=frame;
	    fatherFrame=super.frame;

	    JPanel opPanel=super.opPanel;
	    opPanel.setVisible(false);
	    
	    buttonPanel=new JPanel();
	    
	    sureButton=new JButton("确认分类");
	    sureButton.addActionListener(new EnsureListener());
	
	    buttonPanel.add(sureButton);
	
	    fatherFrame.add(buttonPanel,BorderLayout.SOUTH);
	    fatherFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	    fatherFrame.setVisible(true);
	    fatherFrame.repaint();
	
  }
	

	class EnsureListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
		    DefaultMutableTreeNode selectedNode=(DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
		       if(selectedNode!=null)
		         {
		          currentKind=(String)selectedNode.getUserObject();
		          frame.set_KindText(currentKind);
		          match_Po(currentKind);
		          
		          
		          if(matchedPo.isallowChild())
		          {
		            String kindNum=matchedPo.get_Num()+"-"+String.valueOf(matchedPo.get_NumBase()+1);
		            frame.set_KindNum(kindNum);
		            fatherFrame.dispose();
		          }
		          else
		    	    JOptionPane.showMessageDialog(fatherFrame, "该节点是商品，其下不能再加商品！");
		    	 }
		       else
		          JOptionPane.showMessageDialog(fatherFrame, "请为你的商品选择类别节点");
		   }
	}
	
	private void match_Po(String name){
		super.get_KindPo(name, rootPo);
	}
}
