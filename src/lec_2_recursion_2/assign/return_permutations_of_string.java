package lec_2_recursion_2.assign;
/*Return Permutations - String
        Send Feedback
        Given a string S, find and return all the possible permutations of the input string.
        Note 1 : The order of permutations is not important.
        Note 2 : If original string contains duplicate characters, permutations will also be duplicates.
        Input Format :
        String S
        Output Format :
        All permutations (in different lines)
        Sample Input :
        abc
        Sample Output :
        abc
        acb
        bac
        bca
        cab
        cba*/
public class return_permutations_of_string {
    public static String[] permutationOfString(String input){
        return permutationOfString(input  ,"");

    }
    public static String[] permutationOfString(String input ,String output){
        if (input.length()==0){
            return new String[]{""};
        }
        String [] ans = permutationOfString(input.substring(1) , output);
        String[] temp = new String[ans.length  * input.length()];
        int k = 0;
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j <= ans[i].length(); j++) {
                temp[k++] = ans[i].substring(0,j) + input.charAt(0)+ans[i].substring(j);
            }
        }

        return temp;
    }
}
