package data.kinddata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import po.KindPo;
import dataservice.kinddataservice.KindDataService;

public class KindData extends UnicastRemoteObject implements KindDataService {
	
	public KindData() throws RemoteException {
		super();
		//init();
		// TODO Auto-generated constructor stub
		
	}

	String rootFile="file/root.ser";

	public void init() throws RemoteException{
		KindPo root=new KindPo("灯具",null,"01");
		root.set_AllowChild(true);
		try {
			write_root(root);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public KindPo read_root() throws RemoteException {
		// TODO Auto-generated method stub
		KindPo root=null;
		try{
			ObjectInputStream ois=new ObjectInputStream(new FileInputStream(rootFile));
			System.out.println("读过了");
			root=(KindPo)ois.readObject();
			ois.close();
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		
		
		return root;
	}

	public void write_root(KindPo root) throws RemoteException {
		// TODO Auto-generated method stub
       try{
    	   ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(rootFile));
    	   oos.writeObject(root);
    	   System.out.println("写过了"+root.get_NumOfChild());
    	   
    	   oos.close();
       }catch (FileNotFoundException e) {
   		// TODO Auto-generated catch block
   		e.printStackTrace();
   	  } catch (IOException e) {
   		// TODO Auto-generated catch block
   		e.printStackTrace();
   	}
	}

}
