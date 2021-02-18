package poc.basic;

import java.util.Map;
import java.util.Stack;

public class RunParenthesisChecker {

    private static boolean isMatchingParentesis(String input) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> blockSymbols = Map.of(')', '(', ']', '[', '>', '<');
        for (char ch : input.toCharArray()) {
            //System.out.println(stack + "::" + ch);
            if (blockSymbols.containsValue(ch)) {
                stack.push(ch);
            } else if (blockSymbols.containsKey(ch) && (stack.isEmpty() || blockSymbols.get(ch) != stack.pop())) {
                //System.out.println("encountered an open block!");
                return false;
            }
        }
        //System.out.println("Out of:: "+stack);
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        //Success cases
        System.out.println(isMatchingParentesis("(<[ ]>)"));
        System.out.println("-------");
        System.out.println(isMatchingParentesis("[<incre>ment]"));
        System.out.println("-------");
        System.out.println(isMatchingParentesis("<increment>"));
        System.out.println("-------");
        System.out.println(isMatchingParentesis("()incre<>ment<>"));
        System.out.println("-------");
        //Failure cases
        System.out.println(isMatchingParentesis("<increment("));
        System.out.println("-------");
        System.out.println(isMatchingParentesis("[)increment("));
        System.out.println("-------");
        System.out.println(isMatchingParentesis("<incr>ement())"));
        System.out.println("-------");
        System.out.println(isMatchingParentesis("(<increment>"));
    }
}
