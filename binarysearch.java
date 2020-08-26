import java.util.*;
public class Main
{
    static int binarysearch(int l,int h,int[] arr,int n)
    {
        int m;
        while(l<=h)
		{
		    m=(l+h)/2;
		    if(n==arr[m])
		    {
		        return m;
		    }
		    if(n>arr[m])
		    {
                return binarysearch(m+1,h,arr,n);
            
		    }else
		    {
		        return binarysearch(l,m-1,arr,n);
		    }
		}
		return -1;
    }
	public static void main(String[] args) {
	    Scanner sc=new Scanner(System.in);
	    System.out.println("enter length of array");
	    int n=sc.nextInt();
		int[] arr=new int[n];
		System.out.println("enter elements of array");
		for(int i=0;i<n;i++)
		arr[i]=sc.nextInt();
		System.out.println("enter element to be found");
		int m=sc.nextInt();
		int l=0,h=n-1;
		int p=binarysearch(l,h,arr,m);
		if(p==-1)
		{
		    System.out.println("NOT FOUND");
		}else
		System.out.println(p);
	}
}
