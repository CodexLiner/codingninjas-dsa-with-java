package lec_2_recursion_2.assign;
/*Return all codes - String
        Send Feedback
        Assume that the value of a = 1, b = 2, c = 3, ... , z = 26. You are given a numeric string S. Write a program to return the list of all possible codes that can be generated from the given string.
        Note : The order of codes are not important. And input string does not contain 0s.
        Input format :
        A numeric string
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
public class return_codeString {
    // Return a string array that contains all possible codes
    public static  String[] getCode(String input){
        return getCode(input , 0 , "");
    }
    public static  String[] getCode(String input , int index , String output){
        if (input.length() == 0){
//            System.out.println(index);
            String[] a = new String[1];
            a[0] = output;
            return a;
        }
        char ch = mainer(input.charAt(0) -'0');
        String[] temp = getCode(input.substring(1), index + 1, output+ch);
        if (input.length() >= 2){
            int ch1 = input.charAt(0) - '0';
            int ch2 = input.charAt(1) - '0';
            int x = (ch1 * 10 ) + ch2;
            if (x>=10 && x <= 26){
                char ss = mainer(x);
                String[] temp2 =  getCode(input.substring(2) , index , output + ss);
                String[] ret = new String[temp2.length + temp.length];
                int k = 0;
                for (int i = 0; i < temp.length; i++) {
                    ret[i] = temp[i];
                    k++;
                }
                for (int i = 0; i < temp2.length; i++) {
                    ret[k] = temp2[i];
                    k++;
                }
                return ret;
            }
        }
        return temp;
    }
    public static char mainer(int c) {
        return (char) ('a'+ c - 1);
    }
}
