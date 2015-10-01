package isavin.datastructures;

/**
 * Created by isavin on 09.09.2015.
 */
public class SuffixLinkTrie {
    private static class TrieNode {
        //�������� ����
        private TrieNode[] children = new TrieNode[128];
        //����?
        private boolean leaf;
        //������, �������������� ����� �����
        private String text;
        //������ �� ��������
        private TrieNode parent;
        //������, �� �������� ����� ������� �� �������� � �������
        private char fromParentChar;
        //���������� ������
        private TrieNode link;
        //������� ���������� ������
        private TrieNode flink;
        //����������� �������� ��������
        private TrieNode[] transitions = new TrieNode[128];

        private TrieNode() {}

        private TrieNode(TrieNode parent, char fromParentChar) {
            this.parent = parent;
            this.fromParentChar = fromParentChar;
        }
    }

    private TrieNode root = new TrieNode();

    public SuffixLinkTrie() {

    }

    public void addString(String string) {
        TrieNode currentNode = root;
        for (char c : string.toCharArray()) {
            TrieNode nextNode = currentNode.children[c];
            if (nextNode == null) {
                nextNode = new TrieNode(currentNode, c);
                currentNode.children[c] = nextNode;
            }
            currentNode = nextNode;
        }
        currentNode.text = string;
        currentNode.leaf = true;
    }

    private TrieNode getSuffixLink(TrieNode node) {
        if (node.link == null) {
            if (node == root || node.parent == root) {
                node.link = root;
            } else {
                node.link = getTransition(getSuffixLink(node.parent), node.fromParentChar);
            }
        }
        return node.link;
    }

    private TrieNode getTransition(TrieNode node, char fromParentChar) {
        if (node.transitions[fromParentChar] == null) {
            if (node.children[fromParentChar] != null) {
                node.transitions[fromParentChar] = node.children[fromParentChar];
            } else {
                if (node == root) {
                    node.transitions[fromParentChar] = root;
                } else {
                    node.transitions[fromParentChar] = getTransition(getSuffixLink(node), fromParentChar);
                }
            }
        }
        return node.transitions[fromParentChar];
    }

    private TrieNode getSuffixFLink(TrieNode node) {
        if (node.flink == null) {
            TrieNode suffixLink = getSuffixLink(node);
            if (suffixLink == root) {
                node.flink = root;
            } else {
                node.flink = suffixLink.leaf ? suffixLink : getSuffixFLink(suffixLink);
            }
        }
        return node.flink;
    }

    private void check(TrieNode node) {
        for (TrieNode n = node; n != root; n = getSuffixFLink(n)) {
            if (n.leaf) {
                System.out.println(n.text);
            }
        }
    }

    public static void main(String[] args) {
        SuffixLinkTrie trie = new SuffixLinkTrie();
        trie.addString("bcdc");
        trie.addString("abc");
        trie.addString("cccb");
        trie.addString("bcdd");
        trie.addString("bbbc");
        String s = "abcdcbcddbbbcccbbbcccbb";
        TrieNode transition = trie.root;
        for (char ch : s.toCharArray()) {
            transition = trie.getTransition(transition, ch);
            trie.check(transition);
        }
    }
}
