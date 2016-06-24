package symm;

/***********************************
* CSE2011 - Assignment 2
* File name: match.java
* Author: Niburski, Oskar
* Email: oskarniburski@gmail.com
* CSE number: 212644944
************************************/


public class match {

/*
 * EXHAUSTIVE ALGORITHM
 * Returns index i if array A contains an element A[i] such that A[i] = i.
 * If there exist many of such elements, return the index of any one of them.
 * Returns -1 if there exists no element A[i] such that A[i] == i.
 * n is the number of elements A contains.
 *
 * The running time of your algorithm is O( N ).
 * You may add a brief explanation here if you wish.
 */


public static int match_exh( int[] A, int n ) 
{

	int found = -1;
	
	for (int i = 0; i < n; i++) {
		if (A[i] == i) {
			return i;
		}
	}
	
	return found;


} // end match_exh




/*
 * DIVIDE-AND-CONQUER ALGORITHM
 * Returns index i if array A contains an element A[i] such that A[i] = i.
 * If there exist many of such elements, return the index of any one of them.
 * Returns -1 if there exists no element A[i] such that A[i] == i.
 * n is the number of elements A contains.
 *
 * The running time of your algorithm is O( logN ).
 * You may add a brief explanation here if you wish.
 */

public static int match_dac( int[] A, int n )
{

	return modifiedBinary(A, n, 0, n-1);


}  // end match_dac

public static int modifiedBinary(int[] A, int n, int left, int right) {
	int middle = (left + right)/2; 

	if (left > right) {
		//array has been checked at this point and returns nothing
		return -1;
	}
	
	else if (A[middle] == middle) {
		// found solution
		return middle;
	}
	
	else if (A[middle] < middle)  {
		// on the right side of array
		return modifiedBinary(A, n, middle + 1, right);
	}
		
	else if (A[middle] > middle)  {
		// on left right of array
		return modifiedBinary(A, n, left, middle - 1); 
	}
	
	return -1; //did not find a solution
}


} // end class

