package isavin.datastrustures.list;

import java.util.NoSuchElementException;
import java.util.Iterator;

public class LinkedList {
	private LinkedList next;
	private int item;
	
	public LinkedList(int x) {
		this.item = x;
		this.next = null;
	}
	
	public static LinkedList search(LinkedList list, int x) {
		if (list == null) {
			return null;
		}
		if (list.getItem() == x) {
			return list;
		} else {
			return search(list.getNext(), x);
		}
	}
	
	public static LinkedList insert(LinkedList list, int x) {
		LinkedList l = new LinkedList(x);
		l.setNext(list);
		return l;
	}
	
	public static LinkedList predecessor(LinkedList list, int x) {
		if (list == null || list.getNext() == null) {
			System.out.println("Error: predecessor sought on null list");
			return null;
		}
		if (list.getNext().getItem() == x) {
			return list;
		} else {
			return predecessor(list.getNext(), x);
		}
	}
	
	public static LinkedList reverseList(LinkedList list) {
		LinkedList current = new LinkedList(list.getItem());
		while (list.getNext() != null) {
			list = list.getNext();
			current = insert(current, list.getItem());
		}
		return current;
	}

	public int getItem() {
		return item;
	}

	public void setItem(int item) {
		this.item = item;
	}

	public LinkedList getNext() {
		return next;
	}

	public void setNext(LinkedList next) {
		this.next = next;
	}
	
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList(100);
		for (int i = 99; i > 0; i--) {
			list = insert(list, i);
		}
		
		LinkedList l = list;
		
//		while (l.getNext() != null) {
//			System.out.println(l.getItem());
//			l = l.getNext();
//		}
//		System.out.println(l.getItem());
		
		list = reverseList(list);
		
		l = list;
		
		while (l.getNext() != null) {
			System.out.println(l.getItem());
			l = l.getNext();
		}
		System.out.println(l.getItem());
	}
}

