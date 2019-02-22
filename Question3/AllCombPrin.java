import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AllCombPrinImp {

	private static final Logger LOGGER = Logger.getLogger(AllCombPrinImp.class.getName());
	
	public static void print(double sum, double prev, String digits, double target, String expression) {

		if (digits.length() == 0) {
			if (sum + prev == target)
				System.out.println(expression);
		} else {
			for (int j = 1; j <= digits.length(); j++) {
				String current = digits.substring(0, j);
				String rem = digits.substring(j);
				
				print(sum+prev, Double.parseDouble(current), rem, target, expression+"+"+current);
				print(sum, prev*Double.parseDouble(current), rem, target, expression+"*"+current);
				//print(sum+prev, Double.parseDouble(nextDig), rem, target, expression+"+"+nextDig);
				print(sum+prev, -Double.parseDouble(current), rem, target, expression+"-"+current);
			}
		}
	}

	public static void print(String digits, double target) {
		for (int i = 0; i < digits.length(); i++) {
			for (int j = i + 1; j <= digits.length(); j++) {
				String current = digits.substring(i, j);
				String rem = digits.substring(j);
				print(0, Double.parseDouble(current), rem, 6, current);
			}
		}
	}

	public static void main(String[] args) {
		BufferedReader bs = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		try {
			input = bs.readLine();
		}catch(IOException e) {
			LOGGER.log(Level.INFO, "Excpetion while taking the input", e);
		}
		print(input,6);
	}
}
