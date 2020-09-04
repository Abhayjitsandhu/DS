import java.util.*;
class CQStack
{
  int maxSize;
  int[] stackArray;
  int top;

  public CQStack()
  {
    maxSize = 100;
    stackArray = new int[maxSize];
    top = -1;
  }
  public void push(int j)
  {
    if(isFull())
    {
    }
    else
      stackArray[++top] = j;
  }
  public int pop()
  {
    if (isEmpty())
    {
      return -1;
    }
    else
    {
      int temp=stackArray[top--];
      return temp;
    }
  }
  public boolean isEmpty()
  {
    return (top == -1);
  }
  public boolean isFull()
  {
    return (top == maxSize-1);
  }
}
class Queue
{
  void enqueue(CQStack st1, CQStack st2, int item)
  {
    st1.push(item);
  }

  int dequeue(CQStack st1, CQStack st2)
  {
    if(st2.top>=0)
    {
      return st2.pop();
    }else
    {
      while(st1.top>0)
      {
        int t=st1.pop();
        st2.push(t);
      }
      return st1.pop();
    }
  }
}
class Main
{
  public static void main(String[] args)
  {
    Scanner s=new Scanner(System.in);
    int t, n, q1, q2, k;
    t = Integer.parseInt(s.nextLine());
    Queue qa1 = new Queue();
    CQStack st1=new CQStack();
    CQStack st2=new CQStack();
    while(t>0)
    {
      q1 = s.nextInt();
      if(q1 == 1)
      {
        q2 = s.nextInt();
        qa1.enqueue(st1, st2, q2);
      }
      else
        System.out.print(qa1.dequeue(st1, st2) + " ");
      t--;
    }
    System.out.println();
  }
}
