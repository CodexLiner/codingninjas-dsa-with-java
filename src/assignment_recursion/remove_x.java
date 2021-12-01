package assignment_recursion;
/*Remove X
        Send Feedback
        Given a string, compute recursively a new string where all 'x' chars have been removed.
        Input format :
        String S
        Output format :
        Modified String
        Constraints :
        1 <= |S| <= 10^3
        where |S| represents the length of string S.
        Sample Input 1 :
        xaxb
        Sample Output 1:
        ab
        Sample Input 2 :
        abc
        Sample Output 2:
        abc
        Sample Input 3 :
        xx
        Sample Output 3:*/
public class remove_x {
    public static String removeX(String input){
        if (input.length() < 1){
            return input;
        }
        if (input.charAt(0)=='x'){
            return ""+removeX(input.substring(1 , input.length()));
        }
        return input.charAt(0) + removeX(input.substring(1 , input.length()));

    }
}