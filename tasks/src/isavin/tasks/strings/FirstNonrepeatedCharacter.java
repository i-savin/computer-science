package isavin.tasks.strings;

import java.util.Map;
import java.util.HashMap;

/**
 * Write an efficient function to find the first nonrepeated character in a string. For
 * instance, the first nonrepeated character in "total" is 'o' and the first nonrepeated
 * character in "teeter" is 'r'. Discuss the efficiency of your algorithm.
 */
public class FirstNonrepeatedCharacter {
	
	public static void main(String[] args) {
		String str = "www";
		System.out.println(str + ": " + removeFirstNonrepeatedChar(str));
	}
	
	public static Character removeFirstNonrepeatedChar(String str) {
		Map<Character, Boolean> charactersMap = new HashMap<>();
		//scan input string, put char into hashmap<char, boolean>
		//where value is true if character was met only once
		for (char c : str.toCharArray()) {
			if (charactersMap.get(c) == null) {
				charactersMap.put(c, true);
			} else {
				charactersMap.put(c, false);
			}
		}
		
		//scan input string char-by-char, if char is in map with value true, return it
		//complexity O(n) (n = str.length())
		for (char c : str.toCharArray()) {
			if (charactersMap.get(c)) {
				return c;
			}
		}

		return null;
	}
}
