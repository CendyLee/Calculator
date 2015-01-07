/**
 * 程序主入口文件
 */
package Main;
import java.awt.*;
import javax.swing.*;
public class MyCal {	  
	public static void main(String[] args) { 
		//初始化基本组件
			  MyFrame mainframe=new MyFrame();             
	          MyPanel mainpanel=new MyPanel(); 
	          JTextField text=new JTextField("0");
        //设置基本属性             
              mainframe.setFrameProperty("MyCalculator", 285, 390,null);           
              mainpanel.setPanelProperty(new Rectangle(10,90,250,250), new GridLayout(5,4), new Color(242,242,239));                                              
              text.setBounds(10, 10, 250, 70);  
              //获取到计算器的文本域
              mainpanel.getTextField(text);
        //添加      
              mainframe.mycontainer.add(mainpanel);
              mainframe.mycontainer.add(text);     
              mainframe.setVisible(true);    
	}
}
