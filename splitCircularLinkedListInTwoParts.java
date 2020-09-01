import java.util.Scanner;
class Result {
  static LinkList listCut(LinkList head) {
    if(head==null)
      return null;
    LinkList n=head,temp=null,l;int c=0,m;
    do
    {
      c++;
      l=n;
      n=n.next;
    }while(n!=head);
    n=head;
    m=c/2;
    while(m>1)
    {
      n=n.next;
      m--;
    }
    temp=n.next;
    l.next=temp;
    n.next=head;
    return temp;
  }
}
class LinkList {
  int data;
  LinkList next;
  LinkList() {}
  LinkList(int d) {
    data=d;
  }
}

class Main
{
  static LinkList insertBeg(LinkList head, int data)
  {
    LinkList newLink = new LinkList(data);
    LinkList t = head;
    newLink.next = head;
    if (head != null)
    {
      while(t.next != head)
        t = t.next;
      t.next = newLink;
    }
    else
      newLink.next = newLink;
    head = newLink;
    return head;
  }
  static LinkList insertEnd(LinkList head, int data)
  {
    LinkList newLink = new LinkList(data);
    LinkList last = head;
    newLink.next = null;
    if (head == null)
    {
      head = newLink;
      return head;
    }
    while (last.next != null)  // Find the last node
      last = last.next;
    last.next = newLink;
    return head;
  }

  public static void traverse(LinkList first)
  {
    LinkList temp = first;
    if (first != null)
    {
      do
      {
        System.out.print(temp.data + " ");
        temp = temp.next;
      }
      while (temp != first);
    }
  }
  public static void main(String[] args)
  {
    int t,n,m,x,y,i=0;
    Scanner s = new Scanner(System.in);
    t=s.nextInt();
    while(t>0)
    {
      LinkList head = null, t1, t2;
      n = s.nextInt();
      while(n>0)
      {
        m = s.nextInt();
        head = insertBeg(head, m);
        n--;
      }
      t1 = Result.listCut(head);
      traverse(head);
      System.out.println();
      traverse(t1);
      System.out.println();
      t--;
    }
  }
}
