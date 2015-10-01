package isavin.tasks.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Write an efficient function in C# that deletes characters from a string. Use the prototype
 * string removeChars( string str, string remove );
 * where any character existing in remove must be deleted from str. For example,
 * given a str of "Battle of the Vowels: Hawaii vs. Grozny" and a remove of "aeiou",
 * the function should transform str to "Bttl f th Vwls: Hw vs. Grzny". Justify any
 * design decisions you make and discuss the efficiency of your solution.
 */
public class RemoveCharacters {

    public static void main(String[] args) {
        System.out.println(removeChars("Battle of the Vowels: Hawaii vs. Grozny", "aeiou"));
    }

    public static String removeChars(String str, String remove) {
        char[] chars = str.toCharArray();
        Map<Character, Object> removeMap = new HashMap<>();

        for (char c : remove.toCharArray()) {
            removeMap.put(c, new Object());
        }

        int destination = 0;


        for (int source = 0; source < chars.length; source++) {
            if (removeMap.get(str.charAt(source)) == null) {
                chars[destination] = chars[source];
                destination++;
            }
        }

        return new String(chars, 0, destination);
    }
}
