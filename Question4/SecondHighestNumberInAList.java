import java.util.Arrays;
import java.util.List;
import static java.lang.System.out;

public class SecondHighestNumberInAList {

	private static boolean isGreater(int x, int y) {
		return x>y;
	}
	
	public static void printSecondHighest(List<Integer> list) {
		int f = list.get(0); int s = list.get(1);
		
		if(isGreater(s, f)) {
			int temp  =f;
			f= s;
			s=temp;
		}
		for(int i=2;i<list.size();i++) {
			int currentListEle = list.get(i);
			if(isGreater(currentListEle, f)) {
				s= f;
				f = currentListEle;
			}else if(isGreater(currentListEle, s)) {
				s = currentListEle;
			}			
		}
		out.println(f+","+s);
	}
	
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(26,2,50,48,8,29);
		printSecondHighest(list);
	}
	
}
