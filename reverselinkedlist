import java.util.*;
class Result {
  static Node reverseList(Node head) {
    Node n=head,prev=null,next=null;
    while(n!=null)
    {
      next=n.next;
      n.next=prev;
      prev=n;
      n=next;
    }
    head=prev;
    return head;
  }
}
class Node {
  int data;
  Node next;
  Node(){}
  Node(int d) {
    data=d; next=null;
  }
}

class Main
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
    t=s.nextInt();
    while(t>0)
    {
      Node head = null;
      Node newHead = null;
      n = s.nextInt();
      while(n>0)
      {
        m = s.nextInt();
        head = insertEnd(head, m);
        n--;
      }
      newHead = Result.reverseList(head);
      forwardPrint(newHead);
      System.out.println();
      t--;
    }
  }
}
