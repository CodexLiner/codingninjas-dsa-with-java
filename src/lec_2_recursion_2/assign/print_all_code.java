package lec_2_recursion_2.assign;
/*Print all Codes - String
        Send Feedback
        Assume that the value of a = 1, b = 2, c = 3, ... , z = 26. You are given a numeric string S. Write a program to print the list of all possible codes that can be generated from the given string.
        Note : The order of codes are not important. Just print them in different lines.
        Input format :
        A numeric string S
        Output Format :
        All possible codes in different lines
        Constraints :
        1 <= Length of String S <= 10
        Sample Input:
        1123
        Sample Output:
        aabc
        kbc
        alc
        aaw
        kw*/
public class print_all_code {
    public static void printAllPossibleCodes(String input) {
        printAllPossibleCodes(input , new String(""));
    }
    public static void printAllPossibleCodes(String input, String output) {
        if (input.length()==0){
            System.out.println(output);
            return;
        }
        char s = mainer(input.charAt(0) - '0');
        printAllPossibleCodes(input.substring(1), output+s);
        if (input.length()>=2){
            int ch1 = input.charAt(0) -'0';
            int ch2 = input.charAt(1) -'0';
            int x = (ch1* 10) + ch2;

            if (x >= 10 && x<= 26){
                char s1 = mainer(x);
                printAllPossibleCodes(input.substring(2) , output+s1);
            }
        }

    }

    public static char mainer(int c) {
        return (char) ('a'+ c - 1);
    }
}
