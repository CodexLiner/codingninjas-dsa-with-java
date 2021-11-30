package lec_2_recursion_2.assign;
/*Print Permutations
        Send Feedback
        Given an input string (STR), print all possible permutations of the input string.
        Note:
        The input string may contain the same characters, so there will also be the same permutations.
        The order of permutations doesn’t matter.
        Input Format:
        The only input line contains a string (STR) of alphabets in lower case
        Output Format:
        Print each permutations in a new line
        Note:
        You do not need to print anything, it has already been taken care of. Just implement the function.
        Constraint:
        1<=length of STR<=8
        Time Limit: 1sec
        Sample Input 1:
        cba
        Sample Output 1:
        abc
        acb
        bac
        bca
        cab
        cba*/
public class print_permuations {

    public static void FindPermutations(String str) {
        FindPermutations(str , str.length(), "");

    }
    public static void FindPermutations(String str ,int index,  String output) {
        if (str.length()==0 || index == 0){
            System.out.println(output);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            String s = str.substring(0 , i ) + str.substring(i+1);
            FindPermutations(s , index - 1 , output+str.charAt(i));
        }

    }
}
