import java.util.Arrays;

public class AllNumbersCombsREcursively {

	/**
	 * Calls the overloaded print function by fixing element at first index of out
	 * array and leaving the task of filling remaining elements on the overloaded
	 * print function
	 * 
	 * @param givenArr
	 * @param size
	 */
	public static void print(int[] givenArr, int size) {
		int[] out = new int[size];
		
		/*
		 * Fix and recur approach. Fixing one element at index 0 of out array and then
		 * recurring for remaining indexes by overloaded print function.
		 */
		for(int i=0;i<givenArr.length;i++) {
			out[0] = givenArr[i];
			if(i+1<givenArr.length) print(givenArr, i+1, out, 1);
		}
	}
	
	/**
	 * Recursively calls itself for filling the out array till it's filled with
	 * elements up to it's limit
	 * 
	 * @param input
	 * @param pos
	 * @param out
	 * @param index
	 */
	public static void print(int[] input, int pos, int[] out, int index) {
		
		/*
		 * Base Condition so that recursion stops
		 */
		if(index == out.length) {System.out.println(Arrays.toString(out));return;}		
		
		/*
		 * There arn't enough elements left to fill the out array
		 */
		if(input.length-pos<out.length-index) return;		
		
		for(int j=pos;j<input.length;j++) {
			out[index] = input[j];
			print(input, j+1, out, index+1);
		}		
	}
	
	public static void main(String[] args) {
		int[] givenArr = {1,2,3,4,5};
		print(givenArr, 3);
	}	
}
