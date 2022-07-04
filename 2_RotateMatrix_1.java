/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    static int[][] rotate ( int[][] arr) {
        int n = arr.length;
        int[][] rotated = new int[n][n];
        
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) {
                rotated[j][n-i-1] = arr[i][j];
            }
        }
        return rotated;
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		// Type your code here
		int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
		int[][] rotated = rotate(arr);
		
		System.out.println("Rotated Image : ");
		for(int i = 0 ; i < rotated.length ; i++) {
		    for(int j = 0 ; j < rotated.length; j++) {
		        System.out.print(rotated[i][j] + " ");
		    }
		    System.out.println();
		}
	}
}
