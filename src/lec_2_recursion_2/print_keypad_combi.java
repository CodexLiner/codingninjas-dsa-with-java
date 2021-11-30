package lec_2_recursion_2;
/*Print Keypad Combinations Code
        Send Feedback
        Given an integer n, using phone keypad find out and print all the possible strings that can be made using digits of input n.
        Note : The order of strings are not important. Just print different strings in new lines.
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
public class print_keypad_combi {

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
    public static void printKeypad(int input){
        printKeypad(input , "");
    }
    public static void printKeypad(int input , String output){
        if (input==0){
            System.out.println(output);
            return;
        }

        String[] Letters = listLetters(input % 10);
        // printKeypad(input / 10);
        for (int i = 0; i < Letters.length; i++) {
            printKeypad(input / 10 , Letters[i]+output);
        }
    }
}
