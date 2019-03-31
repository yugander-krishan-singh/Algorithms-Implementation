import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Testing123 {

	static int getCountOfPossibleTeams(List<Integer> coders) {
		int count = 0;
		for (int i = 0; i < coders.size() - 2; i++) {

			for (int j = i + 1; j < coders.size() - 1; j++) {

				for (int k = j + 1; k < coders.size(); k++) {
					if (coders.get(i) < coders.get(j) && coders.get(j) < coders.get(k)) {
						System.out.println(coders.get(i) + "  " + coders.get(j) + "  " + coders.get(k));
						count++;
					}

					else if (coders.get(i) > coders.get(j) && coders.get(j) > coders.get(k)) {
						System.out.println(coders.get(i) + "  " + coders.get(j) + "  " + coders.get(k));
						count++;
					}
				}

			}

		}
		return count;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		int codersCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<String> codersTemp = new ArrayList<>();

		IntStream.range(0, codersCount).forEach(i -> {
			try {
				codersTemp.add(bufferedReader.readLine().replaceAll("\\s+$", ""));
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		List<Integer> coders = codersTemp.stream().map(String::trim).map(Integer::parseInt)
				.collect(Collectors.toList());

		int res = getCountOfPossibleTeams(coders);

		/*
		 * bufferedWriter.write(String.valueOf(res)); bufferedWriter.newLine();
		 */

		bufferedReader.close();
		// bufferedWriter.close();
		System.out.println(res);
	}

}
