package presentation.marketui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class IntListener extends KeyAdapter{
	public void keyTyped(KeyEvent e){
		int keyChar=e.getKeyChar();
		if(!((keyChar>=KeyEvent.VK_0)&&(keyChar<=KeyEvent.VK_9)))
			e.consume();
	}
	
}
