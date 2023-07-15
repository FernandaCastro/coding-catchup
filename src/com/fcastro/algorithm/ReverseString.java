package com.fcastro.algorithm;

public class ReverseString {
    public static void main(String[] args) {
        ReverseString o = new ReverseString();

        String s = "My name is Alok";
        System.out.println("ReverseStringUsingStringBuffer: " + o.reverseStringUsingStringBuffer(s));
    }

    /*Reverse a String
        Input: 'My name is Alok' => Output: 'kolA si eman yM'
        Using StringBuffer
    */
    String reverseStringUsingStringBuffer(String s){
        if (s == null) return "";
        if (s.length() < 2) return s;

        StringBuffer output = new StringBuffer();
        for (int i = s.length() - 1; i >= 0; i--)
            output.append(s.charAt(i));

        return output.toString();
       // return sb.reverse().toString();
    }

    String reverseStringRecursively(String string){
        if (string.length() > 1){
            return reverseStringRecursively(string.substring(string.length()-1, 0));
        }
        return string;
    }
}
