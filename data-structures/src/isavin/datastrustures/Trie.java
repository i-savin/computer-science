package isavin.datastrustures;

import java.util.TreeMap;

public class Trie {
	private TrieNode root = new TrieNode();
	
	private static class TrieNode {
		private boolean leaf;
		TreeMap<Character, TrieNode> children = new TreeMap<>();
		int count = 0;
	}

	public void add(String word) {
		TrieNode current = root;
		for (Character symbol : word.toCharArray()) {
			TrieNode next = current.children.get(symbol);
			if (next == null) {
				next = new TrieNode();
				current.children.put(symbol, next);
			}
			current = next;
		}
		current.leaf = true;
		current.count++;
	}
	
	public boolean remove(String word) {
		TrieNode current = root;
		for (Character symbol : word.toCharArray()) {
			TrieNode next = current.children.get(symbol);
			if (next == null) {
				return false;
			}
			current = next;
		}
		if (current.leaf) {
			current.leaf = false;
			current.count = 0;
			return true;
		}
		return true;
	}
	
	public void print() {
		printTrie(root, "");
	}

	private void printTrie(TrieNode root, String s) {
		if (root.leaf) {
			System.out.println(s +  "----------------" + root.count);
		}
		for (Character letter : root.children.keySet()) {
			TrieNode children = root.children.get(letter);
			if (children != null) {
				printTrie(children, s + letter);
			}
		}
	}

	public static void main(String[] args) {
		
	}
}
