/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    public static int maxPro (int[] arr) {
        int maxP=0, mini=arr[0];
        for(int i=1; i<arr.length ; i++) {
            if(mini > arr[i]) {
                mini = arr[i];
            }
            if((arr[i]-mini) > 0 && (arr[i] - mini) > maxP) maxP = arr[i] - mini; 
            
        }
        return maxP;
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i=0; i < n; i++) {
		    arr[i] = sc.nextInt();
		}
		
		int max = maxPro(arr);
		System.out.println("The maximum profit will be " + max);
		
	}
}
