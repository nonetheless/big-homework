package main;



import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JOptionPane;

import dataservice.mockDataService.MockDataService;
import presentation.loginui.LoginUI;



public class StartSystem {
	
	LoginUI loginUI;
	
	public StartSystem(){
		
		String ip=JOptionPane.showInputDialog("请输入服务器端的ip地址");
		
		boolean isSuccess=false;
		try {
			MockDataService mds=(MockDataService)Naming.lookup("rmi://"+ip+":6666/mockData");
		    isSuccess=true;
		    JOptionPane.showMessageDialog(null, "与服务器连接成功！");
		    } catch (Exception e) {
			JOptionPane.showMessageDialog(null, "与服务器连接失败！请检查ip地址的输入");
		}
		if(isSuccess)
		start(ip);	
		

		
	}
	
	
	private void start(String ip) {
		IPAddress.ip=ip;
		loginUI=new LoginUI();
		loginUI.setVisible(true);
	}
	
	public static void main(String [] ags){
		new StartSystem();
	}
	
}
