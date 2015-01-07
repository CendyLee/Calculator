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
		//去除数组中的null
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
	private static String compare(String a,String b)    //比较a和b的优先级      a大则返回> b大返回< 相等返回"="
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
		//建立栈
		int top=0;
		String[] stack=new String[100];		
		for(int i=0;i<strinChar.length;i++)
		{
			//如果是数字  直接输出到输出字符串
			if(!isOperator(strinChar[i]))
			{
				strout[num]=strinChar[i];
				num++;
			}
			//否则 如果栈为空  直接入栈
			else if(top==0)
			{
				stack[top]=strinChar[i];
				top++;
			}
			//如果栈顶操作符的优先级小于当前取得元素，则入栈
			else if(compare(strinChar[i],stack[top-1]).equals(">"))
			{
				//操作符入栈
				stack[top]=strinChar[i];
				top++;
			}		
			
			else
			{
				//如果栈不为空 并且 当前取得的运算符的优先级小于或者等于栈顶运算符的优先级
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


