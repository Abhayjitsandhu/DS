import java.util.*;

class QueueArray
{
  int SIZE = 100;
  int front = 0;
  int rear = 0;
  int array[] = new int[SIZE];
  void enqueue(int item)
  {
    if (rear == SIZE)
      return;
    if(front == 0 && rear == 0)
      front = rear = 1;
    else
      rear++;
    array[rear] = item;
  }
  int dequeue()
  {
    if (front > rear)
      return -1;
    int item = array[front];
    front++;
    return item;
  }
}
class NewStack
{
  void push(QueueArray qa1, QueueArray qa2, int item)
  {
    qa1.enqueue(item);
  }

  int pop(QueueArray qa1, QueueArray qa2)
  {
    if(qa1.front<=qa1.rear)
    {
      while(qa1.front<qa1.rear)
      {
      	int t=qa1.dequeue();
      	qa2.enqueue(t);
      }
      return qa1.dequeue();
    }else
    {
      while(qa2.front<qa2.rear)
      {
      	int t=qa2.dequeue();
      	qa1.enqueue(t);
      }
      return qa2.dequeue();
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
    NewStack st1 = new NewStack();
    QueueArray qa1=new QueueArray();
    QueueArray qa2=new QueueArray();
    while(t>0)
    {
      q1 = s.nextInt();
      if(q1 == 1)
      {
        q2 = s.nextInt();
        st1.push(qa1, qa2, q2);
      }
      else
      {
        System.out.print(st1.pop(qa1, qa2) + " ");
      }
      t--;
    }
    System.out.println();
  }
}
