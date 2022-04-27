/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    public static int[] sort012s(int[] arr) {
        int n=arr.length,low=0,mid=0,high=n-1,temp;
        
        while(mid<=high) {
            switch(arr[mid]){
                
                case 0:{
                    temp = arr[low];
                    arr[low] = arr[mid];
                    arr[mid]=temp;
                    low++;
                    mid++;
                    break;
                }
                case 1:{
                    mid++;
                    break;
                }
                case 2:{
                    temp = arr[high];
                    arr[high] = arr[mid];
                    arr[mid] = temp;
                    high--;
                    mid++;
                    break;
                }
            }
        }
        return arr;
    }
    
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int[] arr = new int[n];
		
		for(int i=0;i<n;i++){
		    arr[i]=sc.nextInt();
		}
		
		arr = sort012s(arr);
		
		for(int i=0;i<n;i++){
		    System.out.print(arr[i]+" ");
		}
	}
}
