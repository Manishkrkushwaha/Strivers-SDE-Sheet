/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Pair {
    public int x;
    public int y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Codechef
{
    
    static ArrayList<Pair> merged(ArrayList<Pair> arr) {
        
        ArrayList<Pair> ans = new ArrayList<>();
        Collections.sort(arr, (a,b) -> a.x - b.x);
        int n = arr.size();
        for(int i = 0 ; i < n ; i++) {
            if( ans.isEmpty() || ans.get(ans.size() - 1).y < arr.get(i).x) {
                ans.add(new Pair(arr.get(i).x,arr.get(i).y));
            }
            else {
                ans.get(ans.size() - 1).y = Math.max(ans.get(ans.size() - 1).y,arr.get(i).y);
            }
        }
        
        return ans;
    }
    
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// Type your code here
		ArrayList< Pair > arr = new ArrayList<>();
		
		arr.add(new Pair(1,3));
		arr.add(new Pair(2,4));
		arr.add(new Pair(2,6));
		arr.add(new Pair(8,9));
		arr.add(new Pair(8,10));
		arr.add(new Pair(9,11));
		arr.add(new Pair(15,18));
		arr.add(new Pair(16,17));
		
		ArrayList<Pair> ans = merged(arr);
		System.out.println("The merged pairs are : ");
		for(Pair it : ans) {
		    System.out.println(it.x + " " + it.y);
		}
	}
}
