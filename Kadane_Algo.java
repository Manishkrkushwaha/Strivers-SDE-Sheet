/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    
    public static int maxSubArray(int[] nums, ArrayList<Integer> subarray) {
        int maxsum=nums[0],sum=0;
        int s=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum>maxsum){
                subarray.clear();
                maxsum=sum;
                subarray.add(s);
                subarray.add(i);
            }
            if(sum<0) {
                sum=0;
                s=i+1;
            }
        }
        return maxsum;
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		int arr[]={-2,1,-3,4,-1,2,1,-5,4};
		
		ArrayList<Integer> subarray = new ArrayList<>();
		int sum=maxSubArray(arr,subarray);
		
		System.out.println("The longest subarray with maximum sum is "+sum);
		System.out.println("The subarray is ");
		for(int i=subarray.get(0);i<=subarray.get(1);i++){
		    System.out.print(arr[i]+" ");
		}
	}
}
