/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }
    
    static void merge(int[] arr1, int[] arr2, int m, int n) {
        int gap = (int)Math.ceil((double)(n + m) / 2.0);
        
        while( gap > 0) {
            int i = 0;
            int j = gap;
            
            while( j < (n + m)) {
                if(j < m && arr1[i] > arr1[j]) {
                    int temp = arr1[i];
                    arr1[i] = arr2[j];
                    arr2[j] = temp;
                    // swap(arr1[i] , arr2[j]);
                }
                else if ( j >= m && i < m && arr1[i] > arr2[j - m]) {
                    int temp = arr1[i];
                    arr1[i] = arr2[j - m];
                    arr2[j - m] = temp;
                    // swap(arr1[i] , arr2[j - m]);
                }
                else if (j >= m && i >= m && arr2[i - m] > arr2[j - m]) {
                    int temp = arr2[i - m];
                    arr2[i - m] = arr2[j - m];
                    arr2[j - m] = temp;
                    // swap(arr1[i - m], arr2[j - m]);
                }
                i++;
                j++;
            }
            if(gap == 1)
                gap = 0;
            else
                gap = (int)Math.ceil((double) gap / 2.0 );
        }
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		// Type your code here
		int[] arr1 = {1,4,7,8,10};
		int[] arr2 = {2,3,9};
		
		for(int i = 0 ; i < arr1.length ; i++) {
		    System.out.print(arr1[i] + " ");
		}
		for(int i = 0 ; i < arr2.length ; i++) {
		    System.out.print(arr2[i] + " ");
		}
		System.out.println();
		
		merge(arr1 , arr2, arr1.length, arr2.length);

        // swap(arr1[0], arr1[1]);
		
		System.out.println("Merged Array : ");
		
		for(int i = 0 ; i < arr1.length ; i++) {
		    System.out.print(arr1[i] + " ");
		}
		for(int i = 0 ; i < arr2.length ; i++) {
		    System.out.print(arr2[i] + " ");
		}
	}
}
