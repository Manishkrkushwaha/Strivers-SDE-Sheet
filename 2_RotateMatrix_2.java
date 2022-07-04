/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    static void rotate(int[][] arr) {
        int n = arr.length;

        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j <= i ; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
        
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n/2 ; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[i][n - j - 1];
                arr[i][n - j - 1] = temp;
            }
        }
        
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		// Type your code here
		int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(arr);
		System.out.println("Rotated matrix is : ");
		
		for(int i = 0 ; i < arr.length ; i++) {
		    for(int j = 0 ; j < arr.length ; j++) {
		        System.out.print(arr[i][j] + " ");
		    }
		    System.out.println();
		}
	}
}
