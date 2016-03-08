package presentation.accountui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.*;

public class dialogmaker {
	JDialog dialog;
	int screenWidth;
	int screenHeight;
	int frameWidth=1000;
	int frameHeight=600;
	public dialogmaker(String s){
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension screenSize=kit.getScreenSize();
		screenWidth=screenSize.width;
		screenHeight=screenSize.height;
		Image bg_icon=kit.getImage("Image//login_icon.jpg");
		dialog=new JDialog();
		dialog.setTitle("警告");
		dialog.setIconImage(bg_icon);
		dialog.setBounds((screenWidth-frameWidth)/2+300, (screenHeight-frameHeight)/2+100,400, 150);
		JLabel l=new JLabel(s);
		dialog.add(l);
		
		l.setBounds(150,200 ,200, 75);
		
		
		l.setVisible(true);
		dialog.setVisible(true);
	}
	public static void main(String args[]){
		dialogmaker k=new dialogmaker("uadufbkbkabkkufh");
	}

}
