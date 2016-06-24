package symm;

import java.util.Arrays;

/***********************************
* CSE2011 - Assignment 2
* File name: sum.java
* Author: Niburski, Oskar
* Email: oskarniburski@gmail.com
* CSE number: 212644944
************************************/


public class sum {


/*
 * EXHAUSTIVE ALGORITHM
 * Returns true if array A contains two elements whose sum is k.
 * Returns false otherwise.
 * n is the number of elements A contains.
 *
 * The running time of your algorithm is O( N^2 ).
 * You may add a brief explanation here if you wish.
 */

public static boolean sum_exh( int[] A, int n, int k )
{
	boolean truth = false;
	
	for (int i = 0; i < n; i++) {
		for (int j=0; j<n;j++) {
			if (i != j) {
				// fairly simple exhaustive
				if (A[i] + A[j] == k) {
					return true;
				}
			}
		}
	}
	
	return truth;

}  // end sum_exh





/*
 * RECURSIVE ALGORITHM
 * Returns true if array A contains two elements whose sum is k.
 * Returns false otherwise.
 * n is the number of elements A contains.
 *
 * The running time of your algorithm is O( N ).
 * You may add a brief explanation here if you wish.
 */

public static boolean sum_rec( int[] A, int n, int k )
{
	return sumHelper(A, n, k, 0, n-1);
}  // end sum_rec

public static boolean sumHelper( int[] A, int n, int k, int front, int back )
{
	if (n <= 1) {
		//array is of size 1 or less, and thus does not have sum of k
		return false;
	} else if (A[front] + A[back] == k) {
		//if sum is true
		return true;
	} else if (A[front]+A[back] > k) {
		//if the sum is greater than k, shift backwards one
		return sumHelper(A, n - 1, k, front, back - 1); 
	}
	else if (A[front]+A[back] < k) {
		//if the sum is less than k, shift forwards one
		return sumHelper(A, n - 1, k, front + 1, back);
	} 
	
	return false;

} 


} // end class

