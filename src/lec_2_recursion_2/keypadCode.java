package lec_2_recursion_2;
/*Return Keypad Code
        Send Feedback
        Given an integer n, using phone keypad find out all the possible strings that can be made using digits of input n.
        Return empty string for numbers 0 and 1.
        Note : 1. The order of strings are not important.
        2. Input and output has already been managed for you. You just have to populate the output array and return the count of elements populated in the output array.
        Input Format :
        Integer n
        Output Format :
        All possible strings in different lines
        Constraints :
        1 <= n <= 10^6
        Sample Input:
        23
        Sample Output:
        ad
        ae
        af
        bd
        be
        bf
        cd
        ce
        cf*/
public class keypadCode {

    public static String[] keypad(int n){
        if (n == 0){
            return new String[]{""};
        }
        int x = 0;
        String[] getLetter = listLetters(n %10);
        String [] smallAns = keypad(n /10);
        String[] ans = new String[smallAns.length * getLetter.length];
        for (int i = 0; i < getLetter.length; i++) {
            for (int j = 0; j < smallAns.length; j++) {
                ans[x++] = smallAns[j]+getLetter[i];
            }
        }



        return ans;

    }
    private static String[] listLetters(int n) {
        if (n==2){
            return new String[]{ "a", "b" , "c"};
        }
        if (n==3){
            return new String[]{ "d", "e" , "f"};
        }
        if (n==4){
            return new String[]{ "g", "h" , "i"};
        }
        if (n==5){
            return new String[]{ "j", "k" , "l"};
        }
        if (n==6){
            return new String[]{ "m", "n" , "o"};
        }
        if (n==7){
            return new String[]{ "p", "q" , "r" , "s"};
        }
        if (n==8){
            return new String[]{ "t", "u" , "v"};
        }
        if (n==9){
            return new String[]{ "w", "x" , "y" , "z"};
        }
        return new String[]{" "};
    }

}
