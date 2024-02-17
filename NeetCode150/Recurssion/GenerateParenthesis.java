package Recurssion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        if (n <= 0) return null;
        List<String> result = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        backtrack(0, 0, n, result, stack);
        return result;
    }

    private void backtrack(int openCount, int closedCount, int totalCount, List<String> result, Stack<Character> stack) {
        if(openCount == closedCount && openCount == totalCount) {
            result.add(stack.stream().map(a -> a.toString()).collect(Collectors.joining("")));
            return;
        }

        if (openCount < totalCount) {
            stack.push('(');
            backtrack(openCount+1, closedCount, totalCount, result, stack);
            stack.pop();
        }

        if (closedCount < openCount) {
            stack.push(')');
            backtrack(openCount, closedCount+1, totalCount, result, stack);
            stack.pop();
        }
    }

    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        System.out.println(generateParenthesis.generateParenthesis(3));
    }
}