/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    
    static int DuplicateElement(int[] arr) {
        int n = arr.length;
        
        int slow = arr[0];
        int fast = arr[0];
        
        do {
            
            slow = arr[slow];
            fast = arr[arr[fast]];
            System.out.println(slow + " " + fast);
            
        }while(slow != fast);
        
        fast = arr[0];
        
        while(slow != fast) {
            
            slow = arr[slow];
            fast = arr[fast];
            System.out.println(slow + " " + fast);
        }
        
        return slow;
    }
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// Type your code here
		int[] arr = {2,5,9,6,2,3,8,4,7,1};
		
		System.out.println(DuplicateElement(arr));
	}
}
