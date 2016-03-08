package uiField;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;

public class StringField extends JTextField {

	public StringField(){
		this.addKeyListener(new stringListener());
	}
	public StringField(int length){
		super(length);
		this.addKeyListener(new stringListener());
	}
	
	
	private boolean isChinese(int ch){
		Character.UnicodeBlock ub=Character.UnicodeBlock.of(ch);
		
	   if(ub==Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS)
		   return true;
	   else 
		   return false;
				 
	}
	
	class stringListener extends KeyAdapter{
		public void keyTyped(KeyEvent e){
			int keyChar=e.getKeyChar();
			boolean isNum=(keyChar>=KeyEvent.VK_0)&&(keyChar<=KeyEvent.VK_9);
			boolean isUPChar=(keyChar>=KeyEvent.VK_A)&&(keyChar<=KeyEvent.VK_Z);
			boolean isLOWchar=(keyChar>=((KeyEvent.VK_A)+32)&&(keyChar<=(KeyEvent.VK_Z+32)));
		
			boolean isChinese=isChinese(keyChar);
			
			if(!(isNum||isUPChar||isChinese||isLOWchar))
				e.consume();
			
			
		}
	}
	
	
}
