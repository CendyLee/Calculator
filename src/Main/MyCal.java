/**
 * ����������ļ�
 */
package Main;
import java.awt.*;
import javax.swing.*;
public class MyCal {	  
	public static void main(String[] args) { 
		//��ʼ���������
			  MyFrame mainframe=new MyFrame();             
	          MyPanel mainpanel=new MyPanel(); 
	          JTextField text=new JTextField("0");
        //���û�������             
              mainframe.setFrameProperty("MyCalculator", 285, 390,null);           
              mainpanel.setPanelProperty(new Rectangle(10,90,250,250), new GridLayout(5,4), new Color(242,242,239));                                              
              text.setBounds(10, 10, 250, 70);  
              //��ȡ�����������ı���
              mainpanel.getTextField(text);
        //���      
              mainframe.mycontainer.add(mainpanel);
              mainframe.mycontainer.add(text);     
              mainframe.setVisible(true);    
	}
}
