package com.fcastro.codility;

import java.util.HashMap;
import java.util.Stack;

public class Brackets {

    public static void main(String[] args) {
        var o = new Brackets();
        System.out.println("() true => "+ o.isValid("()"));
        System.out.println("()[]{} true => "+ o.isValid("()[]{}"));
        System.out.println("(] false => "+ o.isValid("(]"));
        System.out.println("({[]}) true => "+ o.isValid("({[]})"));
        System.out.println("){ false => "+ o.isValid("){"));
        System.out.println("(}{) false => "+ o.isValid("(}{)"));
        System.out.println("(([]){}) true => "+ o.isValid("(([]){})"));
        System.out.println("({{{{}}})) false => "+ o.isValid("({{{{}}}))"));
    }

    //Time Complexity: O(n)
    //Space complexity:
    public boolean isValid(String s) {
        if (s.length() <= 1) return false;
        if (s.length() % 2 > 0) return false;

        Stack<Character> brackets = new Stack<>();

        var leftBrackets = new HashMap<Character, Character>();
        leftBrackets.put('(', ')');
        leftBrackets.put('[', ']');
        leftBrackets.put('{', '}');

        for (int i = 0; i < s.length(); i++) {

            var bracket = s.charAt(i);

            //Push the corresponding right bracket to the stack
            if (leftBrackets.get(bracket) != null){
                brackets.push(leftBrackets.get(bracket));

            }else{
                //Right bracket in an empty stack is invalid. It means starting sequence with a right bracket.
                if (brackets.isEmpty()) return false;

                //Pop right bracket when it matches the bracket in the loop.
                if (brackets.peek() == bracket)
                    brackets.pop();
                else
                    //A right bracket not matching the top in the stack, means invalid sequence
                    return false;
            }
        }

        if (brackets.isEmpty())
            return true;

        return false;
    }

    //I gave up of this approach. It's clearly the wrong way to go.
    public boolean isValidBruteForce(String s) {
        if (s.length() == 1) return false;
        if (s.length() % 2 > 0) return false;

        var brackets = new HashMap<Character, Character>();
        brackets.put('(',')');
        brackets.put('{','}');
        brackets.put('[',']');
        brackets.put(')','(');
        brackets.put('}','{');
        brackets.put(']','[');

        for (int i=0; i < s.length(); i++){

            var otherBracket = brackets.get(s.charAt(i));

            var isOpenBracket = "({[".indexOf(s.charAt(i)) > -1 ? true : false;

            var idxOtherBracket = s.indexOf(otherBracket);

            //The otherBracket doesn't exist
            if ( idxOtherBracket == -1 ) return false;

            if (isOpenBracket){
                //The close bracket is before the open bracket
                if (idxOtherBracket < i) return false;

                //The other bracket is not in the expected position
                var atExpectedPosition = s.charAt(s.length() - 1 - i);

                int j = i + 1;
                boolean isAtExpectedPosition = false;
                while( j < s.length() && isAtExpectedPosition == false){
                    if (s.charAt(j) == otherBracket) isAtExpectedPosition = true;
                    j = j + 2;
                }

                if (idxOtherBracket != i + 1 && !isAtExpectedPosition  && atExpectedPosition != otherBracket) return false;
            }


            if (!isOpenBracket){
                //The open bracket is after the close bracket
                if (idxOtherBracket > i ) return false;

                int j = i - 1;
                boolean isAtExpectedPosition = false;
                while( j < 0 && isAtExpectedPosition == false){
                    if (s.charAt(j) == otherBracket) isAtExpectedPosition = true;
                    j = j - 2;
                }
                if (idxOtherBracket != i - 1 && !isAtExpectedPosition) return false;
            }
        }

        return true;
    }
}
