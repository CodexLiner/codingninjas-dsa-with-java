package lec_2_recursion_2.assign;
/*Return subset of an array
        Send Feedback
        Given an integer array (of length n), find and return all the subsets of input array.
        Subsets are of length varying from 0 to n, that contain elements of the array. But the order of elements should remain same as in the input array.
        Note : The order of subsets are not important.
        Input format :

        Line 1 : Size of array

        Line 2 : Array elements (separated by space)

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
public class subset_of_array {
    public static int[][] subsets(int[] input) {
        return subsets(input , 0);
    }
    public static int[][] subsets(int[] input, int index) {
        if (index>=input.length){
            return new int[1][0];
        }
        int[][] arr = subsets(input , index+1);
        int [][] temp = new int[arr.length*2][];
        int k =0;
        for (int i = 0; i < arr.length; i++) {
            temp[i] = new int[arr[i].length];
            for (int j = 0; j < arr[i].length ; j++) {
                temp[i][j] = arr[i][j];
            }
            k++;
        }
        for (int i = 0; i < arr.length; i++) {
            temp[k+i] = new int[arr[i].length + 1];
            temp[k+i][0] = input[index];

            for (int j = 1; j <= arr[i].length; j++) {
                temp[k+i][j] = arr[i][j-1];
            }

        }
        return temp;
    }
}
