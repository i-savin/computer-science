package isavin.datastructures;

/**
 * Created by isavin on 09.09.2015.
 */
public class Trie {
    private static class TrieNode {
        private TrieNode[] children = new TrieNode[128];
        private boolean leaf;
    }

    private TrieNode root = new TrieNode();

    public Trie() {

    }

    public void addString(String string) {
        TrieNode currentNode = root;
        for (char c : string.toCharArray()) {
            TrieNode nextNode = currentNode.children[c];
            if (nextNode == null) {
                nextNode = new TrieNode();
                currentNode.children[c] = nextNode;
            }
            currentNode = nextNode;
        }
        currentNode.leaf = true;
    }

    public boolean contains(String string) {
        TrieNode currentNode = root;
        for (char c : string.toCharArray()) {
            TrieNode nextNode = currentNode.children[c];
            if (nextNode == null) {
                return false;
            }
            currentNode = nextNode;
        }
        return currentNode.leaf;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.addString("hello");
        trie.addString("world");
        System.out.println("Trie contains word \"hello\": " + trie.contains("hello"));
        System.out.println("Trie contains word \"hell\": " + trie.contains("hell"));
        System.out.println("Trie contains word \"world\": " + trie.contains("world"));
        System.out.println("Trie contains word \"trie\": " + trie.contains("trie"));
    }
}
