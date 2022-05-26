import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args) {
	    Scanner scn = new Scanner(System.in);
	    int t = scn.nextInt();
	    for(int x=1;x<=t;x++) {
            int n = scn.nextInt();
            int k = scn.nextInt();
            int[] a = new int[n];
            for(int i = 0; i < n; i++)
               a[i] = scn.nextInt();
            int i=0;
        	k%=n;
            if(k<0)
                k+=n;
            rotate(a,i,n-1);
            rotate(a,i,n-k-1);
            rotate(a,n-k,n-1);
            display(a);
            System.out.println();
	    }
	}
	 
	public static void rotate(int[] a, int i, int j) {
        while(j>i) {
            int temp=a[i];
            a[i]=a[j];
            a[j]=temp;
            i++; j--;
        }
    }
    
    public static void display(int[] a) {
        for(int i=0;i<a.length;i++)
            System.out.print(a[i] + " ");
    }
}