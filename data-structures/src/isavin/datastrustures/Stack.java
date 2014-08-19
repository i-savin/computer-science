package isavin.datastrustures;

import java.util.EmptyStackException;

public class Stack {
	private static final int DEFAULT_INITIAL_CAPACITY = 10;
	private char[] content;
	private int size;
	
	public Stack() {
		this(DEFAULT_INITIAL_CAPACITY);
	}
	
	public Stack(int size) {
		this.content = new char[size];
		size = 0;
	}
	
	public void push(char x) {
		
		if (size == content.length) {
			int newSize = size * 2;
			char[] tempArray = new char[newSize];
			System.arraycopy(content, 0, tempArray, 0, size);
			content = tempArray;
		}
		
		content[size++] = x;
	}
	
	public char pop() {
		if (size == 0) {
			throw new EmptyStackException();
		}
		return content[--size];
	}
	
	public boolean isEmpty() {
		return size == 0;
	}

}
