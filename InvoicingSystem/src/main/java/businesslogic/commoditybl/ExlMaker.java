package businesslogic.commoditybl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ExlMaker {

	public void make_exl(JTable table,String time) throws IOException{
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		String fileName="exl/"+"库存盘点单"+time+".xls";
		File file=new File(fileName);
		
		OutputStreamWriter tableWriter=new OutputStreamWriter(new FileOutputStream(file));
		for(int i=0;i<model.getColumnCount();i++){
			tableWriter.write(model.getColumnName(i));
			tableWriter.write("\t");
		}
		tableWriter.write("\n");
		for(int i=0;i<model.getRowCount();i++){
			for(int j=0;j<model.getColumnCount();j++){
				String str=null;;
				if(table.getValueAt(i, j)==null)
					str="";
				else{
					if(j==1)
						str=(String)table.getValueAt(i, j);
					else
					str=table.getValueAt(i, j).toString();
				}
				tableWriter.write(str);
				tableWriter.write("\t");
			}
			tableWriter.write("\n");
		}
		tableWriter.close();
		
		
	}
	
	
	
}
