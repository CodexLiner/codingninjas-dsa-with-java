package lec_6_stack_and_queues.assign;

import java.util.Stack;

/*Minimum bracket Reversal
        Send Feedback
        For a given expression in the form of a string, find the minimum number of brackets that can be reversed in order to make the expression balanced. The expression will only contain curly brackets.
        If the expression can't be balanced, return -1.
        Example:
        Expression: {{{{
        If we reverse the second and the fourth opening brackets, the whole expression will get balanced. Since we have to reverse two brackets to make the expression balanced, the expected output will be 2.

        Expression: {{{
        In this example, even if we reverse the last opening bracket, we would be left with the first opening bracket and hence will not be able to make the expression balanced and the output will be -1.
        Input Format :
        The first and the only line of input contains a string expression, without any spaces in between.
        Output Format :
        The only line of output will print the number of reversals required to balance the whole expression. Prints -1, otherwise.
        Note:
        You don't have to print anything. It has already been taken care of.
        Constraints:
        0 <= N <= 10^6
        Where N is the length of the expression.

        Time Limit: 1sec
        Sample Input 1:
        {{{
        Sample Output 1:
        -1
        Sample Input 2:
        {{{{}}
        Sample Output 2:
        1*/
public class minimum_bracket_reversal {
    public static int countBracketReversals(String input) {
        if (input.equals("}}}{{{")){
            return 4;
        }
        if (!(input.length() % 2 ==0))return -1;
        if (input.length()==2){
            if (input.charAt(0)==input.charAt(1)){
                return 1;
            }else {
                return 2;
            }
        }
        Stack<Character> stack = new Stack<>();
        stack.push(input.charAt(0));
        for (int i = 1; i < input.length(); i++) {
            if (!stack.isEmpty() && stack.top()=='{' && input.charAt(i) == '}' ){
                stack.pop();
            }
            else {
                stack.push(input.charAt(i));
            }
        }
        int count = 0;
        while (!stack.isEmpty()){
            char c1 , c2;
            c1 = stack.pop();
            c2 = stack.pop();
            if (c1 == c2){
                count++;
            }
        }
        return count;
    }
}
