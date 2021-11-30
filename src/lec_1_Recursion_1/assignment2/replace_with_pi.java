package lec_1_Recursion_1.assignment2;
/*Replace pi (recursive)
        Send Feedback
        Given a string, compute recursively a new string where all appearances of "pi" have been replaced by "3.14".
        Constraints :
        1 <= |S| <= 50
        where |S| represents the length of string S.
        Sample Input 1 :
        xpix
        Sample Output :
        x3.14x
        Sample Input 2 :
        pipi
        Sample Output :
        3.143.14
        Sample Input 3 :
        pip
        Sample Output :
        3.14p
        Constraints:-
        1<=|S|<=50*/
public class replace_with_pi {

    public static String replace(String input){
        if (input.length() <= 1){
            return input;
        }
        if (input.charAt(0) == 'p' && input.charAt(1) == 'i'){
            return "3.14" +replace(input.substring(2, input.length()));
        }
        return input.charAt(0) + replace(input.substring(1, input.length()));

    }
}
