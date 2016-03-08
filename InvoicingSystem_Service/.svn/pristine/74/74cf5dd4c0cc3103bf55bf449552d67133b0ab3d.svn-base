package data.commoditydata;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class PoWriter<T extends Serializable> {

	String fileName=null;
	public PoWriter(String outFile){
		fileName=outFile;
	}
	public void write(T po){
		try {
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(fileName));
			oos.writeObject(po);
			oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
