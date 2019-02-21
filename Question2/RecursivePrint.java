import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;;

public class RecursivePrint {

	public static void print(int diff, char[] out, int start, int end) {
		
		if(Math.abs(diff)>(end-start+1)/2) return;
		if(start > end) {
			if(diff ==0) {
				System.out.println(Arrays.toString(out));
				System.out.println();
			}
		}
		
		out[start]='0'; out[end] ='0';
		print(diff, out, start+1, end-1);
		
		out[start] ='1'; out[end]='1';
		print(diff, out, start+1, end-1);
		
		out[start] ='0'; out[end]='1';
		print(diff-1, out, start+1, end-1);
		
		out[start]='1'; out[end]='0';
		print(diff+1, out, start+1, end-1);
		
	}
	
	public static void print(int n) {
		char[] out = new char[2*n];
		print(0, out, 0, out.length-1);
	}

	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = 0;
		try {
			n = Integer.valueOf(reader.readLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		print(n);
	}
}
