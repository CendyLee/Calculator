package Main;
import java.awt.*;
import javax.swing.*;
public class MyFrame extends JFrame {
	public Container mycontainer=this.getContentPane();
	//统一设置frame属性
     public void setFrameProperty(String title,int width,int height,LayoutManager manager)
     {
    	 this.setTitle(title);  	 
    	 this.setSize(width, height);
    	 this.mycontainer.setLayout(manager);
    	 this.setLocationRelativeTo(null);
     }
}
