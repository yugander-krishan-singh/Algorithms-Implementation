public class TailRecursiveFibonacci {

	public static int helper(int a, int b, int n, Integer[] memo) {
		if (n == 1)
			return a + b;
		
		if(memo[n] != null) return memo[n];
		else {
			memo[n] = helper(b, a + b, n - 1, memo);
		}
		
		return memo[n];
	}

	public static int fib(int n) {
		if (n == 1 || n == 2)
			return 1;
		
		Integer[] memo = new Integer[n+1];
		
		return helper(1, 1, n - 2, memo);
	}

	public static void main(String[] args) {
		final long startTime = System.nanoTime();
		System.out.println(fib(9));
		final long duration = System.nanoTime() - startTime;
		System.out.println("Time = "+duration);
	}
}
