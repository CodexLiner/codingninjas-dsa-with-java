package lec_1_Recursion_1.assign;
/*Check Palindrome (recursive)
        Send Feedback
        Check whether a given String S is a palindrome using recursion. Return true or false.
        Input Format :
        String S
        Output Format :
        'true' or 'false'
        Constraints :
        0 <= |S| <= 1000
        where |S| represents length of string S.
        Sample Input 1 :
        racecar
        Sample Output 1:
        true
        Sample Input 2 :
        ninja
        Sample Output 2:
        false*/
public class palindromeString {
    public static boolean isStringPalindrome(String input) {
        return isStringPalindrome(input , 0);
    }
    public static boolean isStringPalindrome(String input , int i) {
        if (i >= input.length() / 2){
            return true;
        }
        if (input.charAt(i) == input.charAt(input.length() - i- 1)) {
            return isStringPalindrome(input, i+ 1);
        }else {
            return false;
        }
    }


}
