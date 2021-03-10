package mosh.stack;

import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println(reverseString("abcd"));
        System.out.println(checkBalancedText("([a]+[b])"));
        System.out.println(checkBalancedText("]a]+[b])"));
        System.out.println(checkBalancedText("([<a]+[b])"));

    }

    public static Boolean checkBalancedText(String text) {
        ArrayList<Character> openingCharacters = new ArrayList<>();
        openingCharacters.add('(');
        openingCharacters.add('[');
        openingCharacters.add('<');

        ArrayList<Character> closingCharacters = new ArrayList<>();
        closingCharacters.add(')');
        closingCharacters.add(']');
        closingCharacters.add('>');
        Stack<Character> stack = new Stack<>();
        for (char c : text.toCharArray()) {
            if (openingCharacters.contains(c))
                stack.push(c);
            if (stack.isEmpty())
                return false;
            if (closingCharacters.contains(c)) {
                if (stack.isEmpty()) return false;
                var top = stack.pop();
                if (openingCharacters.indexOf(top) !=
                        closingCharacters.indexOf(c))
                    return false;
            }

        }
        return true;
    }

    public static String reverseString(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++)
            stack.push(s.charAt(i));
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++)
            stringBuilder.append(stack.pop());
        return stringBuilder.toString();
    }
}
