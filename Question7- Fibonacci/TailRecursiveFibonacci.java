public class TailRecursiveFibonacci {

	public static int helper(int a, int b, int n) {
		if (n == 1)
			return a + b;
		return helper(b, a + b, n - 1);
	}

	public static int fib(int n) {
		if (n == 1 || n == 2)
			return 1;
		return helper(1, 1, n - 2);
	}

	public static void main(String[] args) {
		final long startTime = System.nanoTime();
		System.out.println(fib(30));
		final long duration = System.nanoTime() - startTime;
		System.out.println("Time = "+duration);
	}
}
