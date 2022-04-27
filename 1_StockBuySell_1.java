/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    public static int maxPro(int[] arr) {
        int maxP=0;
        
        for(int i=0; i < arr.length-1; i++){
            for(int j=i+1; j < arr.length; j++) {
                if((arr[j] - arr[i]) > 0 && (arr[j] - arr[i] > maxP)){
                    maxP = arr[j] - arr[i];
                }
            }
        }
        return maxP;
    }
    
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i=0;i < n;i++) {
		    arr[i] = sc.nextInt();
		}
		
		int maxP = maxPro(arr);
		
		System.out.println("The maximum profit is " + maxP);
	}
}
