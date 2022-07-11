/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    
    static int DuplicateElement(int[] arr) {
        int n = arr.length;
        
        Arrays.sort(arr);
        
        for(int i = 0 ; i < n-1 ; i++)
            if(arr[i] == arr[i + 1])
                return arr[i];
        
        return 0;
    }
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// Type your code here
		int[] arr = {1,4,3,5,3,2};
		
		System.out.println(DuplicateElement(arr));
	}
}
