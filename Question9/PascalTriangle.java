import java.util.Arrays;

public class PascalTriangle {

	public static int[] pascalTriangle(int n) {

		if (n == 2) {
			return new int[] { 1, 1 };
		}
		
		// calculate the previous row of pascal traiangle 
		//as value of current row depends on the previous row
		int[] out = pascalTriangle(n - 1);
		
		int[] arr = new int[n];
		
		// First and last element are always 1
		arr[0] = 1;
		arr[n - 1] = 1;
		
		for (int i = 1; i < n - 1; i++) {
			arr[i] = out[i] + out[i - 1];
		}
		
		return arr;
	}

	public static void pascalTraingle(int n) {
		System.out.println(Arrays.toString(pascalTriangle(n)));
	}

	public static void main(String[] args) {
		pascalTraingle(7);
	}
}
