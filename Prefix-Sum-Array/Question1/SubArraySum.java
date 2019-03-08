import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class SubArraySum {

	public static int countSubArraysWithSum(int[] arr, int requiredSum) {
		Map<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (sum == requiredSum)
				count += 1;
			
			int greater = sum - requiredSum;
			if (map.containsKey(greater)) {
				count += map.get(greater);
			}
			
			if (!map.containsKey(sum)) {
				map.put(sum, 1);
			} else {
				map.put(sum, map.get(sum) + 1);
			}
			
		}
		System.out.println(map);
		return count;
	}

	public static void main(String[] args) {
		int[] arr = { 10, 2, -2, -20, 10 };
		System.out.print(countSubArraysWithSum(arr, 0));
	}
}
