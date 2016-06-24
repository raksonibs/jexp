package hello;

public class Recursion {
	public	static void	main(String[] args) {
		long n = countZeros(800410L);
		System.out.println(n);
	}
	
	public static int fibCall(int n) {
		if (n==0 || n == 1) {
			return n;
		} else {
			return fibCall(n-1) + fibCall(n-2);
		}
	}
	
	public static int countZeros(long n) {
		if (n == 0) {
			return 1;
		} else if ( n < 10 ) {
			return 0;
		} else {
			boolean lastZero = n %10L == 0;
			if (lastZero) {
				return 1 + countZeros(n / 10L);
			} else {
				return countZeros(n / 10L);
			}
		}
	}
	
	public static int powerN(int n) {
		if (n ==0) {
			return 1;
		} else if (n > 0) {
			return 10 * powerN(n-1);
		} else {
			return 10 / powerN(n);
		}
	}
	
	public static String printN(String s, int n) {
		if (n == 1) {
			return s;
		} else {
			return s + printN(s, n-1);
		}
	}
}
