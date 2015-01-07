package Main;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class MyPanel extends JPanel implements ActionListener {
	private JTextField textfield;
	private char[] temp;
	private String[] name= {"9","8","7","+","6","5","4","-","3","2","1","*","0","00","C","/","(",")",".","="};
	public String showString="";
	private String inputString="";
	public MyPanel()
	{
		//≥ı ºªØ∞¥≈•
		for(int i=0;i<name.length;i++)
        {
      	  MyButton btn=new MyButton(name[i]);
      	  btn.addActionListener(this);
      	  this.add(btn);
        }
	}
	public void getTextField(JTextField text)
	{
		textfield=text;
	}
	public void setPanelProperty(Rectangle panelrect,LayoutManager manager,Color bgcolor)
	{
		this.setBounds(panelrect);
		this.setLayout(manager);
		this.setBackground(bgcolor);
	}
	public void actionPerformed(ActionEvent e)
	{
		String btnLable=e.getActionCommand();
		if(btnLable=="C")
		{
			showString="";
			inputString="";
			textfield.setText("0");
		}
		else if(btnLable!="=")
		{
			showString+=btnLable;
		    textfield.setText(showString);
		    inputString=showString;
		}
		else if(btnLable=="=")
		{
		   showString=CalculateCore.calculate(inputString);
		   textfield.setText(showString);
		}
		
	}	
}
