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
static LinkList rotateByK(LinkList head, int k)
{
  if(head==null)
    return null;
  if(k==0)
    return head;
  LinkList n=head,last=null;int s=0,c=0;
  while(n!=null)
  {
    s++;
    last=n;
    n=n.next;
  }
  if(k==s)
    return head;
  c=s-k;
  n=head;
  while(c>0)
  {
    n=n.next;
    c--;
  }
  n.prev.next=null;
  n.prev=null;
  last.next=head;
  head.prev=last;
  head=n;
  return head;
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
      x=s.nextInt();
      t1 = rotateByK(head, x);
      traverse(t1);
      System.out.println();
      t--;
    }
  }
}
