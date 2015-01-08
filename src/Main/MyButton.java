package Main;
import java.awt.*;
import javax.swing.*;
public class MyButton extends JButton
{
	MyButton(String text)
	{		
		this.setText(text);
		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));			
        this.setFocusPainted(false);
        this.setFont(new Font("ËÎÌו",Font.BOLD,16));
        
	}
}

