/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    
    static int DuplicateElement(int[] arr) {
        int n = arr.length;
        
        int[] frequency = new int[n];
        
        for(int i = 0 ; i < n-1 ; i++)
            frequency[arr[i]]++;
            
        for(int i = 1; i < n ; i++)
            if(frequency[i] > 1)
                return i;
        
        return 0;
    }
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// Type your code here
		int[] arr = {1,4,3,5,3,2};
		
		System.out.println(DuplicateElement(arr));
	}
}
