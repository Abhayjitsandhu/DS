import java.util.Scanner;
class Node
{
  int data;
  Node leftChild;
  Node rightChild;
  public Node()
  {
    data=0;
  }
  public Node(int d)
  {
    data=d;
  }
}

class Main
{
  static void inOrder(Node root)
  {
    if (root != null)
    {
      inOrder(root.leftChild);
      System.out.print(root.data + " ");
      inOrder(root.rightChild);
    }
  }
static Node buildTree(int t[], int n)
{
  Node node = null;
  // Complete the function body
  if(n<1)
    return null;
  Node arr[]=new Node[n];
  node=new Node(t[0]);
  //System.out.println(node.data);
  Node p=node;
  int k=0,j=0;
  for(int i=1;i<n;i++)
  {
    p.leftChild=new Node(t[i]);
    arr[k]=p.leftChild;
    i++;k++;
    if(i<n)
    {
      p.rightChild=new Node(t[i]);
      arr[k]=p.rightChild;
      k++;
    }
    //System.out.println("root= " + arr[j].data);
    p=arr[j];
    j++;
  }
  return node;
}
public static void main(String[] args)
  {
    int a[]=new int[10];
    int n, i;
    Scanner s=new Scanner(System.in);
    n = Integer.parseInt(s.nextLine());
    for(i=0;i<n;i++)
      a[i] = Integer.parseInt(s.nextLine());
    Node root = null;
    root = buildTree(a, n);
    inOrder(root);
  }
}
