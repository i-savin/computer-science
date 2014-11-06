package isavin.datastrustures.exercises;

import isavin.datastrustures.Trie;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TrieGenerator {
	
	private final static String DELIMETERS = ",.;:'!?- []{}/\\|><\"\t";
	
	public static void main(String[] args) throws IOException {
		
		checkInput(args);
		
		BufferedReader br = new BufferedReader(new FileReader(args[0]));;
		Trie trie = new Trie();
		try {
			List<String> words = parseFile(br);
//			for (String word : words) {
//				trie.insertString(word);
//			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			br.close();
		}
		trie.add("employ");
		trie.add("empty");
		trie.add("employment");
		trie.add("empl");
		trie.add("emp");
		trie.add("empoyl");
		trie.print();
		String wordToDelete = "engine";
		System.out.println("Delete " + wordToDelete + ": " + trie.remove(wordToDelete));
		trie.print();
	}
	
    public static void checkInput(String[] args)
            throws FileNotFoundException {
    if (args.length < 1 || args.length > 2) {
        System.out.println("Usage: java Dictionary sourcefile [outputfile]");
        System.out.println("\tsourcefile - file with text to be counted");
        System.out.println("\toutputfile (optional) - file"
                           + " to write dictionary");
        System.out.println("Without <outputfile> parameter text will be " +
                            "displayed on screen only");
        System.exit(1);
    }
}

    public static List<String> parseFile(BufferedReader inputFile) 
                throws IOException {
        String line;
        StringTokenizer stringToken;
        List<String> words = new ArrayList<>();
        
        while ((line = inputFile.readLine()) != null) {
            stringToken = new StringTokenizer(line, DELIMETERS);
            words.addAll(parseLine(stringToken));
        }
        inputFile.close();
        return words;
    }
    
    /**
     * Method to parse each line of the source file. 
     * On each word invokes <code>addToDictionary</code> method and
     * increases <code>wordsCount</code> field.
     *
     * @param stringToken <code>StringTokenizer</code> object containing
     *                      the line of file
     */
    private static List<String> parseLine(StringTokenizer stringToken) {
        String word;
        List<String> words = new ArrayList<>();
        while (stringToken.hasMoreTokens()) {
            word = stringToken.nextToken().toLowerCase();
            words.add(word);
        }
        return words;
    }
}
