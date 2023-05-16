// Given two strings s and t, return true if t is an anagram of s, and false otherwise.
// An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

// Using an array to store character occurrences of two strings and see if the occurrences are all zeros
// TC: O(n)
// SC: O(1)
public class ValidAnagramSolution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        
        // storing the occurrences of all 26 characters
        int[] store = new int[26];
        for (int i = 0; i < s.length(); i++) {
            // increment string s current character's occurrence count by 1
            store[s.charAt(i) - 'a'] ++;
            // decrement string t current character's occurrence count by 1
            store[t.charAt(i) - 'a'] --;
        }

        // character occurrences should cancel out if it's a valid anagram, thus non-zero means non-valid anagram
        for (int n: store) {
            if (n != 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        ValidAnagramSolution sol = new ValidAnagramSolution();
        String s1 = "anagram";
        String s2 = "nagaram";
        boolean res = sol.isAnagram(s1, s2);
        System.out.printf("Are" + s1 + " and " + s2 + " valid anagram: " + res);
    }
}
