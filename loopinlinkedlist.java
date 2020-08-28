import java.util.Scanner;
class Node
{
  int data;
  Node next;
  Node(int d)
  {
    data=d;
  }
}
class Result {
  static int loopInList(Node head) {
      int c=1;
      if(head==null)
      {
          return 0;
      }
    Node t=head;
    Node r=head;
    do
    {
        r=r.next.next;
        t=t.next;
        if(t==null||r==null)
        return 0;
    }
    while(t!=r);
    Node n=r.next;
    while(n!=t)
    {
        c++;
        n=n.next;
    }
    return c;
  }
}
public class Main
{
  static Node insertEnd(Node head, int data)
  {
    Node newLink = new Node(data);
    Node last = head;
    newLink.next = null;
    if (head == null)
    {
      head = newLink;
      return head;
    }
    while (last.next != null)
      last = last.next;
    last.next = newLink;
    return head;
  }

  static void forwardPrint(Node head)
  {
    Node current = head;
    while(current != null)
    {
      System.out.print(current.data + " ");
      current = current.next;
    }
  }
  public static void main(String[] args)
  {
    int t,n,m,x;
    Scanner s = new Scanner(System.in);
    t=Integer.parseInt(s.nextLine().trim());
    while(t>0)
    {
      Node head = null;
      Node t1, t2;
      int c, k, ans;
      n = s.nextInt();
      while(n>0)
      {
        m = s.nextInt();
        head = insertEnd(head, m);
        n--;
      }
      k = s.nextInt();
      c = s.nextInt();
      if(c>0 && k>0)
      {
        k--;c--;
        t1=head;
        t2=head;
        while(k>0){
          t1 = t1.next; 
          k--;
        }
        while(c>0){
          t2 = t2.next;
          c--;
        }
        t1.next = t2;
      }
      ans = Result.loopInList(head);
      System.out.println(ans);
      t--;
    }
  }
}
