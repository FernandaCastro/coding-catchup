package com.fcastro.codility;

import java.util.HashMap;
import java.util.Map;

/*
Given a string s, find the length of the longest substring without repeating characters.

Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

Constraints:
0 <= s.length <= 5 * 10?4
s consists of English letters, digits, symbols and spaces.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args){
        var o = new LongestSubstringWithoutRepeatingCharacters();

        System.out.println("abcabcbb  expected:3 => " + o.lengthOfLongestSubstring("abcabcbb"));
        System.out.println("bbbbb  expected:1 => " + o.lengthOfLongestSubstring("bbbbb"));
        System.out.println("pwwkew  expected:3 => " + o.lengthOfLongestSubstring("pwwkew"));
        System.out.println("\" \"  expected:1 => " + o.lengthOfLongestSubstring(" "));
        System.out.println("dvdf  expected:3 => " + o.lengthOfLongestSubstring("dvdf"));
        System.out.println("bbtablud  expected:6 => " + o.lengthOfLongestSubstring("bbtablud"));

    }

    public int lengthOfLongestSubstring_passed(String s) {

        if (s == null || s.isEmpty()) return 0;

        StringBuffer sb = new StringBuffer();
        int curr = 0, longest = 0, start = 0, end = 0;

        for (int i=0; i < s.length(); i++){

            var c = String.valueOf(s.charAt(i));
            int idx = sb.indexOf(c, start);
            sb.append(c);

            if( idx == -1) {
                curr++;

            } else{
                start = idx + 1 ;
                longest = longest < curr ? curr : longest;

                if (i + 1 < s.length())
                    curr = sb.indexOf(String.valueOf(s.charAt(i+1)), start) == -1 ? i - idx : 1;
            }
        }

        longest = longest < curr ? curr : longest;
        return longest;
    }

    public int lengthOfLongestSubstring(String s) {

        if (s == null || s.isEmpty()) return 0;

        int curr = 0, longest = 0, start = 0;

        for (int i=0; i < s.length(); i++){

            int idx = s.substring(0, i).indexOf(s.charAt(i), start);

            if( idx == -1) curr++;
            else{
                start = idx + 1 ;
                longest = longest < curr ? curr : longest;

                if (i + 1 < s.length())
                    curr = s.charAt(i) != s.charAt(i+1) ? i - idx : 1;
            }
        }

        longest = longest < curr ? curr : longest;
        return longest;
    }


    public int lengthOfLongestSubstring_BruteForce(String s) {
        if (s == null || s.isEmpty()) return -1;

        StringBuffer sb = new StringBuffer();

        int start = -1, end = -1;

        for (int i=0; i < s.length(); i++){

            var c = String.valueOf(s.charAt(i));
            int idx = sb.indexOf(c, end);
            if( idx == -1) {
                if (start == -1) sb.append(c);
                else break;
            }
            else{
                start = start == -1 ? idx : start;
                end = idx;
            }
        }

        return end - start + 1;
    }
}
