package com.fcastro.codility;

public class PalindromeNumber {

    public static void main(String[] args) {
        isPalindrome(123);
    }

    public static boolean isPalindrome(int num) {
        if (num < 0) {
            return false;
        }

        int r, sum = 0, temp;

        temp = num;
        while (num > 0) {
            r = num % 10;  //getting remainder
            sum = (sum * 10) + r;
            num = num / 10;
        }
        if (temp == sum) {
            System.out.println(temp + " is a palindrome number ");
            return true;
        }
        System.out.println(temp + " is not palindrome");
        return false;
    }
}
