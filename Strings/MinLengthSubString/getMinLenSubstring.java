import java.util.*;

public class MinLengthSubstring {

	public static int getMinLenSubstring(String input) {
		int count = 0;
		Set<Character> set = new HashSet<>();
		for(Character c:input.toCharArray()) {
			set.add(c);
		}
		
		count = set.size();
		
		int start_index=0;
		int start=-1;
		
		int min_length = Integer.MAX_VALUE;
		
		Map<Character, Integer> map = new HashMap<>();
		
		for(int i=0;i<input.length();i++) {
			Character c = input.charAt(i);
			if(!map.containsKey(c)) {
				map.put(c,1);
			}else {
				map.put(c,map.get(c)+1);
			}
			
			if(map.keySet().size() == count) {
				while(map.get(input.charAt(start_index))>1) {
					map.put(input.charAt(start_index),map.get(input.charAt(start_index))-1);
					start_index+=1;					
				}
				int len = i-start_index+1;
				if(len<min_length) {
					min_length = len;
				}				
			}
		}
		
		return min_length;
	}
	
	public static void main(String... args) {
		String input = "GEEKSGEEKSFOR";
		System.out.println(getMinLenSubstring(input));
	}
}
