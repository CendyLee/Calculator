package Main;
import java.awt.*;
import javax.swing.*;
public class MyFrame extends JFrame {
	public Container mycontainer=this.getContentPane();
	//统一设置frame属性
     public void setFrameProperty(Boolean isVisible,String title,int width,int height,LayoutManager manager,Color bgcolor)
     {
    	 this.setTitle(title);
    	 this.setVisible(isVisible);
    	 this.setSize(width, height);
    	 this.mycontainer.setLayout(manager);
    	 this.mycontainer.setBackground(bgcolor);
    	 this.setLocationRelativeTo(null);
     }
}
