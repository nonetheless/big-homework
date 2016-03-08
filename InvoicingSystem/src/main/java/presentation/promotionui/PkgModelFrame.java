package presentation.promotionui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import po.PkgItemVO;
import businesslogic.promotionbl.PkgPromotionController;
import vo.PkgVO;

public class PkgModelFrame extends PromotionUI{
	
	PkgPromotionController ppc;
	
	String id;
	
	JTable table;
	JScrollPane stockPanel;
	String [][]tabledata;
	
	JLabel idLabel;
	JLabel priceLabel;
	JLabel prePriceLabel;
	
	JTextField priceTxt;
	JTextField prePriceTxt;
	
	JButton addGoods;
	JButton delGoods;
	JButton editGoods;
	JButton editPrice;
	
	double prePrice;
	double postPrice;
	
	public PkgModelFrame(String UserName, int view, String id) {
		super(UserName, view);
		// TODO Auto-generated constructor stub
		this.id=id;   //特价包编号
		
		ppc=new PkgPromotionController();
		
		backButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new PromotionFrame(user,3);
				dispose();
			}
			
		});
		
		vipButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new PromotionFrame(user,1);
				dispose();
			}
			
		});
		
		totalButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new PromotionFrame(user,2);
				dispose();
			}
			
		});
		
		pkgButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new PromotionFrame(user,3);
				dispose();
			}
			
		});
		
		giftButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new PromotionFrame(user,4);
				dispose();
			}
			
		});
		
		idLabel=new JLabel("特价包id: "+id);
		idLabel.setBounds(50, 10, 250, 50);
		InfoPanel.add(idLabel);
		
		showGoods();
		showPrice();
	}
	
	
	public void showGoods(){
		tabledata=new String[100][5];
		PkgVO pvo=ppc.getPkgGoods(id);
		ArrayList<PkgItemVO> list=pvo.getPkg();
		
		for(int i=0;i<list.size();i++){
			tabledata[i][0]=list.get(i).getId();   //id
			tabledata[i][1]=list.get(i).getName();   //name
			tabledata[i][2]=list.get(i).getKind();   //kind
			tabledata[i][3]=String.valueOf(list.get(i).getPrice());     //price
			tabledata[i][4]=String.valueOf(list.get(i).getNum());   //num
		}
		
		String []ctitle={"商品编号","商品名","商品种类","商品单价","商品数量"};
		
		table=new JTable(tabledata,ctitle);
		table.setRowHeight(25);
		table.repaint();
		stockPanel = new JScrollPane(table);
		stockPanel.setViewportView(table);
		stockPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		stockPanel.setBounds(50,70,500,300);
		stockPanel.repaint();
		InfoPanel.add(stockPanel);
		
		addGoods=new JButton("增加赠品");
		addGoods.setBounds(590, 110, 150, 50);
		InfoPanel.add(addGoods);
		addGoods.addMouseListener(new addGoodsLis());
		
		delGoods=new JButton("删除赠品");
		delGoods.setBounds(590, 200, 150, 50);
		InfoPanel.add(delGoods);
		delGoods.addMouseListener(new delGoodsLis());
		
		editGoods=new JButton("编辑赠品");
		editGoods.setBounds(590, 290, 150, 50);
		InfoPanel.add(editGoods);
		editGoods.addMouseListener(new editGoodsLis());
	}
	
	public class addGoodsLis implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			DialogForChoice dfc=new DialogForChoice();
			String temp=dfc.chooseCommodityforTotal("请选择赠品");
			if(!temp.equals("no")){
				String []str=temp.split(" ");
				
				PkgItemVO piVO=new PkgItemVO(str[0],str[1],str[2],Integer.parseInt(str[4]),
						Double.parseDouble(str[3]));
				PkgVO prepkg=ppc.getPkgGoods(id);
				
				ArrayList<PkgItemVO> list=prepkg.getPkg();
				list.add(piVO);
				
				PkgVO pkgVO=new PkgVO(id,prepkg.getName(),list,getPrice(list));
				
				String result=ppc.editPkg(pkgVO);
				JOptionPane.showMessageDialog(null,result);
				
				InfoPanel.removeAll();
				showGoods();
				showPrice();
			}
		}
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
		}
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
		}
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub	
		}
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
		}
	}
	
	public class delGoodsLis implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			int row=table.getSelectedRow();
			if(row>=0&&table.getValueAt(row, 0)!=null){
				
				PkgVO prepkg=ppc.getPkgGoods(id);
				
				String goodid=(String)table.getValueAt(row, 0);
				
				ArrayList<PkgItemVO> list=prepkg.getPkg();
				for(int i=0;i<list.size();i++){
					if(list.get(i).getId().equals(goodid)){
						list.remove(i);
						break;
					}
				}
				
				PkgVO pkgVO=new PkgVO(id,prepkg.getName(),list,getPrice(list));
				
				String result=ppc.editPkg(pkgVO);
				System.out.println("result: "+result);
				JOptionPane.showMessageDialog(null,result);
				
				InfoPanel.removeAll();
				showGoods();
				showPrice();
			}
			else{
				JOptionPane.showMessageDialog(null, "请选中您所希望删除的商品");
			}
		}
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub	
		}
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub	
		}
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub	
		}
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub	
		}	
	}
	
	public class editGoodsLis implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			int row=table.getSelectedRow();
			if(table.getSelectedRow()==-1||table.getValueAt(row, 0)==null){
				JOptionPane.showMessageDialog(null,"请选中您希望编辑的行");
				return;
			}
			
			DialogForChoice dfc=new DialogForChoice();
			String num=dfc.oneGet("请输入新的商品数量", "int","新数量", (String)table.getValueAt(row, 4));
			
			if(!num.equals("no")){
				PkgVO prepkg=ppc.getPkgGoods(id);
				String goodid=(String)table.getValueAt(row, 0);
				
				ArrayList<PkgItemVO> list=prepkg.getPkg();
				for(int i=0;i<list.size();i++){
					if(list.get(i).getId().equals(goodid)){
						list.get(i).setNum(Integer.parseInt(num));
						break;
					}
				}
				
				PkgVO pkgVO=new PkgVO(id,prepkg.getName(),list,getPrice(list));
				
				String result=ppc.editPkg(pkgVO);
				
				System.out.println("result: "+result);
				JOptionPane.showMessageDialog(null,result);
				
				InfoPanel.removeAll();
				showGoods();
				showPrice();
			}
		}
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub	
		}
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
		}
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub	
		}
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub	
		}
	}
	//////////////////////////////showGoods/////////////////////////////////////////////////////////
	
	
	//////////////////////////////showPrice/////////////////////////////////////////////////////////
	public double getPrice(ArrayList<PkgItemVO> list){
		getPrePrice(list);
		postPrice=Double.parseDouble(String.format("%.2f", prePrice*0.85));
		return postPrice;
	}
	
	public double getPrePrice(ArrayList<PkgItemVO> list){
		prePrice=0;
		for(int i=0;i<list.size();i++){
			prePrice=prePrice+list.get(i).getNum()*list.get(i).getPrice();
		}
		return prePrice;
	}
	
	
	public void showPrice(){
		priceLabel=new JLabel("优惠价");
		priceLabel.setBounds(120, 410, 150, 50);
		InfoPanel.add(priceLabel);
		
		prePriceLabel=new JLabel("商品实际总价");
		prePriceLabel.setBounds(320, 10, 150, 50);
		InfoPanel.add(prePriceLabel);
		
		PkgVO vo=ppc.getPkgGoods(id);
		
		priceTxt=new JTextField();
		priceTxt.setBounds(250, 410, 150, 50);
		priceTxt.setText(String.valueOf(vo.getAftPrice()));
		priceTxt.setEditable(false);
		InfoPanel.add(priceTxt);
		
		prePriceTxt=new JTextField();
		prePriceTxt.setBounds(530, 10, 150, 50);
		prePriceTxt.setText(String.valueOf(getPrePrice(vo.getPkg())));
		prePriceTxt.setEditable(false);
		InfoPanel.add(prePriceTxt);
		
		editPrice=new JButton("编辑优惠价");
		editPrice.setBounds(480, 410, 150, 50);
		InfoPanel.add(editPrice);
		editPrice.addMouseListener(new editPriceLis());
	}
	
	public class editPriceLis implements MouseListener{

		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			DialogForChoice dfc=new DialogForChoice();
			String price=dfc.oneGet("请输入新的优惠价", "double","优惠价", "");
			
			double temp=0;
			
			PkgVO prepkg=ppc.getPkgGoods(id);
			
			ArrayList<PkgItemVO> list=prepkg.getPkg();
			for(int i=0;i<list.size();i++){
				temp=temp+list.get(i).getNum()*list.get(i).getPrice();
			}
			
			if(!price.equals("no")){
				if(Double.parseDouble(price)>=temp){
					JOptionPane.showMessageDialog(null, "请输入比原总价低的价格");
					return;
				}
				else{
					
					PkgVO pkgVO=new PkgVO(id,prepkg.getName(),list,Double.parseDouble(price));
					
					String result=ppc.editPkg(pkgVO);
					System.out.println("result: "+result);
					JOptionPane.showMessageDialog(null,result);
					
					InfoPanel.removeAll();
					showGoods();
					showPrice();
				}
			}
			
		}
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
		}
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
		}
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub	
		}
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
		}
	}

}
