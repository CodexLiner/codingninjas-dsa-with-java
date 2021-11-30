package lec_2_recursion_2.assign;
/*Print Subset Sum to K
        Send Feedback
        Given an array A and an integer K, print all subsets of A which sum to K.
        Subsets are of length varying from 0 to n, that contain elements of the array. But the order of elements should remain same as in the input array.
        Note : The order of subsets are not important. Just print them in different lines.
        Input format :
        Line 1 : Size of input array
        Line 2 : Array elements separated by space
        Line 3 : K
        Sample Input:
        9
        5 12 3 17 1 18 15 3 17
        6
        Sample Output:
        3 3
        5 1*/
public class print_subset_sum_k {
    public static void printSubsetsSumTok(int input[], int k) {
        printSubsetsSumTok(input , k , 0 , new int[0]);
    }

    public static void printSubsetsSumTok(int[] input, int k , int index , int [] output) {
        if (index == input.length){
            if (k==0){
                for (int j : output) {
                    System.out.print(j + " ");
                }
                System.out.println();
                return;
            }
            return;
        }
        printSubsetsSumTok(input ,  k , index + 1 , output);
        int[] newoutput  = new int[output.length + 1];
        int i = 0;
        for (; i < output.length; i++) {
            newoutput[i] = output[i];
        }
        newoutput[i] = input[index];
        printSubsetsSumTok(input , k - input[index]  , index + 1 , newoutput);
    }

}
