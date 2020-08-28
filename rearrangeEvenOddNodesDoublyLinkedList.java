import java.util.Scanner;
class LinkList
{
  int data;
  LinkList next;
  LinkList prev;
  LinkList(int d)
  {
    data=d;
  }
}
public class Main
{
  static LinkList insertEnd(LinkList head, int data)
  {
    LinkList newLink = new LinkList(data);
    LinkList last = head;
    newLink.next = null;
    if (head == null)
    {
      head = newLink;
      newLink.prev = null;
      return head;
    }
    while (last.next != null)
      last = last.next;
    last.next = newLink;
    newLink.prev = last;
    return head;
  }

  static void traverse(LinkList first)
  {
    while (first != null)
    {
      System.out.print(first.data + " ");
      first = first.next;
    }
  }
  static LinkList rearrangeList(LinkList head)
  {
    LinkList n=head,head1=null;
    int c=1;
    while(n!=null)
    {
      if(c%2==0)
      {
        head1=insertEnd(head1,n.data);
      }
      n=n.next;
      c++;
    }
    c=1;n=head;
    while(n!=null)
    {
      if(c%2!=0)
      {
        head1=insertEnd(head1,n.data);
      }
      n=n.next;
      c++;
    }
    return head1;
  }
  public static void main(String[] args)
  {
    int t,n,m,x,y;
    Scanner s = new Scanner(System.in);
    t=s.nextInt();
    while(t>0)
    {
      LinkList head = null, t1, t2;
      n=s.nextInt();
      while(n>0)
      {
        m=s.nextInt();
        head = insertEnd(head, m);
        n--;
      }
      t1 = rearrangeList(head);
      traverse(t1);
      System.out.println();
      t--;
    }
  }
}
