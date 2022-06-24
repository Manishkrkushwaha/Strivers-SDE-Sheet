/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    public static void printarr(int[] arr) { 
        for(int it : arr) { 
            System.out.print(it + " ");
        }
        System.out.println();
    }
    public static void recur(int index,int[] arr, List<List<Integer>> ans) {
        if(index == arr.length) {
            List<Integer> re = new ArrayList<Integer>();
            for(int i = 0 ; i < arr.length ; i++) {
                re.add(arr[i]);
            }
            ans.add(re);
            return;
        }
        
        for(int i = index ; i < arr.length ; i++) {
            // System.out.println(i + " " + index);
            swap(i, index, arr);
            recur(index + 1, arr, ans);
            swap(i, index, arr);
        }
    }
    
    public static void swap(int i, int j, int[] arr) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
    
    public static List<List<Integer>> permute(int[] arr) {
        
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        recur(0, arr, ans);
        return ans;
        
    }
    
	public static void main (String[] args) throws java.lang.Exception
	{
		int[] num = {1,2,3};
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		ans = permute(num);
		
		for(List<Integer> list : ans) { 
		    for(Integer i : list) {
		        System.out.print(i + " ");
		    }
		    System.out.println();
		}
	}
}
