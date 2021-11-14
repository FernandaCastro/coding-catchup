package com.fcastro.algorithm;

public class ReverseString {
    public static void main(String[] args) {
        ReverseString o = new ReverseString();

        String s = "My name is Alok";
        System.out.println("ReverseStringUsingSplit ('" + s + "'): " + o.reverseStringUsingSplit(s));
        System.out.println("ReverseStringUsingChar('" + s + "'): " + o.reverseStringUsingChar(s));
        System.out.println("ReverseStringUsingStringBuffer('" + s + "'): " + o.reverseStringUsingStringBuffer(s));
    }

    /*Reverse a String
      Input: 'My name is Alok' => Output: 'kolA si eman yM'
      Using String.split()
     */
    String reverseStringUsingSplit(String s){
        if (s == null) return "";
        if (s.length() < 2) return s;

        String output = "";
        String[] string = s.split("");

        for (int i=string.length-1; i>-1; i--){
            output += string[i];
        }
        return output;
    }

    /*Reverse a String
      Input: 'My name is Alok' => Output: 'kolA si eman yM'
      Using StringBuffer
    */
    String reverseStringUsingChar(String s){
        if (s == null) return "";
        if (s.length() < 2) return s;

        String output = "";
        char[] c = s.toCharArray();

        for (int i = c.length - 1; i >= 0; i--)
            output += c[i];

        return output;
    }

    /*Reverse a String
        Input: 'My name is Alok' => Output: 'kolA si eman yM'
        Using StringBuffer
    */
    String reverseStringUsingStringBuffer(String s){
        if (s == null) return "";
        if (s.length() < 2) return s;

        StringBuffer sb = new StringBuffer(s);
        return sb.reverse().toString();
    }
}
