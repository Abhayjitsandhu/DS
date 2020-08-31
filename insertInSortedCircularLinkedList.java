import java.util.Scanner;
class Result {
  static LinkList insertSorted(LinkList head, int data) {
    if(head==null)
    {
      LinkList node=new LinkList(data);
      head=node;
      head.next=node;
      return head;
    }
    LinkList n=head;
    LinkList node=new LinkList(data);
    if(n.data>data)
    {
      while(n.next!=head)
        n=n.next;
      node.next=head;
      head=node;
      n.next=head;
    }else
    {
      n=head;
      while(n.next!=head)
      {
        if(n.next.data>data)
          break;
        n=n.next;
      }
      if(n.next==head)
      {
        n.next=node;
        node.next=head;
      }else
      {
        node.next=n.next;
        n.next=node;
      }
    }
    return head;
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
    if (head != null) {
      while(t.next != head)
        t = t.next;
      t.next = newLink;
    }
    else
      newLink.next = newLink;
    head = newLink;
    return head;
  }
  static LinkList insertEnd(LinkList head, int data) {
    LinkList newLink = new LinkList(data);
    LinkList last = head;
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

  public static void traverse(LinkList first)  {
    LinkList temp = first;
    if (first != null) {
      do {
        System.out.print(temp.data + " ");
        temp = temp.next;
      }
      while (temp != first);
    }
  }

  public static void main(String[] args) {
    int t,n,m,x,y,i=0;
    Scanner s = new Scanner(System.in);
    t=s.nextInt();
    while(t>0) {
      LinkList head = null, t1, t2;
      n = s.nextInt();
      while(n>0) {
        m = s.nextInt();
        head = insertBeg(head, m);
        n--;
      }
      m = s.nextInt();
      head = Result.insertSorted(head, m);
      traverse(head);
      System.out.println();
      t--;
    }
  }
}
