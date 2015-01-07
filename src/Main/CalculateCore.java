package Main;
public class CalculateCore {
	public static String calculate(String inputStr)
	{	
		if(inputStr.equals(""))
		{
			return "0";
		}
		String[] stra=strToStringArray(inputStr); 	
		String[] strb=changeTo(stra);		
		return calculateStr(strb);	
	}
	private static boolean isOperator(String a)
	{
		if(a.equals("+")||a.equals("-")||a.equals("*")||a.equals("/")||a.equals("(")||a.equals(""))
		{
			return true;
		}
		else
			return false;
	}
	private static String[] strToStringArray(String str)
	{	
		String[] strarry=str.split("");
		String[] strtemp=new String[100];	
		String numstr="";
		int i,j=0,k;
		for(i=0;i<strarry.length;i++)
		{		
			if(!isOperator(strarry[i]))
			{
				numstr+=strarry[i];				
			}
			else
			{
				strtemp[j]=numstr;
				numstr="";
				strtemp[j+1]=strarry[i];
				j+=2;
			}			
		}
		strtemp[j]=numstr;
		//ȥ�������е�null
		int strlength=0;
		for(k=0;strtemp[k]!=null;k++)
		{
			strlength++;			
		}	
		String[] strtemp2=new String[strlength];
		for(int m=0;m<strlength;m++)
		{
			strtemp2[m]=strtemp[m];
		}
		return strtemp2;
	}
	private static String compare(String a,String b)    //�Ƚ�a��b�����ȼ�      a���򷵻�> b�󷵻�< ��ȷ���"="
	{
		if(a.equals("(")&&!b.equals("("))
		{
			return ">";
		}
		else if(b.equals("(")&&!a.equals("("))
		{
			return "<";
		}
		else if((a.equals("*")||a.equals("/"))&&(b.equals("+")||b.equals("-")))
		{
			return ">";
		}
		else if((a.equals("+")||a.equals("-"))&&(b.equals("*")||b.equals("/")))
		{
			return "<";
		}
		else 
		{
		return "=";
		}
	}
	private static String[] changeTo(String[] strinChar)
	{
		int num=0;
		String[] strout=new String[100];
		//����ջ
		int top=0;
		String[] stack=new String[100];		
		for(int i=0;i<strinChar.length;i++)
		{
			//���������  ֱ�����������ַ���
			if(!isOperator(strinChar[i]))
			{
				strout[num]=strinChar[i];
				num++;
			}
			//���� ���ջΪ��  ֱ����ջ
			else if(top==0)
			{
				stack[top]=strinChar[i];
				top++;
			}
			//���ջ�������������ȼ�С�ڵ�ǰȡ��Ԫ�أ�����ջ
			else if(compare(strinChar[i],stack[top-1]).equals(">"))
			{
				//��������ջ
				stack[top]=strinChar[i];
				top++;
			}		
			
			else
			{
				//���ջ��Ϊ�� ���� ��ǰȡ�õ�����������ȼ�С�ڻ��ߵ���ջ������������ȼ�
				while(top!=0&&(compare(strinChar[i],stack[top-1]).equals("<")||compare(strinChar[i],stack[top-1]).equals("=")))
				{
					strout[num]=stack[top-1];
					top--;
					num++;
				}
				stack[top]=strinChar[i];
				top++;
							
			}			
		}
		while(top!=0)
		{
			strout[num]=stack[top-1];
			top--;
			num++;
		}	
		return strout;
		
	}	
	private static String calculateStr(String[] str)
	{
		String result="";
		String[] stack=new String[100];
		int i,top=0;
		double num1,num2,tempresult;
		for(i=0;i<str.length&&str[i]!=null;i++)
		{
			if(!isOperator(str[i]))
			{
				stack[top]=str[i];
				top++;
			}
			else
			{
				switch(str[i])
				{
				case "+":
				{
					num1=Double.valueOf(stack[top-2]);
					num2=Double.valueOf(stack[top-1]);
					tempresult=num1+num2;
					top-=2;
					stack[top]=Double.toString(tempresult);
					top++;		
					break;
				}
				case "-":
				{
					num1=Double.valueOf(stack[top-2]);
					num2=Double.valueOf(stack[top-1]);
					tempresult=num1-num2;
					top-=2;
					stack[top]=Double.toString(tempresult);
					top++;
				    break;
				}
				case "*":
				{
					num1=Double.valueOf(stack[top-2]);
					num2=Double.valueOf(stack[top-1]);
					tempresult=num1*num2;
					top-=2;
					stack[top]=Double.toString(tempresult);
					top++;
					break;
				}
				case "/":
				{
					num1=Double.valueOf(stack[top-2]);
					num2=Double.valueOf(stack[top-1]);
					tempresult=num1/num2;
					top-=2;
					stack[top]=Double.toString(tempresult);
					top++;
					break;
				}
				}
			}
		}
		return stack[top-1];
	}
}


