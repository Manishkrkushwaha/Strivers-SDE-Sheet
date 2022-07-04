/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    static void merge(int[] a,int[] b, int m, int n) {
        
        for(int i = 0 ; i < m ; i++) {
            if(a[i] > b[0]) {
                int temp = a[i];
                a[i] = b[0];
                b[0] = temp;
            }
            
            int first = b[0],k = 1;
            for(; k < n && first > b[k] ; k++) {
                b[k - 1] = b[k];
            }
            b[ k - 1 ] = first;
        }
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		// Type your code here
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
