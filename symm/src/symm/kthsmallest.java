package symm;

/***********************************
* CSE2011 - Assignment 2
* File name: kthsmallest.java
* Author: Niburski, Oskar
* Email: oskarniburski@gmail.com
* CSE number: 212644944
************************************/


public class kthsmallest {

public static final int MaxSize = 500;

/*
 * Return the value of the kth smallest element of array A.
 * n is the number of elements A contains, and k <= n.
 * The running time of your algorithm must be O(N).
 *
 */

public static int find_kth_smallest( int[] A, int n, int k )
{
	int[] B = A; //make a copy of the array;
	return find_kth_smallest_rec(B, n, k); 
}  

public static int find_kth_smallest_rec( int[] A, int n, int k )
{
	
	int mid = (n - 1)/2; 
	int pivot = A[mid]; //make the pivot
	int tempA = A[0]; //this is a switch
	
	A[0] = pivot; //swap
	A[mid] = tempA;
	
	int[] highArray = new int[MaxSize]; 
	int[] lowArray = new int[MaxSize];
	int hc = 0, lc = 0; 
	
	 // sorting into respective arrays around pivot
	for (int i = 1; i < n; i++) {
		if (A[i] < pivot) {
			lowArray[lc] = A[i];
			lc++;
		}
		else if (A[i] > pivot) {
			highArray[hc] = A[i];
			hc++;
		}		
	}
	
	if (k <= lc)  {
		// k should be in the left side
		return find_kth_smallest_rec(lowArray, lc, k);
	}
	else if (k > n - hc) {
		//k is in the right side
		return find_kth_smallest_rec(highArray, hc, k - (n - hc));
	}
		
	
	return pivot; 
}

} // end class




