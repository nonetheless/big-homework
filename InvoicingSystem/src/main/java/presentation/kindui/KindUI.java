package presentation.kindui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTree;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import javax.swing.tree.TreePath;

import po.KindPo;
import presentation.commodityui.CommodityFrame;

import businesslogic.kindbl.KindController;

import businesslogicservice.kindblservice.KindblService;

public class KindUI  {
    //KindblService kind=new KindController();
	protected KindPo matchedPo=null;
	protected KindblService kbs=new KindController();

	protected JTree tree=null;
	protected KindPo rootPo=null;
	protected JButton addButton;
	protected JButton delButton;
	protected JButton changeButton;
	protected JPanel opPanel;
	protected JFrame frame;

	private DefaultTreeModel treeModel=null;
	
	private int width=800;
	private int height=800;
	private int rowHeight=30;//树的行高
	public  KindUI(){
		
		frame=new JFrame("商品分类管理");
		//super("商品分类管理");
		frame.setSize(width,height);
		rootPo=kbs.get_root();

		DefaultMutableTreeNode  root=new DefaultMutableTreeNode("灯具类别");
		this.show_SubTree(rootPo, root);
		
	    treeModel=new DefaultTreeModel(root);
		
		Container container=frame.getContentPane();
		
		tree=new JTree(treeModel);
		tree.setRowHeight(rowHeight);
		tree.setEditable(false);
		tree.setExpandsSelectedPaths(true);
		tree.updateUI();

		tree.setBounds(0, 0, width, height*3/4);
		
		JPanel treePanel=new JPanel();
		treePanel.setLayout(null);
		treePanel.add(tree);
        container.add(treePanel,BorderLayout.CENTER);
        
        addButton=new JButton("增加分类");
        addButton.addActionListener(new AddButtonListener());

	
        delButton=new JButton("删除分类");
        delButton.addActionListener(new DelButtonListener());
        
        changeButton=new JButton("修改分类");
        changeButton.addActionListener(new ChangeButtonLisener());
        
        JButton toComd=new JButton("进行库存商品管理");
       // toComd.setSize(200,110);
        toComd.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new CommodityFrame();
	 	   }
      });
        
        
        JButton initButton=new JButton("清空数据");
        initButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				int result=JOptionPane.showConfirmDialog(frame, "该操作将清空所有库存数据，您确定要这样做么？");
				if(result==0){
			   KindblService kindBl=new KindController();
			   kindBl.init();
				}
	 	   }
      });
        
        opPanel=new JPanel();
        opPanel.add(addButton);
        opPanel.add(delButton);
        opPanel.add(changeButton);
        opPanel.add(toComd);
        opPanel.add(initButton);
        
        container.add(opPanel,BorderLayout.SOUTH);
    
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
	
	protected void get_KindPo(String name,KindPo po){
		if(po!=null)
		{
	       if(po.get_Name().equals(name))
		       matchedPo=po;
	       else if(po.is_father())
	       {
		       for(int i=0;i<po.get_NumOfChild();i++)
		          {
			   get_KindPo(name,po.getChilds().get(i));
		          }
	       }
		}
	}
	
	
	
	/*
	 * show_SubTree递归展示树的核心方法
	 */
	private void show_SubTree(KindPo po,DefaultMutableTreeNode father_node){
	    DefaultMutableTreeNode childNode=null;
		if(po!=null)
		{
		
		  if(po.isallowChild())
		  {
			  childNode=new DefaultMutableTreeNode(po.get_Name());
		  }
		  else
		  {
			  childNode=new DefaultMutableTreeNode(po.get_Name());
		  }
		  
		  boolean allowChild=po.isallowChild();
		  childNode.setAllowsChildren(allowChild);
		  father_node.add(childNode);
        }
    	if(po.is_father()){
			
			for(int i=0;i<po.get_NumOfChild();i++){
				show_SubTree(po.getChilds().get(i),childNode);
			}
		}
		
	}
	
	
	
	class AddButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) 
		{
		
			String message="请输入新分类的名称";
			String nullMessage="请选择父类节点";
			int messageType=JOptionPane.QUESTION_MESSAGE;
			String newKindName=null;
			
			DefaultMutableTreeNode parentNode=null;
			TreePath parentPath=tree.getSelectionPath();
			
			
			if(parentPath==null)
			JOptionPane.showMessageDialog(frame, nullMessage);
			else
			{
		      parentNode=(DefaultMutableTreeNode)(parentPath.getLastPathComponent());
			  String parentName=(String)parentNode.getUserObject();
			  get_KindPo(parentName,rootPo);
			
			if(matchedPo.isallowChild())
			{
			  newKindName=JOptionPane.showInputDialog(frame, message, null, messageType);
			  
			  if(newKindName!=null&&(!newKindName.equals("")))
			  {
			     DefaultMutableTreeNode newNode=new DefaultMutableTreeNode(newKindName);
			     newNode.setAllowsChildren(true);
			
                 treeModel.insertNodeInto(newNode, parentNode, parentNode.getChildCount());
			     tree.scrollPathToVisible(new TreePath(newNode.getPath()));
			
			     KindPo newKind=new KindPo(newKindName,matchedPo,null);
			     kbs.addKind(newKind);
			     rootPo=kbs.get_root();
			
			  }
			else
				JOptionPane.showMessageDialog(frame, message);	
			}
			else
			JOptionPane.showMessageDialog(frame, "不能在商品节点下增加分类");
			}
	    }
}
		
class DelButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			TreePath treePath=tree.getSelectionPath();
			
			if(treePath!=null)
			  {
				DefaultMutableTreeNode selectionNode=(DefaultMutableTreeNode)treePath.getLastPathComponent();
				int confirm=0;
				boolean isLeaf=selectionNode.isLeaf();
				if(!isLeaf)
			       confirm=JOptionPane.showConfirmDialog(frame, "该节点不是叶节点，你确定要删除其下所有子类么？");	
				
				
			if(confirm==0)
				{
				DefaultMutableTreeNode parent=null;
				  
				try{
				     parent=(DefaultMutableTreeNode)selectionNode.getParent();
				     treeModel.removeNodeFromParent(selectionNode);
				}catch(IllegalArgumentException e){
					JOptionPane.showMessageDialog(frame, "不能删除根节点");
					}
				catch(NullPointerException e){
					JOptionPane.showMessageDialog(frame, "不能删除根节点");
				}
				
				if(parent!=null)
				{
				  String oldName=(String)selectionNode.getUserObject();
				  get_KindPo(oldName,rootPo);
				  kbs.delKind(matchedPo);
				  
				  if(isLeaf)
				    kbs.delCommodityByName(oldName);
				  else
				    kbs.delCommodityByKindName(oldName);
				
				  JOptionPane.showMessageDialog(frame, "删除成功");
				  rootPo=kbs.get_root();
				}
				}
			}
			
		   else
		     JOptionPane.showMessageDialog(null,"请选择要删除的节点");
	}
}
		
	class ChangeButtonLisener implements ActionListener{
         public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			TreePath treePath=tree.getSelectionPath();
			String newName=null;
			if(treePath==null)
			JOptionPane.showMessageDialog(frame, "请选择要修改的节点");
			else{
			DefaultMutableTreeNode selectionNode=(DefaultMutableTreeNode)treePath.getLastPathComponent();
			String oldName=(String)selectionNode.getUserObject();
			get_KindPo(oldName,rootPo);
			if(matchedPo.isallowChild())
			{
			
		     newName=JOptionPane.showInputDialog(frame,"请输入新的分类名称", null,JOptionPane.QUESTION_MESSAGE);
		    if((newName!=null)&&(!newName.equals("")))
		    {
		    newName=newName.trim();
		    if(newName.length()!=0)
		    {
		      
		       kbs.changeKind(matchedPo,newName);
		       selectionNode.setUserObject(newName);
			   JOptionPane.showMessageDialog(frame, "修改成功");
			   rootPo=kbs.get_root();
			   frame.repaint();
		    }
		    }
		    else 
		    	JOptionPane.showMessageDialog(frame, "非法输入，修改失败");
		    }
		    else
		    	JOptionPane.showMessageDialog(frame, "不能修改商品名称");
		    
			}
			}
		
	}
}




