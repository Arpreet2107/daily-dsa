package LongestSubstring;
//Longest Substring Without Repeating Characters:
//    Problem: Find the length of the longest substring without repeating characters in a given string
import java.util.*;

public class LongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            if (charMap.containsKey(s.charAt(right))) {
                left = Math.max(charMap.get(s.charAt(right)) + 1, left);
            }
            charMap.put(s.charAt(right), right);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String s = sc.nextLine();  // Read the input string

            System.out.println(lengthOfLongestSubstring(s));  
        }
    }
}
