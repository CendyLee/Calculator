package Main;
import java.awt.*;
import javax.swing.*;
public class MyFrame extends JFrame {
	public Container mycontainer=this.getContentPane();
	//ͳһ����frame����
     public void setFrameProperty(String title,int width,int height,LayoutManager manager)
     {
    	 this.setTitle(title);  	 
    	 this.setSize(width, height);
    	 this.mycontainer.setLayout(manager);
    	 this.setLocationRelativeTo(null);
     }
}
