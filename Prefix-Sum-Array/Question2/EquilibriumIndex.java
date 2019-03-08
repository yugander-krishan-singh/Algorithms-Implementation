public class EquilibriumIndex {

	public static void getPrefixSumArray(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			arr[i] += arr[i - 1];
		}
	}

	public static int getEquilibriumIndex(int[] arr) {
		getPrefixSumArray(arr);
		int equilibriumIndex = -1;
		for (int i = 1; i < arr.length - 1; i++) {
			int sum1 = arr[i - 1];
			int sum2 = arr[arr.length - 1] - arr[i];
			if (sum1 == sum2) {
				equilibriumIndex = i;
				break;
			}
		}
		return equilibriumIndex;
	}

	public static void main(String[] args) {
		int[] arr = { 12, 3, 4, 5 };
		System.out.print(getEquilibriumIndex(arr));
	}
}
