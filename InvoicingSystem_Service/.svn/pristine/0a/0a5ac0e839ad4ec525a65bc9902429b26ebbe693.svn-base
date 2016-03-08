package data.commoditydata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;

import po.accountPO;

public class PoReader<T extends Serializable> {

String fileName=null;

public PoReader (String inFile){
	fileName=inFile;
}
public T read(){
	T temp=null;
	try {
		ObjectInputStream ois=new ObjectInputStream(new FileInputStream(fileName));
        temp=(T) ois.readObject();
        ois.close();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	return temp;
}
/*public static void main(String args[]){
	PoReader p=new PoReader("file/account.txt");
	ArrayList<accountPO> po=(ArrayList<accountPO>)p.read();
	for(int i=0;i<po.size();i++){
		System.out.println(po.get(i).get());
	}
}*/

}
