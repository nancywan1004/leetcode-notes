// 49. Given an array of strings strs, group the anagrams together. You can return the answer in any order.
// An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

// Input: strs = ["eat","tea","tan","ate","nat","bat"]
// Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

import java.util.*;
// Hashmap to store a hash string mapped to an array of strings that has the same hash(i.e. chars), and then append the values of the map
// TC: O(k * n) (k is length of each string, n is number of strings)
// SC: O(n) (worst case there's no anagram, thus hashmap has n keys)
public class GroupAnagramsSolution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> anagramMap = new HashMap<>();
        for (String s: strs) {
            String key = computeHashString(s);
            anagramMap.putIfAbsent(key, new ArrayList<>());
            anagramMap.get(key).add(s);
        }
        List<List<String>> res = new ArrayList<>();
        for (List<String> val: anagramMap.values()) {
            res.add(val);
        }
        return res;
    } 

    private String computeHashString(String s) {
        char[] count = new char[26];
        for (char c: s.toCharArray()) {
            count[c - 'a']++;
        }
        System.out.println("char count is: " + count);
        return new String(count);
    }

    public static void main(String[] args) {
        GroupAnagramsSolution sol = new GroupAnagramsSolution();
        String[] strs = new String[] {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> res = sol.groupAnagrams(strs);
        System.out.println("grouped anagrams are: " + res);
    }
}
