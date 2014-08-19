package isavin.datastrustures.exercises;

import java.util.EmptyStackException;

import isavin.datastrustures.Stack;

public class StackExercises {

	public static boolean isParenthesesBalanced(String text) {
		Stack stack = new Stack(text.length());
		
		for (int i = 0; i < text.length(); i++) {
			if ('(' == text.charAt(i)) {
				stack.push(text.charAt(i));
			} else if (')' == text.charAt(i)) {
				try {
					char x = stack.pop();
					if (x != '(') {
						return false;
					}
				} catch (EmptyStackException e) {
					return false;
				}
			} else {
				return false;
			}
		}
		
		if (stack.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(isParenthesesBalanced(")()("));
	}
}
