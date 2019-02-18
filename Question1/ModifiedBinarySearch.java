```
public class ModifiedBinarySearch {

	public static int binarySearch(int[] arr, int val) {
		int start = 0;
		int end = arr.length - 1;

		if (val < arr[start])
			return -1;
		else if (val > arr[end])
			return (end + 2) * -1;

		while (start < end) {
			int mid = (start + end) / 2;
			if (arr[mid] == val)
				return mid;
			else if (arr[mid] < val)
				start = mid + 1;
			else if (arr[mid] > val)
				end = mid - 1;
		}

		if (val < arr[start])
			return (start+1) * -1;
		else if (val > arr[start])
			return (start + 2) * -1;

		return 0;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 9, 18, 21, 29, 50 };

		System.out.println(ModifiedBinarySearch.binarySearch(arr, -5));

	}
}
```
