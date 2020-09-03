import java.util.Scanner;
class Result
{
  static int minReversal(String expr)
  {
    char ch[]=expr.toCharArray();char c,t='\0',t1='\0';
    int s1=expr.trim().length(),c1=0;
    if(s1%2!=0)
      return -1;
    CQStack s=new CQStack(ch.length);
    for(int i=0;i<s1;i++)
    {
      if(s.top==-1)
        s.push(ch[i]);
      else
      {
        if(ch[i]==s.stackArray[s.top] || s.stackArray[s.top]==']' && ch[i]=='[')
          s.push(ch[i]);
        else if(s.stackArray[s.top]=='[' && ch[i]==']')
          c=s.pop();
      }
    }
    while(s.top!=-1)
    {
      t=s.pop();
      if(t==t1)
      {c1++;t1='\0';}
      else if(t==']' && t1=='[')
      {c1+=2;t1='\0';}
      else
      t1=t;
    }
    return c1;
  }
}
class CQStack
{
  public int maxSize;
  public char[] stackArray;
  public int top;

  public CQStack(int s)
  {
    maxSize=s;
    stackArray=new char[maxSize];
    top=-1;
  }

  public void push(char j)
  {
    if(isFull())
      return;
    else
    {
      top++;
      stackArray[top]=j;
    }
  }
  
  public char pop()
  {
   if(isEmpty())
     return '\0';
    else
    {
      char temp=stackArray[top];
      stackArray[top]=0;
      top=top-1;
      return temp;
    }
  }
 public boolean isEmpty()
  {
    if(top==-1)
      return true;
    return false;
  }

  public boolean isFull()
  {
    if(top==maxSize-1)
      return true;
    return false;
  }
}
class Main
{
  public static void main(String[] args)
  {
    int t, ans;
    Scanner s=new Scanner(System.in);
    t = Integer.parseInt(s.nextLine().trim());
    while(t!=0)
    {
      String expr;
      expr = s.nextLine();
      ans = Result.minReversal(expr);
      System.out.println(ans);
      t--;
    }
  }
}
