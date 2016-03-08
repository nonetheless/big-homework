package presentation.marketui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;

class DoubleListener extends KeyAdapter{    
	JTextField m;
    public DoubleListener(JTextField price) {
		m = price;
	}
	public void keyTyped(KeyEvent e){
    	  boolean dot = checkDot();
    	  int temp=e.getKeyChar();
    	  boolean b1=temp>=KeyEvent.VK_0;
    	  boolean b2=temp<=KeyEvent.VK_9;
    	  boolean b3=temp=='.';
    	  boolean b=(b1&&b2)||b3;
    	   if((!b)||(b3&&dot))
    	   e.consume();    		   
        }
    boolean checkDot(){
   		boolean result=false;
   		String text=m.getText();
   		//System.out.println(text);
   	    int dotLoc=text.indexOf('.');
   		if(dotLoc!=-1)
   			result=true;
   		return result;
   	}
}