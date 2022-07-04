/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    static void merge(int[] a, int[] b, int m, int n) {
        int[] c = new int[m+n];
        int k = 0;
        for(int i = 0 ; i < m ; i++) {
            c[k++] = a[i];
        }
        for(int i = 0 ; i < n ; i++) {
            c[k++] = b[i];
        }
        Arrays.sort(c);
        k=0;
        for(int i = 0 ; i < m ; i++) {
            a[i] = c[k++];
        }
        for(int i = 0 ; i < n ; i++) {
            b[i] = c[k++];
        }
    }
    
	public static void main (String[] args) throws java.lang.Exception
	{
		int[] a = {1,4,7,8,10};
		int[] b = {2,3,9};
		
		System.out.println("Before merge");
		
		for(int i = 0 ; i < a.length ; i++) {
		    System.out.print(a[i] + " ");
		}
		System.out.println();
		for(int i = 0 ; i < b.length ; i++) {
		    System.out.print(b[i] + " ");
		}
		System.out.println();
		
		merge(a,b,a.length,b.length);
		
		System.out.println("After merge");
		
		for(int i = 0 ; i < a.length ; i++) {
		    System.out.print(a[i] + " ");
		}
		System.out.println();
		for(int i = 0 ; i < b.length ; i++) {
		    System.out.print(b[i] + " ");
		}
	}
}
