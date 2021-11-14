package com.fcastro.codility;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/*
class Solution { public int solution(String S); }
Given a string containing words, find the longest word that satisfies specific conditions
    it has to contain only alphanumerical characters (a−z, A−Z, 0−9);
    there should be an even number of letters;
    there should be an odd number of digits.

String S consists of N characters, N is an integer within the range [1..200];
string S consists only of printable ASCII characters and spaces.

Returns the length of the longest valid string found
Returns -1 when a valid string is not found
*/
public class LongestPassword {
    public static void main(String[] args) {
        String s = "test 5 a0A pass007 ?xy1";
        LongestPassword solution = new LongestPassword();
        System.out.println(solution.solution(s));
    }

    public int solution(String S) {
        List<String> passwords =  Arrays.asList(S.split(" "));
        Optional<String> longestPassword = passwords.stream()
                .filter(s -> s.matches("[a-zA-Z0-9]*"))
                .filter(s -> (s.replaceAll("[0-9]", "").length())%2==0)
                .filter(s -> (s.replaceAll("[a-zA-Z]","").length())%2!=0)
                .max(Comparator.comparingInt(String::length));

        if (longestPassword.isEmpty())
            return -1;

        return longestPassword.get().length();
    }
}
