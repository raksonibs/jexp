package symm;

import java.util.Arrays;

/***********************************
* CSE2011 - Assignment 2 
* File name: symm.java
* Author: Niburski, Oskar
* Email: oskarniburski@gmail.com
* CSE number: 212644944
************************************/

public class symm
{

/* 
 * Returns true if array A is symmetric.
 * Returns false otherwise.
 * n is the number of elements A contains.
 *
 * The running time of your algorithm is O(N).
 * You may add a brief explanation here if you wish.
 */

public static boolean symmetric( int[] A, int n )
{
   return symmHelper(A,n,0,n-1); //call helper method
}  // end symmetric

public static boolean symmHelper( int[] A, int n, int front, int back)
{
   if (n <= 1) {
	   // if n less than 1, in center
	   return true;
   }
   else {
	   // must not be the center, so check front and back and recursively call
	   return (A[front] == A[back]) && symmHelper(A, n-2, front + 1, back - 1);
   }
	   
} 

}  // end class
