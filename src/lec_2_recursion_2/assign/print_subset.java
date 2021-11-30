package lec_2_recursion_2.assign;
/*Print Subsets of Array
        Send Feedback
        Given an integer array (of length n), find and print all the subsets of input array.
        Subsets are of length varying from 0 to n, that contain elements of the array. But the order of elements should remain same as in the input array.
        Note : The order of subsets are not important. Just print the subsets in different lines.
        Input format :
        Line 1 : Integer n, Size of array
        Line 2 : Array elements (separated by space)
        Constraints :
        1 <= n <= 15
        Sample Input:
        3
        15 20 12
        Sample Output:
        [] (this just represents an empty array, don't worry about the square brackets)
        12
        20
        20 12
        15
        15 12
        15 20
        15 20 12*/
public class print_subset {
    public static boolean checkAB(String input) {
        if (input.length()==3){
            return true;
        }
        if (input.substring(0, 3).equals("abb") && input.charAt(3)== 'a' || input.charAt(3)==' '){
            return checkAB(input.substring(0,3));
        }else if (input.substring(0, 3).equals("bba") || input.substring(0, 2).equals("bb") && input.charAt(3)=='a' || input.charAt(3)==' '){
            return checkAB(input.substring(0,3));
        }
//
        return false;

    }
}
